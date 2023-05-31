package JdbcCommands;

import Conexao.Conexao;
import Conexao.ConexaoDocker;
import Suporte.SlackAlert;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertRegistro {

   private final JdbcTemplate con;
   private final JdbcTemplate conDocker;
   private final Registro registro;

   public InsertRegistro() {
      Conexao conexaoBanco = new Conexao();
      con = conexaoBanco.getConnection();
      registro = new Registro();
      ConexaoDocker conexaoDocker = new ConexaoDocker();
      conDocker = conexaoDocker.getConnection();
   }

   public void queryInserirRegistros(String email) {
      new Timer().scheduleAtFixedRate(new TimerTask() {
         @Override
         public void run() {
            Double cpuUso = registro.getUsoCPU();
            Double ramUso = registro.getMemoriaEmUsoGB();
            Double ramDisponivel = registro.getMemoriaDisponivelGB();
            Double discoUso = registro.showUsado();
            Double discoTotal = registro.showTotal();
            Double redeDownload = registro.showDownload();
            Double redeUpload = registro.showUpload();

            Date dataAtual = new Date();
            Timestamp dataHora = new Timestamp(dataAtual.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatoAmericano = formatter.format(dataHora);

            JSONObject json = new JSONObject();
            SlackAlert slack = new SlackAlert();

            json.put("text", slack.enviarAlertaCpu(cpuUso));
            json.put("text", slack.enviarAlertaRam(ramUso / (ramUso + ramDisponivel) * 100));
            json.put("text", slack.enviarAlertaDisco(discoUso / discoTotal * 100));

            try {
               // SQL AZURE
               con.update("EXEC inserir_registros ?, ?, ?, ?, ?, ?, ?, ?, ?",
                       formatoAmericano, cpuUso, ramUso, ramDisponivel, redeDownload, redeUpload, discoUso, discoTotal, email);
               
               // MYSQL DOCKER
               conDocker.update("INSERT INTO Registro VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                       formatoAmericano, cpuUso, ramUso, ramDisponivel, redeDownload, redeUpload, discoUso, discoTotal);
              
               System.out.println(">> INSERT CONCLUÍDO!");
               
               SlackAlert.sendMessage(json);
            } catch (Exception ex) {
               Logger.getLogger(InsertRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
               Thread.sleep(5000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }, 0, 5000);
   }
}
