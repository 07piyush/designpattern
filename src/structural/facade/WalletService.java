package structural.facade;

public class WalletService {
	public boolean hasSufficientFunds(String userId, double amount) {
        System.out.println("Checking user funds...");
        // Check if the user has enough funds
        return true;  // Assume sufficient funds
    }
    
    public void deductFunds(String userId, double amount) {
        System.out.println("Deducting funds from wallet...");
        // Deduct the amount from the user's wallet
    }
}
