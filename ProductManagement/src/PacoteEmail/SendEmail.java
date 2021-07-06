/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteEmail;

import java.util.Properties;
import javafx.scene.control.Alert;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author jaque
 */
public class SendEmail implements InterfaceEmail {
    
    private String endEmail;
    private boolean enviado = false; 
    public void senEmail(){
        
    }

    @Override
    public boolean sendEmail() {
        
        Properties props = new Properties();
         /** Parâmetros de conexão com servidor Gmail */
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.socketFactory.port", "465");
         props.put("mail.smtp.socketFactory.class",
         "javax.net.ssl.SSLSocketFactory");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.port", "465");

         Session session = Session.getDefaultInstance(props,
           new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication()
                {
                      return new PasswordAuthentication("productmanagementpj@gmail.com",
                      "PM123456");
                }
           });

         /** Ativa Debug para sessão */
         session.setDebug(true);

         try {

           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress("productmanagementpj@gmail.com"));
           //Remetente

           Address[] toUser = InternetAddress //Destinatário(s)
                      .parse(getEndEmail());

           message.setRecipients(Message.RecipientType.TO, toUser);
           message.setSubject("Product Management");//Assunto
           message.setText("Recebemos sua solicitação" +
                            "\nSua senha é: "
                            +"\nPara segurança do sistema não compartilhe sua senha");
           
           /**Método para enviar a mensagem criada*/
           Transport.send(message);

           System.out.println("Email enviado");
           
           enviado = true;

          } 
          catch (MessagingException e) {
             throw new RuntimeException(e);   
          }
         
        return enviado;
    }

    @Override
    public void setEndEmail(String endEmail){
        this.endEmail = endEmail;
    }
    @Override
    public String getEndEmail() {
        return endEmail;
    }
}
