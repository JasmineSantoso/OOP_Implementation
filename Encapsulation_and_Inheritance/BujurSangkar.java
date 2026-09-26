public class BujurSangkar extends Bentuk {
    private double sisi;

    public BujurSangkar(String warna, double sisi) {
        super(warna);
        this.sisi = sisi;
    }

    public double hitungLuas() {
        double luas = sisi * sisi;
        return luas;
    }

    public double getSisi() { return sisi;}
    public void setSisi(double sisi) { this.sisi = sisi; }

    @Override 
    public void printInfo() {
        System.out.println("Bujursangkar berwarna " + getWarna() + ", Luas = " + hitungLuas());
    }
}
