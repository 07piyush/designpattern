package structuralDesignPattern.facade;

public class NotificationService {
	public void sendConfirmation(String userId, String crypto, double amount) {
        System.out.println("Sending purchase confirmation...");
        // Logic to send notification to the user
    }
}
