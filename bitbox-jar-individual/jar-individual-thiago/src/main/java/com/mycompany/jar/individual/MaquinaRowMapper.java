/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jar.individual;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author thiag
 */
/***
 *   private String codigoPatrimonio;
    private String sistemaOperacional;
    private String arquitetura;
    private String fabricante;
    private String fkUsuario;
 * @author thiag
 */
public class MaquinaRowMapper implements RowMapper<Maquina> {

    @Override

    public Maquina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Maquina maquina = new Maquina();
        maquina.setCodigoPatrimonio(rs.getString("codigo_patrimonio"));
        maquina.setSistemaOperacional(rs.getString("sistema_operacional"));
        maquina.setArquitetura(rs.getString("arquitetura"));
        maquina.setFabricante(rs.getString("fabricante"));
        maquina.setFkUsuario(rs.getString("fk_usuario"));
        return maquina;
    }

}
