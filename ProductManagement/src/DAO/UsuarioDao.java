/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.ConexaoBanco;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jaque
 * 
 */
public class UsuarioDao {
    
    //Método para verificar se usuário existe no banco e se dados estão corretos. 
    public boolean verificaLogin(String user, String senha) throws ClassNotFoundException{
       Connection conec = ConexaoBanco.getConnection();
       PreparedStatement stat = null;
       ResultSet result = null;
       boolean verify = false;
       
       try{
           stat = conec.prepareStatement("SELECT * FROM USSISTEMA WHERE US_LOGIN = ?  AND US_SENHA= ? AND US_STATUS = 'A';");
           stat.setString(1, user);
           stat.setString(2, senha);
           result = stat.executeQuery();
           
           if(result.next()){
               verify = true;
           }
           
       } catch(SQLException ex){
           String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
       }finally {
           ConexaoBanco.closeConnection(conec, stat, result);
           return verify;
       }
    }
    
    public void cadastraUsuario(Usuario us) throws ClassNotFoundException{
       Connection conec = ConexaoBanco.getConnection();
       PreparedStatement stat1 = null;
       PreparedStatement stat2 = null;
       PreparedStatement stat3 = null;
       ResultSet result = null;
       
       try{
           //inserção de dados na tabela de usuario
           stat1 = conec.prepareStatement("INSERT INTO USUARIOS (USR_NOME,USR_TELEFONE,USR_EMAIL,USR_CPF,USR_FUNCAO,USR_ESTADO,USR_CIDADE,USR_BAIRRO,USR_RUA,USR_STATUS) " +
                                          "VALUES(?, ?,?, ?,?, ?, ?, ?, ?, ?);");
           stat1.setString(1,us.getNome());
           stat1.setString(2,us.getTelefone());
           stat1.setString(3,us.getEmail());
           stat1.setString(4,us.getCPF());
           stat1.setString(5,us.getFuncao());
           stat1.setString(6,us.getEstado());
           stat1.setString(7,us.getCidade());
           stat1.setString(8,us.getBairro());
           stat1.setString(9,us.getRua());
           stat1.setString(10,Character.toString(us.getUsStatus()));
           
           //Pega o userid para usar na tabela de acesso
           stat2 = conec.prepareStatement("SELECT USR_ID FROM USUARIOS WHERE USR_NOME = ? AND USR_CPF = ?;");
           stat2.setString(1, us.getNome());
           stat2.setString(2,us.getCPF());
           result = stat2.executeQuery();
           
           int usr_id = result.getInt(1);
           
           //insere os dados de acesso na tabela ussistem
           stat3 = conec.prepareStatement("INSERT INTO USSISTEMA (US_ID,US_LOGIN,US_SENHA,US_STATUS,US_GROUPID) "
                                            + "VALUES(?, ?, ?, ?,?);");
           stat3.setInt(1, usr_id);
           stat3.setString(2,us.getLogin());
           stat3.setString(3,us.getSenha());
           stat3.setString(4,Character.toString(us.getUsStatus()));
           stat2.setInt(5,us.getGrupoUser());
           
       }
        catch(SQLException ex){
            String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
        }
        catch(Exception ex){
            String strE = ex.toString();
           strE += ("\n" + ex.getStackTrace());
           
           System.out.println("Ocorreu um erro ao tentar veirificar acesso!\n"
                               +"Conte o administrador: \n"
                               +"Código de erro: " + strE);   
        }finally {
           ConexaoBanco.closeConnection(conec, stat1, result);
           ConexaoBanco.closeConnection(conec, stat2, result);
           ConexaoBanco.closeConnection(conec, stat3, result);
       }
       
    }
    
    //Falta os outros métodos de cadastro
    
    
    
}
