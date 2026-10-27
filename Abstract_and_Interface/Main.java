public class Main {
    public static void main(String[] args) {
        TransferBank transfer = new TransferBank("TRX001", 70000, "9990000001" );
        EWallet eWallet = new EWallet("TRX002", 57000, 100000);
        QRIS qris = new QRIS("TRX002", 8500, "123456");

        // TRASFER BANK
        System.out.println("=== TRANSFER BANK ===");
        System.out.println("ID Transaksi: " + transfer.idTransaksi);
        System.out.println("Nominal Rp: " + transfer.totalPembayaran);
        System.out.println("Biaya Admin: " + transfer.hitungBiayaAdmin());
        System.out.println("Total Akhir: " + transfer.hitungTotalAkhir());

        transfer.prosesPembayaran();

        if (transfer.verifikasiTransaksi()) {
            System.out.println("Status: Pembayaran berhasil");
        } else {
            System.out.println("Status: Pembayaran gagal");
        }

        // E-Wallet
        System.out.println("\n=== E-WALLET ===");
        System.out.println("ID Transaksi: " + eWallet.idTransaksi);
        System.out.println("Nominal: Rp" + eWallet.totalPembayaran);
        System.out.println("Biaya Admin: Rp" + eWallet.hitungBiayaAdmin());
        System.out.println("Total Akhir: Rp" + eWallet.hitungTotalAkhir());

        eWallet.prosesPembayaran();

        if (eWallet.verifikasiTransaksi()) {
            System.out.println("Status: Pembayaran berhasil");
        } else {
            System.out.println("Status: Pembayaran gagal");
        }

        System.out.println("Sisa Saldo: Rp" + eWallet.getSaldo());
        
        // QRIS
        System.out.println("\n=== PEMBAYARAN QRIS ===");
        System.out.println("ID Transaksi: " + qris.idTransaksi);
        System.out.println("Nominal: Rp" + qris.totalPembayaran);
        System.out.println("Biaya Admin: Rp" + qris.hitungBiayaAdmin());
        System.out.println("Total Akhir: Rp" + qris.hitungTotalAkhir());

        qris.prosesPembayaran();

        if (qris.prosesPembayaran()) {
            System.out.println("Status: Pembayaran berhasil");
        } else {
            System.out.println("Status: Pembayaran gagal");
        }

        if (qris.verifikasiTransaksi()) {
            System.out.println("Verifikasi: Transaksi valid");
        } else {
            System.out.println("Verifikasi: Transaksi tidak valid");
        }

        qris.batalkanPembayaran();

        if (qris.batalkanPembayaran()) {
            System.out.println("Pembatalan: Berhasil");
        } else {
            System.out.println("Pembatalan: Ditolak");
        }

    }
}
