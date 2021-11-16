/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Produto;
import java.util.List;

/**
 *
 * @author Jaque
 */
public interface ProdutoEstoque {
    
    public boolean AddProduto(Produto prod);
    
    public String RemoveProduto(Produto prod);
    
    public List<Produto> GetProduto(Produto prod);
    
}
