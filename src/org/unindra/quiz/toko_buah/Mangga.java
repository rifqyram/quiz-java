package org.unindra.quiz.toko_buah;

import org.unindra.quiz.Utils;

import java.util.*;

public class Mangga {

    private final List<Map<String, Object>> products;
    private final List<Map<String, Object>> carts;

    public Mangga() {
        products = new ArrayList<>();
        carts = new ArrayList<>();
        initProduct();
    }

    private void initProduct() {
        Map<String, Object> product1 = new HashMap<>();
        product1.put("id", "1");
        product1.put("name", "Mangga Harum Manis");
        product1.put("price", 15000);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("id", "2");
        product2.put("name", "Mangga Indramayu");
        product2.put("price", 20000);

        Map<String, Object> product3 = new HashMap<>();
        product3.put("id", "3");
        product3.put("name", "Mangga Simanalagi");
        product3.put("price", 30000);

        products.addAll(Arrays.asList(product1, product2, product3));
    }

    public void showProduct() {
        System.out.println("\t Jenis Buah Jeruk");
        System.out.println(Utils.repeat("-", 40));
        for (Map<String, Object> product : products) {
            System.out.printf("%-5s %-20s %-10s\n", String.format("%s.", product.get("id")), product.get("name"), Utils.convertRupiah((Integer) product.get("price")));
        }
        System.out.printf("%-5s %-20s\n", "9.", "Check Out");
    }

    public void buyProductById(String id) {
        Integer qty = Integer.parseInt(Utils.inputUtils("Banyaknya buah yang dibeli"));

        for (Map<String, Object> product : products) {
            if (product.get("id").equals(id)) {
                product.put("qty", qty);
                carts.add(product);
                break;
            }
        }
    }

    public void checkOut() {
        System.out.println(Utils.repeat("-", 40));
        System.out.println("----- Struk Pembelian - Yang dibeli -----");
        System.out.printf("%-5s %-20s %s\n", "No", "Buah", "Banyaknya Buah");
        int totalBills = 0;
        for (int i = 0, cartsSize = carts.size(); i < cartsSize; i++) {
            Map<String, Object> cart = carts.get(i);
            System.out.printf("%-5s %-20s %s\n", String.format("%d.", (i + 1)), cart.get("name"), cart.get("qty"));
            totalBills += (Integer) cart.get("price") * (Integer) cart.get("qty");
        }
        System.out.println();
        System.out.println("Total yang harus dibayar: " + Utils.convertRupiah(totalBills));
    }

}
