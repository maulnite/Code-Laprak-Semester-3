package PRAKTIKUM_ASD.Bab4;

public class Node {
    Object data;
    Node next;

    public static void main(String[] args) {
        Node head = new Node();
        head.data = "A";
        System.out.println("data: " + head.data);
        System.out.println("pointer: " + head.next);
    }
}
