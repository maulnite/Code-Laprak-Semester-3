package PRAKTIKUM_ASD.Bab7;

import java.util.*;

public class stack_array {
    Scanner scanner = new Scanner(System.in);
    final int MAX_SIZE = 10;

    int choice, i;
    char item;
    char[] arr_stack = new char[MAX_SIZE];
    int count = 0;
    int keluar = 0;

    public void push(char item) {
        if (count == MAX_SIZE) {
            System.out.println("\n#Stack Penuh");
        } else {
            arr_stack[count] = item;
            System.out.print("\n# PUSH No urut/index: " + count + ", Push: " + item);
            count++;
        }
    }

    public void pop() {
        if (count == 0) {
            System.out.println("\n## Stack Kosong");
        } else {
            --count;
            System.out.print("\n##POP No urut/index: " + count + ", Value: " + arr_stack[count]);
        }
    }

    public void printAll() {
        System.out.println("\n## Stack Size: " + count);
        for (i = (count - 1); i >= 0; i--) {
            System.out.print("\n## No Urut/index: " + i + ", Value: " + arr_stack[i]);
        }
    }

    public void menu() {
        System.out.print("\nMasukkan operasi yang akan dilakukan (1:push, 2:pop, 3:print): ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("\nMasukkan huruf yang akan dipush: ");
                item = scanner.next().charAt(0);
                push(item);
                break;

            case 2:
                pop();
                break;

            case 3:
                printAll();
                break;

            default:
                System.out.println("\n1:push, 2:pop, 3:print\n");
                keluar = 1;
                break;
        }
    }

    public static void main(String[] args) {
        stack_array s = new stack_array();
        do {
            s.menu();
        } while (s.keluar == 0);
    }

}
