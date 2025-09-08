package ASD;

public class TestSLL {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addFirst("C");
        sll.print();
        sll.addLast("A");
        sll.print();
        sll.addLast("C");
        sll.print();
        sll.addLast("B");
        sll.print();
        sll.addFirst("0");
        sll.print();
        sll.inserAfter("B", "X");
        sll.print();
        sll.insertBefore("C", "Y");
        sll.print();
        System.out.println(sll.get(5));
        System.out.println(sll.indexOf("A"));

        sll.removeAt(3);
        sll.print();
        sll.removeAt(0);
        sll.print();
        sll.removeAt(4);
        sll.print();
        sll.insertAt(3, "P");
        sll.print();
        System.out.println(sll.contains("C"));

        System.out.println("\nSize: " + sll.size());
    }
}