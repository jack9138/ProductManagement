/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.BDProductM;
import ConexaoBD.ConexaoBanco;
import Interfaces.ProdutoEstoque;
import Model.Produto;
import Model.Usuario;
import Model.MarcaModelo;

import java.sql.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ProdutoDao implements ProdutoEstoque {
    
    private UsuarioDao usrDAO = new UsuarioDao();
    private MarcaModelo marcMod = new MarcaModelo();
    
    //Método para adicionar Produto no Banco de Dados
    @Override
    public boolean AddProduto(Produto p){
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        PreparedStatement stat1 = null;
        PreparedStatement stat2 = null;
        ResultSet result = null;
        
        boolean cadastrado = false; 
        
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
            
            stat.execute();
            
            stat1 = conec.prepareStatement("SELECT MAX(PROD_ID) PROD_ID FROM PRODUTO;");
            
            result = stat1.executeQuery();
            result.next();
            int id_prod = result.getInt("PROD_ID");
            
            p.setIdProduto(id_prod);
 
            stat2 = conec.prepareStatement("INSERT INTO PRECOPRODUTO(COD_PRODUTO,COD_MARCA,COD_MODELO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO)"
                                            + "VALUES(?,?,?,?,?,?);");
            stat2.setInt(1,p.getIdProduto());
            stat2.setInt(2,p.getMarca().getIdMarca());
            stat2.setInt(3,p.getModelo().getIdModelo());
            stat2.setDouble(4, p.getValor());
            stat2.setString(5, p.getProdStatus());
            stat2.setString(6,dataFormatada);
            
            stat2.execute();
            
            cadastrado = true;
            
        }catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + Arrays.toString(ex.getStackTrace()));
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE); 
           cadastrado = false;
           
           
       }finally {
           BDProductM.closeConnection(conec, stat,result);
           BDProductM.closeConnection(conec, stat1);
           BDProductM.closeConnection(conec, stat2);
           
       }
         return cadastrado;
         
    }
    @Override
    //Método para deletar produtos
    public String RemoveProduto(Produto p){
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        PreparedStatement stat1 = null;
        ResultSet result = null;
        
        String excluido = new String();
        try{
            
            stat = conec.prepareStatement("DELETE FROM PRODUTO WHERE PROD_ID = ?");
            //Verificar se o produto possui estoque antes de excluir 
            stat1 = conec.prepareStatement("SELECT COUNT(COD_PRODUTO) FROM ESTOQUE WHERE COD_PRODUTO = ? AND QTD_ENTRADAPRODUTO > 0;");
            result = stat1.executeQuery();
            if(!result.next()){
                
                stat.setInt(1, p.getIdProduto());
                stat.execute();
                
                excluido = "Produto excluido!";
            }else{
               excluido = "Produto ainda possui estoque!";
            }
            
        }catch(SQLException ex){
            String strE = ex.toString();
            strE += ("\n" + Arrays.toString(ex.getStackTrace()));
           
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE); 
            
        }finally{
           BDProductM.closeConnection(conec, stat,result);
           BDProductM.closeConnection(conec, stat1);
        }
        return excluido;
    }
    
    @Override
    //Método para listagem de produtos cadastrados
    public List<Produto> GetProduto(Produto p){
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<Produto> listProduto = new ArrayList();
        
        try{//Usa a View para listar os produtos
            stat = conec.prepareStatement("SELECT * FROM V_LIST_PRODUTOS;");
            
            res = stat.executeQuery();
            
            while(res.next()){
                Produto prod = new  Produto();
                MarcaModelo marc = new  MarcaModelo();
                prod.setIdProduto(res.getInt("P_ID")); //P_ID, P_NOME,P_TAM,P_COR,P_MODELO,P_MARCA,M_NOMEMODELO,M_NOMEMARCA
                prod.setNomeProduto(res.getString("P_NOME").toUpperCase());
                prod.setCorProd(res.getString("P_COR"));
                marc.setIdMarca(res.getInt("P_MODELO"));
                marc.setNomeModelo(res.getString("M_NOMEMODELO"));
                marc.setIdModelo(res.getInt("P_MARCA"));
                marc.setNomeMarca(res.getString("M_NOMEMARCA"));
                prod.setMarca(marc);
                prod.setModelo(marc);
                
                listProduto.add(prod);
            }
  
        }catch(SQLException ex){

           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + ex.getStackTrace());  
       }finally {
           BDProductM.closeConnection(conec, stat,res);
           
       }
        return listProduto;
    }
    
    //Método para atualizar Produto
    //public void atualizarPrecoProduto(Produto p){
          //Fazer procedure ou trigger para chamar e realizar atualização.   
    //}

   // @Override
    //public void AddProduto(Produto prod) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

    //@Override
    //public void RemoveProduto(Produto prod) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    //@Override
    //public List<Produto> GetProduto(Produto prod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
    
}
