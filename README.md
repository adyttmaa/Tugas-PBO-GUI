# LifeLog: Campus 🎓

Aplikasi manajemen tugas dan pengingat sederhana berbasis Java GUI (Swing) yang dirancang khusus untuk membantu mahasiswa mengorganisir aktivitas akademik dan keseharian.

## Pemenuhan Kriteria Komponen GUI

Aplikasi ini dibangun dengan memenuhi 5 kriteria utama komponen Graphical User Interface (GUI) Java Swing:

### 1. Top Level Container
* **`JFrame`**: Digunakan sebagai jendela utama (bingkai dasar) aplikasi yang menampung seluruh komponen lainnya. Diimplementasikan melalui pewarisan (`extends JFrame`) pada kelas utama.

### 2. Intermediate Component (Container)
* **`JPanel`**: Digunakan untuk mengelompokkan komponen form input (label, teks, dropdown, dan tombol) di bagian atas aplikasi.
* **`JScrollPane`**: Digunakan untuk membungkus daftar tugas, sehingga antarmuka dapat digulir (di-*scroll*) jika jumlah tugas melebihi kapasitas tinggi jendela.

### 3. Atomic Component
* **`JLabel`**: Menampilkan teks statis pendamping form (contoh: "Hal yang perlu diurus:").
* **`JTextField`**: Kotak input teks satu baris untuk mengetikkan nama tugas.
* **`JComboBox`**: Menu *dropdown* untuk memilih Kategori dan Tingkat Prioritas.
* **`JButton`**: Tombol aksi interaktif ("Tambah Pengingat" dan "Hapus Tugas Terpilih [X]").
* **`JList`**: Menampilkan daftar tugas yang terstruktur per baris dan dapat dipilih (*selectable*). Bekerja sama dengan `DefaultListModel` untuk manipulasi data (tambah/hapus) di dalam memori.
* **`JOptionPane`**: Menampilkan kotak dialog (*pop-up*) peringatan jika input kosong (`showMessageDialog`) dan dialog konfirmasi sebelum mengeksekusi penghapusan tugas (`showConfirmDialog`).

### 4. Layout Manager
* **`BorderLayout`**: Diterapkan pada `JFrame` utama untuk membagi area menjadi dua: `BorderLayout.NORTH` untuk menempatkan panel form input, dan `BorderLayout.CENTER` untuk membiarkan daftar tugas (JList) mengisi sisa ruang secara responsif.
* **`GridLayout`**: Diterapkan pada `JPanel` form input dengan pengaturan struktur (5 baris, 2 kolom) agar susunan label, input, dan tombol menjadi sejajar, rapi, dan memiliki jarak proporsional.

### 5. Event Handling (2 Interface)
Aplikasi ini mengimplementasikan dua antarmuka pendeteksi interaksi pengguna:
* **`ActionListener`**: Mendeteksi kejadian klik. 
  * Pada tombol **Tambah**, mendeteksi klik untuk mengambil data dari komponen form, memvalidasinya, lalu memasukkannya ke dalam model data `JList`. 
  * Pada tombol **Hapus**, mendeteksi baris yang dipilih pengguna lalu mengeksekusi penghapusan setelah mendapat persetujuan dari dialog konfirmasi.
* **`MouseListener`**: Menangani interaksi visual pergerakan kursor (*hover effect*).
  * Diimplementasikan menggunakan `mouseEntered` untuk menggelapkan warna tombol saat kursor menyorot di atasnya, dan `mouseExited` untuk mengembalikan warna tombol ke keadaan aslinya secara mulus.

---

## Screenshot Aplikasi

### 1. Tampilan Awal Aplikasi
![Tampilan Awal](<screenshot/01-Tampilan Awal.png>)

### 2. Menambah Pengingat Baru
![Tambah Pengingat](<screenshot/02-Tambah Pengingat.png>)

### 3. Validasi Input Tugas
![Validasi Input](<screenshot\03-Validasi Input Tugas.png>)

### 4. Validasi Input Hapus Tugas
![Konfirmasi Hapus](<screenshot\04-Validasi Input Hapus Tugas.png>)

### 5. Konfirmasi Hapus Tugas
![Tugas Terhapus](<screenshot\05-Konfirmasi Hapus Tugas.png>)
