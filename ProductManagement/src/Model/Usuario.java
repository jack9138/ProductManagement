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
    private String estado;
    private String bairro;
    private String cidade;
    private String rua;
    private char usStatus;
    private String loginUsuario;
    private String senhaUsuario;
    private int grupoUsuario;
    private int userId;
    
    
    public Usuario(){
        
    }
    
    public Usuario(String nome,String cpf,String email,String telefone,String loginUsuario, String senhaUsuario,int grupoUsuario,String estado,String bairro,String cidade,String rua,char usStatus){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.grupoUsuario = grupoUsuario;
        this.estado = estado;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.usStatus = usStatus;
    
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
    
    public void setGrupoUser(int grupoUsuario){
        this.grupoUsuario = grupoUsuario;
    }

    public int getGrupoUser(){
        return this.grupoUsuario;
    }
   
    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getEstado(){
        return this.estado;
    }
    
    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public String getBairro(){
        return this.bairro;
    }
    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getCidade(){
        return this.cidade;
    }
    
    public void setRua(String rua){
        this.rua = rua;
    }

    public String getRua(){
        return this.rua;
    }
    
    public void  setUsStatus(char usStatus){
        this.usStatus = usStatus;
    }
    public char getUsStatus(){
        return this.usStatus;
    }
    public void setUsId(int usId){
        this.userId = userId;
    }
    public int getUsId(){
        return this.userId;
    }
}
