package Model;

import java.util.Date;

public class NotaDeEstoque {

    private String naturezaOperacao;

    private Date dataNota;

    private String cnpj;

    private double valorItem;

    private double valorTotalNota;

    public NotaDeEstoque() {
    }

    public NotaDeEstoque(String naturezaOperacao, Date dataNota, String cnpj, double valorItem, double valorTotalNota) {
        this.naturezaOperacao = naturezaOperacao;
        this.dataNota = dataNota;
        this.cnpj = cnpj;
        this.valorItem = valorItem;
        this.valorTotalNota = valorTotalNota;
    }

    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public String setNaturezaOperacao() {
        return this.naturezaOperacao;
    }

    public void setDataNota(Date dataNota) {
        this.dataNota = dataNota;
    }

    public Date getdataNota() {
        return this.dataNota;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public double getValorItem() {
        return this.valorItem;
    }

    public void setValorTotalNota(double valorTotalNota) {
        this.valorTotalNota = valorTotalNota;
    }

    public double getValorTotalNota() {
        return this.valorTotalNota;
    }
}
