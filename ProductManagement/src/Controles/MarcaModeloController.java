/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
/**
 *
 * @author jaque
 */
public class MarcaModeloController implements Initializable {
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnSalvar;
    
    @FXML
    private Label lbMarcModel;
    
    @FXML
    private TextField txtNomeMarcaModel;
    
    private static MarcaModelo marcaModel;
    private MarcaModeloDao mDao;
    
    protected static boolean cadMarc; //verificar se foi cadastrado ou não
    protected static boolean cadModel;       
    public static MarcaModelo getMarca() {
        return marcaModel;
    }
    
  
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Cadastro Marca/Modelo inicializado!");
        marcaModel = new MarcaModelo();
        mDao = new MarcaModeloDao();
        cadMarc = false;
        cadModel = false;
    }
    
    public void setMarcaTexto(String mensagem) {
        //String mensage = "Cadastrar Marca";
        lbMarcModel.setText(mensagem);
    }
    
    public void setModeloTexto(String mensagem) {
        //String mensage = "Cadastrar Modelo";
        lbMarcModel.setText(mensagem);
    }
    
    public void onActionVoltar(){
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
    }
    
    public void onActionSalvar() throws ClassNotFoundException{

        Stage stage;
        stage = (Stage) btnSalvar.getScene().getWindow();
        
        try{
            if("Cadastrar Marca".equals(stage.getTitle())){
           
                marcaModel.setNomeMarca(txtNomeMarcaModel.getText().toUpperCase());
                mDao.adicionaMarca(marcaModel);
                cadMarc = true;
            }
            else if("Cadastrar Modelo".equals(stage.getTitle())){
                marcaModel.setNomeModelo(txtNomeMarcaModel.getText().toUpperCase());
                mDao.adicionaModelo(marcaModel);
                cadModel = true;
            }
        }catch(Exception ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle(stage.getTitle());
                alerta.setContentText("Ocorreu erro ao realizar cadastro!" +
                                       "\nContate o Administrador!");
                
                alerta.showAndWait();
            cadMarc = false;
            cadModel = false;
        }
        
        if(cadMarc != false){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle(stage.getTitle());
                alerta.setContentText("Cadastro efetuado com sucesso! ");
                alerta.showAndWait();
            System.out.println("Cadastro efetuado com sucesso!");
            stage.close();
        }
        else if (cadModel != false){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle(stage.getTitle());
                alerta.setContentText("Cadastro efetuado com sucesso! ");
                alerta.showAndWait();
            System.out.println("Cadastro efetuado com sucesso!");
            stage.close();
        }
        
    }
}
