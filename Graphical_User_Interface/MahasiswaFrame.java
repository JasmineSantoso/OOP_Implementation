import javax.swing.*;
import java.awt.event.*;

public class MahasiswaFrame extends JFrame {

    private MahasiswaFormPanel form;

    public MahasiswaFrame() {

        setTitle("Formulir Pendaftaran Mahasiswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        form = new MahasiswaFormPanel();

        add(form);


        form.btnSimpan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String nama = form.txtNama.getText();
                String nim = form.txtNim.getText();

                String prodi = (String) form.cbProdi.getSelectedItem();

                String gender = "";

                if (form.rbLaki.isSelected()) {
                    gender = "Laki-laki";
                } else if (form.rbPerempuan.isSelected()) {
                    gender = "Perempuan";
                }

                if (nama.isEmpty() || nim.isEmpty() || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Semua data harus diisi!"
                    );
                    return;
                }

                Mahasiswa mhs = new Mahasiswa(
                    nama, nim, prodi, gender
                );

                form.txtHasil.setText(mhs.toString());

                JOptionPane.showMessageDialog(
                    null,
                    "Data berhasil disimpan!"
                );
            }
        });

       
        form.btnReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                form.txtNama.setText("");
                form.txtNim.setText("");

                form.cbProdi.setSelectedIndex(0);

                form.rbLaki.setSelected(false);
                form.rbPerempuan.setSelected(false);

                form.txtHasil.setText("");
            }
        });
    }
}