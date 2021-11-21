/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Model.SaiEstoque;

/**
 *
 * @author Jaque
 */
public class NotaDeEstoque extends NotaListener{
    
    private SaiEstoque Nota;
    
    
    public void getNota(SaiEstoque nota){
        this.Nota = nota;
        this.getNota(Nota);
    }
}
