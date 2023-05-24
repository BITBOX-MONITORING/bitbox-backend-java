/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bitbox.jar.captura.dados;
import java.io.IOException;

/**
 *
 * @author Ruanc
 */
public class TesteLooca {

   public static void main(String[] args) throws IOException {

      SlackAlert slack = new SlackAlert();
      
      slack.enviarAlerta();
      

   }

}
