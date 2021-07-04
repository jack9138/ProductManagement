/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author jaque
 */
public class BDProductM {
    
    public static Connection getConnection(){
        return new BDConexaoMySql().getConnection();
    }

    public static void closeConnection(Connection con) {
        
         try {
            if(con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if(stmt !=  null){
                stmt.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if(rs != null){
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
}
