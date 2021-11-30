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

    private List<Relatorio> relat;

    public List<Relatorio> relatorioEntradaEstoque(Date dataInico, Date dataFim) {
        Relatorio relatorio = new Relatorio();
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet result = null;
        int limit = 40;
       /* try {
           
                //reimplementar 
           
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + Arrays.toString(ex.getStackTrace()));
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat);
        }*/
        return relat;
    }

    public List<Relatorio> relatorioSaidaEstoque(Date dataInico, Date dataFim) {
        Relatorio relatorio = new Relatorio();
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet result = null;
        int limit = 40;
        /*try {
           //reimplementar
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + Arrays.toString(ex.getStackTrace()));
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat, result);
        }*/
        return relat;
    }

    public List<Relatorio> relatorioComparativo(Date dataInico, Date dataFim) {
        Relatorio relatorio = new Relatorio();
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet result = null;
        int limit = 40;
        /*try {
           // reimplementar
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + Arrays.toString(ex.getStackTrace()));
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat);
        }*/
        return relat;
    }
}
