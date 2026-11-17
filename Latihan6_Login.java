import javax.swing.*;
import java.awt.*;

// Latihan 6: login dengan JTextField dan JPasswordField
public class Latihan6_Login extends JFrame {
    public Latihan6_Login() {
        super("Login");
        JTextField user = new JTextField(12);
        JPasswordField sandi = new JPasswordField(12);
        JButton btn = new JButton("Masuk");
        btn.addActionListener(e -> {
            String u = user.getText().trim();
            String s = new String(sandi.getPassword());
            if (u.isEmpty() || s.isEmpty()) { JOptionPane.showMessageDialog(this, "Isi user dan sandi."); }
            else if (u.equals("Nia") && s.equals("Nia_377")) { JOptionPane.showMessageDialog(this, "Login berhasil"); }
            else { JOptionPane.showMessageDialog(this, "User atau sandi salah", "Gagal", JOptionPane.ERROR_MESSAGE); }
        });
        setLayout(new GridLayout(0, 1, 3, 3));
        add(new JLabel("User:")); add(user); add(new JLabel("Sandi:")); add(sandi); add(btn);
        pack(); setLocationRelativeTo(null); setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new Latihan6_Login().setVisible(true)); }
}
