package Suporte;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
}
