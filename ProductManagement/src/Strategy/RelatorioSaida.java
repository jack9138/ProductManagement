/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Model.Produto;
import Model.Relatorio;
import java.util.Date;

/**
 *
 * @author Jaque
 */
public class RelatorioSaida extends RelatorioStrategy{
     private Relatorio relatorio;
    
    @Override
    public Relatorio calcularValEntEstoque(Date dataIncio, Date dataFim){
        return this.relatorio;
    }
    
    @Override
    public Relatorio calcularValSaiEstoque(Date dataIncio, Date dataFim){
        
       return this.relatorio;
    }
}
