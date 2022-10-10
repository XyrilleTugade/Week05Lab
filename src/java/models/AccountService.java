package models;

/**
 *
 * @author Xyrille
 */
public class AccountService {

    public AccountService() {
    }
    
    public Account login(String username, String password) {
        if ((username.equals("abe") || username.equals("barb")) && password.equals("password")) {
            Account user = new Account(username, null);
            return user;
        }
        
        else {
            return null;
        }
    }
}
