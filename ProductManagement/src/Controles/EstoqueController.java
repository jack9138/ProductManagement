package Controles;

import DAO.EntEstoqueDao;
import DAO.ProdutoDao;
import Model.EntEstoque;
import Model.Produto;
import Model.SaiEstoque;
import Model.Usuario;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EstoqueController implements Initializable {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSalvar;

    @FXML
    private ComboBox cmbProdutos;

    @FXML
    private TextField txtQuantidade;

    private List<Produto> prodData;

    private EntEstoque entradaEst = new EntEstoque();

    private SaiEstoque saidaEst = new SaiEstoque();

    private EntEstoqueDao entDao = new EntEstoqueDao();

    private ProdutoDao prodDao = new ProdutoDao();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller Estoque inicializado!");
        try {
            carregarProdutos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onActionCancelar() {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    public void onActionSalvar() throws ClassNotFoundException, ParseException {
        Stage stage = (Stage) btnSalvar.getScene().getWindow();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        data = formato.parse(LocalDateTime.now().toString());
        Produto prod = new Produto();
        String selectProd = cmbProdutos.getSelectionModel().getSelectedItem().toString();
        for (int i = 0; i < prodData.size(); i++) {
            if (selectProd == prodData.get(i).getNomeProduto()) {
                prod.setIdProduto(prodData.get(i).getIdProduto());
                prod.setNomeProduto(prodData.get(i).getNomeProduto());
                prod.setMarca(prodData.get(i).getMarca());
                prod.setTamanho(prodData.get(i).getTamanho());
                prod.setCorProd(prodData.get(i).getNomeProduto());
                prod.setModelo(prodData.get(i).getModelo());
            }
        }
        if ("Cadastro - Estoque".equals(stage.getTitle())) {
            entradaEst.setProduto(prod);
            entradaEst.setQtdTotalEntrada(Integer.parseInt(txtQuantidade.getText()));
            entradaEst.setUserEntrada((Usuario) stage.getUserData());
            entradaEst.setValorTotalEstoque(prod.getValor() * entradaEst.getQtdTotalEntrada());
            entradaEst.setDataEntrada(data);
        } else if ("Retirada - Estoque".equals(stage.getTitle())) {
            saidaEst.setProduto(prod);
            saidaEst.setQtdTSai(Integer.parseInt(txtQuantidade.getText()));
            saidaEst.setUserSai((Usuario) stage.getUserData());
            saidaEst.setValorTSaiEstoque(prod.getValor() * saidaEst.getQtdTSai());
            saidaEst.setDataSai(data);
        }
    }

    public void carregarProdutos() throws ClassNotFoundException, SQLException {
        List<String> listaProd = new ArrayList();
        Produto prod = new Produto();
        prodData = prodDao.GetProduto(prod);
        for (int i = 0; i < prodData.size(); i++) {
            listaProd.add(prodData.get(i).getNomeProduto());
        }
        cmbProdutos.setItems(FXCollections.observableArrayList(listaProd));
        cmbProdutos.setValue("<Selecione>");
    }
}
