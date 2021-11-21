/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

import Model.Produto;
import java.util.List;

/**
 *
 * @author Jaque
 */
public class LeafProduto implements ComponentProduto{

    private double valorTotal;
    
    @Override
    public double CalcValorProd() {
        return valorTotal;
    }
}
