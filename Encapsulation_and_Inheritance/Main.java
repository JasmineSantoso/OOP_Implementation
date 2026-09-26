import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        

        int choice;
        do {
            System.out.println("===========================");
            System.out.println("==== CHOOSE YOUR SHAPE ====");
            System.out.println("===========================");
            System.out.println("1. Bentuk");
            System.out.println("2. Bujur Sangkar");
            System.out.println("3. Lingkaran");
            System.out.println("4. Silinder");
            System.out.println("5. Exit");
            System.out.print("Pilih: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                Bentuk shape = new Bentuk("Hijau");
                shape.printInfo();
                System.out.print("Masukkan warna baru: ");
                String inWarna = input.nextLine();
                shape.setWarna(inWarna);
                shape.printInfo();
            } else if (choice == 2) {
                BujurSangkar shape = new BujurSangkar("Hijau", 5);
                shape.printInfo();
                System.out.print("Masukkan warna baru: ");
                String inWarna = input.nextLine();
                shape.setWarna(inWarna);
                System.out.print("Masukkan sisi baru: ");
                double inSisi = input.nextDouble();
                shape.setSisi(inSisi);
                shape.printInfo();
            } else if (choice == 3) {
                Lingkaran shape = new Lingkaran("Hijau", 5);
                shape.printInfo();
                System.out.print("Masukkan warna baru: ");
                String inWarna = input.nextLine();
                shape.setWarna(inWarna);
                System.out.print("Masukkan radius baru: ");
                double inRad = input.nextDouble();
                shape.setRadius(inRad);
                shape.printInfo();
            } else if (choice == 4) {
                Silinder shape = new Silinder("Hijau", 5, 5);
                shape.printInfo();
                System.out.print("Masukkan warna baru: ");
                String inWarna = input.nextLine();
                shape.setWarna(inWarna);
                System.out.print("Masukkan radius baru: ");
                double inRad = input.nextDouble();
                shape.setRadius(inRad);
                System.out.print("Masukkan tinggi baru: ");
                double inTinggi = input.nextDouble();
                shape.setTinggi(inTinggi);
                shape.printInfo();
            } else if (choice == 5) {
                System.out.println();
                System.out.print("Terima kasih.");
            } else {
                System.out.print("Input salah, masukkan angka.");
                break;
            }

        } while(choice != 5);
        input.close();
    }
}
