import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.print("Masukkan nama depan: ");
        String firstName = input.nextLine();
        System.out.print("Masukkan nama belakang: ");
        String lastName = input.nextLine();

        bank.addCustomer(firstName, lastName);
        Customer customer = bank.getCustomer(0);

        System.out.print("Masukkan saldo awal: ");
        double initialBalance = input.nextDouble();
        Account account = new Account(initialBalance);

        customer.addAccount(account);
        int choice;
        do {
            System.out.println();
            System.out.println("=================================");
            System.out.println("          BANK ABC MENU");
            System.out.println("=================================");
            System.out.println("Customer : " + customer);
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Lihat Balance");
            System.out.println("4. Exit");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");
            choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Masukkan jumlah deposit: ");
                    double depositAmount = input.nextDouble();

                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit berhasil!");
                        System.out.println("Balance sekarang: " + account.getBalance());
                    } else {
                        System.out.println("Deposit gagal! Jumlah harus lebih dari 0.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan jumlah withdraw: ");
                    double withdrawAmount = input.nextDouble();

                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdraw berhasil!");
                        System.out.println("Balance sekarang: " + account.getBalance());
                    } else {
                        System.out.println("Withdraw gagal! Saldo tidak mencukupi.");
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.println("---------- ACCOUNT ----------");
                    System.out.println("Customer : " + customer);
                    System.out.println("Balance  : " + account.getBalance());
                    System.out.println("-----------------------------");
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Terima kasih telah menggunakan Bank ABC.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia. Silakan pilih 1-4.");
            }

        } while (choice != 4);
        input.close();

    }
}
