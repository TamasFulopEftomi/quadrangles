package com.eftomi.quadrangles.businesslogic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Parallelogram extends Quadrangle {
    private Scanner scanner;
    private String UOM;
    private List<String> parameters = Arrays.asList("width", "length", "height");
    private Map<String, Double> quadrangleData;
    private double area;
    private double perimeter;

    @Override
    public void computeWithQuadrangleData(Scanner scanner) {
        actualQuadrangle();
        UOM = super.readUOM(scanner);
        quadrangleData = readQuadrangleData(scanner, parameters, UOM);
        countPerimeter();
        countArea();
        printResults(area, perimeter, UOM);
    }

    @Override
    public void countPerimeter() {
        // perimeter P = 2 * (a + b)
        perimeter = 2 * (quadrangleData.get("width") + quadrangleData.get("length"));
    }

    @Override
    public void countArea() {
        // area A = b * h
        area = quadrangleData.get("length") * quadrangleData.get("height");
    }

    @Override
    public String toString() {
        return "parallelogram";
    }
}
