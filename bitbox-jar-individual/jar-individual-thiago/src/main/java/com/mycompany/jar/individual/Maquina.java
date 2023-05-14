package com.mycompany.jar.individual;

import com.github.britooo.looca.api.core.Looca;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author thiag
 */
public class Maquina {

    private String codigoPatrimonio;
    private String sistemaOperacional;
    private String arquitetura;
    private String fabricante;
    private String fkUsuario;

    public Maquina(String codigoPatrimonio, String sistemaOperacional, String arquitetura, String fabricante, String fkUsuario) {
        this.codigoPatrimonio = codigoPatrimonio;
        this.sistemaOperacional = sistemaOperacional;
        this.arquitetura = arquitetura;
        this.fabricante = fabricante;
        this.fkUsuario = fkUsuario;
    }

    public Maquina() {
    }

    @Override
    public String toString() {
        return "Maquina{" + "codigoPatrimonio=" + codigoPatrimonio + ", sistemaOperacional=" + sistemaOperacional + ", arquitetura=" + arquitetura + ", fabricante=" + fabricante + ", fkUsuario=" + fkUsuario + '}';
    }

    public String getCodigoPatrimonio() {
        return codigoPatrimonio;
    }

    public void setCodigoPatrimonio(String codigoPatrimonio) {
        this.codigoPatrimonio = codigoPatrimonio;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(String fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
    
    

}
