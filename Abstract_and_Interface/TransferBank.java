class TransferBank extends Pembayaran implements DapatDiverifikasi {
    private String nomorRekening;

    public TransferBank(String idTransaksi, double totalPembayaran, String nomorRekening) {
        super(idTransaksi, totalPembayaran);
        this.nomorRekening = nomorRekening;
    }

    public boolean prosesPembayaran() {
        if (nomorRekening == null || nomorRekening.length() != 10) {
            berhasil = false;
            return false;
        }

        for (int i = 0; i < nomorRekening.length(); i++) {
            char karakter = nomorRekening.charAt(i);

            if (karakter < '0' || karakter > '9') {
                berhasil = false;
                return false;
            }
        }

        berhasil = true;
        return true;
    }
    
    public double hitungBiayaAdmin() {
        return 2500;
    }

    public boolean verifikasiTransaksi() {
        return berhasil;
    }
}
