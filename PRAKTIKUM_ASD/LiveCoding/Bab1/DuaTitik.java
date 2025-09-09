package PRAKTIKUM_ASD.LiveCoding.Bab1;

import java.util.*;

public class DuaTitik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        if (n <= 1) {
            System.out.println("Minimal harus ada 2 titik!");
            input.close();
            return;
        }
        double[][] array = new double[n][2];

        double jarak = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = input.nextDouble();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double jarakSekarang = Math
                        .sqrt(Math.pow(array[j][0] - array[i][0], 2) + Math.pow(array[j][1] - array[i][1], 2));
                if (jarak >= jarakSekarang) {
                    jarak = jarakSekarang;
                    System.out.println(
                            "(" + array[i][0] + "," + array[i][1] + ") dan (" + array[j][0] + "," + array[j][1] + ")");
                    System.out.println("Jarak terpendek = " + jarak);
                }
            }
        }

        input.close();
    }
}
