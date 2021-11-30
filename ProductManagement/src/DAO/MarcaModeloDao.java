package DAO;

import ConexaoBD.BDProductM;
import Model.MarcaModelo;
import ConexaoBD.ConexaoBanco;
import java.sql.*;
import java.util.*;

public class MarcaModeloDao {

    private MarcaModelo marcMod = new MarcaModelo();

    public void adicionaMarca(MarcaModelo ma) throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        try {
            stat = conec.prepareStatement("INSERT INTO MARCA (NOME_MARCA) VALUES(?)");
            stat.setString(1, ma.getNomeMarca());
            stat.execute();
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + Arrays.toString(ex.getStackTrace()));
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat);
        }
    }

    public void adicionaModelo(MarcaModelo mo) throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        try {
            stat = conec.prepareStatement("INSERT INTO MODELO(NOME_MODELO) VALUES(?)");
            stat.setString(1, mo.getNomeModelo());
            stat.execute();
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + ex.getStackTrace());
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat);
        }
    }

    public boolean removeMarca(MarcaModelo ma) throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        PreparedStatement stat1 = null;
        ResultSet res = null;
        boolean excluido = false;
        try {
            stat1 = conec.prepareStatement(" SELECT COUNT(COD_MARCA) FROM ESTOQUE  WHERE COD_PRODUTO IN(SELECT PROD_ID FROM PRODUTO WHERE PROD_MARCA = ?);");
            stat1.setInt(1, ma.getIdMarca());
            res = stat1.executeQuery();
            if (!res.next()) {
                stat = conec.prepareStatement("DELETE FROM MARCA WHERE ID_MARCA = ?");
                stat.setInt(1, ma.getIdMarca());
                stat.execute();
                excluido = true;
            }
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + ex.getStackTrace());
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
            excluido = false;
        } finally {
            BDProductM.closeConnection(conec, stat);
        }
        return excluido;
    }

    public boolean removeModelo(MarcaModelo mo) throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        PreparedStatement stat1 = null;
        ResultSet res = null;
        boolean excluido = false;
        try {
            stat1 = conec.prepareStatement(" SELECT COUNT(COD_MODELO) FROM ESTOQUE  WHERE COD_PRODUTO IN(SELECT PROD_ID FROM PRODUTO WHERE PROD_MODELO = ?);");
            stat1.setInt(1, mo.getIdModelo());
            res = stat1.executeQuery();
            if (!res.next()) {
                stat = conec.prepareStatement("DELETE FROM MODELO WHERE NOME_MODELO ='?'");
                stat.setInt(1, mo.getIdModelo());
                stat.execute();
                excluido = true;
            }
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + ex.getStackTrace());
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
            excluido = false;
        } finally {
            BDProductM.closeConnection(conec, stat);
            BDProductM.closeConnection(conec, stat1, res);
        }
        return excluido;
    }

    public List<MarcaModelo> listMarca() throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<MarcaModelo> listMarc = new ArrayList();
        try {
            stat = conec.prepareStatement("SELECT ID_MARCA,NOME_MARCA FROM MARCA ORDER BY ID_MARCA ASC;");
            res = stat.executeQuery();
            while (res.next()) {
                MarcaModelo marc = new MarcaModelo();
                marc.setIdMarca(res.getInt("ID_MARCA"));
                marc.setNomeMarca(res.getString("NOME_MARCA"));
                listMarc.add(marc);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + ex.getStackTrace());
        } finally {
            BDProductM.closeConnection(conec, stat, res);
        }
        return listMarc;
    }

    public List<MarcaModelo> listModelo() throws ClassNotFoundException {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<MarcaModelo> listMode = new ArrayList();
        try {
            stat = conec.prepareStatement("SELECT ID_MODELO,NOME_MODELO FROM MODELO ORDER BY ID_MODELO ASC");
            res = stat.executeQuery();
            while (res.next()) {
                MarcaModelo mode = new MarcaModelo();
                mode.setIdModelo(res.getInt("ID_MODELO"));
                mode.setNomeModelo(res.getString("NOME_MODELO"));
                listMode.add(mode);
            }
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + Arrays.toString(ex.getStackTrace()));
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat, res);
        }
        return listMode;
    }
}
