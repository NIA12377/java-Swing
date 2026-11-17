import javax.swing.*;
import java.awt.*;

// Tugas 2: konversi suhu, radio memilih tujuan, switch pada getActionCommand()
public class Tugas2_SuhuRadio extends JFrame {
    public Tugas2_SuhuRadio() {
        super("Konversi Suhu");
        JTextField txt = new JTextField(8);
        ButtonGroup g = new ButtonGroup();
        JRadioButton f = new JRadioButton("Fahrenheit", true), k = new JRadioButton("Kelvin"), r = new JRadioButton("Reamur");
        f.setActionCommand("F"); k.setActionCommand("K"); r.setActionCommand("R");
        g.add(f); g.add(k); g.add(r);
        JButton btn = new JButton("Konversi");
        JLabel hasil = new JLabel("Hasil: -");
        btn.addActionListener(e -> {
            double c;
            try { c = Double.parseDouble(txt.getText().trim()); }
            catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Isi suhu dengan angka."); return; }
            switch (g.getSelection().getActionCommand()) {
                case "F": hasil.setText(String.format("Hasil: %.2f F", c * 9 / 5 + 32)); break;
                case "K": hasil.setText(String.format("Hasil: %.2f K", c + 273.15)); break;
                default: hasil.setText(String.format("Hasil: %.2f R", c * 4 / 5));
            }
        });
        setLayout(new GridLayout(0, 1, 3, 3));
        add(new JLabel("isi Suhu (Celcius):")); add(txt); add(f); add(k); add(r); add(btn); add(hasil);
        pack(); setLocationRelativeTo(null); setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new Tugas2_SuhuRadio().setVisible(true)); }
}
