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
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Controles.MarcaModeloController;

/**
 *
 * @author jaque
 */
public class MenuController implements Initializable{//Responsavel por controlar o acesso entre as telas. 

    
    @FXML
    private MenuItem btnCadastrarUser;
    
    
     @FXML
    private Text textExcluir;
    
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
    
    
    
  
    
   @Override//Inicia a tela o Menu
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Menu inicializado!");
        MarcaModeloController marcaModel = new MarcaModeloController();
        
        //Verifica qual o tipo de usuário esta logando para definir visibilidade das telas
//        if("Product Management - Menu - Estoque".equals(stage.getTitle())){
//            btnCadastrarUser.setVisible(false);
//            btnAtulizarUser.setVisible(false);
//            btnCadastarMarca.setVisible(false);
//            btnCadastarModelo.setVisible(false);
//            btnExcluirMarca.setVisible(false);
//            btnExcluirModelo.setVisible(false);
//            btnExcluirProduto.setVisible(false);
//        }
//        else if("Product Management - Menu - RH".equals(stage.getTitle())){
//            btnCadastrarUser.setVisible(false);
//            btnCadastarMarca.setVisible(false);
//            btnCadastarModelo.setVisible(false);
//            btnExcluirMarca.setVisible(false);
//            btnExcluirModelo.setVisible(false);
//            btnCadastarProduto.setVisible(false);
//            btnExcluirProduto.setVisible(false);
//            btnEntradaEstoque.setVisible(false);
//            btnSaidaEstoque.setVisible(false);
//        }
        
        
    }
    
    
    @FXML//Chama tela de cadastrar Usuário
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
    
    
    @FXML//Chama tela de Atualizar usuário
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
    
    
    @FXML //Chama tela de cadastro de Marca
    public void onActionCadMarca () throws IOException{
      
        
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/CadastrarMarcaModelo.fxml"));
            Parent root = loader.load();
            stage.setTitle("Cadastrar Marca");
           //descobri um jeito de setar a informação de marca e modelo
            stage.setScene(new Scene(root));
            stage.show();
            
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @FXML //Chama tela de cadastro de Modelo
    public void onActionCadModelo () throws IOException{
        
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/CadastrarMarcaModelo.fxml"));
            Parent root = loader.load();
            
            stage.setTitle("Cadastrar Modelo");
            stage.setScene(new Scene(root));
            stage.show();
            
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @FXML //Chama tela de cadastro de Produto
    public void onActionCadProduto() {
    
       try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/CadastroProduto.fxml"));
            Parent root = loader.load();
            stage.setTitle("Cadastro - Produto");
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML //Chama tela de excluir Marca
    public void onActionExMarca() {
    
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/ExcluirMarcaModelo.fxml"));
            Parent root = loader.load();
            stage.setTitle("Excluir - Marca");
            stage.setScene(new Scene(root)); 
            stage.show();
            
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML //Chama tela de excluir Modelo
    public void onActionExModelo() {
    
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/ExcluirMarcaModelo.fxml"));
            Parent root = loader.load();
            
            stage.setTitle("Excluir - Modelo");           
            stage.setScene(new Scene(root));
            stage.show();
            
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML //Chama tela de cadastro de Modelo
    public void onActionExcProd() {
    
       try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/ExcluirProduto.fxml"));
            Parent root = loader.load();
            stage.setTitle("Excluir - Produto");
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML //Chama tela de cadastro Estoque
    public void onActionEntEstoque() {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/EntradaEstoque.fxml"));
            Parent root = loader.load();
            stage.setTitle("Cadastro - Estoque");
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML //Chama tela para realizar retirada de estoque
    public void onActionSaidaEst() {
    
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/EntradaEstoque.fxml"));
            Parent root = loader.load();
            stage.setTitle("Retirada - Estoque");
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML //Chama tela de Relatorio de Entrada Estoque
    public void onActionRelaEntEsto() {
    
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/Relatorios.fxml"));
            Parent root = loader.load();
            stage.setTitle("Relatorio - Entrada de Estoque");
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML //Chama tela de Relatorio de Saida Estoque
    public void onActionRelaSaiEst() {
    
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/Relatorios.fxml"));
            Parent root = loader.load();
            stage.setTitle("Relatorio - Retirada de Estoque");
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML //Chama tela de Relatorio Comparativo
    public void onActionRelaCompa() {
    
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/Relatorios.fxml"));
            Parent root = loader.load();
            stage.setTitle("Relatorio - Comparativo de Estoque");
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException  ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML //Sai da tela Menu e fecha programa
    public void sairOnAction() {
    
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        
    }
    
}
