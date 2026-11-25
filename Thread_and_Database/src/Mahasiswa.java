public class Mahasiswa {
    private int id;
    private String nama;
    private String prodi;

    public Mahasiswa(int id, String nama, String prodi) { 
        this.id = id;
        this.nama = nama;
        this.prodi = prodi;
    }

    public Mahasiswa(String nama, String prodi) { 
        this.nama = nama;
        this.prodi = prodi;
    }

    public int getId() { return id;}
    public String getNama() { return nama;}
    public String getProdi() { return prodi;}

    public void setId(int id) { this.id = id;}
    public void setNama(String nama) { this.nama = nama;}
    public void setProdi(String prodi) { this.prodi = prodi;}
}
