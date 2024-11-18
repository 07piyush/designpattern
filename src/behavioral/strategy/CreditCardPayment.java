package behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy{


	public void pay(int amount) {
		System.out.println("Paying via credit card...");
		
	}

}
