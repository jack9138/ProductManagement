package Composite;

import Model.Produto;
import java.util.List;

public class LeafProduto implements ComponentProduto {

    private double valorTotal;

    @Override
    public double CalcValorProd(double preco) {
        return valorTotal;
    }
}
