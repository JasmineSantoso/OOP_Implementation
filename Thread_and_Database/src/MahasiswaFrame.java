import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class MahasiswaFrame extends JFrame {

    private JTextField txtNama;
    private JTextField txtProdi;

    private JButton btnTambah;
    private JButton btnUpdate;
    private JButton btnHapus;
    private JButton btnRefresh;

    private JLabel lblStatus;

    private JTable table;
    private DefaultTableModel tableModel;

    private MahasiswaDAO dao = new MahasiswaDAO();

    private int selectedId = -1;

    public MahasiswaFrame() {
        setTitle("Student Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        loadData();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));

        txtNama = new JTextField();
        txtProdi = new JTextField();

        panelForm.add(new JLabel("Nama Mahasiswa"));
        panelForm.add(txtNama);

        panelForm.add(new JLabel("Program Studi"));
        panelForm.add(txtProdi);

        JPanel panelButton = new JPanel(new FlowLayout());

        btnTambah = new JButton("Tambah");
        btnUpdate = new JButton("Update");
        btnHapus = new JButton("Hapus");
        btnRefresh = new JButton("Refresh");

        panelButton.add(btnTambah);
        panelButton.add(btnUpdate);
        panelButton.add(btnHapus);
        panelButton.add(btnRefresh);

        panelForm.add(panelButton);

        tableModel = new DefaultTableModel(
                new String[]{"ID", "Nama", "Program Studi"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        lblStatus = new JLabel("Ready");
        JPanel panelStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panelStatus.add(lblStatus);

        add(panelForm, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelStatus, BorderLayout.SOUTH);

        btnTambah.addActionListener(e -> tambahData());
        btnUpdate.addActionListener(e -> updateData());
        btnHapus.addActionListener(e -> hapusData());
        btnRefresh.addActionListener(e -> loadData());

        // table selection
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();

                if (row != -1) {
                    selectedId = (int) tableModel.getValueAt(row, 0);
                    txtNama.setText(
                            tableModel.getValueAt(row, 1).toString());
                    txtProdi.setText(
                            tableModel.getValueAt(row, 2).toString());
                }
            }
        });
    }

    // helper thread
    private <T> void runInBackground(
            String message,
            Callable<T> task,
            Consumer<T> onSuccess
    ) {

        setButtonsEnabled(false);
        lblStatus.setText(message);

        new Thread(() -> {
            try {
                T result = task.call();

                SwingUtilities.invokeLater(() -> {
                    onSuccess.accept(result);
                    lblStatus.setText("Operation completed");
                    setButtonsEnabled(true);
                });

            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> {
                    lblStatus.setText("Operation failed");
                    JOptionPane.showMessageDialog(
                            this,
                            e.getMessage(),
                            "Database Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    setButtonsEnabled(true);
                });
            }
        }).start();
    }

    private void loadData() {
        runInBackground(
                "Loading...",
                () -> dao.getAllMahasiswa(),
                result -> {
                    tableModel.setRowCount(0);
                    for (Mahasiswa m : result) {
                        tableModel.addRow(new Object[]{
                                m.getId(),
                                m.getNama(),
                                m.getProdi()
                        });
                    }
                }
        );
    }

    private void tambahData() {

        String nama = txtNama.getText().trim();
        String prodi = txtProdi.getText().trim();

        if (nama.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Semua field harus diisi!");
            return;
        }

        Mahasiswa mahasiswa = new Mahasiswa(nama, prodi);

        runInBackground(
                "Saving...",
                () -> {
                    dao.tambahMahasiswa(mahasiswa);
                    return null;
                },

                result -> {
                    JOptionPane.showMessageDialog(
                            this,
                            "Data berhasil ditambahkan!");
                    clearForm();
                    loadData();
                }
        );
    }

    private void updateData() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Pilih data terlebih dahulu!");
            return;
        }

        String nama = txtNama.getText().trim();
        String prodi = txtProdi.getText().trim();

        if (nama.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Semua field harus diisi!");
            return;
        }

        Mahasiswa mahasiswa = new Mahasiswa(
                selectedId,
                nama,
                prodi
        );

        runInBackground(
                "Updating...",
                () -> {
                    dao.updateMahasiswa(mahasiswa);
                    return null;
                },
                result -> { JOptionPane.showMessageDialog(
                        this,
                        "Data berhasil diperbarui!"
                    );
                    clearForm();
                    loadData();
                }
        );
    }

    private void hapusData() {
        if (selectedId == -1) { 
            JOptionPane.showMessageDialog(
                    this,
                    "Pilih data terlebih dahulu!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin menghapus data ini?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        int id = selectedId;

        runInBackground(
                "Deleting...",
                () -> {
                    dao.hapusMahasiswa(id);
                    return null;
                },
                result -> { JOptionPane.showMessageDialog(
                            this,
                            "Data berhasil dihapus!");
                    clearForm();
                    loadData();
                }
        );
    }

    private void clearForm() {
        txtNama.setText("");
        txtProdi.setText("");
        selectedId = -1;
        table.clearSelection();
    }

    private void setButtonsEnabled(boolean enabled) {
        btnTambah.setEnabled(enabled);
        btnUpdate.setEnabled(enabled);
        btnHapus.setEnabled(enabled);
        btnRefresh.setEnabled(enabled);
    }
}