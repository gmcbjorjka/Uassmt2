package tokopedia;

import java.util.ArrayList;
import java.util.List;

public class Model {
        private String id;
        private String nama;
        private double harga;
        private int jumlah;

        public Model(String id, String nama, double harga, int jumlah) {
            this.id = id;
            this.nama = nama;
            this.harga = harga;
            this.jumlah = jumlah;
        }

        // Metode getter dan setter

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public double getHarga() {
            return harga;
        }

        public void setHarga(double harga) {
            this.harga = harga;
        }

        public int getJumlah() {
            return jumlah;
        }

        public void setJumlah(int jumlah) {
            this.jumlah = jumlah;
        }
        public static void urutkanBerdasarkanNama(List<Model> daftarBarang) {
            int n = daftarBarang.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    String namaBarang1 = daftarBarang.get(j).getNama();
                    String namaBarang2 = daftarBarang.get(j + 1).getNama();
                    if (namaBarang1.compareToIgnoreCase(namaBarang2) > 0) {
                        Model temp = daftarBarang.get(j);
                        daftarBarang.set(j, daftarBarang.get(j + 1));
                        daftarBarang.set(j + 1, temp);
                    }
                }
            }
        }

        public static List<Model> cariBarang(List<Model> daftarBarang, String namaBarang) {
            List<Model> hasilPencarian = new ArrayList<>();

            for (Model barang : daftarBarang) {
                if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                    hasilPencarian.add(barang);
                }
            }

            return hasilPencarian;
        }
}



