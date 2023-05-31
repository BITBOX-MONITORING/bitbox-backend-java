package bitbox.jar.captura.dados;

import JdbcCommands.Registro;
import Conexao.Conexao;
import Conexao.ConexaoDocker;
import JdbcCommands.InsertMaquina;
import JdbcCommands.InsertRegistro;
import JdbcCommands.SelectUser;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

public class Login {
    private Conexao conexao;
    private JdbcTemplate con;
    private Registro registro;
    private ConexaoDocker conexaodocker;
    private JdbcTemplate condocker;

    public Login() {
        this.registro = new Registro();
        this.conexao = new Conexao();
        this.con = conexao.getConnection();
        this.conexaodocker = new ConexaoDocker();
        this.condocker = conexaodocker.getConnection();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                      ██  █████  ██████      ██████   ██████      ██    ██ ██ ████████  █████   ██████ \s
                      ██ ██   ██ ██   ██     ██   ██ ██    ██     ██    ██ ██    ██    ██   ██ ██    ██ 
                      ██ ███████ ██████      ██   ██ ██    ██     ██    ██ ██    ██    ███████ ██    ██ 
                 ██   ██ ██   ██ ██   ██     ██   ██ ██    ██      ██  ██  ██    ██    ██   ██ ██    ██ 
                  █████  ██   ██ ██   ██     ██████   ██████        ████   ██    ██    ██   ██  ██████  
                                                                                                       \s                                                                       \s
                """);
        System.out.println("BEM-VINDO!!!\n");
        System.out.println("Digite seu e-mail:");
        String email = scanner.nextLine();

        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        String sistemaOperacional = registro.getSistemaOperacional();
        String fabricante = registro.getSistemaFabricante();
        String arquitetura = registro.getSistemaArquitetura();

        SelectUser select = new SelectUser();
        InsertMaquina maquina = new InsertMaquina();
        InsertRegistro registros = new InsertRegistro();
        select.selectAndInsert(email, senha);

        if (select.isLoginValido()) {
            System.out.println("Login deu certo!");

            System.out.println("Sistema Operacional: " + sistemaOperacional);
            System.out.println("Fabricante: " + fabricante);
            System.out.println("Arquitetura: " + arquitetura);

            maquina.queryCadastrarMaquina(email);
            registros.queryInserirRegistros(email);
        } else {
            System.out.println("Login deu errado");
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.run();
    }
}
