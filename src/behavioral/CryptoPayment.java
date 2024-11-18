package behavioral;

public class CryptoPayment implements PaymentStrategy{

	@Override
	public void pay(int amount) {
		System.out.println("Paying via crypto currency...");
		
	}

}
