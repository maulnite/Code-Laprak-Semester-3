package PRAKTIKUM_ASD.LiveCoding.Bab4;

import java.util.Scanner;

public class MahasiswaPriotitas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SLL daftar = new SLL();

        int nAwal = input.nextInt();
        input.nextLine();
        for (int i = 0; i < nAwal; i++) {
            daftar.addLast(input.nextLine());
        }

        int nPrioritas = input.nextInt();
        input.nextLine();
        for (int i = 0; i < nPrioritas; i++) {
            daftar.addFirst(input.nextLine());
        }

        daftar.print();

        input.close();
    }
}
