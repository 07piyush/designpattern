package structural.facade;

public class PurchaseCryptoFacade {
	private AuthenticationService autheticator;
	private MarketService marketCommunicator;
	private OrderService orderHandler;
	private NotificationService notifcationHandler;
	private WalletService walletService;
	
	public PurchaseCryptoFacade(AuthenticationService authService, WalletService walletService,
            MarketService marketService, OrderService orderService,
            NotificationService notificationService) {
		this.autheticator = authService;
		this.marketCommunicator = marketService;
		this.walletService = walletService;
		this.notifcationHandler = notificationService;
		this.orderHandler = orderService;
	}

	public void purchaseCrypto(String userid, String authToken, String cryptoID, double amount) {
		
		System.out.println("Processing crypto purchase...");
		
		//1. authenticate user.
        if (!autheticator.authenticate(userid, authToken)) {
            System.out.println("Authentication failed.");
            return;
        }
        //2.get crypto price from market place.     
        double cryptoPrice = marketCommunicator.getCryptoPrice(cryptoID);
        
        //3. find total cost.
        double totalCost = cryptoPrice * amount;
        
        //4. check available balance.
        boolean hasSufficientFunds = walletService.hasSufficientFunds(userid, totalCost);
        if(hasSufficientFunds) {
        	//5. place order.
        	boolean orderPlaced = orderHandler.placeOrder(userid, cryptoID, amount);
        	if(orderPlaced)
        		walletService.deductFunds(userid, amount);
        }
        else {
        	//6. notify user of insufficient balance.
        	System.out.println("Insufficient balance..");
        }
        
        //6. notify user for successful transaction.
        notifcationHandler.sendConfirmation(userid, cryptoID, amount);
          
        }
}
