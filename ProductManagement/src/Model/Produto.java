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
public class Produto {
    
    private int idProduto;//Mudar tabela, para ID do produto ser gerado a partir de uma proc/function
    private String nomeProduto;
    private String corProd;
    private double valorProduto;
    private int tamanho;
    private String prodStatus;
    
    private MarcaModelo marca = new MarcaModelo();
    private MarcaModelo modelo = new MarcaModelo();
    
    public Produto(){
        
    }
    
    public Produto(String nomeProduto, String descriProduto, String cor,double valorProduto,MarcaModelo marca,MarcaModelo modelo,int tamanho,int idProduto,String prodStatus){
        this.nomeProduto = nomeProduto;
        this.corProd = corProd;
        this.valorProduto = valorProduto; 
        this.tamanho = tamanho;
        this.marca = marca;
        this.modelo = modelo;
        this.idProduto = idProduto;
        this.prodStatus = prodStatus;
    }
    
    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
    
    public int getIdProduto(){
        return this.idProduto;
    }
    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    
    public String getNomeProduto(){
        return this.nomeProduto;
    }
    
    public void setValor(double valorProduto){
        this.valorProduto = valorProduto;
    }
    
    public double  getValor(){
        return this.valorProduto;
    }
    
    
    public void setModelo(MarcaModelo modelo){
        this.modelo = modelo;
    }
    
    public MarcaModelo getModelo(){
        return this.modelo;
    }
    
    public void setMarca(MarcaModelo marca){
        this.marca = marca;
    }
    
    public MarcaModelo getMarca(){
        return this.marca;
    }
    
    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }
    
    public int getTamanho(){
        return this.tamanho;
    }
    
    public void setCorProd(String corProd){
        this.corProd = corProd;
    }
    
    public String getCorProd(){
        return this.corProd;
    }
    
    public void setProdStatus(String prodStatus){
        this.prodStatus = prodStatus;
    }
    
    public String getProdStatus(){
        return this.prodStatus;
    }
}
