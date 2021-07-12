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
import DAO.UsuarioDao;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Model.Usuario;
import javafx.scene.Parent;
import PacoteEmail.SendEmail;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author jaque
 */
public class LoginController implements Initializable {

    
    
    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtSenha;
    
    
    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnSair;


    private static Usuario user;
    private UsuarioDao udao = new UsuarioDao();
    private static Stage stage;

    public static Usuario getUser() {
        return user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Longin inicializado!");
        user = new Usuario();
        
    }
    
    @FXML
    public void loginOnAction() throws IOException, ClassNotFoundException {
        
        if (udao.verificaLogin(txtUsuario.getText(), txtSenha.getText()) != 0){
            
            int usr_id = udao.verificaLogin(txtUsuario.getText().toUpperCase(), txtSenha.getText());
            
            user = udao.lerUser(usr_id);
            //Verifica o usuário e o grupo para conseguir Bloquear as telas de acesso; 
            if(user != null && user.getGrupoUser() == 1){
               
                try{  
                    Stage stage = new Stage();
                    stage = (Stage) btnEntrar.getScene().getWindow();
                    
                    FXMLLoader root = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
                    root.setControllerFactory(c -> {
                      return new MenuController();
                    });
                    stage.setTitle("Product Management - Menu - Administrador");
                    stage.setScene(new Scene(root.load(), stage.getWidth(), stage.getHeight()));
                    stage.setResizable(false);
                    stage.setWidth(500.0);
                    stage.setHeight(400.0);
                    stage.show();
                    System.out.println("Longin efetuado!");
                    
                    
                    
                }catch(IOException  ex){
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (user != null && user.getGrupoUser() == 2){
                try{  
                    Stage stage = new Stage();
                    stage = (Stage) btnEntrar.getScene().getWindow();
                    
                    FXMLLoader root = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
                    root.setControllerFactory(c -> {
                      return new MenuController();
                    });
                    stage.setTitle("Product Management - Menu - Estoque");
                    stage.setScene(new Scene(root.load(), stage.getWidth(), stage.getHeight()));
                    stage.setResizable(false);
                    stage.setWidth(500.0);
                    stage.setHeight(400.0);
                    stage.show();
                    
                    System.out.println("Longin efetuado!");
                    
                    
                    
                }catch(IOException  ex){
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(user != null && user.getGrupoUser() == 3){
                try{  
                    Stage stage = new Stage();
                    stage = (Stage) btnEntrar.getScene().getWindow();
                    
                    FXMLLoader root = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
                    root.setControllerFactory(c -> {
                      return new MenuController();
                    });
                    stage.setTitle("Product Management - Menu - RH");
                    stage.setScene(new Scene(root.load(), stage.getWidth(), stage.getHeight()));
                    stage.setResizable(false);
                    stage.setWidth(500.0);
                    stage.setHeight(400.0);
                    stage.show();
                    System.out.println("Longin efetuado!");
                    
                    
                    
                }catch(IOException  ex){
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
          //txtUsuario.clear();
          //txtSenha.clear();  
            
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ControlX - Aviso");
            alert.setHeaderText("Login");
            alert.setContentText("Login ou senha inválidos!");

            alert.showAndWait();
        }

    }
        
    
    @FXML
    public void sairOnAction() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensagem");
        alerta.setContentText("Deseja sair?");

        Optional<ButtonType> result = alerta.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            Stage stage = (Stage) btnSair.getScene().getWindow();
            stage.close();
        }
    }
    
    
    @FXML
    public void enviarSenha() throws ClassNotFoundException{
        
        if(udao.verificaEmail(txtUsuario.getText().toUpperCase()) != 0){
            udao.lerUser(udao.verificaEmail(txtUsuario.getText()));
        }
        
        String endEmail = user.getEmail();
        SendEmail sendEmail = new SendEmail();
        sendEmail.setEndEmail(endEmail.toLowerCase());
        
        //Arrumar essa partte depois
        if(sendEmail.sendEmail()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Esqueci a Senha");
            alert.setContentText("Enviado um email com a sua senha para " + endEmail);
            alert.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Esqueci a Senha");
            alert.setContentText("Ocorreu um erro ao enviar a senha, verifique os dados !");
            alert.show();
        }
    }
    
}
