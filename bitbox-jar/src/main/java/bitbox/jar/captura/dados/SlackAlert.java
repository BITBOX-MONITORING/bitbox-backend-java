package bitbox.jar.captura.dados;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlackAlert {

   private static final String CHANNEL_NAME = "#bit-alert";
   private static final String MESSAGE_TEXT = "Atenção! Deu merda!";

   private final Slack slack;

   public SlackAlert() {
      this.slack = Slack.getInstance();
   }

   // Cria uma mensagem com um bloco de texto simples
   ChatPostMessageRequest message = ChatPostMessageRequest.builder()
//           .token(SLACK_TOKEN);
           .channel(CHANNEL_NAME)
           .text(MESSAGE_TEXT)
           .build();

   public void enviarAlerta() {

      try {
         // Envia a mensagem
         ChatPostMessageResponse response = slack.methods().chatPostMessage(message);

         // Imprime o resultado da operação
         System.out.println("Mensagem enviada com sucesso! ID da mensagem: " + response.getTs());
      } catch (IOException | SlackApiException ex) {
         Logger.getLogger(SlackAlert.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
