package Model;

public abstract class Account {

    public String username;
    public String password;

    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
