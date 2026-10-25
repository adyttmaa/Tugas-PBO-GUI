import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Mengimplementasikan 2 interface sekaligus: ActionListener (klik) dan MouseListener (hover mouse)
public class AplikasiBukuTamu implements ActionListener, MouseListener {
    
    // 1. Deklarasi Komponen
    // Top Level
    private JFrame frame;
    // Intermediate
    private JPanel panelInput;
    private JScrollPane scrollPane;
    // Atomic
    private JLabel lblNama, lblInstansi;
    private JTextField txtNama, txtInstansi;
    private JTextArea txtAreaDaftar;
    private JButton btnSimpan;

    // 2. Konstruktor (Tempat merakit GUI)
    public AplikasiBukuTamu() {
        // --- TOP LEVEL CONTAINER ---
        frame = new JFrame("Buku Tamu Digital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        // LAYOUT MANAGER 1: BorderLayout untuk frame utama
        frame.setLayout(new BorderLayout());

        // --- INTERMEDIATE COMPONENT & LAYOUT MANAGER 2 ---
        panelInput = new JPanel();
        // GridLayout: 2 baris, 2 kolom (agar form rapi)
        panelInput.setLayout(new GridLayout(2, 2, 10, 10)); 
        
        // --- ATOMIC COMPONENT ---
        lblNama = new JLabel(" Nama Lengkap:");
        txtNama = new JTextField();
        lblInstansi = new JLabel(" Asal Instansi:");
        txtInstansi = new JTextField();
        
        // Memasukkan atomic ke dalam panel (urutan menentukan posisi di grid)
        panelInput.add(lblNama);
        panelInput.add(txtNama);
        panelInput.add(lblInstansi);
        panelInput.add(txtInstansi);

        // Menyiapkan area daftar hadir
        txtAreaDaftar = new JTextArea();
        txtAreaDaftar.setEditable(false); // Agar tidak bisa diketik manual oleh user
        // JScrollPane: Intermediate component agar text area bisa di-scroll
        scrollPane = new JScrollPane(txtAreaDaftar);

        // Menyiapkan tombol
        btnSimpan = new JButton("Simpan Data");

        // --- MENYUSUN KE FRAME (Menggunakan arah mata angin BorderLayout) ---
        frame.add(panelInput, BorderLayout.NORTH); // Form di atas
        frame.add(scrollPane, BorderLayout.CENTER); // Daftar hadir di tengah
        frame.add(btnSimpan, BorderLayout.SOUTH); // Tombol di bawah

        // --- REGISTRASI EVENT HANDLING ---
        // "Menyambungkan" tombol dengan interface yang ada di class ini (this)
        btnSimpan.addActionListener(this);
        btnSimpan.addMouseListener(this);

        // Memunculkan GUI ke layar
        frame.setVisible(true);
    }

    // ==========================================
    // 3. IMPLEMENTASI EVENT HANDLING (Logika)
    // ==========================================

    // Interface 1: ActionListener (Menangkap event KLIK)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSimpan) {
            String nama = txtNama.getText();
            String instansi = txtInstansi.getText();

            // Validasi jika inputan kosong menggunakan JOptionPane
            if (nama.isEmpty() || instansi.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Data tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                // Menambahkan teks ke area daftar hadir
                txtAreaDaftar.append("- " + nama + " (" + instansi + ")\n");
                // Mengosongkan form kembali setelah disimpan
                txtNama.setText("");
                txtInstansi.setText("");
            }
        }
    }

    // Interface 2: MouseListener (Menangkap pergerakan MOUSE)
    @Override
    public void mouseEntered(MouseEvent e) {
        // Saat kursor masuk area tombol, ubah warna jadi hijau
        if (e.getSource() == btnSimpan) {
            btnSimpan.setBackground(Color.GREEN);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Saat kursor keluar, kembalikan warna ke default
        if (e.getSource() == btnSimpan) {
            btnSimpan.setBackground(UIManager.getColor("control"));
        }
    }

    // Method MouseListener lainnya (wajib ditulis meski dikosongkan karena aturan interface)
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}

    // 4. Main Method
    public static void main(String[] args) {
        new AplikasiBukuTamu();
    }
}