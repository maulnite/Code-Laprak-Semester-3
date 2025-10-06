package UTP.Latihan;

import java.util.*;

public class WadahAir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] tinggi = new int[n];

        for (int i = 0; i < n; i++) {
            tinggi[i] = input.nextInt();
        }

        int kiri = 0;
        int kanan = n - 1;
        int max = 0;
        int luas = 0;
        while (kiri != kanan) {
            if (tinggi[kiri] < tinggi[kanan]) {
                luas = tinggi[kiri] * (kanan - kiri);
                if (luas > max) {
                    max = luas;
                }
                kiri++;
            } else {
                luas = tinggi[kanan] * (kanan - kiri);
                if (luas > max) {
                    max = luas;
                }
                kanan--;
            }
        }

        System.out.println(max);

        input.close();
    }
}
