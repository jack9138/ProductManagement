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

public abstract class ConexaoBanco {
    
    protected Connection con;
    protected String servidor;
    protected String bd;
    protected String usuario;
    protected String senha;
    protected String driver;
    protected int porta;
    
    public abstract Connection getConnection();
    
    public abstract String getURL();

}
