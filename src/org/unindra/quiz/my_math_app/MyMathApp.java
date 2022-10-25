package org.unindra.quiz.my_math_app;

import java.util.Scanner;

public class MyMathApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input Length: ");
        double length = scanner.nextDouble();
        System.out.print("Input Width: ");
        double width = scanner.nextDouble();

        Rectangle rectangle = new Rectangle(length, width);
        Double surfaceArea = rectangle.getSurfaceArea();
        System.out.printf("Result: %1$,.2f\n", surfaceArea);

        rectangle.printProperties();

    }
}
