public class Mahasiswa {
    private String nama;
    private String nim;
    private String prodi;
    private String jenisKelamin;

    public Mahasiswa(String nama, String nim,
                     String prodi, String jenisKelamin) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getProdi() {
        return prodi;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String toString() {
        return "Nama          : " + nama +
               "\nNIM           : " + nim +
               "\nProgram Studi : " + prodi +
               "\nJenis Kelamin : " + jenisKelamin;
    }
}