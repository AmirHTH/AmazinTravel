package impl.miw.infrastructure;

import java.util.Date;
import java.util.Properties;
 

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.miw.model.Billete;

public class SendMailManager {
	private String host = "smtp.gmail.com"; 
	private String port = "587";
	
	String from = "amazin.travels.miw@gmail.com";
    String password = "XXXXXXXXXXXXXXXX";
	 
	private boolean debug;
	 
	private Properties props;
	
	 
	public Properties addProxy(String host, String port) {
	    props.setProperty("proxySet", "true");
	    props.setProperty("socksProxyHost", host);
	    props.setProperty("socksProxyPort", port);
	    return props;
	}
	 
	public boolean sendMail(String to, Billete billete) {
	    boolean result = false;
	    props = System.getProperties();
	    try {
	        props.setProperty("mail.smtp.host", this.host);
	        props.setProperty("mail.smtp.port", this.port);
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.debug", "true");
	        props.put("mail.store.protocol", "pop3");
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.starttls.enable", "true");
	 
	        Session session = Session.getDefaultInstance(props, new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(from, password);
	        }
	        });
	 
	        session.setDebug(debug);
	 
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(from));
	 
	        InternetAddress[] addressTO = { new InternetAddress(to) };
	        msg.setRecipients(Message.RecipientType.TO, addressTO);
	 
	        /*
	        InternetAddress[] addressCC = { new InternetAddress(cc) };
	        msg.setRecipients(Message.RecipientType.CC, addressCC);
	        */
	 
	        InternetAddress addressFROM = new InternetAddress(from);
	        msg.setFrom(addressFROM);
	 
	        msg.setSentDate(new Date());
	 
	        msg.setSubject("Amazin Travels! Detalles de su reserva");
	        msg.setText(generarCuerpoMensaje(billete));
	 
	        Transport.send(msg);
	        result = true;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        result = false;
	    }
	 
	    return result;
	    }
	
	private String generarCuerpoMensaje(Billete billete){
		String cuerpoMensaje = "A continuación se muestran los detalles de su vuelo: \n\r";
		
			cuerpoMensaje += billete.toStringEmail();
		
			cuerpoMensaje += "\n\rPara cualquier aclaración pongase en contacto con Amazin Travels!";
		
		return cuerpoMensaje;
		
	}
	 
	    public boolean isDebug() {
	    	return debug;
	    }
	 
	    public void setDebug(boolean debug) {
	    	this.debug = debug;
	    }
	
}
