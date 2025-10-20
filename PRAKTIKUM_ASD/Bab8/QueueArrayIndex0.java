package PRAKTIKUM_ASD.Bab8;

import java.util.Scanner;

public class QueueArrayIndex0 {
    static final int MAX_SIZE = 10;
    Scanner input = new Scanner(System.in);

    int rear = 0;
    char[] queue = new char[MAX_SIZE];
    int keluar = 0;

    public void enqueue(char item) {
        if (rear == MAX_SIZE) {
            System.out.println("\n# Queue penuh!");
        } else {
            for (int i = rear; i > 0; i--) {
                queue[i] = queue[i - 1];
            }
            queue[0] = item;
            rear++;
            System.out.println("\n# Enqueue: " + item + " pada index 0");
        }
    }

    public void dequeue() {
        if (rear == 0) {
            System.out.println("\n## Queue kosong!");
        } else {
            char removed = queue[rear - 1];
            rear--;
            System.out.println("\n## Dequeue Value: " + removed);
        }
    }

    public void printAll() {
        if (rear == 0) {
            System.out.println("\n## Queue kosong!");
        } else {
            System.out.println("\n## Isi Queue (depan -> belakang):");
            for (int i = 0; i < rear; i++) {
                System.out.println("Index " + i + " : " + queue[i]);
            }
        }
    }

    public void menu() {
        System.out.print("\nPilih operasi (1: enqueue, 2: dequeue, 3: print, lainnya: keluar): ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Masukkan huruf yang akan di-enqueue: ");
                char item = input.nextLine().charAt(0);
                enqueue(item);
                break;
            case 2:
                dequeue();
                break;
            case 3:
                printAll();
                break;
            default:
                keluar = 1;
                System.out.println("\nKeluar dari program...");
        }
    }

    public static void main(String[] args) {
        QueueArrayIndex0 q = new QueueArrayIndex0();
        do {
            q.menu();
        } while (q.keluar == 0);
    }
}