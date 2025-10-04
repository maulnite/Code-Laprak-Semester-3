package ASD;

public class QueueArray {
    private Object[] data;
    private int front, rear, size, capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, capacity);
        data = newData;
        capacity = newCapacity;
    }

    void makeEmpty() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(Object value) {
        if (isFull()) {
            resize();
        }
        data[++rear] = value;
        size++;
    }

    Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        Object removed = data[front];
        for (int i = 0; i < rear; i++) {
            data[i] = data[i + 1];
        }
        data[rear--] = null;
        size--;
        return removed;
    }

    Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        Object peeked = data[front];
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
        System.out.print("Front -> ");
        for (int i = 0; i <= rear; i++) {
            System.out.print(data[i]);
            if (i < rear)
                System.out.print(" | ");
        }
        System.out.println(" <- Rear");
    }

}
