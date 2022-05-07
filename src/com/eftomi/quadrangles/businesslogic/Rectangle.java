package com.eftomi.quadrangles.businesslogic;

import java.util.Scanner;

// perimeter P = 2 * (l + W)
// area A = w * l
public class Rectangle extends Quadrangle {
    private Scanner scanner;

    @Override
    public void readQuadrangleData(Scanner scanner) {
        System.out.println(this.readUOM(scanner));
        int a;
        boolean negative;
        do {
            System.out.print("You choose Square. Please enter the length of the side: ");
            a = scanner.nextInt();
            negative = a < 0;
            if (negative) {
                System.out.println("\nLength of the side is not be negative!");
            }
        } while (negative);
    }

}
