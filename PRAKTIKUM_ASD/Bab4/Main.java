package PRAKTIKUM_ASD.Bab4;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("=== Penggunaan method init() ===");
        list.init();
        System.out.println("head: " + list.head);
        System.out.println("tail: " + list.tail);
        list.print();
        System.out.println();

        System.out.println("=== Penggunaan method isEmpty() ===");
        System.out.println("is list empty? " + list.isEmpty());
        list.print();
        System.out.println();

        System.out.println("=== Penggunaan method size() ===");
        System.out.println("size of list : " + list.size());
        list.print();
        System.out.println();

        System.out.println("=== Penggunaan method addFirst() ===");
        list.addFirst("B");
        list.print();
        list.addFirst("A");
        list.print();
        System.out.println();

        System.out.println("=== Penggunaan method addLast() ===");
        list.addLast("C");
        list.print();
        list.addLast("D");
        list.print();
        System.out.println();

        System.out.println("=== Penggunaan method insertAt() ===");
        list.insertAt(1, "A+");
        list.print();
        list.insertAt(3, "B+");
        list.print();
        System.out.println();

        System.out.println("=== Penggunaan method indexOf() ===");
        list.print();
        System.out.println("Index of \"B+\"? " + list.indexOf("B+"));
        System.out.println();

        System.out.println("=== Penggunaan method get() ===");
        list.print();
        System.out.println("Data of index 1: " + list.get(1));
        System.out.println();

    }
}
