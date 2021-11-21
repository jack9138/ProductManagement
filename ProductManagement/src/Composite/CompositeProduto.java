/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

/**
 *
 * @author Jaque
 */
public class CompositeProduto implements ComponentProduto {
    private double valorTotal;
    private double precoProd;
    private int qtdProduto;
    
    public void addPrecoProd(double preco){
        this.precoProd = preco;
    }
    
    public void addQtdProduto(int quantidade){
        this.qtdProduto = quantidade;
    }
    
    @Override
    public double CalcValorProd() {
        valorTotal = precoProd * qtdProduto;
        return valorTotal;
    }
}
