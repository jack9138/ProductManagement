package Model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import Composite.ComponentProduto;

public class EntEstoque implements ComponentProduto {

    private int idEstoque;

    private Produto produto;

    private Date dataEntrada;

    private int qtdTotalEntrada;

    private double valorTotalEstoque;

    private Usuario userEntrada;


    public EntEstoque() {
    }

    public EntEstoque(int idEstoque, Produto produto, Date dataEntrada, int qtdTotalEntrada, Usuario userEntrada) {
        this.idEstoque = idEstoque;
        this.produto = produto;
        this.dataEntrada = dataEntrada;
        this.qtdTotalEntrada = qtdTotalEntrada;
        this.userEntrada = userEntrada;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getIdEstoque() {
        return this.idEstoque;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProdutos() {
        return this.produto;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataEntrada() {
        return this.dataEntrada;
    }

    public void setQtdTotalEntrada(int qtdTotalEntrada) {
        this.qtdTotalEntrada = qtdTotalEntrada;
    }

    public int getQtdTotalEntrada() {
        return this.qtdTotalEntrada;
    }

    public void setValorTotalEstoque(double valorTotalEstoque) {
        this.valorTotalEstoque = valorTotalEstoque;
    }

    public double getValorTotalEstoque() {
        return this.valorTotalEstoque;
    }

    public void setUserEntrada(Usuario userEntrada) {
        this.userEntrada = userEntrada;
    }

    public Usuario getUserEntrada() {
        return this.userEntrada;
    }

    @Override
    public double CalcValorProd(double valorProduto) {
        valorTotalEstoque = this.qtdTotalEntrada * valorProduto;
        return valorTotalEstoque;
    }
}
