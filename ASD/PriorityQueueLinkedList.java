package ASD;

class NodePQ {
    Object data;
    int priority;
    NodePQ next;

    public NodePQ(Object data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}

public class PriorityQueueLinkedList {
    private NodePQ front;
    private int size;

    public PriorityQueueLinkedList() {
        front = null;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void enqueue(Object data, int priority) {
        NodePQ input = new NodePQ(data, priority);

        if (isEmpty() || priority < front.priority) {
            input.next = front;
            front = input;
            size++;
        }
        NodePQ current = front;
        while (current.next != null && current.next.priority <= priority) {
            current = current.next;
        }
        input.next = current.next;
        current.next = input;
        size++;
    }

    Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        Object removed = front.data;
        front = front.next;
        size--;
        return removed;
    }

    Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        Object peeked = front.data;
        return peeked;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Front -> ");
        NodePQ current = front;
        while (current != null) {
            System.out.print(current.data + "(" + current.priority + ")");
            if (current.next != null) {
                System.out.print(" | ");
            }
            current = current.next;
        }
        System.out.println(" <- Rear");
    }

}
