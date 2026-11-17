import javax.swing.*;

// Latihan 3: tombol Keluar dengan konfirmasi
public class Latihan3_KonfirmasiKeluar extends JFrame {
    public Latihan3_KonfirmasiKeluar() {
        super("Keluar");
        JButton btn = new JButton("Putus");
        btn.addActionListener(e -> {
            int j = JOptionPane.showConfirmDialog(this, "Yakin ingin Putus, padahal lagi sayang - sayang nya", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (j == JOptionPane.YES_OPTION) { System.exit(0); }
        });
        add(btn);
        setSize(220, 100); setLocationRelativeTo(null); setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new Latihan3_KonfirmasiKeluar().setVisible(true)); }
}
