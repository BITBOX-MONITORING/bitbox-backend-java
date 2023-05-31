/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.io.File;
import java.text.DecimalFormat;
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
   
   Long download = null;
    Long bytesRecebidosB = null;

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
   
       public String nomeDisco() {
        String nome = null;
        List<Disco> discos = looca.getGrupoDeDiscos().getDiscos();

        for (Disco disco : discos) {
           nome = disco.getNome();
        }
        
        return nome;
        
    }
    
    public Double showTotal() {
        File disk = new File("/"); // diretório raiz do disco
        long totalSpace = disk.getTotalSpace(); // tamanho total do disco em bytes

        // converter bytes para GB
        Double totalGB = (double) totalSpace / (1024 * 1024 * 1024);
        
        Double value = totalGB;
        DecimalFormat df = new DecimalFormat("#,##0.00"); // define o padrão de formatação
        String formattedValue = df.format(value); // formata o valor double
        Double numero = Double.parseDouble(formattedValue.replace(",", "."));
        
        return numero;
    }
    
    public Double showDisponivel() {
        File disk = new File("/"); // diretório raiz do disco
        long freeSpace = disk.getFreeSpace(); // espaço livre em bytes

        // converter bytes para GB
        Double freeGB = (double) freeSpace / (1024 * 1024 * 1024);
        
        Double value = freeGB;
        DecimalFormat df = new DecimalFormat("#,##0.00"); // define o padrão de formatação
        String formattedValue = df.format(value); // formata o valor double
        Double numero = Double.parseDouble(formattedValue.replace(",", "."));
        
        return numero;
        
    }
    
    public Double showUsado() {
        File disk = new File("/"); // diretório raiz do disco
        long totalSpace = disk.getTotalSpace(); // tamanho total do disco em bytes
        long usedSpace = totalSpace - disk.getFreeSpace(); // espaço usado em bytes

        Double usedGB = (double) usedSpace / (1024 * 1024 * 1024);
        
        Double value = usedGB;
        DecimalFormat df = new DecimalFormat("#,##0.00"); // define o padrão de formatação
        String formattedValue = df.format(value); // formata o valor double
        Double numero = Double.parseDouble(formattedValue.replace(",", "."));
        
        return numero;
    }
    
    private static Double byteConverterMega(long bytes){
        return (double) bytes / (1024 * 1024);
    }
    
    // Download de rede acumulativo
    public Double showDownload(){
        List<RedeInterface> lista = rede.getGrupoDeInterfaces().getInterfaces();
        
        for (RedeInterface redeInterface : lista) {
            long bytesRecebidosA = redeInterface.getBytesRecebidos();
            
            if(bytesRecebidosB != null){
                download = bytesRecebidosA - bytesRecebidosB;
                bytesRecebidosB = bytesRecebidosA;
            }else{
                download = bytesRecebidosA;
                bytesRecebidosB = bytesRecebidosA;
            }
        }
        
        return byteConverterMega(download);
    }
    
    // Upload da rede acumulativo
    public Double showUpload() {
        List<RedeInterface> lista = rede.getGrupoDeInterfaces().getInterfaces();
        
        Long upload = null;
        
        for (RedeInterface redeInterface : lista) {
            long bytesEnviadosA = redeInterface.getBytesEnviados();
            upload = bytesEnviadosA;
        }

        return byteConverterMega(upload);
    }
}
