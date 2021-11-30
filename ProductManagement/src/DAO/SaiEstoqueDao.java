package DAO;

import ConexaoBD.BDProductM;
import ConexaoBD.ConexaoBanco;
import Model.EntEstoque;
import Model.SaiEstoque;
import Model.Produto;
import Model.MarcaModelo;
import Model.Usuario;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SaiEstoqueDao {
    
    private UsuarioDao usrDAO = new UsuarioDao();

    private MarcaModelo marcMod = new MarcaModelo();

    public boolean AddSaiEstoque(EntEstoque entrada, int qtdProduto) {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        PreparedStatement stat1 = null;
        ResultSet result = null;
        boolean estocado = false;
        String dataLocal = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 

        try {
            stat = conec.prepareStatement("INSERT INTO SAIDAESTOQUE(COD_PRODUTO,QTD_SAIDAPRODUTO,VALOR_SAIDAES,USRID_RETIRADA,DATA_SAIDAES) VALUES(?,?,?,?,?);");
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

    public List<Integer> GetIdSaiEstoque() {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<Integer> listIdEstoque = new ArrayList<Integer>();

        try {
            stat = conec.prepareStatement("SELECT COD_SAIDA FROM SAIDAESTOQUE;");
            res = stat.executeQuery();
            while (res.next()) {

                int id_Estoque = res.getInt("COD_SAIDA");

                listIdEstoque.add(id_Estoque);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + ex.getStackTrace());
        } finally {
            BDProductM.closeConnection(conec, stat, res);
        }
        return listIdEstoque;

    }

    public List<SaiEstoque> GetDadosSaiEstoque(int idEstoque) {
        Connection conec = BDProductM.getConnection();
        PreparedStatement stat = null;
        ResultSet res = null;
        List<SaiEstoque> listSaiEstoque = new ArrayList();
        Produto prod = new Produto();
        Usuario user = new Usuario();
        try {
            stat = conec.prepareStatement("SELECT * FROM V_LIST_PRODUTOS;"); //falta trocar query para certa
            res = stat.executeQuery();
            while (res.next()) {
                SaiEstoque saiEstoque = new SaiEstoque();
                prod.setIdProduto(res.getInt("IDPRODUTO"));
                prod.setNomeProduto(res.getString("NOMEPRODUTO"));
                saiEstoque.setProduto(prod);
                saiEstoque.setDataSai(res.getDate("DATA_ENTRADA"));
                saiEstoque.setQtdTSai(res.getInt("QTDENTRADA"));
                saiEstoque.setValorTSaiEstoque(res.getDouble("VALORESTOQUE"));
                user.setNome(res.getString("USERENTRADA"));
                saiEstoque.setUserSai(user);

                listSaiEstoque.add(saiEstoque);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n" + "Conte o administrador: \n" + "Código de erro: " + ex.getStackTrace());
        } finally {
            BDProductM.closeConnection(conec, stat, res);
        }
        return listSaiEstoque;
    }
    
}
