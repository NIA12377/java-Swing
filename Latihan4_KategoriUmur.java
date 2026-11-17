import javax.swing.*;

// Latihan 4: input umur lewat dialog, kategori dengan else if
public class Latihan4_KategoriUmur {
    public static void main(String[] args) {
        String teks = JOptionPane.showInputDialog("Umur?");
        if (teks == null) { return; }                       // Cancel
        try {
            int umur = Integer.parseInt(teks.trim());
            String k;
            if (umur < 0) { k = "Umur tidak valid"; }
            else if (umur < 13) { k = "Anak"; }
            else if (umur < 24) { k = "Remaja"; }
            else if (umur < 25) { k = "Dewasa"; }
            else if (umur < 35) { k = " Waktunya cari jodoh";}
            else if (umur < 60) { k = "Orang Tua"; }
            else { k = "Lansia"; }
            JOptionPane.showMessageDialog(null, k);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Harus berupa angka.");
        }
    }
}
