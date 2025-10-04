package ASD;

class SinglyNode {
    Object data;
    SinglyNode next;

    SinglyNode() {
    }

    SinglyNode(Object data) {
        this(data, null);
    }

    SinglyNode(Object data, SinglyNode next) {
        this.data = data;
        this.next = next;
    }
}

public class SinglyLinkedList {
    SinglyNode head, tail;
    int size = 0;

    void init() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void addFirst(Object data) {
        SinglyNode input = new SinglyNode(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    void addLast(Object data) {
        SinglyNode input = new SinglyNode(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void inserAfter(Object key, Object data) {
        SinglyNode current = head;

        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with data " + key + " not found.");
            return;
        }

        SinglyNode input = new SinglyNode(data);

        input.next = current.next;
        current.next = input;

        if (current == tail) {
            tail = input;
        }

        size++;
    }

    void insertBefore(Object key, Object data) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        if (head.data.equals(key)) {
            addFirst(data);
            return;
        }

        SinglyNode current = head;
        SinglyNode previous = null;

        while (current != null && !current.data.equals(key)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with data " + key + " not found.");
            return;
        }

        SinglyNode input = new SinglyNode(data);
        previous.next = input;
        input.next = current;

        size++;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty -from removeLast()");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            SinglyNode current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }

    void remove(Object key) {
        if (isEmpty()) {
            System.out.println("List is empty -from remove()");
            return;
        }

        if (head.data.equals(key)) {
            removeFirst();
            return;
        }

        SinglyNode prev = null;
        SinglyNode current = head;

        while (current != null && !current.data.equals(key)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with data key " + key + " not found.");
            return;
        }

        prev.next = current.next;
        current.next = null;
        current.data = null;

        size--;
    }

    void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
    }

    Object get(int index) {
        checkIndex(index);

        if (index == size - 1)
            return tail.data;

        SinglyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    int indexOf(Object key) {
        SinglyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(key)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    void removeAt(int index) {
        checkIndex(index);

        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }
        SinglyNode prev = null;
        SinglyNode current = head;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
        current.next = null;

        size--;
    }

    void insertAt(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds, size = " + size);
        }

        if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size) {
            addLast(data);
            return;
        }

        SinglyNode current = head;
        SinglyNode input = new SinglyNode(data);

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        input.next = current.next;
        current.next = input;

        size++;
    }

    boolean contains(Object data) {
        return indexOf(data) != -1;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("List is empty -from print()");
        } else {
            SinglyNode current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}