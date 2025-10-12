package ASD.Materi;

public class TestPriorityQueueLinkedList {
    public static void main(String[] args) {
        PriorityQueueLinkedList pqll = new PriorityQueueLinkedList();

        pqll.enqueue("A", 2);
        pqll.enqueue("B", 1);
        pqll.enqueue("C", 3);
        pqll.enqueue("D", 5);
        pqll.enqueue("E", 4);
        pqll.print();

        System.out.println(pqll.dequeue());
        pqll.print();

        System.out.println(pqll.peek());
        pqll.print();
    }
}
