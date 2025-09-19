package PRAKTIKUM_ASD.Bab4;

public class SLL {
    Node head, tail;
    int size = 0;

    void inisialisasi() {
        head = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void insertAt(int index, Node input) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }

        if (index == 0) {
            addFirst(input);
        }
    }

    public static void main(String[] args) {
        // SLL list = new SLL();
        // System.out.println("head : " + list.head);
        // System.out.println("tail : " + list.tail);
        // list.addFirst(new Node());
        // System.out.println("head : " + list.head);
        // System.out.println("tail : " + list.tail);
        // list.addFirst(new Node());
        // System.out.println("head : " + list.head);
        // System.out.println("tail : " + list.tail);
        // list.addLast(new Node());
        // System.out.println("head : " + list.head);
        // System.out.println("tail : " + list.tail);

        SLL list = new SLL();
        System.out.println("head : " + list.head);
        System.out.println("tail : " + list.tail);
        list.addLast(new Node());
        System.out.println("head : " + list.head);
        System.out.println("tail : " + list.tail);
        list.addLast(new Node());
        System.out.println("head : " + list.head);
        System.out.println("tail : " + list.tail);
        list.addLast(new Node());
        System.out.println("head : " + list.head);
        System.out.println("tail : " + list.tail);
    }
}