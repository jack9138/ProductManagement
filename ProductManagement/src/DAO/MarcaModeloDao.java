/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.BDProductM;
import Model.MarcaModelo;
import ConexaoBD.ConexaoBanco;
import java.sql.*;
import java.util.*;

public class MarcaModeloDao {

    private MarcaModelo marcMod = new MarcaModelo();
    
    //Adicionar Marca
    public void adicionaMarca(MarcaModelo ma) throws ClassNotFoundException{
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        
        
        try{
            stat = conec.prepareStatement("INSERT INTO MARCA (NOME_MARCA) VALUES(?)");
            
            stat.setString(1,ma.getNomeMarca());
            stat.execute();
            
        }catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           BDProductM.closeConnection(conec, stat);
            
       }
        
    }
    //Adicionar Modelo
    public void adicionaModelo(MarcaModelo mo) throws ClassNotFoundException{
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        
        
        try{
            stat = conec.prepareStatement("INSERT INTO MODELO(NOME_MODELO) VALUES(?)");
            
            stat.setString(1,mo.getNomeModelo());
            stat.execute();
            
        }catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           BDProductM.closeConnection(conec, stat);
            
       }
        
    }
    //Deletar marcar
    public void removeMarca(MarcaModelo ma) throws ClassNotFoundException{
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        
        
        try{
            stat = conec.prepareStatement("DELETE FROM MARCA WHERE ID_MARCA = ?");
            
            stat.setInt(1,ma.getIdMarca());
            stat.executeQuery();
            
        }catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           BDProductM.closeConnection(conec, stat);
            
       }
        
    }
    //Deletar  modelo
    public void removeModelo(MarcaModelo mo) throws ClassNotFoundException{
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        
        
        try{
            stat = conec.prepareStatement("DELETE FROM MODELO WHERE ID_MODELOR = ?");
            
            stat.setInt(1,mo.getIdModelo());
            
            stat.executeQuery();
            
        }catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           BDProductM.closeConnection(conec, stat);
            
       }
        
    }
    
    //Listar as Marcas
    public List<MarcaModelo> listMarca (MarcaModelo ma, int seleMarca) throws ClassNotFoundException{
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<MarcaModelo>  listMarc = new ArrayList();
        
        try{
           
            //selecionar todas as marcas. 0 significa todas, passado valor significa o id marca
            if(seleMarca != 0 ){
              stat = conec.prepareStatement("SELECT ID_MARCA, NOME_MARCA  FROM MARCA"); 
              res = stat.executeQuery();
              
              while(res.next()){
                MarcaModelo marc = new  MarcaModelo();
                marc.setIdMarca(res.getInt("Id"));
                marc.setNomeMarca(res.getString("MarcaN"));
                listMarc.add(marc);
              }
            }
            else{
              stat = conec.prepareStatement("SELECT ID_MARCA, NOME_MARCA  FROM MARCA WHERE ID_MARCA = ?"); 
              stat.setInt(1, seleMarca);
              
              res = stat.executeQuery();
                while(res.next()){
                    MarcaModelo marc = new  MarcaModelo();  
                    marc.setIdMarca(res.getInt("Id"));
                    marc.setNomeMarca(res.getString("MarcaN"));
                    listMarc.add(marc);
                } 
            }

        }
        catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           BDProductM.closeConnection(conec, stat);
            
       }
        return listMarc;
    }
    
    //Listar os modelos cadastrados
    public List<MarcaModelo> listModelo (MarcaModelo mo, int seleMarca) throws ClassNotFoundException{
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<MarcaModelo>  listMode = new ArrayList();
        
        try{
           
            //selecionar todas as marcas. 0 significa todas, passado valor significa o id marca
            if(seleMarca != 0 ){
              stat = conec.prepareStatement("SELECT ID_MARCA, NOME_MARCA  FROM MARCA"); 
              res = stat.executeQuery();
              
              while(res.next()){
                MarcaModelo mode = new  MarcaModelo();  
                mode.setIdModelo(res.getInt("Id"));
                mode.setNomeModelo(res.getString("MarcaN"));
                listMode.add(mode);
              }
            }
            else{
              stat = conec.prepareStatement("SELECT ID_MARCA, NOME_MARCA  FROM MARCA WHERE ID_MARCA = ?"); 
              stat.setInt(1, seleMarca);
              
              res = stat.executeQuery();
                while(res.next()){
                    MarcaModelo mode = new  MarcaModelo();  
                    mode.setIdModelo(res.getInt("Id"));
                    mode.setNomeModelo(res.getString("MarcaN"));
                    listMode.add(mode);
                } 
            }

        }
        catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           BDProductM.closeConnection(conec, stat);
            
       }
        return listMode;
    }
    
}
