class Bank {
    private Customer[] customers;
    private int numberOfCustomers = 0;
    
    public Bank() {
        customers = new Customer[10];
    }

    public void addCustomer(String firstName, String lastName) {
        customers[numberOfCustomers] = new Customer(firstName, lastName);
        numberOfCustomers++;
    }
    
    public Customer getCustomer(int i) { return customers[i]; }
    public int getNumberOfCustomers() { return numberOfCustomers; }
    
}