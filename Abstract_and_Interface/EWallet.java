class EWallet extends Pembayaran implements DapatDiverifikasi {
    private double saldo;

    public EWallet(String idTransaksi, double totalPembayaran, double saldo) {
        super(idTransaksi, totalPembayaran);
        this.saldo = saldo;
    }

    public boolean prosesPembayaran() {
        double totalAkhir = hitungTotalAkhir();

        if (saldo >= totalAkhir) {
            saldo = saldo - totalAkhir;
            berhasil = true;
            return true;
        } else {
            berhasil = false;
            return false;
        }
    }

    public double hitungBiayaAdmin() {
        return totalPembayaran * 0.01;
    }

    public boolean verifikasiTransaksi() {
        return berhasil;
    }

    public double getSaldo() { return saldo; }
    
}
