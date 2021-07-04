/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import static Controles.Main.stage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jaque
 */
public class MenuController implements Initializable{

    
    @FXML
    private MenuItem btnCadastrarUser;
    
    @FXML
    private MenuItem btnAtulizarUser;
    
    @FXML
    private MenuItem btnCadastarMarca;
    
    @FXML
    private MenuItem btnCadastarModelo;
    
    @FXML
    private MenuItem btnCadastarProduto;
    
    @FXML
    private MenuItem btnExcluirMarca;
    
    @FXML
    private MenuItem btnExcluirModelo;
    
    @FXML
    private MenuItem btnExcluirProduto;
    
    @FXML
    private MenuItem  btnEntradaEstoque;
    
     @FXML
    private MenuItem btnSaidaEstoque;
     
    @FXML
    private MenuItem  btnRentradaEst;
    
    @FXML
    private MenuItem btnRsaidaEst;
    
    @FXML
    private MenuItem  btnRComparativo;
    
    @FXML
    private Button btnSair;
    
    
  
    
   @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Menu inicializado!");
        
    }
    
    
    @FXML
    public void onActionCadUser () throws IOException{
        
        try{  
            Stage stage = new Stage();
            FXMLLoader root = new FXMLLoader(getClass().getResource("/Views/CadastroUsuario.fxml"));
            root.setControllerFactory(c -> {
                return new UsuarioController();
            });
            stage.setTitle("Product Management - Cadastro Usuário");
            stage.setScene(new Scene(root.load(), stage.getWidth(), stage.getHeight()));
            stage.setResizable(false);
            stage.show();
            System.out.println("Tela de Cadastro!");
                  
                    
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @FXML
    public void onActionAtuaUser () throws IOException{
        try{  
            Stage stage = new Stage();
            FXMLLoader root = new FXMLLoader(getClass().getResource("/Views/CadastroUsuario.fxml"));
            root.setControllerFactory(c -> {
                return new UsuarioController();
            });
            stage.setTitle("Product Management - Atualizar Usuário");
            stage.setScene(new Scene(root.load(), stage.getWidth(), stage.getHeight()));
            stage.setResizable(false);
            stage.show();
            System.out.println("Tela de Atualizar Cadastro!");
                  
                    
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     @FXML
    public void onActionCadMarca () throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/CadastroMarcaModelo.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    
    @FXML
    public void onActionCadModelo () throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/CadastrarMarcaModelo.fxml"));
        Parent root = loader.load();
        stage.setTitle("Cadastro - Marca");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    
    @FXML
    public void onActionCadProduto() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    public void onActionExMarca() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    @FXML
    public void onActionExModelo() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    @FXML
    public void onActionExcProd() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    @FXML
    public void onActionEntEstoque() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    @FXML
    public void onActionSaidaEst() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    @FXML
    public void onActionRelaEntEsto() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    @FXML
    public void onActionRelaSaiEst() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    @FXML
    public void onActionRelaCompa() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    public void sairOnAction() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    
}
