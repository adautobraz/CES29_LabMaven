
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class DefaultSender implements ServiceMail{
	private String subject;
	private String content;
	private String sender;
	private String password;
	
	@Override
	 public boolean sendEmail(String address) {
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	
	    Session session = Session.getDefaultInstance(props,
	    new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() 
	         {
	               return new PasswordAuthentication(sender, password);
	         }
	    });
	    /** Ativa Debug para sessao */
	    session.setDebug(true);
	    try {
	
	          Message message = new MimeMessage(session);
	          message.setFrom(new InternetAddress(sender)); //Remetente
	
	          Address[] toUser = InternetAddress //Destinatario(s)
	                     .parse(address);  
	          message.setRecipients(Message.RecipientType.TO, toUser);
	          message.setSubject(subject);//Assunto
	          message.setText(content);
	          /**Metodo para enviar a mensagem criada*/
	          Transport.send(message);
	          return true;
	         } catch (MessagingException e) {
	        	 return false;
	    }
	}

	@Override
	public String defineSubject(String subject) {
		this.subject = subject;
		return this.subject;
	}

	@Override
	public String defineContent(String content) {
		this.content = content;
		return this.content;
	}
	
	@Override
	public String defineSender(String sender) {
		this.sender= sender;
		return this.sender;
	}
	
	@Override
	public String definePassword(String password) {
		this.password= password;
		return this.password;
	}
	
	@Override
	public boolean sendMail(String address){
		//Apenas retorna true;
		return true;
	}
}
