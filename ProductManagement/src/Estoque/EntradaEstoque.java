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
import java.util.Date;
public class EntradaEstoque extends Produto{
    
    private int idProduto;
    private int qtdProduto;
    private double valor;
    private Date dateEntrada;
    
    
    public EntradaEstoque(int idProduto, int qtdProduto, double valor, Date dataEntrada){
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
        this.valor = valor;
        this.dateEntrada = dataEntrada;
    }
    
    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
    
    public int getIdProduto(){
        return this.idProduto;
    }
    
    public void setQtdProduto(int qtdProduto){
        this.qtdProduto = qtdProduto;
    }
    
    public int getQtdProduto(){
        return this.qtdProduto;
    }
    
    public void setValorProduto(double valor){
        this.valor = valor;
    }
    
    public double getValorProduto(){
        return this.valor;
    }
    
    public void setDataEntrada(Date dataEntrada){
        this.dateEntrada = dataEntrada;//tem que enviar a hora local
    }
    
    public Date getDataEntrada(){
        return this.dateEntrada;//tem que enviar a hora local
    }
    
    
    public void incluirEstoque(int idProduto, int qtdProduto, double valor, Date dataEntrada){
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
        this.valor = valor;
        this.dateEntrada = dataEntrada;
    }
 
    @Override
    public String imprimeProduto(){
        
        return "Número Produto: " + idProduto + "\n"
                + "Produto: " + super.getProduto() + "\n"
                + "Marca: "  + super.getMarca() + "\n"
                + "Modelo: " + super.getModelo() + "\n"
                + "Valor unidade:R$ " + this.valor + "\n"
                + "Quantidade: " + this.qtdProduto;
    }
    
    
}
