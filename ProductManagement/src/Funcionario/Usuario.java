/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionario;

/**
 *
 * @author jaque
 */
public class Usuario extends Funcionario {
    
    private String loginUsuario;
    private String senhaUsuario;
    private String grupoUsuario;
    
    
    public Usuario(){
        
    }
    
    public Usuario(String loginUsuario, String senhaUsuario, String grupoUusario){
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.grupoUsuario = grupoUsuario;
    }
    
    public void setLogin(String loginUsuario){
        this.loginUsuario = loginUsuario;
    }
    public String getLogin(){
       return  this.loginUsuario;
    }
    
    public void setSenha(String senhaUsuario){
        this.senhaUsuario = senhaUsuario;
    }

    public String getSenha(){
        return this.senhaUsuario;
    }
    
    public void CadastrarUsuario(){
        
    }
    
    public void AtualizarUsuario(){
        
    }
    public void DesativarUsuario(){
        
    }
   
}
