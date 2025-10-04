package ASD;

public class TestStackLinkedList {
    public static void main(String[] args) {
        StackLinkedList sll = new StackLinkedList();

        sll.push("A");
        sll.push("B");
        sll.push("C");
        sll.push("D");
        sll.push("E");
        sll.print();

        System.out.println(sll.pop());
        sll.print();

        System.out.println(sll.peek());
        sll.print();
    }
}
