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

    public Map<String, Double> readQuadrangleData(Scanner scanner, List<String> parameters) {
        Map<String, Double> quadrangleData = new HashMap<>();
        String unitOfMeasure;
        boolean badUnitOfMeasure = true;
        String dataInput;
        String dataArray[];
        double num = 0;
        boolean negative;
        for (String parameter : parameters) {
            do {
                do {
                    System.out.printf("\nPlease enter the value of the %s and its UOM from the bracket (", parameter);
                    UOM[] UOMvalues = UOM.values();
                    for (int i = 0; i < UOMvalues.length; i++) {
                        System.out.print(UOMvalues[i].getMeasure());
                        if (i < UOMvalues.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.print("). Please enter one space between the two data: ");
                    dataInput = scanner.nextLine();
                    dataArray = dataInput.split(" ");
                    if (dataArray.length != 2) {
                        System.out.println("Please enter the data in this form: 88 cm");
                    }
                } while (dataArray.length != 2);
                num = Double.parseDouble(dataArray[0]);
                unitOfMeasure = dataArray[1];
                negative = num < 0;
                badUnitOfMeasure = isBadUnitOfMeasure(unitOfMeasure, badUnitOfMeasure);
                if (badUnitOfMeasure) {
                    System.out.println("\nUnit of measure is not correct!");
                }
                if (negative) {
                    System.out.printf("\nValue of %s can not be negative!", parameter);
                }
            } while (negative || badUnitOfMeasure);

            UOM[] values = UOM.values();
            for (UOM uom : values) {
                if (uom.getMeasure().equals(unitOfMeasure)) {
                    num *= uom.getMultiplierToMm();
                }
            }
            quadrangleData.put(parameter, num);
        }

        return quadrangleData;
    }

    public void actualQuadrangle() {
        System.out.println("\n***** You choose " + toString() + ". *****");
    }

    public double roundedResult(double rawDouble) {
        BigDecimal bigDecimal = new BigDecimal(rawDouble)
                .setScale(2, RoundingMode.CEILING);
        return bigDecimal.doubleValue();
    }

    public void printResults(double area, double perimeter, Scanner scanner) {
        boolean badUnitOfMeasure = true;
        String unitOfMeasure;
        do {
            System.out.print("\nPlease enter the UOM of the result from the bracket (");
            UOM[] UOMvalues = UOM.values();
            for (int i = 0; i < UOMvalues.length; i++) {
                System.out.print(UOMvalues[i].getMeasure());
                if (i < UOMvalues.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("): ");
            unitOfMeasure = scanner.nextLine();
            badUnitOfMeasure = isBadUnitOfMeasure(unitOfMeasure, badUnitOfMeasure);
            if (badUnitOfMeasure) {
                System.out.println("\nUnit of measure is not correct!");
            }
        } while (badUnitOfMeasure);

        int divider = getDivider(unitOfMeasure);
        double perimeterInUOM = perimeter / divider;
        double areaInUOM = area / Math.pow(divider, 2);

        System.out.println("\nThe results of the calculation is the next:");
        System.out.println("\tThe perimeter of the " + toString() + " is " + roundedResult(perimeterInUOM) + unitOfMeasure + ".");
        System.out.println("\tThe area of the " + toString() + " is " + roundedResult(areaInUOM) + unitOfMeasure + "^2.\n");
    }

    private boolean isBadUnitOfMeasure(String unitOfMeasure, boolean badUnitOfMeasure) {
        UOM[] values = UOM.values();
        for (UOM uom : values) {
            if (uom.getMeasure().equals(unitOfMeasure)) {
                badUnitOfMeasure = false;
            }
        }
        return badUnitOfMeasure;
    }

    private int getDivider(String unitOfMeasure) {
        int divider = 0;
        switch (unitOfMeasure) {
            case "mm":
                divider = 1;
                break;
            case "cm":
                divider = 10;
                break;
            case "dm":
                divider = 100;
                break;
            case "m":
                divider = 1_000;
                break;
            case "km":
                divider = 1_000_000;
                break;
        }
        return divider;
    }

}

