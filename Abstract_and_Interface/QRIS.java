class QRIS extends Pembayaran implements DapatDiverifikasi, DapatDibatalkan{
    private String kodeQR;

    public QRIS(String idTransaksi, double totalPembayaran, String kodeQR) {
        super(idTransaksi, totalPembayaran);
        this.kodeQR = kodeQR;
    }

    public boolean prosesPembayaran() {
        if (kodeQR == null || kodeQR.length() != 6) {
            berhasil = false;
            return false;
        }

        for (int i = 0; i < kodeQR.length(); i++) {
            char karakter = kodeQR.charAt(i);

            if (karakter < '0' || karakter > '9') {
                berhasil = false;
                return false;
            }
        }

        berhasil = true;
        return true;
    }

    public double hitungBiayaAdmin() {
        return totalPembayaran * 0.007;
    }

    public boolean verifikasiTransaksi() {
        return berhasil;
    }

    public boolean batalkanPembayaran() {
        if (berhasil) {
            return false;
        }

        berhasil = false;
        return true;
    }
}
