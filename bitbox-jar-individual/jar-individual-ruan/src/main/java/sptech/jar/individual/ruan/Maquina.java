/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.jar.individual.ruan;

/**
 *
 * @author Ruanc
 */
public class Maquina {
    
    private String codigoPatrimonio;
    private String sistemaOperacional;
    private Integer arquitetura;
    private String fabricante;

    public Maquina(String codigoPatrimonio, String sistemaOperacional, Integer arquitetura, String fabricante) {
        this.codigoPatrimonio = codigoPatrimonio;
        this.sistemaOperacional = sistemaOperacional;
        this.arquitetura = arquitetura;
        this.fabricante = fabricante;
    }

    public Maquina() {
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

    public Integer getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(Integer arquitetura) {
        this.arquitetura = arquitetura;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Maquina{" + "codigoPatrimonio=" + codigoPatrimonio + ", sistemaOperacional=" + sistemaOperacional + ", arquitetura=" + arquitetura + ", fabricante=" + fabricante + '}';
    }
    
    
    
}
