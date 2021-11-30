package Model;

import Strategy.RelatorioStra;
import java.util.Date;

public class Relatorio extends RelatorioStra{

    private String nomeRelatorio;

    private EntEstoque entradaEstoque;

    private SaiEstoque saiEstoque;

    private double valorTotal;

    private Date dataInicio;

    private Date dataFim;

    private double valorTotalSai;

    private double valorTotalEnt;


    public Relatorio() {
    }

    public Relatorio(EntEstoque entEstoque, String nomeRelatorio,Date dataInicio, Date dataFim) {
       this.entradaEstoque = entEstoque;
       this.dataInicio = dataInicio;
       this.dataFim = dataFim;
    }
    
    public Relatorio(SaiEstoque saiEstoque, String nomeRelatorio, Date dataInicio, Date dataFim) {
       this.saiEstoque = saiEstoque;
       this.dataInicio = dataInicio;
       this.dataFim = dataFim; 
    }

    public void setNomeRelatorio(String nomeRelatorio) {
        this.nomeRelatorio = nomeRelatorio;
    }

    public String getNomeRelatorio() {
        return this.nomeRelatorio;
    }

    public void setEntEstoque(EntEstoque entEstoque) {
        this.entradaEstoque = entEstoque;
    }

    public EntEstoque getEntEstoque() {
        return this.entradaEstoque;
    }

    public void setSaiEstoque(SaiEstoque saiEstoque) {
        this.saiEstoque = saiEstoque;
    }

    public SaiEstoque getSaiEstoque() {
        return this.saiEstoque;
    }
    
    public void  setValTotalEntrada(double valTotalEnt) {
        this.valorTotalEnt = valTotalEnt;
    }
    public double  getValorTotalEntrada() {
        return this.valorTotalEnt;
    }
    
    public void  setValTotalSaida(double valTotalSai) {
        this.valorTotalSai = valTotalSai;
    }
    public double  getValorTotalSaida() {
        return this.valorTotalSai;
    }
    
    public void  setValTotalComparativo(double valTotal) {
        this.valorTotal = valTotal;
    }
    public double  getValTotalComparativo() {
        return this.valorTotal;
    }
    
    
    public void  setDataInicio(Date dateInicio) {
        this.dataInicio= dateInicio;
    }
    public Date  getDataInicio() {
        return this.dataInicio;
    }
    
    public void  setDataFim(Date dateFim) {
        this.dataFim = dateFim;
    }
    public Date  getDataFim() {
        return this.dataFim;
    }
    
    
}
