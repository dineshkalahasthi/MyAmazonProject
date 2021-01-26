package reporting;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailServicewithHtml {

	public void MailWithHtml() throws EmailException {
	Email email=new SimpleEmail();
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(25);
	email.setAuthentication("automation.tester222@gmail.com", "Automation@123");
	email.setSSLOnConnect(true);
	email.addTo("kalahasthi.dinesh10@gmail.com");
	email.setFrom("automation.tester222@gmail.com");
	email.setMsg("This is the mail service generated mail");
	email.send();
	}
	
	public static void main(String[] args) throws EmailException {
		MailServicewithHtml obj=new MailServicewithHtml();
		obj.MailWithHtml();
	}
}
