package ASD.Materi;

public class StackArray {
    private Object[] data;
    private int top;
    private int capacity;

    public StackArray(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == capacity - 1;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, capacity);
        data = newData;
        capacity = newCapacity;
    }

    void push(Object value) {
        if (isFull()) {
            resize();
        }
        data[++top] = value;
    }

    Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty, cannot pop.");
        }
        Object value = data[top];
        data[top--] = null;
        return value;
    }

    Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty, cannot pop.");
        }
        Object value = data[top];
        return value;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
            if (i != 0) {
                System.out.println("-");
            }
        }
        System.out.println();
    }
}