/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Conexao.Conexao;
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

/**
 *
 * @author diego
 */
public class InsertRegistro {

   Conexao conexaoBanco = new Conexao();
   JdbcTemplate con = conexaoBanco.getConnection();
   Registro registro = new Registro();


   Double cpuUso = registro.getUsoCPU();
   Double ramUso = registro.getMemoriaEmUsoGB();
   Double ramDisponivel = registro.getMemoriaDisponivelGB();
   Double discoUso = registro.showUsado();
   Double discoTotal = registro.showTotal();

   Double redeDownload = registro.showDownload();
   Double redeUpload = registro.showUpload();

   Date dataAtual = new Date();
   Timestamp dataHora = new Timestamp(dataAtual.getTime());
   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   String formatoAmericano = formatter.format(dataHora);


   public void queryInserirRegistros(String email) {
      //Timer para rodas a cada 5 segundos
      new Timer().scheduleAtFixedRate(new TimerTask() {
         @Override
         public void run() {
            // INSERIR REGISTRO NO AZURE

            JSONObject json = new JSONObject();
            SlackAlert slack = new SlackAlert();

            JSONObject cpuAlert = slack.enviarAlertaCpu(cpuUso + 100);
            JSONObject ramAlert = slack.enviarAlertaRam(ramUso / (ramUso + ramDisponivel) * 100);
            JSONObject diskAlert = slack.enviarAlertaDisco(discoUso / discoTotal * 100);

            if(cpuUso + 100 > 80) {
               json.put("text", "testeee");
            }

            con.update("EXEC inserir_registros ?, ?, ?, ?, ?, ?, ?, ?, ?",
                    formatoAmericano, cpuUso, ramUso,ramDisponivel,redeDownload ,redeUpload , discoUso, discoTotal, email);

            // conMysql.update(String.format("insert into Registro values (null,'%s','%s','%s','%s','5845','8000','2seg','%s',3,5,2,1);", formattedDateTime, processador.getUso(), memoria.getEmUso(), memoria.getTotal(), processador.getUso()));
            System.out.println("Inseriu Sql");

            try {
               SlackAlert.sendMessage(json);
            } catch (IOException ex) {
               Logger.getLogger(InsertRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
               Logger.getLogger(InsertRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
               Thread.sleep(5000); // Aguarda 5 segundos antes de inserir o próximo registro
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }, 0, 5000);

   }

}
