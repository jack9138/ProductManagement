/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaque
 */

public class ConexaoBanco {
    
    private Connection con = null;
    
    private String jdbcDriver = null;
    private String hostName = null;
    private String  url = null;
    private String  user= null;
    private String senha = null;
    private String nomeBanco = null;
    private String prefixoBanco = null;
    private String portaBanco = null;
    
    public ConexaoBanco(){
       super();
       
       //Dados setados abaixo serve para conectar no banco. 
       //"jdbc: mysql:/localhost:3306/meu_bd";
        hostName = "localhost";
        user = "Dev";
        senha = "Dev@9138";
        jdbcDriver = "org.gjt.mm.mysql.Driver";
        nomeBanco = "productmanagement";
        prefixoBanco = "jdbc: mysql:/";
        portaBanco = "3306";

        url = prefixoBanco + hostName + ":"+portaBanco+"/" + nomeBanco + "/"; 
    }
    
    public Connection getConnection(){
        try{
            if(con == null){
                Class.forName(jdbcDriver);
                con = DriverManager.getConnection(url, user, senha);
                
            }else if(!con.isClosed()){
                con = null;
                return getConnection();
            }
            
        }catch(SQLException ex){
            //Mlehorar forma de pegar e mostrar execções
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
