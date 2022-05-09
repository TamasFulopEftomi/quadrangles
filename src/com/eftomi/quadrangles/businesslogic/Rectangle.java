package com.eftomi.quadrangles.businesslogic;

import java.util.*;

// perimeter P = 2 * (l + W)
// area A = w * l
public class Rectangle extends Quadrangle {
    private Scanner scanner;
    private String UOM;
    private List<String> parameters = Arrays.asList("width", "length");

    @Override
    public void computeWithQuadranleData(Scanner scanner) {
        System.out.println("You choose " + toString() +".");
        UOM = super.readUOM(scanner);
        Map<String, Double> quadrangleData = readQuadrangleData(scanner, parameters, UOM);
        for (Map.Entry<String, Double> entry : quadrangleData.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "rectangle";
    }
}
