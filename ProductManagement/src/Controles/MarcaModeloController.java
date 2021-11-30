package Controles;

import static Controles.Main.stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Model.MarcaModelo;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import DAO.MarcaModeloDao;
import DAO.ProdutoDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MarcaModeloController implements Initializable {

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnSalvar;

    @FXML
    private Label lbMarcModel;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtNomeMarcaModel;

    @FXML
    private ComboBox cmbMarcModel;

    private List<MarcaModelo> marcaData;

    private List<MarcaModelo> modeloData;

    private MarcaModeloDao marcMo = new MarcaModeloDao();

    ;

    private ProdutoDao prodDao = new ProdutoDao();

    private MarcaModelo marcModel = new MarcaModelo();

    protected static boolean cadMarc;

    protected static boolean cadModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller Marca/Modelo inicializado!");
    }

    public void onActionVoltar() {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
        cmbMarcModel.getSelectionModel().clearSelection();
    }

    public void onActionSalvar() throws ClassNotFoundException {
        Stage stage;
        stage = (Stage) btnSalvar.getScene().getWindow();
        try {
            if ("Cadastrar Marca".equals(stage.getTitle())) {
                marcModel.setNomeMarca(txtNomeMarcaModel.getText().toUpperCase());
                marcMo.adicionaMarca(marcModel);
                cadMarc = true;
            } else if ("Cadastrar Modelo".equals(stage.getTitle())) {
                marcModel.setNomeModelo(txtNomeMarcaModel.getText().toUpperCase());
                marcMo.adicionaModelo(marcModel);
                cadModel = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle(stage.getTitle());
            alerta.setContentText("Ocorreu erro ao realizar cadastro!" + "\nContate o Administrador!");
            alerta.showAndWait();
            cadMarc = false;
            cadModel = false;
        }
        if (cadMarc != false) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle(stage.getTitle());
            alerta.setContentText("Cadastro efetuado com sucesso! ");
            alerta.showAndWait();
            System.out.println("Cadastro efetuado com sucesso!");
            stage.close();
        } else if (cadModel != false) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle(stage.getTitle());
            alerta.setContentText("Cadastro efetuado com sucesso! ");
            alerta.showAndWait();
            System.out.println("Cadastro efetuado com sucesso!");
            stage.close();
        }
    }
}
