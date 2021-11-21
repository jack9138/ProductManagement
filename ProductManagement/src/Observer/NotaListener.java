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
abstract class NotaListener {
    //implementrar resto do código referente ao observer
    
    private String Nota;
    
    EventNota  eventNota = new EventNota() {
        @Override
        public String notifyNota(SaiEstoque saidaEstoque, Date dataSaida) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

    public String getNota(SaiEstoque saiEstoque, Date dataSaida)
    {
        return Nota;
    };
}
