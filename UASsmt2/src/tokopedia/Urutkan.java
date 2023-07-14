package tokopedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tokopedia.Model.cariBarang;
import static tokopedia.Model.urutkanBerdasarkanNama;

public class Urutkan {
    public void run() {
        List<Model> daftarBarang = new ArrayList<>();
        daftarBarang.add(new Model("010", "Baju", 50000.0, 10));
        daftarBarang.add(new Model("002", "Celana", 70000.0, 5));
        daftarBarang.add(new Model("014", "Sepatu", 150000.0, 3));
        daftarBarang.add(new Model("015", "Handphone", 1000000.0, 3));
        daftarBarang.add(new Model("017", "jam tangan", 100000.0, 3));
        daftarBarang.add(new Model("014", "kasur", 500000.0, 3));
        daftarBarang.add(new Model("023", "mobil", 75000000.0, 3));
        daftarBarang.add(new Model("023", "sepeda", 1500000.0, 3));
        System.out.println("\nDaftar Barang Sebelum diurutkan");
        System.out.println("===============================");
        for (Model barang : daftarBarang) {
            System.out.println(barang.getNama());
        }
        urutkanBerdasarkanNama(daftarBarang);
        System.out.println("Daftar Barang setelah diurutkan:");
        System.out.println("===============================");
        for (Model barang : daftarBarang) {
            System.out.println(barang.getNama());
        }
        System.out.println("===============================");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan nama barang yang ingin dicari: ");
            String namaCari = scanner.nextLine();
            System.out.println("===============================");
            List<Model> hasilPencarian = cariBarang(daftarBarang, namaCari);
            if (hasilPencarian.isEmpty()) {
                System.out.println("Barang dengan nama tersebut tidak ditemukan.");
                System.out.println("===============================");
            } else {
                System.out.println("Hasil Pencarian:");
                for (Model barang : hasilPencarian) {
                    System.out.println("Nama Barang: " + barang.getNama());
                    System.out.println("ID: " + barang.getId());
                    System.out.println("Harga: Rp." + barang.getHarga());
                    System.out.println("Jumlah: " + barang.getJumlah());
                    System.out.println("---------------------");
                }
            }
            String pilihan;
            while (true) {
                System.out.print("Anda ingin mencari barang lagi? (y/n): ");
                pilihan = scanner.nextLine();
                System.out.println("===============================");
                if (pilihan.equalsIgnoreCase("y") || pilihan.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Masukan tidak valid. Mohon masukkan 'y' atau 'n'.");
                    System.out.println("===============================");
                }
            }
            if (pilihan.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Urutkan urutkan = new Urutkan();
        urutkan.run();
    }
}
