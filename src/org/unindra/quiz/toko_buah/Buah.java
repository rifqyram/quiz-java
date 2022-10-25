package org.unindra.quiz.toko_buah;

import org.unindra.quiz.Utils;

public class Buah {
    private String nama;
    private String nomorTelpon;

    public Buah(String nama, String nomorTelpon) {
        this.nama = nama;
        this.nomorTelpon = nomorTelpon;
    }

    public static void main(String[] args) {
        System.out.println("====== Selamat Datang di Toko Buah Hotaru =====");
        System.out.println(Utils.repeat("-", 40));

        String nama = Utils.inputUtils("Masukkan Nama Pelanggan");
        String telp = Utils.inputUtils("Masukkan No Telp");

        Buah buah = new Buah(nama, telp);
        buah.showMenu();

        System.out.println(Utils.repeat("-", 40));
        System.out.printf("Terima Kasih Telah Berbelanja %s\n", nama);
        System.out.println("\t Jangan Lupa Datang Kembali");
    }

    private void showMenu() {
        Jeruk jeruk = new Jeruk();
        Mangga mangga = new Mangga();

        System.out.println("Jenis buah yang ingin dibeli");
        System.out.println("1. Jeruk");
        System.out.println("2. Mangga");

        switch (Utils.inputUtils("Pilihan")) {
            case "1":
                while (true) {
                    jeruk.showProduct();
                    String menuProductOpt = Utils.inputUtils("Pilihan Anda");
                    if (menuProductOpt.equals("9")) {
                        jeruk.checkOut();
                        break;
                    } else {
                        jeruk.buyProductById(menuProductOpt);
                    }
                }
                break;
            case "2":
                while (true) {
                    mangga.showProduct();
                    String menuProductOpt = Utils.inputUtils("Pilihan Anda");
                    if (menuProductOpt.equals("9")) {
                        mangga.checkOut();
                        break;
                    } else {
                        mangga.buyProductById(menuProductOpt);
                    }
                }
                break;
            default:
                showMenu();
                break;
        }
    }

}
