import javax.swing.*;
import java.awt.*;

public class Tugas3_NilaiAkhirUI extends JFrame {
    JTextField txtTugas, txtUTS, txtUAS;
    JCheckBox chkBonus;
    JLabel lblHasil;

    public Tugas3_NilaiAkhirUI() {
        super("Hitung Nilai Akhir");
        setSize(320, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtTugas = new JTextField(8);
        txtUTS = new JTextField(8);
        txtUAS = new JTextField(8);
        chkBonus = new JCheckBox("Bonus +3 (keaktifan)");
        JButton btnHitung = new JButton("Hitung Nilai");
        lblHasil = new JLabel("Hasil: -", SwingConstants.CENTER);
        lblHasil.setFont(new Font("Arial", Font.BOLD, 13));

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Nilai Tugas (0‑100):"), gbc);
        gbc.gridx = 1;
        add(txtTugas, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Nilai UTS (0‑100):"), gbc);
        gbc.gridx = 1;
        add(txtUTS, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Nilai UAS (0‑100):"), gbc);
        gbc.gridx = 1;
        add(txtUAS, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(chkBonus, gbc);

        gbc.gridy = 4;
        add(btnHitung, gbc);

        gbc.gridy = 5;
        add(lblHasil, gbc);

        btnHitung.addActionListener(e -> {
            double nt, nu, na;
            try {
                nt = Double.parseDouble(txtTugas.getText().trim());
                nu = Double.parseDouble(txtUTS.getText().trim());
                na = Double.parseDouble(txtUAS.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Semua nilai harus berupa angka!",
                        "Kesalahan Input",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nt < 0 || nt > 100 || nu < 0 || nu > 100 || na < 0 || na > 100) {
                JOptionPane.showMessageDialog(this,
                        "Nilai harus berada di rentang 0‑100!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            double akhir = nt * 0.30 + nu * 0.30 + na * 0.40;

            if (chkBonus.isSelected()) {
                akhir = Math.min(100, akhir + 3);
            }

            String grade;
            if (akhir >= 85) grade = "A";
            else if (akhir >= 70) grade = "B";
            else if (akhir >= 55) grade = "C";
            else grade = "D";

            String status = (akhir >= 55) ? "✅ Lulus" : "❌ Tidak Lulus";

            lblHasil.setText(String.format("<html>Nilai: %.1f<br>Grade: %s | %s</html>",
                    akhir, grade, status));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Tugas3_NilaiAkhirUI().setVisible(true);
        });
    }
}
