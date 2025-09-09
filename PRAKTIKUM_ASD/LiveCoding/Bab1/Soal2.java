import java.util.*;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[] array = new int[m * n];

        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int l = input.nextInt();
            int p = input.nextInt();
            int temp = array[l];
            if (l < p) {
                for (int j = l; j < p; j++) {
                    array[j] = array[j + 1];
                }
            } else if (l > p) {
                for (int j = l; j > p; j--) {
                    array[j] = array[j - 1];
                }
            }
            array[p] = temp;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i * n + j] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}
