package com.itron.Kata;

import java.util.ArrayList;


import com.itron.Kata.notifier.EmailNotifier;

public class EmailNotifierTestDouble implements EmailNotifier {

	ArrayList<Message> receivedMessage = new ArrayList<>();
	
	@Override
	public void sendNotification(String subject, String body, String address) {
		receivedMessage.add(new Message(subject,body, address));
	}
	
	class Message {
		public String toAddress;
		public String subject;
		public String body;
		
		public Message (String subject, String body, String address) {
			this.subject = subject;
			this.body = body;
			this.toAddress = address;
		} 
	} 

}
