package classAlert;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	public SendEmail() {
		
	}

	public void email(String classTitle) {
		System.out.println("Starting...");
		
		final String username = "jgalante1997@gmail.com";
		final String password = "James1997";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("JGalante1997@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("jgalante@udel.edu"));
			message.setSubject("CLASS OPEN: " + classTitle);
			message.setText("There is a class open,"
				+ "Go check!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}