package ASD;

public class SinglyLinkedList {
    SinglyNode head, tail;
    int size = 0;

    void init() {
        head = tail = null;
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
            input.pointer = head;
            head = input;
        }
        size++;
    }

    void addLast(Object data) {
        SinglyNode input = new SinglyNode(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.pointer = input;
            tail = input;
        }
        size++;
    }

    void inserAfter(Object key, Object data) {
        SinglyNode current = head;

        while (current != null && !current.data.equals(key)) {
            current = current.pointer;
        }

        if (current == null) {
            System.out.println("Node with data " + key + " not found.");
            return;
        }

        SinglyNode input = new SinglyNode(data);

        input.pointer = current.pointer;
        current.pointer = input;

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
            current = current.pointer;
        }

        if (current == null) {
            System.out.println("Node with data " + key + " not found.");
            return;
        }

        SinglyNode input = new SinglyNode(data);
        previous.pointer = input;
        input.pointer = current;

        size++;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty -from removeFirst()");
            return;
        }

        head = head.pointer;
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
            while (current.pointer != tail) {
                current = current.pointer;
            }
            current.pointer = null;
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
            current = current.pointer;
        }

        if (current == null) {
            System.out.println("Node with data key " + key + " not found.");
            return;
        }

        prev.pointer = current.pointer;
        current.pointer = null;

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
            current = current.pointer;
        }
        return current.data;
    }

    int indexOf(Object key) {
        SinglyNode current = head;
        int index = 0;
        while (current != null && !current.data.equals(key)) {
            current = current.pointer;
            index++;
        }
        if (current == null) {
            return -1;
        }
        return index;
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
            current = current.pointer;
        }

        prev.pointer = current.pointer;
        current.pointer = null;

        size--;
    }

    void insertAt(int index, Object data) {
        checkIndex(index);

        if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size - 1) {
            addLast(data);
            return;
        }

        SinglyNode current = head;
        SinglyNode input = new SinglyNode(data);

        for (int i = 0; i < index - 1; i++) {
            current = current.pointer;
        }
        input.pointer = current.pointer;
        current.pointer = input;

        size++;
    }

    boolean contains(Object data) {
        if (isEmpty())
            return false;
        SinglyNode current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.pointer;
        }
        return false;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("List is empty -from print()");
        } else {
            SinglyNode current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current.pointer != null) {
                    System.out.print(" -> ");
                }
                current = current.pointer;
            }
            System.out.println();
        }
    }
}

class SinglyNode {
    Object data;
    SinglyNode pointer;

    SinglyNode() {
    }

    SinglyNode(Object data) {
        this(data, null);
    }

    SinglyNode(Object data, SinglyNode pointer) {
        this.data = data;
        this.pointer = pointer;
    }
}