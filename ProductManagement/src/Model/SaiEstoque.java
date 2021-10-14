/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jaque
 */
public class SaiEstoque {
    private int idEstoque;
    private Produto produto ;
    private Date dataSaiEstoque;
    private int qtdTotalSaiEstoque;
    private double valorTSaiEstoque;
    private Usuario userSaiEntrada;
    
    
    public SaiEstoque(){
        
    }
    
     public SaiEstoque(int idEstoque, Produto produto, Date dataSaiEstoque, int qtdTotalSaiEstoque, double valorTSaiEstoque, Usuario userSaiEntrada ){
        this.idEstoque = idEstoque;
        this.produto = produto;
        this.dataSaiEstoque = dataSaiEstoque;
        this.qtdTotalSaiEstoque = qtdTotalSaiEstoque;
        this.valorTSaiEstoque = valorTSaiEstoque;
        this.userSaiEntrada = userSaiEntrada;
        
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
    
    
    public void setDataSai(Date dataSaiEstoque){
        this.dataSaiEstoque = dataSaiEstoque;
    }
    
    public Date getDataSai(){
        return this.dataSaiEstoque;
    }
     
    public void setQtdTSai(int qtdTotalSaiEstoque){
        this.qtdTotalSaiEstoque = qtdTotalSaiEstoque;
    }
    
    public int getQtdTSai(){
        return this.qtdTotalSaiEstoque;
    }
    
    public void setValorTSaiEstoque(double valorTSaiEstoque){
        this.valorTSaiEstoque = valorTSaiEstoque;
    }
    
    public double getValorTSaiEstoque(){
        return this.valorTSaiEstoque;
    }
   
    public void setUserSai(Usuario userSaiEntrada){
        this.userSaiEntrada = userSaiEntrada;
    }
    
    public Usuario getUserSai(){
        return this.userSaiEntrada;
    }
}
