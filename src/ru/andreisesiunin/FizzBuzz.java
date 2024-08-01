package ru.andreisesiunin;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz());
    }

    public static String fizzBuzz() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number % 5 == 0 && number % 3 == 0)
            return "FizzBuzz";
        else if (number % 5 == 0)
            return "Fizz";
        else if (number % 3 == 0)
            return "Buzz";
        else return "";

    }

}
