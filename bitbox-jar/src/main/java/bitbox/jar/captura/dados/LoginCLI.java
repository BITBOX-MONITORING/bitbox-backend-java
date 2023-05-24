/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bitbox.jar.captura.dados;

import Entidades.UsuarioRowMapper;
import Entidades.Usuario;
import Conexao.ConexaoDocker;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;
import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Ruanc
 */
public class LoginCLI {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      Looca looca = new Looca();
      ConexaoDocker connDocker = new ConexaoDocker();
      JdbcTemplate conn = connDocker.getConnection();
      
      Sistema sistema = looca.getSistema();

      System.out.println("Digite seu email:");
      String email = sc.nextLine();

      System.out.println("Digite sua senha:");
      String senha = sc.nextLine();

      List<Usuario> usuarios = conn.query("select * from Funcionario where email = ? and senha = ?",
              new UsuarioRowMapper(), email, senha);

      if(!usuarios.isEmpty()){
         System.out.println("Bem vindo " + usuarios.get(0).getNome());
         System.out.println("Sistema Operacional: " + sistema.getSistemaOperacional());
         System.out.println("Arquitetura: " + sistema.getArquitetura());
         System.out.println("Fabricante: " + sistema.getFabricante());
      } else{
         System.out.println("Acesso negado!");
      }
         
                 
   }

}
