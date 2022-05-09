package com.eftomi.quadrangles.businesslogic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Square extends Quadrangle {
    private Scanner scanner;
    private String UOM;
    private List<String> parameters = Arrays.asList("side");
    private Map<String, Double> quadrangleData;
    private double area;
    private double perimeter;

    @Override
    public void computeWithQuadrangleData(Scanner scanner) {
        actualQuadrangle();
        UOM = readUOM(scanner);
        quadrangleData = readQuadrangleData(scanner, parameters, UOM);
        countPerimeter();
        countArea();
        printResults(area, perimeter, UOM);
    }

    @Override
    public void countPerimeter() {
        // perimeter P = 4 * a
        perimeter = 4 * quadrangleData.get("side");
    }

    @Override
    public void countArea() {
        // area A = a^2
        area = quadrangleData.get("side") * quadrangleData.get("side");
    }

    @Override
    public String toString() {
        return "square";
    }

}
