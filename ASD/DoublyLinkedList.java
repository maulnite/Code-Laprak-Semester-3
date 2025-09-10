package ASD;

class DoublyNode {
    Object data;
    DoublyNode prev, next;

    DoublyNode() {
    }

    DoublyNode(Object data) {
        this(data, null, null);
    }

    DoublyNode(Object data, DoublyNode prev, DoublyNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

public class DoublyLinkedList {
    DoublyNode head, tail;
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
        DoublyNode input = new DoublyNode(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.next = head;
            head.prev = input;
            head = input;
        }
        size++;
    }

    void addLast(Object data) {
        DoublyNode input = new DoublyNode(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            input.prev = tail;
            tail = input;
        }
        size++;
    }

    void insertAfter(Object key, Object data) {
        if (isEmpty()) {
            System.out.println("List is Empty.");
            return;
        }

        DoublyNode current = head;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with data " + key + " not found.");
            return;
        }

        if (current == tail) {
            addLast(data);
            return;
        }

        DoublyNode input = new DoublyNode(data);
        input.next = current.next;
        input.prev = current;
        current.next.prev = input;
        current.next = input;

        size++;
    }

    void insertBefore(Object key, Object data) {
        if (isEmpty()) {
            System.out.println("List is Empty.");
            return;
        }

        if (head.data.equals(key)) {
            addFirst(data);
            return;
        }

        DoublyNode current = head;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with data " + key + " not found.");
            return;
        }

        DoublyNode input = new DoublyNode(data);
        DoublyNode previous = current.prev;

        previous.next = input;
        input.prev = previous;
        input.next = current;
        current.prev = input;

        size++;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is Empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("List is Empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    void remove(Object key) {
        if (isEmpty()) {
            System.out.println("List is Empty.");
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

        DoublyNode current = head;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with data " + key + " not found.");
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;

        current.prev = current.next = null;

        size--;
    }

    void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
    }

    Object get(int index) {
        checkIndex(index);

        if (index == 0)
            return head.data;
        if (index == size - 1)
            return tail.data;

        DoublyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }

    int indexOf(Object key) {
        DoublyNode current = head;
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

        DoublyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;

        current.prev = current.next = null;

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

        DoublyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        DoublyNode input = new DoublyNode(data);
        DoublyNode previous = current.prev;

        previous.next = input;
        input.prev = previous;
        input.next = current;
        current.prev = input;

        size++;
    }

    boolean contains(Object data) {
        return indexOf(data) != -1;
    }

    void printForward() {
        if (isEmpty()) {
            System.out.println("List is Empty.");
            return;
        }

        DoublyNode current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    void printReverse() {
        if (isEmpty()) {
            System.out.println("List is Empty.");
            return;
        }

        DoublyNode current = tail;
        System.out.print("Reverse: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println();
    }
}