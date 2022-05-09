package com.eftomi.quadrangles.businesslogic;

import com.eftomi.quadrangles.enums.UOM;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public abstract class Quadrangle implements IQuadrangle {

    public static IQuadrangle chooseQuadrangle(int select) {
        IQuadrangle IQuadrangle = null;
        switch (select) {
            case 1:
                IQuadrangle = new Square();
                break;
            case 2:
                IQuadrangle = new Rectangle();
                break;
            case 3:
                IQuadrangle = new Parallelogram();
                break;
            case 4:
                IQuadrangle = new Rhombus();
                break;
            case 5:
                IQuadrangle = new Deltoid();
                break;
            case 0:
                System.out.println("\nI hope you enjoyed this app. :-)");
                System.exit(0);
                break;
        }
        return IQuadrangle;
    }

    public String readUOM(Scanner scanner) {
        String unitOfMeasure;
        boolean badUnitOfMeasure = true;
        do {
            System.out.print("Please enter the unit of measure from the bracket (");
            UOM[] UOMvalues = UOM.values();
            for (int i = 0; i < UOMvalues.length; i++) {
                System.out.print(UOMvalues[i].getMeasure());
                if (i < UOMvalues.length -1 ) {
                    System.out.print(", ");
                }
            }
            System.out.print("): ");
            unitOfMeasure = scanner.nextLine();
            UOM[] values = UOM.values();
            for (UOM uom : values) {
                if (uom.getMeasure().equals(unitOfMeasure)) {
                    badUnitOfMeasure = false;
                }
            }
            if (badUnitOfMeasure) {
                System.out.println("\nUnit of measure is not correct!");
            }
        }
        while (badUnitOfMeasure);
        return unitOfMeasure;
    }

    public Map<String, Double> readQuadrangleData(Scanner scanner, List<String> parameters, String UOM) {
        Map<String, Double> quadrangleData = new HashMap<>();
        double num;
        boolean negative;
        for (String parameter : parameters) {
            do {
                System.out.printf("Please enter the value of %s (%s): ", parameter, UOM);
                num = scanner.nextDouble();
                negative = num < 0;
                if (negative) {
                    System.out.printf("\nValue of %s can not be negative!", parameter);
                }
            } while (negative);
            quadrangleData.put(parameter, num);
        }
        return quadrangleData;
    }

    public void actualQuadrangle() {
        System.out.println("\nYou choose " + toString() + ".");
    }

    public double roundedResult(double rawDouble) {
        BigDecimal bigDecimal = new BigDecimal(rawDouble)
                .setScale(2, RoundingMode.CEILING);
        return bigDecimal.doubleValue();
    }

    public void printResults(double area, double perimeter, String UOM) {
        System.out.println("\nThe results of the calculation is the next:");
        System.out.println("\tThe perimeter of the " + toString() + " is " + roundedResult(perimeter) + UOM + ".");
        System.out.println("\tThe area of the " + toString() + " is " + roundedResult(area) + UOM + "^2.\n");
    }

}

