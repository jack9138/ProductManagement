package DAO;

import ConexaoBD.BDProductM;
import ConexaoBD.ConexaoBanco;
import Model.EntEstoque;
import Model.EntEstoque;
import Model.MarcaModelo;
import Model.Produto;
import Model.Usuario;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EntEstoqueDao {

    private UsuarioDao usrDAO = new UsuarioDao();

    private MarcaModelo marcMod = new MarcaModelo();

    public boolean AddEstoque(EntEstoque entrada, int qtdProduto) {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        PreparedStatement stat1 = null;
        ResultSet result = null;
        boolean estocado = false;
        String dataLocal = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 

        try {
            stat = conec.prepareStatement("INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(?,?,?,?,?);");
            stat.setInt(1, entrada.getProdutos().getIdProduto());
            stat.setInt(2, entrada.getQtdTotalEntrada());
            stat.setDouble(3, entrada.getValorTotalEstoque());
            stat.setString(4, entrada.getUserEntrada().toString());
            stat.setString(5, dataLocal);
            stat.execute();

            estocado = true;

        } catch (SQLException ex) {
            String strE = ex.toString();
            strE += ("\n" + Arrays.toString(ex.getStackTrace()));
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + strE);
            estocado = false;
        } finally {
            BDProductM.closeConnection(conec, stat, result);
            BDProductM.closeConnection(conec, stat1);

        }
        return estocado;
    }

    public List<Integer> GetIdEstoque() {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<Integer> listIdEstoque = new ArrayList<Integer>();

        try {
            stat = conec.prepareStatement("SELECT COD_ESTOQUE FROM ESTOQUE;");
            res = stat.executeQuery();
            while (res.next()) {

                int id_Estoque = res.getInt("COD_ESTOQUE");

                listIdEstoque.add(id_Estoque);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + ex.getStackTrace());
        } finally {
            BDProductM.closeConnection(conec, stat, res);
        }
        return listIdEstoque;

    }

    public List<EntEstoque> GetDadosEstoque(int idEstoque) {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<EntEstoque> listEstoque = new ArrayList();
        Produto prod = new Produto();
        Usuario user = new Usuario();
        try {
            stat = conec.prepareStatement("SELECT * FROM V_LIST_PRODUTOS;"); //falta trocar query para certa
            res = stat.executeQuery();
            while (res.next()) {
                EntEstoque entEstoque = new EntEstoque();
                prod.setIdProduto(res.getInt("IDPRODUTO"));
                prod.setNomeProduto(res.getString("NOMEPRODUTO"));
                entEstoque.setProduto(prod);
                entEstoque.setDataEntrada(res.getDate("DATA_ENTRADA"));
                entEstoque.setQtdTotalEntrada(res.getInt("QTDENTRADA"));
                entEstoque.setValorTotalEstoque(res.getDouble("VALORESTOQUE"));
                user.setNome(res.getString("USERENTRADA"));
                entEstoque.setUserEntrada(user);

                listEstoque.add(entEstoque);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + ex.getStackTrace());
        } finally {
            BDProductM.closeConnection(conec, stat, res);
        }
        return listEstoque;
    }

}
