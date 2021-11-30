package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;

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
