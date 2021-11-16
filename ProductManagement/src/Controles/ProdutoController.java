/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import DAO.MarcaModeloDao;
import DAO.ProdutoDao;
import Model.MarcaModelo;
import Model.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jaque
 */
public class ProdutoController implements Initializable  {
    
    @FXML
    private TextField txtNomeProduto;
    @FXML
    private TextField txtPreco;
    @FXML
    private TextField txtTam;
    @FXML
    private TextField txtCor;
   
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnFinalizar;
    
    @FXML
    private ComboBox cmbProdutos;
    
    @FXML
    private ComboBox cmbSelectMarca;
    @FXML
    private ComboBox cmbSelectModelo;
    @FXML
    private List<MarcaModelo> marcaData;
    @FXML
    private List<MarcaModelo> modeloData;
    @FXML
    private List<Produto> prodData;
    
    @FXML
    private Button btnExcluir;
    @FXML
    private Text txtNome;
    
    private MarcaModeloDao marcMo = new MarcaModeloDao();;
    
    private ProdutoDao prodDao = new ProdutoDao();
    
    private MarcaModelo marcModel = new MarcaModelo();
    
    
    @Override//Inicia as telas de Produto
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller Produto inicializado!");
        
   
        //Inicia as listas de Objetos
        marcaData = new ArrayList();
        modeloData = new ArrayList();
        prodData = new ArrayList();
        
        try {
               
            carregarListaModelo();
            carregarListaMarca();
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //Salva os dados do produto
    public void onActionFinalizar() throws ClassNotFoundException{
        Produto prod = new Produto(); 
       
        Stage stage; 
        stage = (Stage) btnFinalizar.getScene().getWindow();
        
        try{
            if("Cadastro - Produto".equals(stage.getTitle())){
                prod.setNomeProduto(txtNomeProduto.getText().toUpperCase());
                prod.setCorProd(txtCor.getText().toUpperCase());
                prod.setTamanho(Integer.parseInt(txtTam.getText()));
                prod.setValor(Double.parseDouble(txtPreco.getText()));
                //prod.setMarca(marcModel);
                //prod.setModelo(marcModel);
                prod.setProdStatus("A");
        
        
                if(prodDao.AddProduto(prod)){
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle(stage.getTitle());
                    alerta.setContentText("Produto cadastrado com sucesso !");
                    alerta.show();
                    stage.close();
                    
                }else{
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle(stage.getTitle());
                    alerta.setContentText("Ocorreu erro ao realizar cadastro!" +
                                       "\nContate o Administrador!");
                    alerta.show();
                }
            }

        }catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void onActionSMarca(){
        marcModel.setIdMarca(cmbSelectMarca.getSelectionModel().getSelectedIndex() + 1);
        marcModel.setNomeMarca(cmbSelectMarca.getValue().toString());
    }
    public void onActionSModel(){
        marcModel.setIdModelo(cmbSelectModelo.getSelectionModel().getSelectedIndex() + 1);
        marcModel.setNomeModelo(cmbSelectModelo.getValue().toString());
    }
    
    //Carrega lista de Marcas e coloca no combo para seleção
    public void carregarListaMarca() throws ClassNotFoundException{
        
        List<String> listaMarcas = new ArrayList<>();
        
        marcaData = marcMo.listMarca();
        
        for(int i = 0; i < marcaData.size(); i++){ 
            listaMarcas.add(marcaData.get(i).getNomeMarca());
        }
        cmbSelectMarca.setItems(FXCollections.observableArrayList(listaMarcas));
        cmbSelectMarca.setValue("<Selecione>");
    }
    //Carrega lista de modelos e coloca no combo para seleção
    public void carregarListaModelo() throws ClassNotFoundException{
        
        List<String> listaModelos = new ArrayList<>();
        
        modeloData = marcMo.listModelo();
        
        for(int i = 0; i < modeloData.size(); i++){
            listaModelos.add(modeloData.get(i).getNomeModelo());
        }
        cmbSelectModelo.setItems(FXCollections.observableArrayList(listaModelos));
        cmbSelectModelo.setValue("<Selecione>");
        
    }
    public void carregarListaProdutos() throws ClassNotFoundException, SQLException{
      List<String> listaProdutos = new ArrayList<>();
      Produto prod = new Produto();
      
      prodData = prodDao.GetProduto(prod);
      
        for(int i = 0; i < prodData.size(); i++){
            listaProdutos.add(prodData.get(i).getNomeProduto());
        }
        cmbProdutos.setItems(FXCollections.observableArrayList(listaProdutos));
        cmbProdutos.setValue("<Selecione>");
    }
    
    //Atividado pelo botão Excluir, chama método pra excluir produto
    @FXML
    public void onActionExcluir(){
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    //Cancela execução e fecha tela aberta
    @FXML
    public void onActionCancelar(){
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
