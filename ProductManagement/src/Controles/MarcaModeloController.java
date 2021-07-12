/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Button btnCancelar;
    
    @FXML
    private TextField txtNomeMarcaModel;
    
    //@FXML
    //private Text textExcluir;
    
    @FXML
    private ComboBox cmbMarcModel;
    
    private List<MarcaModelo> marcaData;
    
    private List<MarcaModelo> modeloData;
    
    
    private MarcaModeloDao marcMo = new MarcaModeloDao();;
    
    private ProdutoDao prodDao = new ProdutoDao();
    
    private MarcaModelo marcModel = new MarcaModelo();
    
    
    protected static boolean cadMarc; //verificar se foi cadastrado ou não
    protected static boolean cadModel;//verificar se foi cadastrado ou não


  
    
    @Override//Inicia a tela de Marca e Modelo
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller Marca/Modelo inicializado!");
 
     
    }
    
    //public void setMarcaTexto(String mensagem) {
        
       // lbMarcModel.setText(mensagem);
    //}
    
    //public void setModeloTexto(String mensagem) {
   
       // lbMarcModel.setText(mensagem);
   // }
    
    //Retorna a tela Menu
    public void onActionVoltar(){
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
        cmbMarcModel.getSelectionModel().clearSelection();
    }
    
    //Método para salvar as informações
    public void onActionSalvar() throws ClassNotFoundException{

        Stage stage;
        stage = (Stage) btnSalvar.getScene().getWindow();
        
        try{//verifica se é modelo ou marca e seta as informações para salvar no Banco 
            if("Cadastrar Marca".equals(stage.getTitle())){
           
                marcModel.setNomeMarca(txtNomeMarcaModel.getText().toUpperCase());
                marcMo.adicionaMarca(marcModel);
                cadMarc = true;
            }
            else if("Cadastrar Modelo".equals(stage.getTitle())){
                marcModel.setNomeModelo(txtNomeMarcaModel.getText().toUpperCase());
                marcMo.adicionaModelo(marcModel);
                cadModel = true;
            }
        }catch(Exception ex){//Se ocorrer erro deve ser apresentado um alerta de erro
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle(stage.getTitle());
                alerta.setContentText("Ocorreu erro ao realizar cadastro!" +
                                       "\nContate o Administrador!");
                
                alerta.showAndWait();
            cadMarc = false;
            cadModel = false;
        }
        //Alerta de sucesso no cadastro
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
//    //Dispara o método para excluir uma marca
//    public void onActionExcluir() throws ClassNotFoundException{
//        Stage stage;
//        stage = (Stage) btnSalvar.getScene().getWindow();
//  
//        try{
//            if("Excluir - Modelo".equals(stage.getTitle())){
//                MarcaModelo modelo = (MarcaModelo) cmbMarcModel.getSelectionModel().getSelectedItem();
//                
//                //chama o método removeMarca da classe DAO
//                if(marcMo.removeModelo(modelo)){
//                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//                    alerta.setTitle(stage.getTitle());
//                    alerta.setContentText("Modelo Excluído ! ");
//                
//                    alerta.show();
//                }else{
//                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//                    alerta.setTitle(stage.getTitle());
//                    alerta.setContentText("Modelo não pode ser excluído !");
//                
//                    alerta.show();
//                }
//                
//            }else if ("Excluir - Marca".equals(stage.getTitle())){
//                MarcaModelo marc = (MarcaModelo) cmbMarcModel.getSelectionModel().getSelectedItem();
//                
//                //chama o método removeMarca da classe DAO
//               if(marcMo.removeMarca(marc)){
//                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//                    alerta.setTitle(stage.getTitle());
//                    alerta.setContentText("Marca Excluída !");
//                
//                    alerta.show();
//               }else{
//                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//                    alerta.setTitle(stage.getTitle());
//                    alerta.setContentText("Marca não pode ser excluída !");
//                
//                    alerta.show();
//                }
//            }
//            
//        }catch(Exception ex){
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//                alerta.setTitle(stage.getTitle());
//                alerta.setContentText("Ocorreu erro ao excluir!" +
//                                       "\nContate o Administrador!");
//                
//                alerta.show();
//        }
//    }
//    
//    //Selecionar Marca/Modelo
//    public void onActionCombo() throws ClassNotFoundException{
//       cmbMarcModel.getOnAction().toString();
//    }
//    //Método para carregar combo com os dados de Marca
//    public void carregarListaMarca() throws ClassNotFoundException{
//        
//        List<String> listaMarcas = new ArrayList<>();
//        
//        marcaData = marcMo.listMarca();
//        
//        for(int i = 0; i < marcaData.size(); i++){ 
//            listaMarcas.add(marcaData.get(i).getNomeMarca());
//        }
//        cmbMarcModel.setItems(FXCollections.observableArrayList(listaMarcas));
//        cmbMarcModel.setValue("<Selecione>");
//    }
//    //Método para carregar combo com os dados de Modelo. 
//    public void carregarListaModelo() throws ClassNotFoundException{
//        
//        List<String> listaModelos = new ArrayList<>();
//        
//        modeloData = marcMo.listModelo();
//        
//        for(int i = 0; i < modeloData.size(); i++){
//            listaModelos.add(modeloData.get(i).getNomeModelo());
//        }
//        cmbMarcModel.setItems(FXCollections.observableArrayList(listaModelos));
//        cmbMarcModel.setValue("<Selecione>");
//        
//    }
}
