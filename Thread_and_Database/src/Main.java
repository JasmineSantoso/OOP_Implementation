import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaFrame frame = new MahasiswaFrame();
            frame.setVisible(true);
        });
    }
}