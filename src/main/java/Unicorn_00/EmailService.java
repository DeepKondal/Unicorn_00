package Unicorn_00;

public class EmailService {
	public void sendEmail(String senderEmail, String recipientEmail, String subject, String message) {
		// Logic to send an email
		System.out.println("Sending email from: " + senderEmail);
		System.out.println("Sending email to: " + recipientEmail);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		System.out.println("Email sent successfully!");
	}
}
