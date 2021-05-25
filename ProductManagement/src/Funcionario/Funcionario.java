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
public class Funcionario {
    
    /*Declaração dos objetos*/
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String funcao;
    
    public Funcionario(){
        
    }
   
    public Funcionario(String nome,String cpf,String email,String telefone){
        
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        
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
      
}
