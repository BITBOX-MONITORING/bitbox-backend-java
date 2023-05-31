/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bitbox.jar.captura.dados;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;

/**
 *
 * @author Ruanc
 */
public class Registro {

   private Looca looca;
   private Sistema sistema;
   private Memoria memoria;
   private Processador processador;
   private DiscoGrupo grupoDiscos;
   private List<Disco> discos;
   private Rede rede;

   public Registro() {
      this.looca = new Looca();
      this.sistema = looca.getSistema();
      this.memoria = looca.getMemoria();
      this.processador = looca.getProcessador();
      this.grupoDiscos = looca.getGrupoDeDiscos();
      this.discos = grupoDiscos.getDiscos();
      this.rede = looca.getRede();
   }

   public String getSistemaOperacional() {
      return sistema.getSistemaOperacional();
   }

   public String getSistemaFabricante() {
      return sistema.getFabricante();
   }

   public String getSistemaArquitetura() {
      return sistema.getArquitetura().toString();
   }
   
   public Double getUsoCPU(){
      return processador.getUso();
   }

   public double getMemoriaEmUsoGB() {
      long bytesEmUso = memoria.getEmUso();
      double gigabytesEmUso = bytesEmUso / Math.pow(1024.0, 3.0);
      return gigabytesEmUso;
   }

   public double getMemoriaDisponivelGB() {
      long bytesDisponiveis = memoria.getDisponivel();
      double gigabytesDisponiveis = bytesDisponiveis / Math.pow(1024.0, 3.0);
      return gigabytesDisponiveis;
   }

}
