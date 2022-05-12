package com.eftomi.quadrangles.businesslogic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Rhombus extends Quadrangle {
    private Scanner scanner;
    private List<String> parameters = Arrays.asList("side", "short diagonal", "long diagonal");
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
        // perimeter P = 4 * a
        perimeter = 4 * quadrangleData.get("side");
    }

    @Override
    public void countArea() {
        // area A = (p * q) / 2
        area = (quadrangleData.get("short diagonal") * quadrangleData.get("long diagonal")) / 2;
    }

    @Override
    public String toString() {
        return "rhombus";
    }

}
