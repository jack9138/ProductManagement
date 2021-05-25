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

public class NotaFiscal extends Produto {
    
    private String naturezaOperacao; //Fazer uma classe que identifica os tipos de operações
    private Date dataNota;
    private String cnpj;
    //private double valorItem; //reaproveitar da classe Produto
    private double valorTotalNota; // reaproveitar da classe Produto
    
    
    //construtor padrão vazio para não dar erro
    public NotaFiscal(){
        
    }
    
    public void setNaturezaOperacao(String naturezaOperacao){
        this.naturezaOperacao =  naturezaOperacao;
    }
    
    public String setNaturezaOperacao(){
         return this.naturezaOperacao;
    }
    
    public void setDataNota (Date dataNota){
        this.dataNota =  dataNota;
    }
    
    public Date getdataNota(){
         return this.dataNota;
    }
    
     public void setCnpj (String cnpj){
        this.cnpj =  cnpj;
    }
    
    public String getCnpj(){
         return this.cnpj;
    }
    
    
    public void setValorTotalNota (double valorTotalNota){
        this.valorTotalNota =  valorTotalNota;
    }
    
    public double setValorTotalNota(){
         return this.valorTotalNota;
    }
    
    
    public NotaFiscal(String naturezaOperacao,Date dataNota, String cnpj,double valorItem, double valorTotalNota){
        
        this.naturezaOperacao = naturezaOperacao;
        this.dataNota = dataNota;//Deve ser a nota da emissão(hora local)
        this.cnpj = cnpj;
    }
    
    //valorProduto = valor unidade do produto
    public double totalNota(int qtdProduto, double valorProduto){
        double total = 0.0;
        //Lógica de verificar se a quantidade é maior que 0 deve ser feita antes de chamar o método
        total = (qtdProduto * valorProduto);
        return total;
    }
    
    
    //Não sei se esta certo esse método
    public String gerarNota(String naturezaOperacao,Date dataNota, String cnpj,double valorTotalNota){
        
        return ("NATUREZA DA OPERACAO: %s "
                +naturezaOperacao+ 
                "\nDATA DE EMISSAO: %s "
                +dataNota+
                "\nCNPJ: %s "
                +cnpj+
                "\nValor Unid: %.2f"
                +super.getValor()+
                "\nValorTotal: %.2f"
                +valorTotalNota
                );
        
    }
    
    
}
