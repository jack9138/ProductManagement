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
abstract class RelatorioStrategy {
    
    abstract public Relatorio calcularValEntEstoque(Date dataInicio, Date dataFim);
    abstract public Relatorio calcularValSaiEstoque(Date dataInicio, Date dataFim);
}
