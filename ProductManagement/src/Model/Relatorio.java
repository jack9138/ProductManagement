/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author jaque
 */
public class Relatorio {
    
    private String nomeRelatorio;
    private String nomeProduto;
    private String nomeMarca;
    private String nomeModelo;
    private double precoUnid;
    private int qtdEstoque;
    private double valorTotal;
    private Date dataComum;
    private Date dataEntrada;
    private Date dataSaida;
    
    private double valorTotalSai;
    private double valorTotalEnt;
    private int qtdSaiEstoque;
    
    public Relatorio (){
        
    }
    
    public Relatorio(String nomeRelatorio,String nomeProduto,String nomeMarca,String nomeModelo,double precoUnid,int qtdEstoque,double valorTotal,Date dataEntrada,Date dataSaida){ 
        this.nomeRelatorio = nomeRelatorio;
        this.nomeProduto = nomeProduto;
        this.nomeMarca = nomeMarca;
        this.nomeModelo = nomeModelo;
        this.precoUnid = precoUnid;
        this.qtdEstoque = qtdEstoque;
        this.valorTotal = valorTotal;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        
       
    }
    
    public void setNomeRelatorio(String nomeRelatorio){
        this.nomeRelatorio = nomeRelatorio;
    }
    
    public String getNomeRelatorio(){
        return this.nomeRelatorio;
    }
    
    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    
    public String getNomeProduto(){
        return this.nomeProduto;
    }
    
    public void setNomeMarca(String nomeMarca){
        this.nomeMarca = nomeMarca;
    }
    
    public String getNomeMarca(){
        return this.nomeMarca;
    }
    
    
     public void setNomeModelo(String nomeModelo){
        this.nomeModelo = nomeModelo;
    }
    
    public String getNomeModelo(){
        return this.nomeModelo;
    }
    
    public void setPrecoUnid(double precoUnid){
        this.precoUnid =  precoUnid;
    }
    
    public double getPrecoUnid(){
        return this.precoUnid;
    }
    
    public void setQtdEstoque(int qtdEstoque){
        this.qtdEstoque =  qtdEstoque;
    }
    
    public int getQtdEstoque(){
        return this.qtdEstoque;
    }
    
    public void setQtdSaiEstoque(int qtdSaiEstoque){
        this.qtdSaiEstoque =  qtdSaiEstoque;
    }
    
    public int getQtdSaiEstoque(){
        return this.qtdSaiEstoque;
    }
    
    public void setValorTotal(double valorTotal){
        this.valorTotal =  valorTotal;
    }
    
    public double getValorTotal(){
        return this.valorTotal;
    }
    
    public void setDataEntrada(Date dataEntrada){
        this.dataEntrada =  dataEntrada;
    }
    
    public Date getDataEntrada(){
        return this.dataEntrada;
    }
    
    public void setDataSaida(Date dataSaida){
        this.dataSaida =  dataSaida;
    }
    
    public Date getDataSaida(){
        return this.dataSaida;
    }
    
    public void setDataComum(Date dataComum){
        this.dataComum =  dataComum;
    }
    
    public Date getDataComum(){
        return this.dataComum;
    }
    
    public void setValorTotalEnt(double valorTotalEnt){
        this.valorTotalEnt =  valorTotalEnt;
    }
    
    public double getValorTotalEnt(){
        return this.valorTotalEnt;
    }
    
     public void setValorTotalSai(double valorTotalSai){
        this.valorTotalSai =  valorTotalSai;
    }
    
    public double getValorTotalSai(){
        return this.valorTotalSai;
    }
}
