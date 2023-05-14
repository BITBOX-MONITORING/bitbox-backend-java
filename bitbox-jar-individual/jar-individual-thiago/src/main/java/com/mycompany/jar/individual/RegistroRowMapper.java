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
public class RegistroRowMapper implements RowMapper<Registro>{
     @Override
     public Registro mapRow(ResultSet rs, int rowNum) throws SQLException {
        Registro registro = new Registro();
        registro.setDataRegistro(rs.getString("data_registro"));
        registro.setCpuUso(rs.getString("cpu_uso"));
        registro.setRamDisponivel(rs.getString("ram_uso"));
        registro.setRamUso(rs.getString("ram_disponivel"));
        registro.setRedeDownload(rs.getString("rede_download"));
        registro.setRedeUpload(rs.getString("rede_upload"));
        registro.setDiscoTempoResposta(rs.getString("disco_tempo_resposta"));
        registro.setDiscoCapacidadeDisponivel(rs.getString("disco_capacidade_disponivel"));
        registro.setFkComponente(rs.getString("fk_componente"));
        registro.setFkMaquina(rs.getString("fk_maquina"));
        registro.setFkFuncionario(rs.getString("fk_funcionario"));
        registro.setFkTipoComponente(rs.getString("fk_tipo_componente"));
        return registro;
    }
 
    
    
    
}
