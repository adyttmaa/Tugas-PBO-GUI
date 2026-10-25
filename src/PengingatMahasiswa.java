import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

// 1. TOP-LEVEL CONTAINER & 2 INTERFACE EVENT HANDLING
public class PengingatMahasiswa extends JFrame implements ActionListener, MouseListener {

    // 2. DEKLARASI ATOMIC COMPONENT
    private JTextField txtTugas;
    private JComboBox<String> cbKategori;
    private JComboBox<String> cbPrioritas;
    private JButton btnTambah;
    private JTextArea txtDaftarTugas;

    // 3. KONSTRUKTOR (Merakit Tata Letak & Styling Modern)
    public PengingatMahasiswa() {
        // --- A. PENGATURAN TOP-LEVEL CONTAINER ---
        setTitle("LifeLog: Campus"); 
        setSize(550, 500); // Ukuran sedikit diperbesar agar lebih lega
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        // Mengubah warna background jendela utama menjadi putih
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout(15, 15)); // Jarak antar panel diperbesar

        // Membuat template font modern untuk dipakai ke semua komponen
        Font fontLabel = new Font("Segoe UI", Font.BOLD, 13);
        Font fontInput = new Font("Segoe UI", Font.PLAIN, 14);

        // --- B. INTERMEDIATE CONTAINER (Form Input) ---
        // GridLayout (4 baris, 2 kolom) dengan jarak yang lebih luas (10px horizontal, 15px vertikal)
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 10, 15));
        panelInput.setBackground(Color.WHITE); // Panel menyatu dengan background utama
        panelInput.setBorder(BorderFactory.createEmptyBorder(20, 25, 10, 25)); // Padding luar

        // --- C. INISIALISASI ATOMIC COMPONENT DENGAN STYLING ---
        // Baris 1: Tugas
        JLabel lblTugas = new JLabel("Hal yang perlu diurus:");
        lblTugas.setFont(fontLabel);
        panelInput.add(lblTugas);
        
        txtTugas = new JTextField();
        txtTugas.setFont(fontInput);
        panelInput.add(txtTugas);

        // Baris 2: Kategori
        JLabel lblKategori = new JLabel("Kategori:");
        lblKategori.setFont(fontLabel);
        panelInput.add(lblKategori);
        
        String[] pilihanKategori = {"Akademik & Tugas", "Tagihan & Kos", "Kebutuhan Harian", "Organisasi"};
        cbKategori = new JComboBox<>(pilihanKategori);
        cbKategori.setFont(fontInput);
        cbKategori.setBackground(Color.WHITE);
        panelInput.add(cbKategori);

        // Baris 3: Prioritas (Memakai Solusi Teks Aman)
        JLabel lblPrioritas = new JLabel("Tingkat Prioritas:");
        lblPrioritas.setFont(fontLabel);
        panelInput.add(lblPrioritas);
        
        String[] pilihanPrioritas = {"Tinggi [!]", "Sedang [-]", "Rendah [v]"};
        cbPrioritas = new JComboBox<>(pilihanPrioritas);
        cbPrioritas.setFont(fontInput);
        cbPrioritas.setBackground(Color.WHITE);
        panelInput.add(cbPrioritas);

        // Baris 4: Tombol
        panelInput.add(new JLabel("")); // Spacer
        btnTambah = new JButton("Tambah Pengingat");
        btnTambah.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // --- BAGIAN YANG DIREVISI ---
        btnTambah.setBackground(new Color(45, 45, 45)); // Hitam keabu-abuan (Dark Charcoal) 
        btnTambah.setForeground(Color.WHITE); 
        
        // Tambahkan 2 baris ini agar warna background biru "tembus" di tema Windows
        btnTambah.setContentAreaFilled(false);
        btnTambah.setOpaque(true);
        // -----------------------------
        
        btnTambah.setFocusPainted(false); 
        btnTambah.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        // Mendaftarkan Event Handling
        btnTambah.addActionListener(this); 
        btnTambah.addMouseListener(this);  
        panelInput.add(btnTambah);

        // --- D. AREA HASIL (INTERMEDIATE + ATOMIC COMPONENT) ---
        txtDaftarTugas = new JTextArea();
        txtDaftarTugas.setEditable(false); 
        txtDaftarTugas.setFont(new Font("Consolas", Font.PLAIN, 14)); // Font khas coding yang rapi
        txtDaftarTugas.setBackground(new Color(245, 247, 250)); // Background teks abu-abu sangat muda
        txtDaftarTugas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding dalam teks
        
        // JScrollPane dengan TitledBorder modern
        JScrollPane scrollPane = new JScrollPane(txtDaftarTugas);
        TitledBorder borderDaftar = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), "Daftar Pengingat Saya:"
        );
        borderDaftar.setTitleFont(fontLabel);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(0, 25, 20, 25), // Margin luar scrollpane
            borderDaftar // Border garis
        ));
        scrollPane.getViewport().setBackground(Color.WHITE);

        // --- E. MENGGABUNGKAN KE FRAME UTAMA ---
        getContentPane().add(panelInput, BorderLayout.NORTH); 
        getContentPane().add(scrollPane, BorderLayout.CENTER); 
    }

    // 4. IMPLEMENTASI EVENT HANDLING
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTambah) {
            String tugas = txtTugas.getText().trim();
            String kategori = cbKategori.getSelectedItem().toString();
            String prioritas = cbPrioritas.getSelectedItem().toString();

            if (tugas.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Hal yang perlu diurus tidak boleh kosong!", 
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                String formatTeks = ">> [" + prioritas + "] " + tugas + "\n   Kategori: " + kategori + "\n\n";
                txtDaftarTugas.append(formatTeks); 
                txtTugas.setText(""); 
            }
        }
    }

    // Bagian ini sekarang lebih interaktif!
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == btnTambah) {
            btnTambah.setBackground(new Color(75, 75, 75)); // Menjadi abu-abu sedikit lebih terang saat disentuh
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == btnTambah) {
            btnTambah.setBackground(new Color(45, 45, 45)); // Kembali ke hitam semula
        }
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}

    // 5. MAIN METHOD
    public static void main(String[] args) {
        // Menggunakan "look and feel" bawaan sistem operasi agar tidak terlihat seperti Java jadul
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            PengingatMahasiswa aplikasi = new PengingatMahasiswa();
            aplikasi.setVisible(true);
        });
    }
}