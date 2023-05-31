/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Suporte.SlackAlert;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Ruanc
 */
public class TesteSlack {

   public static void main(String[] args) {

      JSONObject json = new JSONObject();
      SlackAlert slack = new SlackAlert();
      
      json.put("text", slack.enviarAlertaCpu(100.00));

      try {
         SlackAlert.sendMessage(json);
      } catch (IOException ex) {
         Logger.getLogger(InsertRegistro.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InterruptedException ex) {
         Logger.getLogger(InsertRegistro.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

}
