package structuralDesignPattern.facade;

public class OrderService {
	 public boolean placeOrder(String userId, String crypto, double amount) {
	        System.out.println("Placing order for crypto...");
	        // Logic to place the order
	        return true;
	    }
}
