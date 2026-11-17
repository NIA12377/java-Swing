import javax.swing.*;
import java.awt.*;

// Latihan 2: radio jenis kelamin + salam
public class Latihan2_Gender extends JFrame {
    public Latihan2_Gender() {
        super("Salam Berdasarkan Nama, Jenis Kelamin & Umur");

        // Komponen
        JTextField txtNama = new JTextField(12);
        JTextField txtUmur = new JTextField(12);

        JRadioButton laki = new JRadioButton("Laki‑laki");
        JRadioButton perempuan = new JRadioButton("Perempuan");
        ButtonGroup groupGender = new ButtonGroup();
        groupGender.add(laki);
        groupGender.add(perempuan);

        JButton btnSapa = new JButton("Sapa");
        JLabel hasil = new JLabel(" ");

        btnSapa.addActionListener(e -> {
            String nama = txtNama.getText().trim();
            String strUmur = txtUmur.getText().trim();

            if (nama.isEmpty()) {
                hasil.setText("⚠️ Nama wajib diisi!");
                return;
            }
            int umur;
            try {
                umur = Integer.parseInt(strUmur);
            } catch (NumberFormatException ex) {
                hasil.setText("⚠️ Umur harus berupa angka!");
                return;
            }

            String kategoriUmur;
            if (umur >= 1 && umur <= 10) {
                kategoriUmur = "Anak";
            } else if (umur >= 11 && umur <= 30) {
                kategoriUmur = "Remaja";
            } else if (umur > 31 && umur <= 100) {
                kategoriUmur = (laki.isSelected()) ? "Bapak" : "Ibu";
            } else {
                kategoriUmur = "dewasa";
            }

            String sapaan;
            if (laki.isSelected()) {
                sapaan =  kategoriUmur + " " + "Halo, " + nama;
            } else if (perempuan.isSelected()) {
                sapaan = kategoriUmur + " " + "Halo, "+ nama;
            } else {
                hasil.setText("⚠️ Pilih jenis kelamin dulu!");
                return;
            }

            hasil.setText(sapaan);
        });

        // Layout
        setLayout(new GridLayout(7, 1, 5, 5));
        add(new JLabel("Nama:"));
        add(txtNama);
        add(new JLabel("Umur:"));
        add(txtUmur);
        add(laki);
        add(perempuan);
        add(btnSapa);
        add(hasil);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Latihan2_Gender().setVisible(true);
        });
    }
}
