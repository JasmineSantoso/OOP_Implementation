public class Silinder extends Lingkaran{
    private double tinggi;

    public Silinder(String warna, double radius, double tinggi) {
        super(warna, radius);
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        return phi * getRadius() * getRadius() * tinggi;
    }

    public double getTinggi() { return tinggi;}
    public void setTinggi(double tinggi) { this.tinggi = tinggi;}

    @Override
    public void printInfo() {
        double volume = hitungVolume();

        System.out.println("Silinder warna " + getWarna()
                + ", volume = " + volume);
    }
}
