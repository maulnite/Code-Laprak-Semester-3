package UTP.Latihan;

import java.util.*;

public class Jooxtify {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL s = new SLL();

        int perintah = input.nextInt();
        input.nextLine();
        for (int i = 0; i < perintah; i++) {
            String choice = input.nextLine();
            switch (choice) {
                case "ADD": {
                    Lagu l = new Lagu(input.nextLine(), input.nextLine());
                    s.ADD(l);
                    break;
                }

                case "DELETE": {
                    s.DELETE(input.nextLine());
                    break;
                }

                case "SEARCH": {
                    s.SEARCH(input.nextLine());
                    break;
                }
            }
        }
        input.close();
    }
}

class Lagu {
    String judulLagu;
    String namaPenyanyi;

    Lagu(String judulLagu, String namaPenyanyi) {
        this.judulLagu = judulLagu;
        this.namaPenyanyi = namaPenyanyi;
    }
}

class Node {
    Lagu data;
    Node next;

    public Node(Lagu data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {
    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return (size == 0);
    }

    int getSize() {
        return size;
    }

    void ADD(Lagu data) {
        Node laguBaru = new Node(data);
        if (isEmpty()) {
            head = tail = laguBaru;
        } else {
            tail.next = laguBaru;
            tail = laguBaru;
        }
        size++;
        System.out.println(laguBaru.data.judulLagu + " berhasil disimpan\n");
    }

    void DELETE(String judulLagu) {
        if (head.data.judulLagu.equals(judulLagu)) {
            System.out.println(head.data.judulLagu + " berhasil dihapus\n");
            head = head.next;
            if (head == null)
                tail = null;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.judulLagu.equals(judulLagu)) {
                System.out.println(temp.next.data.judulLagu + " berhasil dihapus\n");
                temp.next = temp.next.next;
                if (temp.next == null)
                    tail = temp;
                size--;
                return;
            }
            temp = temp.next;
        }

        System.out.println("tidak dapat menghapus, lagu tidak ditemukan\n");

    }

    void SEARCH(String judulLagu) {
        Node temp = head;

        while (temp != null) {
            if (temp.data.judulLagu.equals(judulLagu)) {
                System.out.println("judul lagu = " + temp.data.judulLagu);
                System.out.println("penyanyi = " + temp.data.namaPenyanyi);
                System.out.println();
                return;
            }
            temp = temp.next;
        }

        System.out.println("lagu tidak ditemukan\n");
    }
}