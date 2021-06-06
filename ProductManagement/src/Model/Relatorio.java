/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jaque
 */
public class Relatorio {
    
    private int idRelatorio;
    private String nomeRelatorio;
    private int tipoRelatorio; //pdf, txt
    private String consultaRelatorio;
    
    
    public Relatorio (){
        
    }
    
    public Relatorio(int idRelatorio, String nomeRelatorio, int tipoRelatorio,String consultaRelatorio){
        this.idRelatorio = idRelatorio;
        this.nomeRelatorio = nomeRelatorio;
        this.tipoRelatorio = tipoRelatorio;
        this.consultaRelatorio = consultaRelatorio;
    }
    
    public void setIdRelatorio(int idRelatorio){
        this.idRelatorio = idRelatorio;
    }
    
    public int getIdRelatorio(){
        return this.idRelatorio;
    }
    
    public void setNomeRelatorio(String nomeRelatorio){
        this.idRelatorio = idRelatorio;
    }
    
    public String getNomeRelatorio(){
        return this.nomeRelatorio;
    }
    
    public void setTipoRelatorio(int tipoRelatorio){
        this.tipoRelatorio = tipoRelatorio;
    }
    
    public int getTipoRelatorio(){
        return this.tipoRelatorio;
    }
    
    public void setConsultRelatorio(String consultaRelatorio){
        this.consultaRelatorio = consultaRelatorio;
    }
    
    public String getConsultRelatorio(){
        return this.consultaRelatorio;
    }
}
