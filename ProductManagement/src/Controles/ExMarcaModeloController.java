package Controles;

import static Controles.Main.stage;
import static Controles.MarcaModeloController.cadMarc;
import static Controles.MarcaModeloController.cadModel;
import DAO.MarcaModeloDao;
import DAO.ProdutoDao;
import Model.MarcaModelo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExMarcaModeloController implements Initializable {

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
        System.out.println("Controller ExcluiMarca inicializado!");
        cadMarc = false;
        cadModel = false;
        try {
            carregarListaModelo();
            carregarListaMarca();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onActionVoltar() {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
        cmbMarcModel.getSelectionModel().clearSelection();
    }

    public void onActionExcluir() throws ClassNotFoundException {
        Stage stage;
        stage = (Stage) btnSalvar.getScene().getWindow();
        try {
            if ("Excluir - Modelo".equals(stage.getTitle())) {
                MarcaModelo modelo = (MarcaModelo) cmbMarcModel.getSelectionModel().getSelectedItem();
                if (marcMo.removeModelo(modelo)) {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle(stage.getTitle());
                    alerta.setContentText("Modelo Excluído ! ");
                    alerta.show();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle(stage.getTitle());
                    alerta.setContentText("Modelo não pode ser excluído !");
                    alerta.show();
                }
            } else if ("Excluir - Marca".equals(stage.getTitle())) {
                MarcaModelo marc = (MarcaModelo) cmbMarcModel.getSelectionModel().getSelectedItem();
                if (marcMo.removeMarca(marc)) {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle(stage.getTitle());
                    alerta.setContentText("Marca Excluída !");
                    alerta.show();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle(stage.getTitle());
                    alerta.setContentText("Marca não pode ser excluída !");
                    alerta.show();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle(stage.getTitle());
            alerta.setContentText("Ocorreu erro ao excluir!" + "\nContate o Administrador!");
            alerta.show();
        }
    }

    public void onActionCombo() throws ClassNotFoundException {
        cmbMarcModel.getOnAction().toString();
    }

    public void carregarListaMarca() throws ClassNotFoundException {
        List<String> listaMarcas = new ArrayList();
        marcaData = marcMo.listMarca();
        for (int i = 0; i < marcaData.size(); i++) {
            listaMarcas.add(marcaData.get(i).getNomeMarca());
        }
        cmbMarcModel.setItems(FXCollections.observableArrayList(listaMarcas));
        cmbMarcModel.setValue("<Selecione>");
    }

    public void carregarListaModelo() throws ClassNotFoundException {
        List<String> listaModelos = new ArrayList();
        modeloData = marcMo.listModelo();
        for (int i = 0; i < modeloData.size(); i++) {
            listaModelos.add(modeloData.get(i).getNomeModelo());
        }
        cmbMarcModel.setItems(FXCollections.observableArrayList(listaModelos));
        cmbMarcModel.setValue("<Selecione>");
    }
}
