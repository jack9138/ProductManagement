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
public class RelatorioStra {
    private RelatorioStrategy relatorioStrag;
    private RelatorioEntrada relatorioEntrada;
    public Relatorio relatorio;
    private RelatorioSaida relatorioSaida;
    private RelatorioComparativo relatorioComparativo;
    
    RelatorioStra (RelatorioStrategy relatorio){
        this.relatorioStrag = relatorio;
    }
    
    public Relatorio gerarRelatorio(Date dataInicio,Date dataFim, int tipoRelatorio){
        
        
       if(tipoRelatorio == 1){
           this.relatorio = relatorioEntrada.calcularValEntEstoque(dataInicio,dataFim);
       }else  if(tipoRelatorio == 2){
           this.relatorio = relatorioSaida.calcularValEntEstoque(dataInicio,dataFim);
       }else if(tipoRelatorio == 3){
           this.relatorio = relatorioComparativo.calcularValEntEstoque(dataInicio,dataFim);
       }
        return this.relatorio;
    } 
}
