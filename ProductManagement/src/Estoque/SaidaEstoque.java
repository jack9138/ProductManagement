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
public class SaidaEstoque extends Produto{
    
    private int idProduto;
    private int qtdProdutoSaida;
    private double valorSaida;
    private Date dataSaida;
    
    
    
    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
    
    public int getIdProduto(){
        return this.idProduto;
    }
    
    public void setQtdProduto(int qtdProduto){
        this.qtdProdutoSaida = qtdProduto;
    }
    
    public int getQtdProduto(){
        return this.qtdProdutoSaida;
    }
    
    public void setValorProduto(double valor){
        this.valorSaida = valor;
    }
    
    public double getValorProduto(){
        return this.valorSaida;
    }
    
    public void setDataEntrada(Date dataSaida){
        this.dataSaida = dataSaida;//tem que enviar a hora local
    }
    
    public Date getDataEntrada(){
        return this.dataSaida;//tem que enviar a hora local
    }
    
    
    public SaidaEstoque (int idProduto, int qtdProduto, double valor, Date dataEntrada){
        this.idProduto = idProduto;
        this.qtdProdutoSaida = qtdProduto;
        this.valorSaida = valor;
        this.dataSaida = dataSaida;
    }
    
    
    
    public void saidaEstoque(int idProduto, int qtdSaida,double valorSaida ,Date dataSaida){
        this.idProduto = idProduto;
        this.qtdProdutoSaida = qtdSaida;
        this.valorSaida = valorSaida;
        this.dataSaida = dataSaida;
       
    }
    
    
    @Override
    public String imprimeProduto(){
        
        return "Número Produto: " + idProduto + "\n"
                + "Produto: " + super.getProduto() + "\n"
                + "Marca: "  + super.getMarca() + "\n"
                + "Modelo: " + super.getModelo() + "\n"
                + "Valor unidade:R$ " + this.valorSaida + "\n"
                + "Quantidade: " + this.qtdProdutoSaida;
    }
}
