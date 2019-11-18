package com.itron.Kata.notifier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.itron.Kata.ClinicCalendar;
import com.itron.Kata.PatientAppointment;
import com.sun.mail.smtp.SMTPMessage;

public class UpcomingAppointmentNotifier {

	private ClinicCalendar calendar;
	private EmailNotifier notifier;
	
	public UpcomingAppointmentNotifier(ClinicCalendar calendar, EmailNotifier notifeir) {
		this.calendar = calendar;
		this.notifier = notifeir;
	}
	
	public void run() {
		
		calendar.getTomorrowdAppointments().forEach(appt -> {
			sendNotificationForAppointment(appt);
		});
	}

	private void sendNotificationForAppointment(PatientAppointment appt) {
		String email = appt.getPatientLastName().toLowerCase()  + appt.getPatientFirstName().toLowerCase();
		System.out.println("Sending with body: " + buildMessageBody(appt));
		notifier.sendNotification("Appointment Reminder", buildMessageBody(appt), email);
	}

	private String buildMessageBody(PatientAppointment appt) {
		return "You have an appointment tommorrow at " + appt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("h:mm a", Locale.US))
				+ " with Dr. "
				+ appt.getDoctor().getName() +".";
	}
}
