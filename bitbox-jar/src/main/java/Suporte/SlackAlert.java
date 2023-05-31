package Suporte;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.github.britooo.looca.api.core.Looca;
import org.json.JSONObject;

public class SlackAlert {
   private static HttpClient client = HttpClient.newHttpClient();
    private static final String webhook = "https://hooks.slack.com/services/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";

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {;
        HttpRequest request = HttpRequest.newBuilder(URI.create(webhook))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
        
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    }
    public String enviarAlertaCpu(Double cpu)  {
        String mensagem = "";
        JSONObject json = new JSONObject();

        if(cpu > 80) {
            mensagem = "[CRÍTICO!] O limite de 80% de uso da cpu foi atingido!";
            try {
                generateLog("[CRÍTICO!] O limite de 80% de uso da cpu foi atingido!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (cpu > 50) {
            mensagem = "[ATENÇÃO!] O limite de 50% de uso da cpu foi atingido!";
            try {
                generateLog("[ATENÇÃO!] O limite de 50% de uso da cpu foi atingido!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return mensagem;
    }

    public String enviarAlertaRam(Double ram)  {
        String mensagem = "";
        JSONObject json = new JSONObject();

        if(ram > 80) {
            mensagem = "[CRÍTICO!] O limite de 80% de uso da ram foi atingido!";
            try {
                generateLog("[CRÍTICO!] O limite de 80% de uso da ram foi atingido!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (ram > 50) {
            mensagem = "[ATENÇÃO!] O limite de 50% de uso da ram foi atingido!";
            try {
                generateLog("[ATENÇÃO!] O limite de 50% de uso da ram foi atingido!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        json.put("text", mensagem);

        return mensagem;
    }

    public String enviarAlertaDisco(Double disco) {
        String mensagem = "";
        JSONObject json = new JSONObject();

        if(disco > 80) {
            mensagem = "[CRÍTICO!] O limite de 80% de uso da disco foi atingido!";
            try {
                generateLog("[CRÍTICO!] O limite de 80% de uso da disco foi atingido!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (disco > 50) {
            mensagem = "[ATENÇÃO!] O limite de 50% de uso da disco foi atingido!";
            try {
                generateLog("[ATENÇÃO!] O limite de 50% de uso da disco foi atingido!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        json.put("text", mensagem);

        return mensagem;
    }


    public static void generateLog(String mensagem) throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Define o fuso horário de Brasília
        TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
        dateFormat.setTimeZone(timeZone);

        // Obtém a data e hora atual
        Date date = new Date();

        // Formata a data e hora de acordo com o fuso horário de Brasília
        String dateTimeBrasilia = dateFormat.format(date);

        Path path = Paths.get("/home/victorpereira/Documentos/logs");

        if(!Files.exists(path)) {

            Files.createDirectory(path);

        }

        File log = new File("/home/victorpereira/Documentos/Vitao/logs/logs.txt");

        if(!log.exists()) {

            log.createNewFile();

        }

        FileWriter fw = new FileWriter(log, true);

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(dateTimeBrasilia + mensagem);
        bw.newLine();

        bw.close();
        fw.close();

    }
}
