/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import static Controles.Main.stage;
import DAO.MarcaModeloDao;
import DAO.ProdutoDao;
import Model.MarcaModelo;
import Model.Produto;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jaque
 */
public class ExcluirProdutoController implements Initializable{
    
   
    @FXML
    private Button btnCancelar;
    
    private Button btnFinalizar;
    
    @FXML
    private ComboBox cmbProdutos;
       
    private List<MarcaModelo> marcaData;
    
    private List<MarcaModelo> modeloData;
    private List<Produto> prodData;
    
    
    private MarcaModeloDao marcMo = new MarcaModeloDao();;
    
    private ProdutoDao prodDao = new ProdutoDao();
    
    private MarcaModelo marcModel = new MarcaModelo();
    
    @FXML
    private Button btnExcluir;
    @FXML
    private Text txtNome;
    
    @Override//Inicia as telas de Produto
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller Produto inicializado!");
        
   
        //Inicia as listas de Objetos
        marcaData = new ArrayList();
        modeloData = new ArrayList();
        prodData = new ArrayList();
        
        try {
                carregarListaProdutos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public void carregarListaProdutos() throws ClassNotFoundException, SQLException{
        
        List<String> listaProdutos = new ArrayList<>();
        
        prodData = prodDao.listarProduto();
        
        for(int i = 0; i < prodData.size(); i++){
            listaProdutos.add(prodData.get(i).getNomeProduto()); 
        }
        cmbProdutos.setItems(FXCollections.observableArrayList(listaProdutos));
        cmbProdutos.setValue("<Selecione>");
    }
    
    //Atividado pelo botão Excluir, chama método pra excluir produto
    @FXML
    public void onActionExcluir(){
        
        //Método responsavel por enviar para ProdutoDao a solicitação de exclusão do Produto
        try{ 
            Produto prod = new Produto();
            
            prod.setIdProduto(prodData.indexOf(prodData.get(cmbProdutos.getSelectionModel().getSelectedIndex()).getIdProduto()));
            
            prodDao.deletarProduto(prod);//chama o método removeMarca da classe DAO
            
        }catch(Exception ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle(stage.getTitle());
                alerta.setContentText("Ocorreu erro ao excluir!" +
                                       "\nContate o Administrador!");
                
                alerta.show();
        }
    }
    
    @FXML
    public void onActionCancelar(){
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
