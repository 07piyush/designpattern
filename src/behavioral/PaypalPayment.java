package behavioral;

public class PaypalPayment implements PaymentStrategy{

	@Override
	public void pay(int amount) {
		System.out.println("Paying via Paypal...");
		
	}

}
