import javax.swing.*;
import java.awt.*;

public class AppSederhana {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi Kalkulator Sederhana");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        
        JTextField angka1 = new JTextField(5);
        angka1.setName("inputAngka1");
        
        JTextField angka2 = new JTextField(5);
        angka2.setName("inputAngka2");
        
        JComboBox<String> operasi = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        operasi.setName("comboOperasi");
        
        JButton tombol = new JButton("Hitung");
        tombol.setName("btnHitung");
        
        JLabel hasil = new JLabel("Hasil: ");
        hasil.setName("lblHasil");

        tombol.addActionListener(e -> {
            try {
                double a = Double.parseDouble(angka1.getText());
                double b = Double.parseDouble(angka2.getText());
                String op = (String) operasi.getSelectedItem();
                double res = 0;
                
                switch(op) {
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": res = b != 0 ? a / b : Double.NaN; break;
                }
                
                // Tampilkan bulat jika hasilnya bilangan bulat
                if (res == (long) res) {
                    hasil.setText("Hasil: " + (long) res);
                } else {
                    hasil.setText("Hasil: " + res);
                }
                
            } catch(NumberFormatException ex) {
                hasil.setText("Hasil: Input tidak valid!");
            }
        });

        panel.add(new JLabel("Angka 1:"));
        panel.add(angka1);
        panel.add(operasi);
        panel.add(new JLabel("Angka 2:"));
        panel.add(angka2);
        panel.add(tombol);
        panel.add(hasil);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}