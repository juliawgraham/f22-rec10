package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

/*
 * InMemoryDatabase is a fake for AndrewWS database, in order to improve tests efficiency. 
 */

public class InMemoryDatabase {

    Map<String, Integer> accounts = new HashMap<>();

    public void addAccount(String accountName, int password) {
        this.accounts.put(accountName, password);
    }

    public int getPassword(String accountName) {
        return this.accounts.get(accountName);
    }
}