package ru.andreisesiunin;

import java.util.Arrays;

public class Case1 {
    public static void main(String[] args) {
        int[] a = {5, 5};
        int b = 1;

        a[b] = b = 0;

        //what will print this code?
        System.out.println(b);
        System.out.println(b);
        System.out.println(Arrays.toString(a));
    }
}
