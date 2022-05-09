package com.eftomi.quadrangles.processlogic;

import java.util.Scanner;

public class UserInputReader {
    private final Scanner scanner;

    public UserInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readUserInput() {
        boolean bad;
        int select;
        do {
            System.out.print("Please select which quadrangle you want to perform the operation on:" +
                    "\n\t1. Square\n\t2. Rectangle\n\t3. Parallelogram\n\t4. Rhombus\n\t5. Deltoid\n\n\t0. Exit\nPlease enter the number of the selected function: ");
            select = scanner.nextInt();
            scanner.nextLine();
            bad = select < 0 || select > 5;
            if (bad) {
                System.out.println("\nPlease enter a correct number from the list!");
            }
        } while (bad);
        return select;
    }

}
