package tokopedia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {
    private List<Model> daftarBarang = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Data barang
        daftarBarang.add(new Model("010", "Baju", 50000.0, 10));
        daftarBarang.add(new Model("002", "Celana", 70000.0, 5));
        daftarBarang.add(new Model("014", "Sepatu", 150000.0, 3));
        daftarBarang.add(new Model("015", "Handphone", 1000000.0, 3));
        daftarBarang.add(new Model("017", "Jam Tangan", 100000.0, 3));
        daftarBarang.add(new Model("014", "Kasur", 500000.0, 3));
        daftarBarang.add(new Model("023", "Mobil", 75000000.0, 3));
        daftarBarang.add(new Model("023", "Sepeda", 1500000.0, 3));

        // Membuat elemen-elemen GUI
        Label titleLabel = new Label("Sistem Inventaris Toko");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        ListView<String> barangListView = new ListView<>();
        Button urutkanButton = new Button("Urutkan Berdasarkan Nama");
        Button cariButton = new Button("Cari Barang");
        Label hasilLabel = new Label();

        // Mengatur tampilan ListView dengan daftar barang
        for (Model barang : daftarBarang) {
            barangListView.getItems().add(barang.getNama());
        }

        // Mengatur aksi tombol urutkan
        urutkanButton.setOnAction(event -> {
            urutkanBerdasarkanNama(daftarBarang);
            barangListView.getItems().clear();
            for (Model barang : daftarBarang) {
                barangListView.getItems().add(barang.getNama());
            }
        });

        // Mengatur aksi tombol cari
        cariButton.setOnAction(event -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Cari Barang");
            dialog.setHeaderText("Masukkan Nama Barang yang Dicari");
            dialog.setContentText("Nama Barang:");

            String namaCari = dialog.showAndWait().orElse("");
            if (!namaCari.isEmpty()) {
                List<Model> hasilPencarian = cariBarang(daftarBarang, namaCari);
                if (hasilPencarian.isEmpty()) {
                    hasilLabel.setText("Barang dengan nama tersebut tidak ditemukan.");
                } else {
                    StringBuilder hasilText = new StringBuilder("Hasil Pencarian:\n");
                    for (Model barang : hasilPencarian) {
                        hasilText.append("Nama Barang: ").append(barang.getNama()).append("\n");
                        hasilText.append("ID: ").append(barang.getId()).append("\n");
                        hasilText.append("Harga: Rp.").append(barang.getHarga()).append("\n");
                        hasilText.append("Jumlah: ").append(barang.getJumlah()).append("\n");
                        hasilText.append("---------------------\n");
                    }
                    hasilLabel.setText(hasilText.toString());
                }
            } else {
                hasilLabel.setText("");
            }
        });

        // Membuat tampilan VBox dan mengatur penempatan elemen-elemen
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, barangListView, urutkanButton, cariButton, hasilLabel);

        // Membuat scene dan menampilkan jendela aplikasi
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Aplikasi Inventaris Toko");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void urutkanBerdasarkanNama(List<Model> daftarBarang) {
        // Kode sorting sama seperti sebelumnya
        // ...
    }

    private List<Model> cariBarang(List<Model> daftarBarang, String namaBarang) {
        List<Model> hasilPencarian = new ArrayList<>();

        for (Model barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                hasilPencarian.add(barang);
            }
        }

        return hasilPencarian;
    }
}
