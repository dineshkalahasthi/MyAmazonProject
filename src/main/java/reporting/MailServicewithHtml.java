package reporting;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.ITestResult;

import okhttp3.MultipartBody;

public class MailServicewithHtml {

	public void MailWithHtml() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(25);
		email.setAuthentication("automation.tester222@gmail.com", "Automation@123");
		email.setSSLOnConnect(true);
		email.addTo("kalahasthi.dinesh10@gmail.com");
		email.setFrom("automation.tester222@gmail.com");
		email.setMsg("This is the mail service generated mail");
		email.send();
	}

	public void ShareMailReport(ITestResult result) throws AddressException, MessagingException {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.googlemail.com");
		prop.put("mail.smtp.port", "25");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("automation.tester222@gmail.com","Automation@123");
			}
		});

		Message message = PrepareMessage(session);
		Transport.send(message);
		System.out.println("Email sent successfully");
	}
	public void ShareMailReport(String attachment) throws AddressException, MessagingException {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.googlemail.com");
		prop.put("mail.smtp.port", "25");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("automation.tester222@gmail.com","Automation@123");
			}
		});

		Message message = PrepareMessage(session,attachment);
		
		
		Transport.send(message);
		System.out.println("Email sent successfully");
	}

	public Message PrepareMessage(Session session) throws AddressException, MessagingException {
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress("kalahasthi.dinesh10@gmail.com"));
		message.setRecipient(Message.RecipientType.TO,new InternetAddress("kalahasthi.dinesh10@gmail.com"));
		message.setSubject("Amazon Automation Results");
		message.setText("AR is successful");
		return message;
	}
	public Message PrepareMessage(Session session,String attachment) throws AddressException, MessagingException {
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress("kalahasthi.dinesh10@gmail.com"));
		message.setRecipient(Message.RecipientType.TO,new InternetAddress("kalahasthi.dinesh10@gmail.com"));
		message.setSubject("Amazon Automation Results");
		MimeBodyPart message1=new MimeBodyPart();
		message1.setText("AR is successful");
		
		MimeBodyPart message2=new MimeBodyPart();
		DataSource data=new FileDataSource(attachment);
		message2.setDataHandler(new DataHandler(data));
		message2.setFileName(attachment);
		Multipart multi=new MimeMultipart();
		multi.addBodyPart(message1);
		multi.addBodyPart(message2);
	message.setContent(multi);
		return message;
	}

	public static void main(String[] args) throws EmailException, AddressException, MessagingException {
		MailServicewithHtml obj=new MailServicewithHtml();
		obj.MailWithHtml();
		//obj.ShareMailReport();
	}
}
