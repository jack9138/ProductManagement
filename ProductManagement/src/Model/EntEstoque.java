/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import Composite.ComponentProduto;
/**
 *
 * @author jaque
 */

public class EntEstoque implements ComponentProduto{ 
    
    private int idEstoque;
    private Produto produto;
    private Date dataEntrada;
    private int qtdTotalEntrada;
    private double valorTotalEstoque;
    private Usuario userEntrada;
    
    
    public EntEstoque(){
        
    }
    
     public EntEstoque(int idEstoque, Produto produto, Date dataEntrada, int qtdTotalEntrada, double valorTotalEntrada, Usuario userEntrada ){
        this.idEstoque = idEstoque;
        this.produto = produto;
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
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public Produto getProdutos(){
        return this.produto;
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

    @Override
    public double CalcValorProd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
