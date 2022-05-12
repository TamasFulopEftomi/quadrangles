package com.eftomi.quadrangles.businesslogic;

import java.util.*;

public class Rectangle extends Quadrangle {
    private Scanner scanner;
    private List<String> parameters = Arrays.asList("width", "length");
    private Map<String, Double> quadrangleData;
    private double area;
    private double perimeter;

    @Override
    public void computeWithQuadrangleData(Scanner scanner) {
        actualQuadrangle();
        quadrangleData = readQuadrangleData(scanner, parameters);
        countPerimeter();
        countArea();
        printResults(area, perimeter, scanner);
    }

    @Override
    public void countPerimeter() {
        // perimeter P = 2 * (l + W)
        perimeter = 0;
        for (Map.Entry<String, Double> entry : quadrangleData.entrySet()) {
            perimeter += entry.getValue();
        }
        perimeter *= 2;
    }

    @Override
    public void countArea() {
        // area A = w * l
        area = 1;
        for (Map.Entry<String, Double> entry : quadrangleData.entrySet()) {
            area *=entry.getValue();
        }
    }

    @Override
    public String toString() {
        return "rectangle";
    }
}
