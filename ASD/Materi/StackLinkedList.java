package ASD.Materi;

class StackNode {
    Object data;
    StackNode next;

    public StackNode(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class StackLinkedList {
    StackNode top;
    int size;

    public StackLinkedList() {
        top = null;
        size = 0;
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(Object data) {
        StackNode input = new StackNode(data);
        input.next = top;
        top = input;
        size++;
    }

    Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        Object value = top.data;
        top = top.next;
        size--;
        return value;
    }

    Object peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        Object value = top.data;
        return value;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        StackNode current = top;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" - ");
            }
            current = current.next;
        }
        System.out.println();
    }

}
