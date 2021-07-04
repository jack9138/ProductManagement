/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.BDProductM;
import ConexaoBD.ConexaoBanco;
import Model.Produto;
import Model.Usuario;
import Model.MarcaModelo;

import java.sql.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ProdutoDao {
    
    private UsuarioDao usrDAO = new UsuarioDao();
    private MarcaModelo marcMod = new MarcaModelo();
    
    
    public void adicionaProduto(Produto p) throws ClassNotFoundException{
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        PreparedStatement stat1 = null;
        
        LocalDate dataLocal = LocalDate.now();
        DateTimeFormatter formtData = DateTimeFormatter.ofPattern("2021-02-28");
        String dataFormatada = dataLocal.format(formtData);
        try{
            stat = conec.prepareStatement("INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA)"+
                                           "VALUES(?,?,?,?,?);");
            
            stat.setString(1,p.getNomeProduto());
            stat.setInt(2,p.getTamanho());
            stat.setString(3,p.getCorProd());
            stat.setInt(4,p.getModelo().getIdModelo());
            stat.setInt(5,p.getMarca().getIdMarca());
            
            stat1 = conec.prepareStatement("INSERT INTO PRECOPRODUTO(COD_PRODUTO,COD_MARCA,COD_MODELO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO)"
                                            + "VALUES(?,?,?,?,?,?);");
            stat1.setInt(1,p.getIdProduto());
            stat1.setInt(2,p.getMarca().getIdMarca());
            stat1.setInt(3,p.getModelo().getIdModelo());
            stat1.setDouble(4, p.getValor());
            stat1.setString(5, p.getProdStatus());
            stat1.setString(6,dataFormatada);
            
        }catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           BDProductM.closeConnection(conec, stat);
           BDProductM.closeConnection(conec, stat1);
           
       }
        
    }
    
    //public void deletarProduto(Produto p){
          //Fazer trigger  ou proc pra deletar produto.  
    //}
    
  
    //public void listarProduto(Produto p){
          //Fazer proc ou view para listar todos os produtos.  
    //}
    
    //public void atualizarPrecoProduto(Produto p){
          //Fazer procedure ou trigger para chamar e realizar atualização.   
    //}
    
    
}
