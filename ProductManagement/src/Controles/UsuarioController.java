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
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import javafx.stage.Stage;
import javax.swing.JTextField;

/**
 *
 * @author jaque
 */
public class UsuarioController implements Initializable {

    @FXML
    private ComboBox cmbGrupoUser;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSalvar;

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
    private TextField txtUF;

    @FXML
    private TextField txtFuncao;

    @FXML
    private TextField txtEmail;

    private static String user = new String();
    private static String senha = new String();
    UsuarioDao udao = new UsuarioDao();
    private static boolean cadastro;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Cadastro inicializado!");
        ObservableList<String> grpFuncao = FXCollections.observableArrayList(
                "ADMINISTRADOR", "ESTOQUE", "RH/OUTROS");
        cmbGrupoUser.setItems(grpFuncao);

        cmbGrupoUser.setValue("<Selecione>");

    }

    @FXML
    public void onActionCbGrupoUser() throws IOException {
        cmbGrupoUser.getItems();
    }

    @FXML
    public void onActionVoltar() throws IOException {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onActionSalvar() throws IOException, ClassNotFoundException, Exception {
        Stage stage = (Stage) btnSalvar.getScene().getWindow();

        try {
            Usuario us = new Usuario();
            String uscpf = new String();
            String userInitial = new String();

            us.setNome(txtNome.getText().toUpperCase());
            us.setCPF(txtCPF.getText().toUpperCase());
            us.setEmail(txtEmail.getText().toUpperCase());
            us.setBairro(txtBairro.getText().toUpperCase());
            us.setRua(txtRua.getText().toUpperCase());
            us.setCidade(txtCidade.getText().toUpperCase());
            us.setEstado(txtUF.getText().toUpperCase());
            us.setTelefone(txtTelefone.getText().toUpperCase());
            us.setFuncao(txtFuncao.getText().toUpperCase());

            //Seta o grupo do usuario cadastrado
            if (cmbGrupoUser.getValue().equals("ADMINISTRADOR")) {//Grupo de Adminstrador
                us.setGrupoUser(1);
            } else if (cmbGrupoUser.getValue().equals("ESTOQUE")) {//Grupo de Funcionarios Estoque
                us.setGrupoUser(2);
            } else if (cmbGrupoUser.getValue().equals("RH/OUTROS")) {//Grupo de Funcionario Administração->RH
                us.setGrupoUser(3);
            }

            //Montagem do usuario:
            userInitial = us.getNome();
            uscpf = us.getCPF();

            us.setLogin(userInitial.substring(0, 3) + uscpf.substring(0, 3));

            //Montagem da senha:
            String senha = new String();
            senha = uscpf.substring(3, uscpf.length() - 1);
            us.setSenha(senha);

            us.setUsStatus('A');
            //Envia dados do Usuario para DAO de cadastro
            if (udao.cadastraUsuario(us) == true) {

                if (udao.cadastrarUsSistema(us) == true) {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Cadastro Usuario");
                    alerta.setContentText("Usuário cadastrado com sucesso !");
                    alerta.showAndWait();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Cadastro Usuario");
                    alerta.setContentText("Ocorreu erro ao cadastrar usuário!");
                    alerta.showAndWait();
                }

                stage.close();
            }
        } catch (ClassNotFoundException ex) {

            System.out.println("Ocorreu erro ao cadastrar usuário!\n"
                    + "Contate o administrador: \n"
                    + "Mensagem de erro: " + ex.getMessage()
                    + "Local do erro: " + ex.getException());
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle(stage.getTitle());
            alerta.setContentText("Ocorreu erro ao realizar cadastro!"
                    + "\nContate o Administrador!");

            alerta.showAndWait();

        }

    }
}
