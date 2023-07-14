package tokopedia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static tokopedia.Model.cariBarang;
import static tokopedia.Model.urutkanBerdasarkanNama;

public class UrutkanGui {
    private List<Model> daftarBarang;
    private JFrame frame;
    private JTextField searchField;
    private JTextArea resultArea;

    public void run() {
        daftarBarang = new ArrayList<>();
        daftarBarang.add(new Model("010", "Baju", 50000.0, 10));
        daftarBarang.add(new Model("002", "Celana", 70000.0, 5));
        daftarBarang.add(new Model("014", "Sepatu", 150000.0, 3));
        daftarBarang.add(new Model("015", "Handphone", 1000000.0, 3));
        daftarBarang.add(new Model("017", "jam tangan", 100000.0, 3));
        daftarBarang.add(new Model("014", "kasur", 500000.0, 3));
        daftarBarang.add(new Model("023", "mobil", 75000000.0, 3));
        daftarBarang.add(new Model("023", "sepeda", 1500000.0, 3));

        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Search App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel searchLabel = new JLabel("Masukkan nama barang yang ingin dicari:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Cari");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        panel.add(searchLabel, BorderLayout.NORTH);
        panel.add(searchField, BorderLayout.CENTER);
        panel.add(searchButton, BorderLayout.EAST);
        panel.add(scrollPane, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaCari = searchField.getText();
                searchField.setText("");

                List<Model> hasilPencarian = cariBarang(daftarBarang, namaCari);

                if (hasilPencarian.isEmpty()) {
                    resultArea.setText("Barang dengan nama tersebut tidak ditemukan.");
                } else {
                    StringBuilder resultBuilder = new StringBuilder();
                    for (Model barang : hasilPencarian) {
                        resultBuilder.append("Nama Barang: ").append(barang.getNama()).append("\n");
                        resultBuilder.append("ID: ").append(barang.getId()).append("\n");
                        resultBuilder.append("Harga: Rp.").append(barang.getHarga()).append("\n");
                        resultBuilder.append("Jumlah: ").append(barang.getJumlah()).append("\n");
                        resultBuilder.append("---------------------").append("\n");
                    }
                    resultArea.setText(resultBuilder.toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        Urutkan urutkan = new Urutkan();
        urutkan.run();
    }
}
