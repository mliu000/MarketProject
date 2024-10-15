package Model;

import java.util.ArrayList;
import java.util.List;

// Singleton because only one database should exist.
class AccountDatabase {

    private List<Customer> customerDatabase;
    private List<Retailer> retailerDatabase;

    private static AccountDatabase accountDatabaseInstance;

    private AccountDatabase() {
        this.customerDatabase = new ArrayList<>();
        this.retailerDatabase = new ArrayList<>();

    }

    private AccountDatabase getInstance() {
        if (accountDatabaseInstance == null) {
            accountDatabaseInstance = new AccountDatabase();
        }
        return accountDatabaseInstance;
    }
}
