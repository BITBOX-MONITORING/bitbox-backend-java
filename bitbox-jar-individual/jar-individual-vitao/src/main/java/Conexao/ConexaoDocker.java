/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author livia
 */
public class ConexaoDocker {

    private JdbcTemplate connection;

    public ConexaoDocker(){

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://0.0.0.0:3306/bdBitbox?autoReconnect=true&useSSL=false");

        dataSource.setUsername("root");

        dataSource.setPassword("urubu100");
        this.connection = new JdbcTemplate(dataSource);
    }
    public JdbcTemplate getConnection() {
        return connection;
    }
}
