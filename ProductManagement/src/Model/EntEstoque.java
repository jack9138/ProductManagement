/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author jaque
 */

public class EntEstoque{
    
    private int idEstoque;
    private List<Produto> produtos = new ArrayList<Produto>();
    private Date dataEntrada;
    private int qtdTotalEntrada;
    private double valorTotalEstoque;
    private Usuario userEntrada;
    
    
    public EntEstoque(){
        
    }
    
     public EntEstoque(int idEstoque, List<Produto> produto, Date dataEntrada, int qtdTotalEntrada, double valorTotalEntrada, Usuario userEntrada ){
        this.idEstoque = idEstoque;
        this.produtos = produtos;
        this.dataEntrada = dataEntrada;
        this.qtdTotalEntrada = qtdTotalEntrada;
        this.valorTotalEstoque = valorTotalEstoque;
        this.userEntrada = userEntrada;
        
    }
     
    public void setIdEstoque(int  idEstoque){
        this.idEstoque = idEstoque;
    }
    
    public int getIdEstoque(){
        return this.idEstoque;
    }
    
    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }
    
    public List<Produto> getProdutos(){
        return this.produtos;
    }
    
    
    public void setDataEntrada(Date dataEntrada){
        this.dataEntrada = dataEntrada;
    }
    
    public Date getDataEntrada(){
        return this.dataEntrada;
    }
     
    public void setQtdTotalEntrada(int  qtdTotalEntrada){
        this.qtdTotalEntrada = qtdTotalEntrada;
    }
    
    public int getQtdTotalEntrada(){
        return this.qtdTotalEntrada;
    }
    
    public void setValorTotalEstoque(double valorTotalEstoque){
        this.valorTotalEstoque = valorTotalEstoque;
    }
    
    public double getValorTotalEstoque(){
        return this.valorTotalEstoque;
    }
   
    public void setUserEntrada(Usuario userEntrada){
        this.userEntrada = userEntrada;
    }
    
    public Usuario getUserEntrada(){
        return this.userEntrada;
    }
}
