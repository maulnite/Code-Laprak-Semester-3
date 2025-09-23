package PRAKTIKUM_ASD.LiveCoding.Bab5;

import java.util.Scanner;

public class Musik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            playlist.ADD_END(scanner.nextLine());
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            String operator = scanner.nextLine();
            String[] parts = operator.split(" ");
            switch (parts[0]) {
                case "ADD_BEGIN":
                    playlist.ADD_BEGIN(parts[1]);
                    break;
                case "ADD_END":
                    playlist.ADD_END(parts[1]);
                    break;
                case "ADD_AFTER":
                    playlist.ADD_AFTER(Integer.parseInt(parts[1]), parts[2]);
                    break;
                case "REMOVE":
                    playlist.REMOVE(Integer.parseInt(parts[1]));
                    break;
                case "PLAY":
                    playlist.PLAY(Integer.parseInt(parts[1]));
                    break;
                case "NEXT":
                    playlist.NEXT();
                    break;
                case "PREV":
                    playlist.PREV();
                    break;
                case "SEARCH":
                    playlist.SEARCH(parts[1]);
                    break;
                case "PRINT":
                    playlist.PRINT();
                    break;
                default:
                    System.out.println("-");
            }
        }
        scanner.close();
    }
}

class Node {
    String title;
    Node next;
    Node prev;

    Node(String title) {
        this.title = title;
        this.next = null;
        this.prev = null;
    }
}

class Playlist {
    Node head;
    Node tail;
    Node current;
    int size;

    void ADD_END(String title) {
        Node newNode = new Node(title);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    void ADD_BEGIN(String title) {
        Node newNode = new Node(title);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    void ADD_AFTER(int index, String title) {
        Node newNode = new Node(title);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newNode.prev = temp;
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }
        temp.next = newNode;
        size++;
    }

    void REMOVE(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp == current) {
            current = temp.next != null ? temp.next : temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }
        size--;
    }

    void PLAY(int index) {
        current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
    }

    void NEXT() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    void PREV() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    void SEARCH(String title) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.title.equals(title)) {
                System.out.println(index);
                return;
            }
            temp = temp.next;
            index++;
        }
        System.out.println(-1);
    }

    void PRINT() {
        Node temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.println("*" + temp.title);
            } else {
                System.out.println(temp.title);
            }
            temp = temp.next;
        }
    }
}