/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Model.SaiEstoque;
import java.util.Date;
/**
 *
 * @author Jaque
 */
public interface EventNota {
    
    public String notifyNota(SaiEstoque saidaEstoque, Date dataSaida);
}
