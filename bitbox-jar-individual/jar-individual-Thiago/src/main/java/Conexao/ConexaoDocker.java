/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author livia
 */
public class ConexaoDocker {

    private JdbcTemplate connection;
    String ipv4;

    public ConexaoDocker(String ipv4) throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        this.ipv4 = localhost.getHostAddress(); ;
    }

    public ConexaoDocker(){
        
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://35.175.146.158:3306/BitBoxDB?autoReconnect=true&useSSL=false");

        dataSource.setUsername("root");

        dataSource.setPassword("urubu100");
        this.connection = new JdbcTemplate(dataSource);
    }
    public JdbcTemplate getConnection() {
        return connection;
    }
}
