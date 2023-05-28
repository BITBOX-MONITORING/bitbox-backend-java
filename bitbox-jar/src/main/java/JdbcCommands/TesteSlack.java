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
      
      json.put("text", "O limite de 80% de uso da cpu foi atingido!");

      try {
         SlackAlert.sendMessage(json);
      } catch (IOException ex) {
         Logger.getLogger(InsertRegistro.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InterruptedException ex) {
         Logger.getLogger(InsertRegistro.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

}
