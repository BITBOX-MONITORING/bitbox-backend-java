/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.jar.individual.ruan;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Ruanc
 */
public class MaquinaRowMapper implements RowMapper<Maquina> {

   @Override
    public Maquina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Maquina maquina = new Maquina();
        maquina.setCodigoPatrimonio(rs.getString("codigo_patrimonio"));
        maquina.setSistemaOperacional(rs.getString("sistema_operacional"));
        maquina.setArquitetura(rs.getInt("arquitetura"));
        maquina.setFabricante(rs.getString("fabricante"));
        return maquina;
    }
    
}
