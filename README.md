🎓 LifeLog: Campus

LifeLog: Campus adalah aplikasi antarmuka grafis (GUI) berbasis Java Swing yang dirancang sebagai asisten pencatat tugas untuk mahasiswa. Aplikasi ini memungkinkan pengguna untuk menambahkan daftar hal yang perlu diurus, mengelompokkannya berdasarkan kategori, menetapkan tingkat prioritas, serta menghapus tugas yang sudah diselesaikan.

Proyek ini dibangun untuk memenuhi kriteria Tugas Praktikum Pemrograman Berbasis Objek (PBO) - Materi GUI.

🚀 Fitur Utama

Tambah Pengingat: Pengguna dapat menginput nama tugas, kategori, dan prioritas.

Daftar Tugas Interaktif: Menampilkan tugas dalam format ringkas di dalam daftar (List) yang bisa dipilih (diklik).

Hapus Tugas: Pengguna dapat menghapus tugas spesifik yang sudah diselesaikan dari dalam daftar.

Desain Modern & Dinamis: Dilengkapi dengan efek hover pada tombol dan menggunakan System Look and Feel agar antarmuka menyesuaikan dengan gaya sistem operasi pengguna.

🛠️ Pemenuhan Syarat Kriteria Tugas (PBO GUI)

Aplikasi ini telah menerapkan 100% dari 5 kriteria wajib komponen GUI yang disyaratkan oleh dosen pengampu:

1. Top-Level Container

Menggunakan JFrame sebagai jendela utama (window) aplikasi yang menampung seluruh komponen grafis.

2. Intermediate Container

Menggunakan JPanel untuk menampung komponen form input (Tugas, Kategori, Prioritas) agar rapi.

Menggunakan JScrollPane untuk membungkus daftar tugas sehingga dapat digulir (scrollable) ketika teks melebihi kapasitas layar.

3. Atomic Components

Komponen atomik yang diimplementasikan meliputi:

JLabel : Sebagai teks keterangan pada form (Hal yang perlu diurus, Kategori, Tingkat Prioritas).

JTextField : Sebagai kolom input teks untuk nama tugas.

JComboBox : Sebagai dropdown menu untuk memilih Kategori dan Tingkat Prioritas.

JButton : Sebagai tombol aksi utama (Tambah Pengingat dan Hapus Tugas Terpilih).

JList : Sebagai layar utama untuk menampilkan daftar tugas secara berbaris per item (dipadukan dengan DefaultListModel).

4. Layout Manager

BorderLayout : Mengatur tata letak utama jendela. Form input diletakkan di NORTH (atas), dan Daftar Tugas diletakkan di CENTER (tengah).

GridLayout : Diaplikasikan pada JPanel (5 baris, 2 kolom) agar form isian dan tombol sejajar rapi dengan presisi yang sama.

5. Event Handling (Minimal 2 Interface)

Aplikasi ini mengimplementasikan dua listener utama:

ActionListener :

Menangkap event klik pada tombol "Tambah Pengingat" untuk mengambil teks dari input dan memindahkannya ke dalam daftar tugas.

Menangkap event klik pada tombol "Hapus Tugas" untuk membaca index baris yang dipilih pengguna dan menghapus datanya dari memori.

MouseListener :

Menangani interaksi visual (hover effect) menggunakan fungsi mouseEntered dan mouseExited. Warna latar tombol akan berubah menjadi lebih terang/gelap secara dinamis saat kursor mouse menyorot tombol.

💻 Cara Menjalankan Program

Pastikan Anda telah menginstal Java Development Kit (JDK) di perangkat Anda.

Unduh atau clone repositori ini.

Buka file PengingatMahasiswa.java di IDE favorit Anda (misal: VS Code, IntelliJ, Eclipse, atau NetBeans).

Compile dan jalankan (Run) program tersebut. Tidak ada library eksternal yang dibutuhkan karena seluruhnya menggunakan pustaka bawaan javax.swing dan java.awt.

Dibuat untuk keperluan Ujian/Tugas Praktikum PBO