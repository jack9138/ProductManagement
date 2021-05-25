/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estoque;

/**
 *
 * @author jaque
 */
public class Produto {
    
    private int idProduto;
    private String nomeProduto;
    private String descriProduto;
    private double valorProduto;
    private String marca;
    private String modelo;
    private int tamanho;
    
    public Produto(){
        
    }
    
    public Produto(String nomeProduto, String descriProduto, double valorProduto,String marca,String modelo,int tamanho){
        this.nomeProduto = nomeProduto;
        this.descriProduto = descriProduto;
        this.valorProduto = valorProduto; 
        this.tamanho = tamanho;
    }
    
    public void setProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    
    public String getProduto(){
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
    
    //metodo para incluir produto
    public void incluirProduto(String nomeProduto, String descriProduto, double valorProduto,String marca,String modelo,int tamanho){
        this.nomeProduto = nomeProduto ;
        this.descriProduto = descriProduto;
        this.modelo = modelo;
        this.modelo = marca;
        this.valorProduto = valorProduto;
        this.tamanho = tamanho;
        
    }
    //meotodo para excluir produto
    public void excluirProduto(String nomeProduto, String descriProduto, double valorProduto,String marca,String modelo,int tamanho){
        this.nomeProduto = nomeProduto ;
        this.descriProduto = descriProduto;
        this.modelo = modelo;
        this.modelo = marca;
        this.valorProduto = valorProduto;
        this.tamanho = tamanho;
    }
    
    //metodo para imprimir
    public String imprimeProduto(){
        
        return "Número Produto: " + idProduto + "\n"
                + "Produto: " + this.nomeProduto + "\n"
                + "Marca: "  + this.modelo + "\n"
                + "Modelo: " +this.modelo + "\n"
                + "Valor unidade:R$ " + this.valorProduto;
    }
    
}
