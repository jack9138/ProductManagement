/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import ConexaoBD.BDProductM;
import ConexaoBD.ConexaoBanco;

import Model.Relatorio;
import Model.Produto;
import Model.MarcaModelo;
import Model.EntEstoque;
import Model.SaiEstoque;
import java.sql.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class RelatorioDao {
    
    //Inicializando objetos
    private List<Relatorio> relat;
    
    
    //Método responsavel por trazer todos os dados de entrada de estoque
    public List<Relatorio> relatorioEntradaEstoque(Date dataInico, Date dataFim){
        Relatorio relatorio = new Relatorio();
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet result = null;
        int limit = 40;//limita a quantidade de registro a ser mostrado
        
        try{//Chama a procedure e seta os dados no relatorio de entrada de estoque
            stat = conec.prepareStatement("CALL P_RELATORIO_ENTESTOQUE('?','?',?,@P_NOMEPRODUTO,@P_NOMEMARCA,@P_NOMEMODELO,@P_PRECOUNID,@P_QTDENTRADAPRODUTO,@P_VALORTOTALENT,@P_DATAENTRADA);");
            stat.setDate(1, dataInico);
            stat.setDate(2, dataFim);
            stat.setInt(3,limit);
            
            result = stat.executeQuery();
            if(result.next()){
                while(result.next()){
                    relatorio.setNomeRelatorio("Relatorio - Comparativo");
                    relatorio.setNomeProduto(result.getString("@P_NOMEPRODUTO"));
                    relatorio.setNomeMarca(result.getString("@P_NOMEPRODUTO"));
                    relatorio.setNomeModelo(result.getString("@P_NOMEPRODUTO"));
                    relatorio.setPrecoUnid(result.getDouble("@P_PRECOUNID"));
                    relatorio.setQtdEstoque(result.getInt("@P_QTDENTRADAPRODUTO"));
                    relatorio.setValorTotal(result.getDouble("@P_VALORTOTALENT"));
                    relatorio.setDataComum(result.getDate("@P_DATAENTRADA"));
                    
                    relat.add(relatorio);//adiona os dados do relatorio na lista a ser retornada
                }
            }
        }catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + Arrays.toString(ex.getStackTrace()));
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           BDProductM.closeConnection(conec, stat);
        }
        return relat;
    }
    
    //Método responsavel por pegar os dados do relatorio de saida
    public List<Relatorio> relatorioSaidaEstoque(Date dataInico, Date dataFim){
        Relatorio relatorio = new Relatorio();
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet result = null;
        int limit = 40;//limita a quantidade de registro a ser mostrado
        
        //SimpleDateFormat formatador = new SimpleDateFormat("yyyy-mm-dd");
        try{
            stat = conec.prepareStatement("CALL P_RELATORIO_ENTESTOQUE('?','?',?,@P_NOMEPRODUTO,@P_NOMEMARCA,@P_NOMEMODELO,@P_PRECOUNID,@P_QTDSAIDAPRODUTO,@P_VALORTOTALSAI,@P_DATASAIDA);");
            stat.setDate(1, dataInico);
            stat.setDate(2, dataFim);
            stat.setInt(3,limit);
            
            result = stat.executeQuery();
            if(result.next()){
                 while(result.next()){
                    relatorio.setNomeRelatorio("Relatorio - Comparativo");
                    relatorio.setNomeProduto(result.getString("@P_NOMEPRODUTO"));
                    relatorio.setNomeMarca(result.getString("@P_NOMEPRODUTO"));
                    relatorio.setNomeModelo(result.getString("@P_NOMEPRODUTO"));
                    relatorio.setPrecoUnid(result.getDouble("@P_PRECOUNID"));
                    relatorio.setQtdEstoque(result.getInt("@@P_QTDSAIDAPRODUTO"));
                    relatorio.setValorTotal(result.getDouble("@P_VALORTOTALSAI"));
                    relatorio.setDataEntrada(result.getDate("@P_DATASAIDA"));
                    
                    relat.add(relatorio);//adiona os dados do relatorio na lista a ser retornada
                 }
            }
            
        }catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + Arrays.toString(ex.getStackTrace()));
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
        }finally {
           BDProductM.closeConnection(conec, stat,result);
        }
        return relat;
    }
    
    //Serve para comparar quantidade de entrada e saida de produto
    public List<Relatorio> relatorioComparativo(Date dataInico, Date dataFim){
        Relatorio relatorio = new Relatorio();
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet result = null;
        int limit = 40;//limita a quatindade de registro, verificar depois para ser possivel setar na tela
        
        try{
            stat = conec.prepareStatement("CALL P_RELATORIO_ENTESTOQUE('?','?',?,@P_NOMEPRODUTO,@P_NOMEMARCA ,@P_NOMEMODELO,@P_PRECOUNID ,@P_QTDENTRADAPRODUTO ,@P_QTDSAIDAPRODUTO,@P_VALORTOTALENT,@P_VALORTOTALSAI,@P_DATAENTRADA,@P_DATASAIDA);");
            stat.setDate(1, dataFim);
            stat.setDate(2, dataFim);
            stat.setInt(3,limit);
            
            result = stat.executeQuery();
            if(result.next()){
                while(result.next()){
                    relatorio.setNomeRelatorio("Relatorio - Comparativo");
                    relatorio.setNomeProduto(result.getString("@P_NOMEPRODUTO"));
                    relatorio.setNomeMarca(result.getString("@P_NOMEPRODUTO"));
                    relatorio.setNomeModelo(result.getString("@P_NOMEPRODUTO"));
                    relatorio.setPrecoUnid(result.getDouble("@P_PRECOUNID"));
                    relatorio.setQtdEstoque(result.getInt("@P_QTDENTRADAPRODUTO"));
                    relatorio.setValorTotalEnt(result.getDouble("@P_VALORTOTALENT"));
                    relatorio.setValorTotalSai(result.getDouble("@P_VALORTOTALSAI"));
                    relatorio.setDataEntrada(result.getDate("@P_DATAENTRADA"));
                    relatorio.setDataSaida(result.getDate("@P_DATASAIDA"));
                    
                    relat.add(relatorio);//adiona os dados do relatorio na lista a ser retornada
                }
                
                
            }
            
        }catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + Arrays.toString(ex.getStackTrace()));
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           BDProductM.closeConnection(conec, stat);
        }
        return relat;
    }
}
