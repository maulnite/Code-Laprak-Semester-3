package ASD;

class QueueNode {
    Object data;
    QueueNode next;

    public QueueNode(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueLinkedList {
    private QueueNode front, rear;
    private int size;

    public QueueLinkedList() {
        front = rear = null;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void makeEmpty() {
        front = rear = null;
        size = 0;
    }

    void enqueue(Object data) {
        QueueNode input = new QueueNode(data);
        if (isEmpty()) {
            front = rear = input;
            size++;
            return;
        }
        rear.next = input;
        rear = input;
        size++;
    }

    Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        Object removed = front.data;
        front = front.next;
        size--;
        return removed;
    }

    Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        Object peeked = front.data;
        return peeked;
    }

    public int size() {
        return size;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        QueueNode current = front;
        System.out.print("Front -> ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null)
                System.out.print(" | ");
            current = current.next;
        }
        System.out.println(" <- Rear");
    }

}
