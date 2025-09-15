package PRAKTIKUM_ASD.LiveCoding.Bab4;

public class SLL {
    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    public void addFirst(Object data) {
        Node input = new Node(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    public void addLast(Object data) {
        Node input = new Node(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void insertAt(int index, Object data) {
        Node current = head;
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node input = new Node(data);
        input.next = current.next;
        current.next = input;

        size++;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current != tail) {
                System.out.print(" -> ");
            } else {
                System.out.print(" -> null");
            }
            current = current.next;
        }
    }

    public void printReverseRecursive(Node node) {
        if (node == null) {
            return;
        }
        printReverseRecursive(node.next);
        System.out.print(node.data + " ");
    }

    public void printReverse() {
        printReverseRecursive(head);
        System.out.println();
    }

}