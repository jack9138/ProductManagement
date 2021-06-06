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
    private List<Produto> produtos = new ArrayList<Produto>();
    private Date dataSaiEstoque;
    private int qtdTotalSaiEstoque;
    private double valorTSaiEstoque;
    private Usuario userSaiEntrada;
    
    
    public SaiEstoque(){
        
    }
    
     public SaiEstoque(int idEstoque, List<Produto> produto, Date dataSaiEstoque, int qtdTotalSaiEstoque, double valorTSaiEstoque, Usuario userSaiEntrada ){
        this.idEstoque = idEstoque;
        this.produtos = produtos;
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
    
    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }
    
    public List<Produto> getProdutos(){
        return this.produtos;
    }
    
    
    public void setDataSaiEntrada(Date dataSaiEstoque){
        this.dataSaiEstoque = dataSaiEstoque;
    }
    
    public Date getDataSaiEntrada(){
        return this.dataSaiEstoque;
    }
     
    public void setQtdTSaiEntrada(int qtdTotalSaiEstoque){
        this.qtdTotalSaiEstoque = qtdTotalSaiEstoque;
    }
    
    public int getQtdTSaiEntrada(){
        return this.qtdTotalSaiEstoque;
    }
    
    public void setValorTSaiEstoque(double valorTSaiEstoque){
        this.valorTSaiEstoque = valorTSaiEstoque;
    }
    
    public double getValorTSaiEstoque(){
        return this.valorTSaiEstoque;
    }
   
    public void setUserSaiEntrada(Usuario userSaiEntrada){
        this.userSaiEntrada = userSaiEntrada;
    }
    
    public Usuario getUserSaiEntrada(){
        return this.userSaiEntrada;
    }
}
