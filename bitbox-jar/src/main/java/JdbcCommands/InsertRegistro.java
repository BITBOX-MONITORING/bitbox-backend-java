/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author diego
 */
public class InsertRegistro {

    Conexao conexaoBanco = new Conexao();
    JdbcTemplate con = conexaoBanco.getConnection();
    Registro registro = new Registro();
    ConexaoDocker conexaoDocker = new ConexaoDocker();
    JdbcTemplate conDocker = conexaoDocker.getConnection();

<<<<<<< HEAD
    String sistemaOperacional = registro.getSistemaOperacional();
    String fabricante = registro.getSistemaFabricante();
    String arquitetura = registro.getSistemaArquitetura();
    Double cpuUso = registro.getUsoCPU();
    Double ramUso = registro.getMemoriaEmUsoGB();
    Double ramDisponivel = registro.getMemoriaDisponivelGB();

    Date dataAtual = new Date();
    Timestamp dataHora = new Timestamp(dataAtual.getTime());
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String formatoAmericano = formatter.format(dataHora);
=======

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

>>>>>>> ba07c09b91b51bc007b45ea3ad421382b90330d2

    JSONObject json = new JSONObject();

<<<<<<< HEAD
    public void queryInserirRegistros(String email) {
        //Timer para rodas a cada 5 segundos
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // INSERIR REGISTRO NO AZURE

                if (cpuUso > 80.0) {
                    json.put("text", "O limite de 80% de uso da cpu foi atingido!");
                }

                con.update("EXEC inserir_registros ?, ?, ?, ?, ?, ?, ?, ?, ?",
                        formatoAmericano, registro.getUsoCPU(), registro.getMemoriaEmUsoGB(), registro.getMemoriaDisponivelGB(), registro.showDownload(), registro.showUpload(), registro.showUsado(), registro.showTotal(), email);
                conDocker.update(String.format("Insert into Registro (data_registro,cpu_uso,ram_uso,ram_disponivel,rede_download,rede_upload,disco_tempo_resposta,disco_capacidade_disponivel,fk_componente,fk_maquina)values ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", formatoAmericano,registro.getUsoCPU(),registro.getMemoriaEmUsoGB(),registro.getMemoriaDisponivelGB(),registro.showDownload(),registro.showUpload(), registro.showUsado(), registro.showTotal(),3,1));
                
                System.out.println("INSERIU REGISTRO");
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
=======
            JSONObject json = new JSONObject();
            SlackAlert slack = new SlackAlert();

           // JSONObject cpuAlert = slack.enviarAlertaCpu(cpuUso + 100);
            json.put("text",slack.enviarAlertaCpu(cpuUso));
            json.put("text",slack.enviarAlertaRam(ramUso / (ramUso + ramDisponivel) * 100));
            json.put("text",slack.enviarAlertaDisco(discoUso / discoTotal * 100));

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
>>>>>>> ba07c09b91b51bc007b45ea3ad421382b90330d2

}
