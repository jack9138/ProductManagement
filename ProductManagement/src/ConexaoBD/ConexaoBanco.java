/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.lang.Exception;
import java.sql.*;

/**
 *
 * @author jaque
 * #Avisos#
 * Classe para conexão do Banco, deve ser verificado os dados de conexão antes
 * Pois para cada local os dados podem variar, como user,host,senha e etc. 
 */

public class ConexaoBanco {
    
    //private Connection con = null;
    
    private static String jdbcDriver ="com.mysql.jdbc.Driver";
    //private String hostName = null;
    private static String  url = "jdbc: mysql:/localhost:3306/productmanagement/";
    private static String  user= "Dev";
    private static String senha = "Dev@9138";
    //private String nomeBanco = null;
    //private String prefixoBanco = null;
    //private String portaBanco = null;
    
   /* public ConexaoBanco(){
       super();
       
       //Dados setados abaixo serve para conectar no banco. 
       //"jdbc: mysql:/localhost:3306/meu_bd";
        hostName = "localhost";
        user = "Dev";
        senha = "Dev@9138";
        jdbcDriver = "org.gjt.mm.mysql.Driver";//antigo
        nomeBanco = "productmanagement";
        prefixoBanco = "jdbc: mysql:/";
        portaBanco = "3306";

        url = prefixoBanco + hostName + ":"+portaBanco+"/" + nomeBanco + "/"; 
    }*/
    
    public static  Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName(jdbcDriver);
            return DriverManager.getConnection(url, user, senha);
                
        }catch(SQLException ex){
            //Ver melhor forma de pegar e mostrar execções
            String strE = ex.toString();
            
            throw new RuntimeException("Erro ao tentar conectar !" 
                                        +"\nCódigo do erro: " + strE);
            
        } 
    }
    
    public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        //Tratamento de exceções, verificar outras formas    
        } catch(SQLException ex ){
            ex.printStackTrace();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stat){
        
        closeConnection(con);
        
        try{
            if(stat != null){
                stat.close();
            }
        //Tratamento de exceções, verificar outras formas    
        } catch(SQLException ex ){
            ex.printStackTrace();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     public static void closeConnection(Connection con, PreparedStatement stat, ResultSet rst){
        
        closeConnection(con, stat);
        
        try{
            if(rst != null){
                rst.close();
            }
        //Tratamento de exceções, verificar outras formas    
        } catch(SQLException ex ){
            ex.printStackTrace();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


}
