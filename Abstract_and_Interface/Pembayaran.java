abstract class Pembayaran {
    protected  String idTransaksi;
    protected  double totalPembayaran;
    protected boolean berhasil;

    public Pembayaran(String idTransaksi, double totalPembayaran) {
        this.idTransaksi = idTransaksi;
        this.totalPembayaran = totalPembayaran;
    }

    public abstract boolean prosesPembayaran();

    public abstract double hitungBiayaAdmin();

    public double hitungTotalAkhir() {
        return totalPembayaran + hitungBiayaAdmin();
    }

}
