package com.eftomi.quadrangles.businesslogic;

import com.eftomi.quadrangles.enums.UOM;

import java.util.Scanner;

public abstract class Quadrangle implements IQuadrangle {

    public static IQuadrangle chooseQuadrangle(int select) {
        IQuadrangle IQuadrangle = null;
        switch (select) {
            case 1:
                IQuadrangle = new Rectangle();
                break;
            case 2:
                System.out.println("Hajrá!");
                break;
            case 3:
                System.out.println("Hajrá!");
                break;
            case 4:
                System.out.println("Hajrá!");
                break;
            case 5:
                System.out.println("Hajrá!");
                break;
            case 0:
                System.out.println("Hajrá!");
                break;
        }
        return IQuadrangle;
    }

    public String readUOM(Scanner scanner) {
        String unitOfMeasure;
        boolean badUnitOfMeasure = true;
        do {
            System.out.print("You choose Rectangle. Please enter the unit of measure: ");
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

}

