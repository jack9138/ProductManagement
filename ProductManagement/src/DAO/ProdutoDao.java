package DAO;

import ConexaoBD.BDProductM;
import ConexaoBD.ConexaoBanco;
import Model.Produto;
import Model.Usuario;
import Model.MarcaModelo;
import java.sql.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import Composite.ComponentProduto;

public class ProdutoDao {

    private UsuarioDao usrDAO = new UsuarioDao();

    private MarcaModelo marcMod = new MarcaModelo();

    public boolean AddProduto(Produto p) {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        PreparedStatement stat1 = null;
        PreparedStatement stat2 = null;
        ResultSet result = null;
        boolean cadastrado = false;
        LocalDate dataLocal = LocalDate.now();
        DateTimeFormatter formtData = DateTimeFormatter.ofPattern("2021-02-28");
        String dataFormatada = dataLocal.format(formtData);
        try {
            stat = conec.prepareStatement("INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA)" + "VALUES(?,?,?,?,?);");
            stat.setString(1, p.getNomeProduto());
            stat.setInt(2, p.getTamanho());
            stat.setString(3, p.getCorProd());
            stat.setInt(4, p.getModelo().getIdModelo());
            stat.setInt(5, p.getMarca().getIdMarca());
            stat.execute();
            stat1 = conec.prepareStatement("SELECT MAX(PROD_ID) PROD_ID FROM PRODUTO;");
            result = stat1.executeQuery();
            result.next();
            int id_prod = result.getInt("PROD_ID");
            p.setIdProduto(id_prod);
            stat2 = conec.prepareStatement("INSERT INTO PRECOPRODUTO(COD_PRODUTO,COD_MARCA,COD_MODELO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO)" + "VALUES(?,?,?,?,?,?);");
            stat2.setInt(1, p.getIdProduto());
            stat2.setInt(2, p.getMarca().getIdMarca());
            stat2.setInt(3, p.getModelo().getIdModelo());
            stat2.setDouble(4, p.getValor());
            stat2.setString(5, p.getProdStatus());
            stat2.setString(6, dataFormatada);
            stat2.execute();
            cadastrado = true;
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + Arrays.toString(ex.getStackTrace()));
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "C??digo de erro: " + strE);
            cadastrado = false;
        } finally {
            BDProductM.closeConnection(conec, stat, result);
            BDProductM.closeConnection(conec, stat1);
            BDProductM.closeConnection(conec, stat2);
        }
        return cadastrado;
    }

    public String RemoveProduto(Produto p) {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        PreparedStatement stat1 = null;
        ResultSet result = null;
        String excluido = new String();
        try {
            stat = conec.prepareStatement("DELETE FROM PRODUTO WHERE PROD_ID = ?");
            stat1 = conec.prepareStatement("SELECT COUNT(COD_PRODUTO) FROM ESTOQUE WHERE COD_PRODUTO = ? AND QTD_ENTRADAPRODUTO > 0;");
            result = stat1.executeQuery();
            if (!result.next()) {
                stat.setInt(1, p.getIdProduto());
                stat.execute();
                excluido = "Produto excluido!";
            } else {
                excluido = "Produto ainda possui estoque!";
            }
        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + Arrays.toString(ex.getStackTrace()));
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "C??digo de erro: " + strE);
        } finally {
            BDProductM.closeConnection(conec, stat, result);
            BDProductM.closeConnection(conec, stat1);
        }
        return excluido;
    }

    public List<Produto> GetProduto(Produto p) {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<Produto> listProduto = new ArrayList();
        try {
            stat = conec.prepareStatement("SELECT * FROM V_LIST_PRODUTOS;");
            res = stat.executeQuery();
            while (res.next()) {
                Produto prod = new Produto();
                MarcaModelo marc = new MarcaModelo();
                prod.setIdProduto(res.getInt("P_ID"));
                prod.setNomeProduto(res.getString("P_NOME").toUpperCase()); 
                prod.setCorProd(res.getString("P_COR"));
                prod.setValor(res.getDouble("VALORUNIDPRODUTO"));
                marc.setIdMarca(res.getInt("P_MODELO"));
                marc.setNomeModelo(res.getString("M_NOMEMODELO"));
                marc.setIdModelo(res.getInt("P_MARCA"));
                marc.setNomeMarca(res.getString("M_NOMEMARCA"));
                prod.setMarca(marc);
                prod.setModelo(marc);
                listProduto.add(prod);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "C??digo de erro: " + ex.getStackTrace());
        } finally {
            BDProductM.closeConnection(conec, stat, res);
        }
        return listProduto;
    }
}
