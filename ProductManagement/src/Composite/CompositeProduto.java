package Composite;

public class CompositeProduto implements ComponentProduto {

    private double valorTotal;

    private double precoProd;

    private int qtdProduto;

    public void addPrecoProd(double preco) {
        this.precoProd = preco;
    }

    public void addQtdProduto(int quantidade) {
        this.qtdProduto = quantidade;
    }

    @Override
    public double CalcValorProd(double valor) {
        valorTotal = precoProd * qtdProduto;
        return valorTotal;
    }
}
