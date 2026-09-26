# Exercise - Exploration of Array and ArrayList
## Deskripsi
Program ini dibuat untuk memenuhi tugas mahasiswa semester 5 kelas A untuk topik materi Array and ArrayList pada mata kuliah Pemrograman Berorientasi Objek (PBO).
Program yang dibuat merupakan simulasi sederhana sistem perbankan yang menggunakan konsep Object-Oriented Programming, khususnya penggunaan Array, object, constructor, method, dan accessor.
Program menampilkan menu sederhana dan dapat menerima input dari user menggunakan Scanner untuk mengakses akun bank sederhana.
Program menggunakan method yang ada pada class untuk semua operasi.

## Struktur Program
Program terdiri dari 4 class, yaitu:

`Account.java`
Digunakan untuk menyimpan informasi saldo dan terdapat method untuk melakukan deposit, withdraw, serta melihat saldo.

`Customer.java`
Digunakan untuk menyimpan informasi customer, yaitu nama depan, nama belakang, dan account yang dimiliki.

`Bank.java`
Digunakan untuk menyimpan customer dalam sebuah array dan menyediakan method untuk menambahkan serta mengambil customer.

`Welcome.java`
Adalah main program untuk membuat object dan mengeksplorasi penggunaan class, array, dan method.

## Fitur Program
Program menyediakan 4 pilihan menu:

- Deposit
- Withdraw
- Check Balance
- Exit

## Flowchart Program

```text
Start
  │
  ▼
Input Nama
  │
  ▼
Input Saldo Awal
  │
  ▼
Tampilkan Menu
  │
  ▼
┌─────────────────────┐
│     BANK ABC MENU   │
├─────────────────────┤
│ 1. Deposit          │
│ 2. Withdraw         │
│ 3. Lihat Balance    │
│ 4. Exit             │
└──────────┬──────────┘
           │
           ▼
      ┌───────────┐
      │  Pilihan? │
      └─────┬─────┘
            │
      ┌─────┼─────┬─────┐
      │     │     │     │
     1│    2│    3│    4│
      ▼     ▼     ▼     ▼
  Deposit Withdraw Balance Exit
      │     │     │     │
      │     │     │     └──► Program Selesai
      │     │     │
      └─────┴─────┘
            │
            ▼
       Kembali Menu
```


##  SCREENSHOT PROGRAM OUTPUT
### 1. Input Nama
<img width="207" height="47" alt="image" src="https://github.com/user-attachments/assets/ca0a842d-3c00-410e-8e7c-fe8c3838208f" />

### 2. Input Saldo Awal
<img width="194" height="50" alt="image" src="https://github.com/user-attachments/assets/07320e1d-4800-46b9-92a9-7d56304752ae" />

### 3. Menu
<img width="205" height="142" alt="image" src="https://github.com/user-attachments/assets/08103af4-aa65-4e91-b233-6b8ec2482c26" />

### 4. Deposit
<img width="199" height="176" alt="image" src="https://github.com/user-attachments/assets/69a9a22f-10c5-4908-b025-8687aaa23e5f" />

### 5. Withdraw
<img width="195" height="175" alt="image" src="https://github.com/user-attachments/assets/86651a81-edd9-4b22-8871-472ae927c482" />

### 6. Lihat Balance
<img width="194" height="199" alt="image" src="https://github.com/user-attachments/assets/a1383461-1126-4db8-b819-cc253798410e" />

### 7. Exit
<img width="239" height="159" alt="image" src="https://github.com/user-attachments/assets/c2b29a2c-8ca0-4995-a912-072a75cf9abb" />



