package ASD;

class DoublyNode {
    Object data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public DoublyNode() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    DoublyNode head, tail;
    int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void makeEmpty() {
        head = tail = null;
        size = 0;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(Object data) {
        DoublyNode newNode = new DoublyNode(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(Object data) {
        DoublyNode newNode = new DoublyNode(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public void insertAfter(DoublyNode prevNode, Object data) {
        if (!isEmpty()) {
            DoublyNode after = head;
            while (after != null){}
        }
        else {
            System.out.println("DLL is empty");
        }
    }

    public void printToTail() {
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + " - ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void printToHead() {
        DoublyNode current = tail;
        while (current != null) {
            System.out.print(current.data + " - ");
            current = current.next;
        }
        System.out.println();
    }
}


