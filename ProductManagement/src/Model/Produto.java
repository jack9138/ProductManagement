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
    private String descriProduto;
    private double valorProduto;
    private String marca;
    private String modelo;
    private int tamanho;
    
    public Produto(){
        
    }
    
    public Produto(String nomeProduto, String descriProduto, double valorProduto,String marca,String modelo,int tamanho,int idProduto){
        this.nomeProduto = nomeProduto;
        this.descriProduto = descriProduto;
        this.valorProduto = valorProduto; 
        this.tamanho = tamanho;
        this.marca = marca;
        this.modelo = modelo;
        this.idProduto = idProduto;
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
    
    public void setDescProd(String descriProduto){
        this.descriProduto = descriProduto;
    }
    
    public String getDescProd(){
        return this.descriProduto;
    }
    
    public void setValor(double valorProduto){
        this.valorProduto = valorProduto;
    }
    
    public double  getValor(){
        return this.valorProduto;
    }
    
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
     public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }
    
    public int getTamanho(){
        return this.tamanho;
    }
}
