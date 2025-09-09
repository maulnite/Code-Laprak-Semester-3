package PRAKTIKUM_ASD.LiveCoding.Bab1;

import java.util.*;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int r = input.nextInt();
        int c = input.nextInt();
        int total = r * c;

        int[] array = new int[total];
        for (int i = 0; i < total; i++) {
            array[i] = input.nextInt();
        }

        int t = input.nextInt();
        while (t-- > 0) {
            int i = input.nextInt();
            int p = input.nextInt();

            int simpan = array[i];

            if (i < p) {
                System.arraycopy(array, i + 1, array, i, p - i);
            } else if (i > p) {
                System.arraycopy(array, p, array, p + 1, i - p);
            }
            array[p] = simpan;
        }

        for (int i = 0; i < total; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) % c == 0) {
                System.out.println();
            }
        }

        input.close();
    }
}