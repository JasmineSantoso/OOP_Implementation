# Formulir Pendaftaran Mahasiswa

## Deskripsi Proyek

**Formulir Pendaftaran Mahasiswa** merupakan aplikasi desktop sederhana berbasis Java Swing yang digunakan untuk memasukkan dan menampilkan data mahasiswa melalui Graphical User Interface (GUI).

Proyek ini dibuat sebagai penerapan konsep GUI pada Java Swing, khususnya penggunaan JFrame, JPanel, atomic components, layout manager, intermediate containers, dan event handling.

## Tujuan Proyek

1. Memahami penerapan GUI menggunakan Java Swing.
2. Memahami penggunaan top-level container dan intermediate container.
3. Mengimplementasikan atomic components pada aplikasi GUI.
4. Memahami penggunaan layout manager untuk mengatur tata letak komponen.
5. Menerapkan event handling untuk menangani interaksi pengguna.

## Teknologi yang Digunakan

- **Bahasa Pemrograman:** Java
- **GUI Library:** Java Swing
- **AWT:** Java Abstract Window Toolkit
- **IDE:** Visual Studio Code / IntelliJ IDEA / NetBeans

## Fitur Aplikasi

- Input nama mahasiswa.
- Input NIM mahasiswa.
- Memilih program studi melalui dropdown.
- Memilih jenis kelamin menggunakan radio button.
- Menyimpan dan menampilkan data mahasiswa.
- Mereset formulir untuk menghapus input.

## Struktur Proyek

```text
FormulirPendaftaranMahasiswa/
│
├── Main.java
├── Mahasiswa.java
├── MahasiswaFrame.java
├── MahasiswaFormPanel.java
└── README.md
```

### Penjelasan File

| File | Deskripsi |
|---|---|
| `Main.java` | Titik awal eksekusi aplikasi. |
| `Mahasiswa.java` | Class model untuk merepresentasikan data mahasiswa. |
| `MahasiswaFrame.java` | Mengatur jendela utama aplikasi menggunakan JFrame dan menangani event. |
| `MahasiswaFormPanel.java` | Membuat tampilan formulir dan komponen GUI menggunakan JPanel. |

## Implementasi Konsep Java Swing

### 1. Container

Aplikasi menggunakan dua jenis container:

**Top-Level Container**
- `JFrame`: Menjadi jendela utama aplikasi.

**Intermediate Container**
- `JPanel`: Mengelompokkan komponen formulir dan hasil.
- `JScrollPane`: Menyediakan fitur scroll pada area hasil.

### 2. Atomic Components

Aplikasi menggunakan 13 atomic components:

| Komponen | Jumlah | Fungsi |
|---|---:|---|
| `JLabel` | 5 | Menampilkan teks atau keterangan. |
| `JTextField` | 2 | Menerima input nama dan NIM. |
| `JComboBox` | 1 | Memilih program studi. |
| `JRadioButton` | 2 | Memilih jenis kelamin. |
| `JButton` | 2 | Menjalankan aksi simpan dan reset. |
| `JTextArea` | 1 | Menampilkan data mahasiswa. |
| **Total** | **13** | |

### 3. Layout Manager

Terdapat dua jenis layout manager yang digunakan:

- `BorderLayout`: Mengatur posisi panel formulir dan panel hasil serta komponen di dalam panel hasil.
- `GridLayout`: Mengatur komponen formulir dalam bentuk baris dan kolom.

### 4. Event Handling

Event handling digunakan untuk menangani interaksi pengguna dengan tombol aplikasi.

- `ActionListener`: Menangani aksi ketika tombol diklik.
- `actionPerformed(ActionEvent e)`: Method yang dijalankan ketika terjadi aksi pada komponen.

## Alur Penggunaan Aplikasi

1. Pengguna membuka aplikasi.
2. Pengguna mengisi nama dan NIM.
3. Pengguna memilih program studi.
4. Pengguna memilih jenis kelamin.
5. Pengguna menekan tombol **Simpan**.
6. Data mahasiswa ditampilkan pada bagian hasil.
7. Pengguna dapat menekan tombol **Reset** untuk mengosongkan formulir.

## Output

![alt text](<Output.png>)
