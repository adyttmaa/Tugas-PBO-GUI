import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class PengingatMahasiswa extends JFrame implements ActionListener, MouseListener {

    private JTextField txtTugas;
    private JComboBox<String> cbKategori;
    private JComboBox<String> cbPrioritas;
    private JButton btnTambah, btnHapus;
    
    private DefaultListModel<String> modelTugas; 
    private JList<String> listTugas;

    public PengingatMahasiswa() {
        setTitle("LifeLog: Campus"); 
        setSize(600, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout(15, 15));

        Font fontLabel = new Font("Segoe UI", Font.BOLD, 13);
        Font fontInput = new Font("Segoe UI", Font.PLAIN, 14);

        JPanel panelInput = new JPanel(new GridLayout(5, 2, 10, 15));
        panelInput.setBackground(Color.WHITE); 
        panelInput.setBorder(BorderFactory.createEmptyBorder(20, 25, 10, 25));

        JLabel lblTugas = new JLabel("Hal yang perlu diurus:");
        lblTugas.setFont(fontLabel);
        panelInput.add(lblTugas);
        
        txtTugas = new JTextField();
        txtTugas.setFont(fontInput);
        panelInput.add(txtTugas);

        JLabel lblKategori = new JLabel("Kategori:");
        lblKategori.setFont(fontLabel);
        panelInput.add(lblKategori);
        
        String[] pilihanKategori = {"Akademik & Tugas", "Tagihan & Kos", "Kebutuhan Harian", "Organisasi"};
        cbKategori = new JComboBox<>(pilihanKategori);
        cbKategori.setFont(fontInput);
        cbKategori.setBackground(Color.WHITE);
        panelInput.add(cbKategori);

        JLabel lblPrioritas = new JLabel("Tingkat Prioritas:");
        lblPrioritas.setFont(fontLabel);
        panelInput.add(lblPrioritas);
        
        String[] pilihanPrioritas = {"Tinggi", "Sedang", "Rendah"};
        cbPrioritas = new JComboBox<>(pilihanPrioritas);
        cbPrioritas.setFont(fontInput);
        cbPrioritas.setBackground(Color.WHITE);
        panelInput.add(cbPrioritas);

        panelInput.add(new JLabel("")); 
        btnTambah = new JButton("Tambah Pengingat");
        btnTambah.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnTambah.setBackground(new Color(45, 45, 45));
        btnTambah.setForeground(Color.WHITE);
        btnTambah.setContentAreaFilled(false);
        btnTambah.setOpaque(true);
        btnTambah.setFocusPainted(false); 
        btnTambah.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        btnTambah.addActionListener(this); 
        btnTambah.addMouseListener(this);  
        panelInput.add(btnTambah);

        panelInput.add(new JLabel("")); 
        btnHapus = new JButton("Hapus Tugas Terpilih [X]");
        btnHapus.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnHapus.setBackground(new Color(217, 83, 79));
        btnHapus.setForeground(Color.WHITE);
        btnHapus.setContentAreaFilled(false);
        btnHapus.setOpaque(true);
        btnHapus.setFocusPainted(false); 
        btnHapus.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        btnHapus.addActionListener(this); 
        btnHapus.addMouseListener(this);  
        panelInput.add(btnHapus);

        modelTugas = new DefaultListModel<>(); 
        listTugas = new JList<>(modelTugas);   
        listTugas.setFont(new Font("Consolas", Font.PLAIN, 14)); 
        listTugas.setBackground(new Color(245, 247, 250)); 
        listTugas.setSelectionBackground(new Color(210, 215, 222));
        listTugas.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(listTugas);
        TitledBorder borderDaftar = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), "Daftar Pengingat Saya (Klik tugas untuk memilih):"
        );
        borderDaftar.setTitleFont(fontLabel);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(0, 25, 20, 25), 
            borderDaftar 
        ));
        scrollPane.getViewport().setBackground(Color.WHITE);

        getContentPane().add(panelInput, BorderLayout.NORTH); 
        getContentPane().add(scrollPane, BorderLayout.CENTER); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTambah) {
            String tugas = txtTugas.getText().trim();
            String kategori = cbKategori.getSelectedItem().toString();
            String prioritas = cbPrioritas.getSelectedItem().toString();

            if (tugas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Hal yang perlu diurus tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                String formatTeks = ">> " + "[" + prioritas + "] " + tugas + " (" + kategori + ")";
                modelTugas.addElement(formatTeks); 
                txtTugas.setText(""); 
            }
        } else if (e.getSource() == btnHapus) {
            int indexTerpilih = listTugas.getSelectedIndex();
            
            if (indexTerpilih == -1) {
                JOptionPane.showMessageDialog(this, "Pilih tugas yang ingin dihapus terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                int konfirmasi = JOptionPane.showConfirmDialog(this, 
                    "Apakah Anda yakin ingin menghapus tugas ini?", 
                    "Konfirmasi Hapus", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
                
                if (konfirmasi == JOptionPane.YES_OPTION) {
                    modelTugas.remove(indexTerpilih); 
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == btnTambah) {
            btnTambah.setBackground(new Color(75, 75, 75));
        } else if (e.getSource() == btnHapus) {
            btnHapus.setBackground(new Color(231, 76, 60));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == btnTambah) {
            btnTambah.setBackground(new Color(45, 45, 45)); 
        } else if (e.getSource() == btnHapus) {
            btnHapus.setBackground(new Color(217, 83, 79)); 
        }
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new PengingatMahasiswa().setVisible(true);
        });
    }
}