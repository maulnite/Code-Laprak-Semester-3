package ASD;

public class TestQueueLinkedList {
    public static void main(String[] args) {
        QueueLinkedList qll = new QueueLinkedList();

        qll.enqueue("A");
        qll.enqueue("B");
        qll.enqueue("C");
        qll.enqueue("D");
        qll.enqueue("E");
        qll.print();

        System.out.println(qll.dequeue());
        qll.print();

        System.out.println(qll.peek());
        qll.print();
    }
}
