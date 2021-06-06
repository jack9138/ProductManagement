/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jaque
 */
public class Usuario {
    
    //private int userId;-Tabelas possuem autoincrement
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String funcao;
    private String loginUsuario;
    private String senhaUsuario;
    private String grupoUsuario;
    
    
    public Usuario(){
        
    }
    
    public Usuario(String nome,String cpf,String email,String telefone,String loginUsuario, String senhaUsuario, String grupoUsuario){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.grupoUsuario = grupoUsuario;
    }
    
    public String getNome()
    {
        return this.nome;
    }
   
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
     public String getEmail()
    {
        return this.email;
    }
   
    public void setEmail(String email)
    {
        this.email = email;
    }
   
   
    public String getTelefone()
    {
        return this.telefone;
    }
   
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
   
    public String getCPF()
    {
        return this.cpf;
    }
   
    public void setCPF(String Cpf)
    {
        this.cpf = Cpf;
    }
   
    public String getFuncao()
    {
        return this.funcao;
    }
   
    public void setFuncao(String funcao)
    {
        this.funcao = funcao;
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
    
    public void setGrupoUser(String grupoUsuario){
        this.grupoUsuario = grupoUsuario;
    }

    public String getGrupoUser(){
        return this.grupoUsuario;
    }
   
}
