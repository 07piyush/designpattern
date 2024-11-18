package structural.facade;

public class AuthenticationService {
	public boolean authenticate(String userId, String password) {
        System.out.println("Authenticating user...");
        // Authentication logic
        return true;  // Assume authentication is successful
    }
}
