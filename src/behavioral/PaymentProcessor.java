package behavioral;

public class PaymentProcessor {
	private PaymentStrategy paymentMode;
	
	public void setPaymentStrategy(PaymentStrategy strategy) {
		paymentMode = strategy;
	}
	
	public void processPayment(int amount) {
		paymentMode.pay(amount);
	}
}
