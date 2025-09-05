package PRAKTIKUM_ASD;

public class Array {
    public static void main(String[] args) {
        int[] angka = { 30, 87, 90, 3, 1, 50, 23, 4, 25, 23, 40, 35, 47, 2, 33};

        // Mengakses elemen array
        System.out.println("Elemen pertama: " + angka[0]);
        System.out.println("Elemen kedua: " + angka[1]);

        // Menampilkan semua elemen array
        System.out.println("\nSemua elemen dalam array:");
        for (int i = 0; i < angka.length; i++) {
            System.out.println("Elemen ke-" + (i + 1) + ": " + angka[i]);
        }
    }
}