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
public class BDConexaoMySql extends  ConexaoBanco{
    
    public BDConexaoMySql(){
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.porta = 3306;
        this.servidor = "localhost";
        this.bd = "productmanagement";
        this.usuario = "Dev";
        this.senha = "Dev@9138";
    }
    
    @Override
    public Connection getConnection(){
        try {
            Class.forName(driver);
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(getURL(), usuario, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDConexaoMySql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BDConexaoMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
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
    
    @Override
    public String getURL() {
        
        return "jdbc:mysql://" + this.servidor + ":" + this.porta + "/" + this.bd
                + "?useTimezone=true&serverTimezone=UTC";
        
    }

}
