package ASD.Materi;

class CircularSinglyNode {
    Object data;
    CircularSinglyNode next;

    public CircularSinglyNode(Object data) {
        this.data = data;
        this.next = null;
    }

}

public class CircularSinglyLinkedList {
    CircularSinglyNode head, tail;
    private int size;

    void init() {
        head = tail = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    void addFirst(Object data) {
        CircularSinglyNode input = new CircularSinglyNode(data);
        if (isEmpty()) {
            head = tail = input;
            tail.next = head;
            size++;
            return;
        }
        input.next = head;
        head = input;
        tail.next = head;

        size++;
    }

    void addLast(Object data) {
        CircularSinglyNode input = new CircularSinglyNode(data);
        if (isEmpty()) {
            head = tail = input;
            tail.next = head;
            size++;
            return;
        }
        tail.next = input;
        tail = input;
        tail.next = head;

        size++;
    }

    void inserAfter(Object key, Object data) {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        if (tail.data.equals(key)) {
            addLast(data);
            return;
        }
        CircularSinglyNode current = head;
        do {
            if (current.data.equals(key)) {
                CircularSinglyNode input = new CircularSinglyNode(data);
                input.next = current.next;
                current.next = input;
                size++;
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Node with key: " + key + " is not found.");
    }

    void insertBefore(Object key, Object data) {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data.equals(key)) {
            addFirst(data);
            return;
        }
        CircularSinglyNode current = head;
        CircularSinglyNode previous = null;
        do {
            if (current.data.equals(key)) {
                CircularSinglyNode input = new CircularSinglyNode(data);
                input.next = current;
                previous.next = input;
                size++;
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Node with key: " + key + " is not found.");
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }
        tail.next = head.next;
        head = head.next;
        size--;
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }
        CircularSinglyNode current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = head;
        tail = current;
        size--;
    }

    void remove(Object key) {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data.equals(key)) {
            removeFirst();
            return;
        }
        if (tail.data.equals(key)) {
            removeLast();
            return;
        }
        CircularSinglyNode current = head.next;
        CircularSinglyNode previous = head;
        while (current != head) {
            if (current.data.equals(key)) {
                previous.next = current.next;

                current.next = null;
                current.data = null;

                size--;
                return;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Node with key: " + key + " is not found.");
    }

    Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if (index == size - 1) {
            return tail.data;
        }

        CircularSinglyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    int indexOf(Object data) {
        if (isEmpty()) {
            return -1;
        }
        if (tail.data.equals(data)) {
            return size - 1;
        }
        int index = 0;
        CircularSinglyNode current = head;
        do {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        } while (current != head);

        return -1;
    }

    void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }

        CircularSinglyNode previous = head;
        CircularSinglyNode current = head.next;
        for (int i = 1; i < index; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        current.next = null;
        size--;
    }

    void insertAt(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        CircularSinglyNode previous = head;
        CircularSinglyNode current = head.next;
        for (int i = 1; i < index; i++) {
            previous = current;
            current = current.next;
        }
        CircularSinglyNode input = new CircularSinglyNode(data);
        input.next = current;
        previous.next = input;
        size++;
    }

    boolean contains(Object data) {
        return indexOf(data) != -1;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        CircularSinglyNode current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head: " + head.data + ")");
    }

}
