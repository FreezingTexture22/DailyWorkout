package ru.andreisesiunin;

import java.util.Scanner;

public class Console {
    public static double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                return value;
            }

            System.out.println("Enter a value between " + min + " and " + max);
        }
    }
}
