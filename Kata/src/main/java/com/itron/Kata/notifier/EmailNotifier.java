package com.itron.Kata.notifier;

public interface EmailNotifier {

	public void sendNotification(String subject, String body, String address);
	
}