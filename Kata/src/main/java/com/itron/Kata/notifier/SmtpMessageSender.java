package com.itron.Kata.notifier;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpMessageSender implements EmailNotifier {

	public void sendNotification(String subject, String body, String address) {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "localhost");
		Session session = Session.getDefaultInstance(properties, null);
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("jozsefnagy141@gmail.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
			message.setSubject(subject);
			message.setContent(body, "text/htmal");
			Transport.send(message);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
