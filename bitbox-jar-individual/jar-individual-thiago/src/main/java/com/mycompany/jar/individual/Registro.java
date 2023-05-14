/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jar.individual;

import java.time.LocalDateTime;

/**
 *
 * @author thiag
 */
public class Registro {
    private String dataRegistro;
    private String cpuUso;
    private String ramUso;
    private String ramDisponivel;
    private String redeDownload;
    private String redeUpload;
    private String discoTempoResposta;
    private String discoCapacidadeDisponivel;
    private String fkComponente;
    private String fkMaquina;
    private String fkFuncionario;
    private String fkTipoComponente;

    public Registro(String dataRegistro, String cpuUso, String ramUso, String ramDisponivel, 
            String redeDownload, String redeUpload, String discoTempoResposta, String discoCapacidadeDisponivel,
            String fkComponente, String fkMaquina, String fkFuncionario, String fkTipoComponente) {
        this.dataRegistro = dataRegistro;
        this.cpuUso = cpuUso;
        this.ramUso = ramUso;
        this.ramDisponivel = ramDisponivel;
        this.redeDownload = redeDownload;
        this.redeUpload = redeUpload;
        this.discoTempoResposta = discoTempoResposta;
        this.discoCapacidadeDisponivel = discoCapacidadeDisponivel;
        this.fkComponente = fkComponente;
        this.fkMaquina = fkMaquina;
        this.fkFuncionario = fkFuncionario;
        this.fkTipoComponente = fkTipoComponente;
    }

    public Registro() {
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getCpuUso() {
        return cpuUso;
    }

    public void setCpuUso(String cpuUso) {
        this.cpuUso = cpuUso;
    }

    public String getRamUso() {
        return ramUso;
    }

    public void setRamUso(String ramUso) {
        this.ramUso = ramUso;
    }

    public String getRamDisponivel() {
        return ramDisponivel;
    }

    public void setRamDisponivel(String ramDisponivel) {
        this.ramDisponivel = ramDisponivel;
    }

    public String getRedeDownload() {
        return redeDownload;
    }

    public void setRedeDownload(String redeDownload) {
        this.redeDownload = redeDownload;
    }

    public String getRedeUpload() {
        return redeUpload;
    }

    public void setRedeUpload(String redeUpload) {
        this.redeUpload = redeUpload;
    }

    public String getDiscoTempoResposta() {
        return discoTempoResposta;
    }

    public void setDiscoTempoResposta(String discoTempoResposta) {
        this.discoTempoResposta = discoTempoResposta;
    }

    public String getDiscoCapacidadeDisponivel() {
        return discoCapacidadeDisponivel;
    }

    public void setDiscoCapacidadeDisponivel(String discoCapacidadeDisponivel) {
        this.discoCapacidadeDisponivel = discoCapacidadeDisponivel;
    }

    public String getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(String fkComponente) {
        this.fkComponente = fkComponente;
    }

    public String getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(String fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public String getFkFuncionario() {
        return fkFuncionario;
    }

    public void setFkFuncionario(String fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }

    public String getFkTipoComponente() {
        return fkTipoComponente;
    }

    public void setFkTipoComponente(String fkTipoComponente) {
        this.fkTipoComponente = fkTipoComponente;
    }

    

    

    
    
    
    
    
}
