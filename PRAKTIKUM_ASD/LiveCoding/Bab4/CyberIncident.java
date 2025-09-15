package PRAKTIKUM_ASD.LiveCoding.Bab4;

import java.util.Scanner;

public class CyberIncident {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL logs = new SLL();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            logs.addLast(input.nextInt());
        }
        logs.insertAt(input.nextInt(), input.nextInt());
        logs.printReverse();
        input.close();
    }
}
