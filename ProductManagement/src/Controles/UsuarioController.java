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
import Model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author jaque
 */
public class UsuarioController implements Initializable  {    
    
    
    @FXML
    private ComboBox cmbGrupoUser;
    
    @FXML
    private Button btnCancelar;
    
    @FXML
    private  Button btnSalvar;
    
    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtCPF;
    
    @FXML
    private TextField txtTelefone;
    
    @FXML
    private TextField txtRua;
    
    @FXML
    private TextField txtBairro;
    
    @FXML
    private TextField txtCidade;
    
    @FXML
    private TextField txtEstado;
    
    @FXML
    private TextField txtFuncao;
    
    @FXML
    private TextField txtEmail;
    
    private  static String user = new String();
    private static String senha  = new String();
    UsuarioDao udao = new UsuarioDao();
    private static boolean cadastro;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Cadastro inicializado!");
        ObservableList<String> grpFuncao = FXCollections.observableArrayList(
                    "ADMINISTRADOR", "ESTOQUE","RH/OUTROS" );
            cmbGrupoUser.setItems(grpFuncao);
        
        cmbGrupoUser.setValue("<Selecione>");
    }

    
    @FXML
    public void onActionCbGrupoUser () throws IOException{
            
         cmbGrupoUser.getItems();
          
    }
    
    
    @FXML
    public void onActionVoltar () throws IOException{
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void  onActionSalvar () throws IOException, ClassNotFoundException{
       
        
  
            try{
                
                cadastro = true;
                Usuario us = new Usuario();
                String uscpf = new String();

                us.setNome(txtNome.getText());
                us.setCPF(txtCPF.getText());
                us.setEmail(txtEmail.getText());
                us.setBairro(txtBairro.getText());
                us.setRua(txtRua.getText());
                us.setCidade(txtCidade.getText());
                us.setEstado(txtEstado.getText());
                us.setTelefone(txtTelefone.getText());
                us.setFuncao(txtFuncao.getText());

                //Seta o grupo do usuario cadastrado
                if(cmbGrupoUser.getValue().equals("ADMINISTRADOR")){//Grupo de Adminstrador
                    us.setGrupoUser(1);
                }else if(cmbGrupoUser.getValue().equals("ESTOQUE")){//Grupo de Funcionarios Estoque
                    us.setGrupoUser(2);
                }else if(cmbGrupoUser.getValue().equals("RH/OUTROS")){//Grupo de Funcionario Administração->RH
                    us.setGrupoUser(3);
                }

                //Montagem do usuario:
                user.getChars(0,3, txtNome.getText().toCharArray(),0);
                uscpf.getChars(0,3,txtCPF.getText().toCharArray(),0);

                us.setLogin(user+uscpf);

                //Montagem da senha:
                senha.getChars(6,10, txtCPF.getText().toCharArray(),6); 
                us.setSenha(senha);

                us.setUsStatus('A');
                //Envia dados do Usuario para DAO de cadastro
                udao.cadastraUsuario(us);
                
                

            }catch(Exception ex){
                //String strE = ex.toString();
                //strE += ("\n" + ex.getStackTrace());

               System.out.println("Ocorreu erro ao cadastrar usuário!\n"
                                   +"Contate o administrador: \n"
                                   +"Codigo de erro: " + ex.getStackTrace()); 
               
               cadastro = false;
            }
            
            if(cadastro = true){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Cadastro");
                alerta.setContentText("Usuário cadastrado com sucesso !");
              
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Cadastro");
                alerta.setContentText("Ocorreu erro ao cadastrar usuário!");
            }
    }
}
