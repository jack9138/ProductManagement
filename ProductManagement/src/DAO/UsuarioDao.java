package DAO;

import ConexaoBD.BDProductM;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

public class UsuarioDao {

    public int verificaLogin(String user, String senha) throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet result = null;
        int verify = 0;
        try {
            stat = conec.prepareStatement("SELECT US_ID FROM USSISTEMA WHERE US_LOGIN = ?  AND US_SENHA= ? AND US_STATUS = 'A';");
            stat.setString(1, user);
            stat.setString(2, senha);
            result = stat.executeQuery();
            if (result.next()) {
                verify = result.getInt("US_ID");
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: \n");
            ex.printStackTrace();
        } finally {
            BDProductM.closeConnection(conec, stat, result);
            return verify;
        }
    }

    public Usuario lerUser(int usr_id) throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet result = null;
        Usuario usuario = new Usuario();
        try {
            stat = conec.prepareStatement("SELECT US.USR_ID,US.USR_NOME,US.USR_TELEFONE,US.USR_EMAIL,US.USR_CPF,US.USR_FUNCAO,US.USR_ESTADO,US.USR_CIDADE,US.USR_BAIRRO,US.USR_RUA," + "UST.US_LOGIN,UST.US_SENHA, UST.US_GROUPID FROM USUARIOS AS US INNER JOIN USSISTEMA AS UST ON US.USR_ID = UST.US_ID WHERE UST.US_ID = ? ;");
            stat.setInt(1, usr_id);
            result = stat.executeQuery();
            if (result.next()) {
                usuario.setUsId(result.getInt("US.USR_ID"));
                usuario.setNome(result.getString("US.USR_NOME"));
                usuario.setTelefone(result.getString("US.USR_TELEFONE"));
                usuario.setEmail(result.getString("US.USR_EMAIL"));
                usuario.setCPF(result.getString("US.USR_CPF"));
                usuario.setFuncao(result.getString("US.USR_FUNCAO"));
                usuario.setEstado(result.getString("US.USR_ESTADO"));
                usuario.setBairro(result.getString("US.USR_BAIRRO"));
                usuario.setRua(result.getString("US.USR_RUA"));
                usuario.setLogin(result.getString("UST.US_LOGIN"));
                usuario.setSenha(result.getString("UST.US_SENHA"));
                usuario.setGrupoUser(result.getInt("UST.US_GROUPID"));
            }
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + ex.getStackTrace());
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } catch (Exception ex) {
            String strE = ex.toString();
            strE += ("\n" + ex.getStackTrace());
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat, result);
        }
        return usuario;
    }

    public boolean cadastraUsuario(Usuario us) throws ClassNotFoundException, SQLException, Exception {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat1 = null;
        PreparedStatement stat2 = null;
        PreparedStatement stat3 = null;
        ResultSet result = null;
        boolean cadEfect = false;
        try {
            stat1 = conec.prepareStatement("INSERT INTO USUARIOS (USR_NOME,USR_TELEFONE,USR_EMAIL,USR_CPF,USR_FUNCAO,USR_ESTADO,USR_CIDADE,USR_BAIRRO,USR_RUA,USR_STATUS) " + "VALUES(?, ?,?, ?,?, ?, ?, ?, ?, ?);");
            stat1.setString(1, us.getNome());
            stat1.setString(2, us.getTelefone());
            stat1.setString(3, us.getEmail());
            stat1.setString(4, us.getCPF());
            stat1.setString(5, us.getFuncao());
            stat1.setString(6, us.getEstado());
            stat1.setString(7, us.getCidade());
            stat1.setString(8, us.getBairro());
            stat1.setString(9, us.getRua());
            stat1.setString(10, Character.toString(us.getUsStatus()));
            stat1.execute();
            cadEfect = true;
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            BDProductM.closeConnection(conec, stat1, result);
            BDProductM.closeConnection(conec, stat2, result);
            BDProductM.closeConnection(conec, stat3, result);
            return cadEfect;
        }
    }

    public boolean cadastrarUsSistema(Usuario us) throws ClassNotFoundException, SQLException, Exception {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat2 = null;
        ResultSet result = null;
        boolean cadEfect = false;
        try {
            stat2 = conec.prepareStatement("INSERT INTO USSISTEMA (US_ID,US_LOGIN,US_SENHA,US_STATUS,US_GROUPID) \n" + "                                                VALUES((SELECT MAX(USR_ID) FROM USUARIOS), ?, ?, ?,?);");
            stat2.setString(1, us.getLogin());
            stat2.setString(2, us.getSenha());
            stat2.setString(3, Character.toString(us.getUsStatus()));
            stat2.setInt(4, us.getGrupoUser());
            stat2.execute();
            cadEfect = true;
        } catch (SQLException ex) {
            cadEfect = false;
            throw new SQLException(ex);
        } catch (Exception ex) {
            cadEfect = false;
            throw new Exception(ex);
        } finally {
            BDProductM.closeConnection(conec, stat2, result);
            return cadEfect;
        }
    }

    public void inativarUser(Usuario us) throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        try {
            stat = conec.prepareStatement("UPDATE USSISTEMA SET US_STATUS = '?'  WHERE US_ID = ? ");
            stat.setString(1, "I");
            stat.setInt(2, us.getUsId());
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + ex.getStackTrace());
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } catch (Exception ex) {
            String strE = ex.toString();
            strE += ("\n" + ex.getStackTrace());
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat);
        }
    }

    public int verificaEmail(String user) throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet result = null;
        int verify = 0;
        try {
            stat = conec.prepareStatement("SELECT US_ID FROM USSISTEMA WHERE US_LOGIN = ? AND US_STATUS = 'A';");
            stat.setString(1, user);
            result = stat.executeQuery();
            if (result.next()) {
                verify = result.getInt("US_ID");
            }
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + ex.getStackTrace());
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat, result);
            return verify;
        }
    }
}
