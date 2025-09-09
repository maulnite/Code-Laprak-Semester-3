package PRAKTIKUM_ASD.LiveCoding.Bab1;

import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        int target = input.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] + array[j] == target)
                    System.out.println("[" + i + "," + j + "]");
            }
        }

        input.close();
    }
}
