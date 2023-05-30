/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bitbox.jar.captura.dados;

import JdbcCommands.Registro;

import Conexao.Conexao;
import Conexao.ConexaoDocker;
import JdbcCommands.InsertMaquina;
import JdbcCommands.InsertRegistro;
import JdbcCommands.SelectUser;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author livia
 */
public class Login extends javax.swing.JFrame {

   Conexao conexao;
   JdbcTemplate con;
   Registro registro;
   ConexaoDocker conexaodocker;
   JdbcTemplate condocker;

   public Login() {
      initComponents();
      this.registro = new Registro();
      this.conexao = new Conexao();
      this.con = conexao.getConnection();
      this.conexaodocker = new ConexaoDocker();
      this.condocker = conexaodocker.getConnection();

   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      txtEmail = new javax.swing.JTextField();
      txtSenha = new javax.swing.JPasswordField();
      lblEntrar = new javax.swing.JButton();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      lblSO = new javax.swing.JLabel();
      lblFabricante = new javax.swing.JLabel();
      lblArquitetura = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jPanel1.setBackground(new java.awt.Color(13, 13, 13));

      jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

      jLabel2.setForeground(new java.awt.Color(255, 255, 255));
      jLabel2.setText("E-mail");

      jLabel3.setForeground(new java.awt.Color(255, 255, 255));
      jLabel3.setText("Senha");

      txtEmail.setBackground(new java.awt.Color(44, 44, 44));
      txtEmail.setForeground(new java.awt.Color(204, 204, 204));
      txtEmail.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtEmailActionPerformed(evt);
         }
      });

      txtSenha.setBackground(new java.awt.Color(44, 44, 44));
      txtSenha.setForeground(new java.awt.Color(204, 204, 204));
      txtSenha.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtSenhaActionPerformed(evt);
         }
      });

      lblEntrar.setBackground(new java.awt.Color(245, 230, 91));
      lblEntrar.setForeground(new java.awt.Color(0, 0, 0));
      lblEntrar.setText("Entrar");
      lblEntrar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            lblEntrarActionPerformed(evt);
         }
      });

      jLabel4.setForeground(new java.awt.Color(255, 255, 255));
      jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel4.setText("Sistema Operacional");

      jLabel6.setForeground(new java.awt.Color(255, 255, 255));
      jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel6.setText("Fabricante ");

      jLabel7.setForeground(new java.awt.Color(255, 255, 255));
      jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel7.setText("Arquitetura");

      lblSO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      lblSO.setForeground(new java.awt.Color(245, 230, 91));
      lblSO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblSO.setText("-");

      lblFabricante.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      lblFabricante.setForeground(new java.awt.Color(245, 230, 91));
      lblFabricante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblFabricante.setText("-");

      lblArquitetura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      lblArquitetura.setForeground(new java.awt.Color(245, 230, 91));
      lblArquitetura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblArquitetura.setText("-");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
              jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(22, 22, 22)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                      .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                      .addComponent(lblSO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                      .addGroup(jPanel1Layout.createSequentialGroup()
                                              .addGap(32, 32, 32)
                                              .addComponent(jLabel6))
                                      .addGroup(jPanel1Layout.createSequentialGroup()
                                              .addGap(8, 8, 8)
                                              .addComponent(lblFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGap(25, 25, 25)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                      .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                      .addGroup(jPanel1Layout.createSequentialGroup()
                                              .addGap(16, 16, 16)
                                              .addComponent(lblArquitetura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                      .addComponent(lblEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                      .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                              .addGroup(jPanel1Layout.createSequentialGroup()
                                                      .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addGap(142, 142, 142))
                                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                      .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(txtEmail)
                                                      .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                      .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                              .addGap(57, 57, 57)
                                              .addComponent(jLabel1)))
                              .addGap(106, 106, 106))
      );
      jPanel1Layout.setVerticalGroup(
              jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(41, 41, 41)
                              .addComponent(jLabel1)
                              .addGap(37, 37, 37)
                              .addComponent(jLabel2)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(jLabel3)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(32, 32, 32)
                              .addComponent(lblEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                              .addComponent(jLabel5)
                                              .addGap(53, 53, 53))
                                      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(jLabel4)
                                                      .addComponent(jLabel6)
                                                      .addComponent(jLabel7))
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(lblSO)
                                                      .addComponent(lblFabricante)
                                                      .addComponent(lblArquitetura))
                                              .addGap(18, 18, 18))))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>                        

   private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {

   }

   private void lblEntrarActionPerformed(java.awt.event.ActionEvent evt) {

      String email = String.valueOf(txtEmail.getText());
      String senha = String.valueOf(txtSenha.getText());

      String sistemaOperacional = registro.getSistemaOperacional();
      String fabricante = registro.getSistemaFabricante();
      String arquitetura = registro.getSistemaArquitetura();

      SelectUser select = new SelectUser();
      InsertMaquina maquina = new InsertMaquina();
      InsertRegistro registros = new InsertRegistro();
      select.selectAndInsert(email, senha);

      if (select.isLoginValido()) {
         System.out.println("Login deu certo!");

         lblSO.setText(sistemaOperacional);
         lblFabricante.setText(fabricante);
         lblArquitetura.setText(arquitetura);

         maquina.queryCadastrarMaquina(email);
         registros.queryInserirRegistros(email);
      } else {
         System.out.println("Login deu errado");
      }
   }

   private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Login().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify                     
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JLabel lblArquitetura;
   private javax.swing.JButton lblEntrar;
   private javax.swing.JLabel lblFabricante;
   private javax.swing.JLabel lblSO;
   private javax.swing.JTextField txtEmail;
   private javax.swing.JPasswordField txtSenha;
   // End of variables declaration                   
}
