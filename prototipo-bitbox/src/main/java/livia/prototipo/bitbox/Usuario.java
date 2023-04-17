/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livia.prototipo.bitbox;

/**
 *
 * @author livia
 */
public class Usuario {
    private Integer id;
    private String email;
    private String senha;

    public Usuario(Integer id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
        
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", senha=" + senha + '}';
    }
    
    
    
}
