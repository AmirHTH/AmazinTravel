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

public class SendMailManager {
	private static SendMailManager instance = null;
	private String host = "smtp.gmail.com"; 
	private String port = "587";
	
	String from = "burrow.tv@gmail.com";
    String password = "moganmogan";
	 
	private boolean debug;
	 
	private Properties props;
	
	 
	public Properties addProxy(String host, String port) {
	    props.setProperty("proxySet", "true");
	    props.setProperty("socksProxyHost", host);
	    props.setProperty("socksProxyPort", port);
	    return props;
	}
	 
	public boolean sendMail(String to) {
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
	 
	        msg.setSubject("Amazin");
	        msg.setText("Amazin");
	 
	        Transport.send(msg);
	        result = true;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        result = false;
	    }
	 
	    return result;
	    }
	 
	    public boolean isDebug() {
	    	return debug;
	    }
	 
	    public void setDebug(boolean debug) {
	    	this.debug = debug;
	    }
	
}
