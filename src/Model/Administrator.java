package Model;

// Singleton because only one Admin can exist in the market
class Administrator extends Account {

    private static Administrator adminInstance;

    // Constructs the instance of Admin account with default given username and password
    private Administrator() {
        username = "StoreAdmin";
        password = "thisIsThePassword";
    }

    // Method to retrieve the one instance of this class
    public Administrator getInstance() {
        if (adminInstance == null) {
            adminInstance = new Administrator();
        }
        return adminInstance;
    }
}
