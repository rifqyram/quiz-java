package org.unindra.quiz;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class Utils {

    public static String repeat(String character, int n) {
        return new String(new char[n]).replace("\0", character);
    }

    public static <T> Integer inputUtilsInt(String info, Function<T, Boolean> validation) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("%s : ", info);
            try {
                Integer i = Integer.parseInt(scanner.nextLine());
                if (!validation.apply((T) i)) continue;
                return i;
            } catch (Exception ignored) {
            }
        }
    }

    public static Integer inputUtilsInt(String info) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("%s : ", info);
            try {
                int i = Integer.parseInt(scanner.nextLine());
                if (i == 0) continue;
                return i;
            } catch (Exception ignored) {
            }
        }
    }

    public static <T> String inputUtils(String info, Function<T, Boolean> validation) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("%s : ", info);
            String input = scanner.nextLine();
            if (!validation.apply((T) input)) continue;
            return input;
        }
    }

    public static String inputUtils(String info) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("%-10s : ", info);
            String input = scanner.nextLine();
            if (input.isEmpty()) continue;
            return input;
        }
    }

    public static String convertRupiah(int intPrice) {
        Locale localId = new Locale("in", "ID");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localId);
        return formatter.format(intPrice);
    }

}
