import javax.swing.*;
import java.awt.*;

public class MahasiswaFormPanel extends JPanel {

    JTextField txtNama;
    JTextField txtNim;

    JComboBox<String> cbProdi;

    JRadioButton rbLaki;
    JRadioButton rbPerempuan;

    JButton btnSimpan;
    JButton btnReset;

    JTextArea txtHasil;

    public MahasiswaFormPanel() {

        setLayout(new BorderLayout(10, 10));

        JPanel panelForm = new JPanel(new GridLayout(5, 2, 10, 10)); // (rows, columns, hgap, vgap)

        JLabel lblNama = new JLabel("Nama:");
        txtNama = new JTextField();

        JLabel lblNim = new JLabel("NIM:");
        txtNim = new JTextField();

        JLabel lblProdi = new JLabel("Program Studi:");

        String[] daftarProdi = {
            "Teknik Informatika",
            "Sistem Informasi",
            "Teknik Elektro"
        };

        cbProdi = new JComboBox<>(daftarProdi);

        JLabel lblGender = new JLabel("Jenis Kelamin:");

        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");

        ButtonGroup groupGender = new ButtonGroup();
        groupGender.add(rbLaki);
        groupGender.add(rbPerempuan);

        JPanel panelGender = new JPanel();
        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);

        panelForm.add(lblNama);
        panelForm.add(txtNama);

        panelForm.add(lblNim);
        panelForm.add(txtNim);

        panelForm.add(lblProdi);
        panelForm.add(cbProdi);

        panelForm.add(lblGender);
        panelForm.add(panelGender);

        btnSimpan = new JButton("Simpan");
        btnReset = new JButton("Reset");

        panelForm.add(btnSimpan);
        panelForm.add(btnReset);

    
        JPanel panelHasil = new JPanel(new BorderLayout());

        JLabel lblHasil = new JLabel("Data Mahasiswa:");

        txtHasil = new JTextArea(6, 30);
        txtHasil.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(txtHasil);

        panelHasil.add(lblHasil, BorderLayout.NORTH);
        panelHasil.add(scrollPane, BorderLayout.CENTER);

        add(panelForm, BorderLayout.NORTH);
        add(panelHasil, BorderLayout.CENTER);

        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // jarak kosong di tepi (top, left, bottom, right)
    }
}