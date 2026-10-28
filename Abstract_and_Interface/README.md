# Abstract Class and Interface Implementation in Java

## 1. Deskripsi Program

Program ini merupakan implementasi konsep Object-Oriented Programming (OOP) menggunakan bahasa Java dengan studi kasus **Sistem Pembayaran Toko Online**.

Program menyimulasikan tiga metode pembayaran, yaitu Transfer Bank, E-Wallet, dan QRIS. Setiap metode pembayaran memiliki mekanisme pemrosesan transaksi dan perhitungan biaya administrasi yang berbeda.

Program ini dibuat untuk memahami penerapan beberapa konsep OOP, terutama:

- Abstract Class
- Interface
- Inheritance
- Method Overriding
- Encapsulation
- Polymorphism sebagai konsep lanjutan yang dapat diterapkan pada desain ini

Program hanya merupakan simulasi dan tidak terhubung dengan layanan pembayaran atau sistem perbankan yang sebenarnya.

## 2. Tujuan

Tujuan dari program ini adalah:

1. Memahami penggunaan abstract class sebagai struktur dasar bagi beberapa class turunan.
2. Memahami penggunaan interface untuk mendefinisikan kemampuan yang harus dimiliki suatu class.
3. Menerapkan inheritance untuk mewarisi atribut dan method dari superclass.
4. Menerapkan method overriding untuk memberikan implementasi method yang berbeda pada setiap subclass.
5. Memahami perbedaan antara abstract class dan interface dalam desain program Java.

## 3. Struktur Class

Program terdiri dari satu abstract class, dua interface, dan tiga concrete class.

| Class/Interface | Jenis | Deskripsi |
|---|---|---|
| `Pembayaran` | Abstract Class | Menyediakan atribut dan perilaku dasar pembayaran. |
| `DapatDiverifikasi` | Interface | Mendefinisikan kemampuan untuk memverifikasi transaksi. |
| `DapatDibatalkan` | Interface | Mendefinisikan kemampuan untuk membatalkan pembayaran. |
| `TransferBank` | Concrete Class | Mengimplementasikan pembayaran melalui transfer bank. |
| `EWallet` | Concrete Class | Mengimplementasikan pembayaran menggunakan saldo E-Wallet. |
| `QRIS` | Concrete Class | Mengimplementasikan pembayaran menggunakan simulasi QRIS. |
| `Main` | Main Class | Menjalankan program dan menguji proses pembayaran. |

## 4. Class Diagram

![alt text](<Screenshot 2026-10-27 103723.png>)

## 5. Implementasi Abstract Class

Abstract class `Pembayaran` merupakan superclass yang menyediakan struktur dasar bagi seluruh metode pembayaran.

Class ini memiliki tiga atribut utama:

- `idTransaksi`: menyimpan identitas transaksi.
- `totalPembayaran`: menyimpan nominal pembayaran sebelum biaya administrasi.
- `berhasil`: menyimpan status keberhasilan transaksi.

Abstract class ini mendefinisikan dua abstract method:

```java
public abstract boolean prosesPembayaran();

public abstract double hitungBiayaAdmin();
```

Kedua method tersebut tidak memiliki implementasi di dalam abstract class. Oleh karena itu, setiap concrete subclass wajib memberikan implementasinya sendiri.

Selain itu, `Pembayaran` memiliki method konkret:

```java
public double hitungTotalAkhir() {
    return totalPembayaran + hitungBiayaAdmin();
}
```

Method tersebut menghitung total pembayaran beserta biaya administrasi. Karena implementasinya sudah tersedia di superclass, subclass dapat menggunakan method ini tanpa harus menuliskannya kembali.

**Tujuan penerapan abstract class:** menyediakan struktur dan perilaku dasar yang dapat digunakan bersama oleh seluruh metode pembayaran, sekaligus mewajibkan subclass menentukan proses pembayaran dan perhitungan biaya administrasinya.

## 6. Implementasi Interface

Program menggunakan dua interface, yaitu `DapatDiverifikasi` dan `DapatDibatalkan`.

### A. Interface DapatDiverifikasi

Interface ini mendefinisikan kemampuan untuk memverifikasi transaksi.

```java
interface DapatDiverifikasi {
    boolean verifikasiTransaksi();
}
```

Interface ini diimplementasikan oleh `TransferBank`, `EWallet`, dan `QRIS`.

Setiap class memberikan implementasi `verifikasiTransaksi()` sesuai dengan status transaksi yang dimilikinya.

### B. Interface DapatDibatalkan

Interface ini mendefinisikan kemampuan untuk membatalkan pembayaran.

```java
interface DapatDibatalkan {
    boolean batalkanPembayaran();
}
```

Interface ini diimplementasikan oleh class `QRIS`.

Dalam simulasi ini, pembayaran yang belum berhasil diproses dapat dibatalkan, sedangkan pembayaran yang sudah berhasil tidak dapat dibatalkan melalui method tersebut.

**Tujuan penerapan interface:** memisahkan definisi kemampuan dari implementasinya. Dengan demikian, suatu class dapat memiliki kemampuan tertentu tanpa harus mewarisi implementasi dari class lain.

Java juga memungkinkan sebuah class mengimplementasikan lebih dari satu interface, seperti yang ditunjukkan oleh class `QRIS`.

## 7. Implementasi Inheritance

Inheritance diterapkan dengan menggunakan keyword `extends`.

Contohnya:

```java
class TransferBank extends Pembayaran
        implements DapatDiverifikasi {
    // Implementasi method
}
```

```java
class EWallet extends Pembayaran
        implements DapatDiverifikasi {
    // Implementasi method
}
```

```java
class QRIS extends Pembayaran
        implements DapatDiverifikasi, DapatDibatalkan {
    // Implementasi method
}
```

Ketiga class tersebut mewarisi struktur dasar dari `Pembayaran`.

Dengan inheritance, atribut dan method yang sudah didefinisikan pada superclass tidak perlu dideklarasikan ulang di setiap subclass.

Constructor subclass menggunakan `super()` untuk memanggil constructor superclass dan menginisialisasi atribut dasar pembayaran.

## 8. Implementasi Method Overriding

Method overriding dilakukan ketika subclass memberikan implementasi sendiri terhadap method yang diwarisi dari superclass atau diwajibkan oleh interface.

Pada program ini, method yang di-override meliputi:

- `prosesPembayaran()`
- `hitungBiayaAdmin()`
- `verifikasiTransaksi()`
- `batalkanPembayaran()` pada class `QRIS`

Setiap metode pembayaran memiliki aturan yang berbeda.

| Metode Pembayaran | Mekanisme Pembayaran | Biaya Administrasi |
|---|---|---|
| Transfer Bank | Memeriksa format nomor rekening yang terdiri dari 10 digit. | Tetap sebesar Rp2.500. |
| E-Wallet | Memeriksa kecukupan saldo dan mengurangi saldo jika pembayaran berhasil. | 1% dari nominal pembayaran. |
| QRIS | Memeriksa kode QR simulasi yang terdiri dari 6 digit. | 0,7% dari nominal pembayaran. |

Perbedaan implementasi ini menunjukkan bahwa method dengan nama yang sama dapat memiliki perilaku berbeda pada setiap subclass.

## 9. Implementasi Encapsulation

Encapsulation diterapkan dengan membatasi akses langsung terhadap atribut tertentu menggunakan modifier `private`.

Contohnya pada class `EWallet`:

```java
private double saldo;
```

Atribut saldo tidak dapat diakses secara langsung dari class lain yang tidak memiliki hak akses terhadapnya.

Untuk mendapatkan nilai saldo, class `EWallet` menyediakan getter:

```java
public double getSaldo() {
    return saldo;
}
```

Pendekatan ini membantu menjaga pengelolaan data objek dan mengurangi akses langsung yang tidak diperlukan.

## 10. Alur Kerja Program

Secara umum, alur program adalah sebagai berikut:

1. Membuat objek dari class `TransferBank`, `EWallet`, atau `QRIS`.
2. Menginisialisasi ID transaksi, nominal pembayaran, serta data tambahan sesuai metode pembayaran.
3. Menghitung biaya administrasi menggunakan `hitungBiayaAdmin()`.
4. Menghitung total pembayaran menggunakan `hitungTotalAkhir()`.
5. Memproses transaksi menggunakan `prosesPembayaran()`.
6. Memeriksa status transaksi melalui `verifikasiTransaksi()`.
7. Menampilkan hasil transaksi.
8. Untuk QRIS, menguji kemampuan pembatalan menggunakan `batalkanPembayaran()`.

Setiap metode pembayaran memiliki aturan pemrosesan yang berbeda, tetapi tetap mengikuti struktur dasar yang ditetapkan oleh abstract class.

## 12. Kesimpulan

Program Sistem Pembayaran Toko Online merupakan implementasi sederhana konsep Object-Oriented Programming menggunakan Java.

Abstract class `Pembayaran` digunakan untuk menyediakan struktur dasar dan perilaku bersama bagi berbagai metode pembayaran. Interface `DapatDiverifikasi` dan `DapatDibatalkan` digunakan untuk mendefinisikan kemampuan yang dapat diterapkan pada class tertentu.

Melalui inheritance dan method overriding, setiap subclass dapat menggunakan struktur yang sama sambil menerapkan logika pembayaran sesuai karakteristiknya.

Dengan demikian, program ini menunjukkan perbedaan fungsi abstract class dan interface serta bagaimana keduanya dapat digunakan bersama untuk menghasilkan desain program yang lebih terstruktur dan mudah dikembangkan.