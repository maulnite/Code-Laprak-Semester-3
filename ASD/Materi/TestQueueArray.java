package ASD.Materi;

public class TestQueueArray {
    public static void main(String[] args) {
        QueueArray qa = new QueueArray(5);

        qa.enqueue("A");
        qa.enqueue("B");
        qa.enqueue("C");
        qa.enqueue("D");
        qa.enqueue("E");
        qa.enqueue("F");
        qa.print();

        System.out.println(qa.dequeue());
        qa.print();

        System.out.println(qa.peek());
        qa.print();
    }
}
