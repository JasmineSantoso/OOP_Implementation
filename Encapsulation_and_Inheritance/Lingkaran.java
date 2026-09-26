public class Lingkaran extends Bentuk{
    private double radius;
    public static final double phi = 3.14;

    public Lingkaran(String warna, double radius) {
        super(warna);
        this.radius = radius;
    }

    public double hitungLuas() {
        return phi * radius * radius;
    }

    public double getRadius() { return radius;}
    public void setRadius(double radius) { this.radius = radius; }

    @Override
    public void printInfo() {
        double luas = hitungLuas();

    System.out.println("Lingkaran " + getWarna() + ", luas = " + luas);
    }
}
