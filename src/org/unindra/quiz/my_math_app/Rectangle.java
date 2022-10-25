package org.unindra.quiz.my_math_app;

public class Rectangle {

    private final Double length;
    private final Double width;

    public Rectangle(Double length, Double width) {
        this.length = length;
        this.width = width;
    }

    public Double getSurfaceArea() {
        return width * length;
    }

    public void printProperties() {
        System.out.printf("Length=%1$,.2f\nWidth=%1$,.2f", length, width);
    }
}
