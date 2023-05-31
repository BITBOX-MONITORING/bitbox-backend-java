
package Conexao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class Conexao {

    private JdbcTemplate connection;

    public Conexao(){

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        dataSource.setUrl("jdbc:sqlserver://srv-projeto-bitbox.database.windows.net:1433;databaseName=bd-projeto-bitbox");

        dataSource.setUsername("admin-projeto-bitbox");

        dataSource.setPassword("#Gfgrupo4");
        this.connection = new JdbcTemplate(dataSource);
    }
    public JdbcTemplate getConnection() {
        return connection;
    }
}
