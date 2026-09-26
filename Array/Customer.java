public class Customer {
    private String firstName;
    private String lastName;
    private Account[] accounts = new Account[3];
    private int numberOfAccounts = 0;


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount(Account account) {
        if (numberOfAccounts < 5) {
            accounts[numberOfAccounts++] = account;
        }
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public Account getAccount(int account_index) {
        return accounts[account_index];
    }
    public int getNumOfAccounts() {
        return numberOfAccounts;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;    }
}
