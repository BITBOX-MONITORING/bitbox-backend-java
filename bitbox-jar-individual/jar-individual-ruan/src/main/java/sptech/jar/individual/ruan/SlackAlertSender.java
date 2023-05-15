/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.jar.individual.ruan;

import com.slack.api.Slack;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

/**
 *
 * @author Ruanc
 */
public class SlackAlertSender {

   public static void main(String[] args) throws Exception {

      // Define o token de acesso do bot
      String slackToken = "xoxb-5261956336466-5261965219058-ctozkcMLOQwAumBnS058UE0Y";

      // Cria uma instância do cliente da Slack API
      Slack slack = Slack.getInstance();

      // Cria uma mensagem com um bloco de texto simples
      ChatPostMessageRequest message = ChatPostMessageRequest.builder()
              .token(slackToken)
              .channel("#bit-alert")
              .text("Atenção! Deu merda!")
              .build();

      // Envia a mensagem
      ChatPostMessageResponse response = slack.methods().chatPostMessage(message);

      // Imprime o resultado da operação
      System.out.println("Mensagem enviada com sucesso! ID da mensagem: " + response.getTs());
   }
}
