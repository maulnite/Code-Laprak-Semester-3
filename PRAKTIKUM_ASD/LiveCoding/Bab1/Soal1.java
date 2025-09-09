package PRAKTIKUM_ASD.LiveCoding.Bab1;

import java.util.*;

public class Soal1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        double jumlah = 0.0;
        double rata = 0.0;
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        Arrays.sort(array); // gaada larangan kan kak pake ini, hehe
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            jumlah += array[i];
        }
        rata = jumlah / n;
        System.out.printf("%.2f%n", rata);

        System.out.println(array[n - 1] + " " + array[0]);

        boolean isOdd = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
                isOdd = true;
            }
        }
        if (!isOdd) {
            System.out.print("None");
        }
        System.out.println();

        boolean isAnyPrime = false;
        for (int i = 0; i < array.length; i++) {
            boolean isPrime = true;
            if (array[i] < 2) {
                isPrime = false;
            } else {
                for (int j = 2; j <= Math.sqrt(array[i]); j++) {
                    if (array[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                isAnyPrime = true;
                System.out.print(array[i] + " ");
            }
        }
        if (!isAnyPrime)
            System.out.println("None");

        input.close();
    }
}
