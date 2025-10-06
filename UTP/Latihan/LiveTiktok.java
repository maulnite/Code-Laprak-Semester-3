package UTP.Latihan;

import java.util.*;

public class LiveTiktok {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DLLProduct dll = new DLLProduct();
        String command;
        String[] part;

        do {
            command = input.nextLine();
            part = command.split(" ");

            switch (part[0]) {
                case "ADD":
                    String id = part[1];
                    String nama = part[2];
                    int harga = Integer.parseInt(part[3]);
                    dll.ADD(new NodeProduct(id, nama, harga));
                    break;

                case "PRINT_ASC":
                    dll.PRINT_ASC();
                    break;
            }

        } while (!part[0].equals("END"));
        input.close();
    }
}

class NodeProduct {
    String id, nama;
    int harga;
    NodeProduct next, prev;

    public NodeProduct(String id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.next = this.prev = null;
    }
}

class DLLProduct {
    NodeProduct head;

    void ADD(NodeProduct input) {
        if (head == null) {
            head = input;
        } else {
            if (input.harga < head.harga) {
                input.next = head;
                head.prev = input;
                head = input;
            } else {
                NodeProduct current = head;
                while (current.next != null && input.harga >= current.next.harga) {
                    current = current.next;
                }
                input.next = current.next;
                input.prev = current;
                if (current.next != null)
                    current.next.prev = input;
                current.next = input;
            }
        }
    }

    void PRINT_ASC() {
        NodeProduct current = head;
        System.out.print("ASC: ");
        while (current != null) {
            System.out.print(current.harga + " " + current.nama);
            if (current.next != null) {
                System.out.print(" | ");
            }
            current = current.next;
        }
        System.out.println();
    }
}