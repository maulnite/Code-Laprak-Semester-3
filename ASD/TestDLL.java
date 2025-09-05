package ASD;

public class TestDLL {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addFirst(10);
        dll.printToHead();
        dll.printToTail();

        dll.addFirst(20);
        dll.printToHead();
        dll.printToTail();

        dll.addFirst(30);
        dll.printToHead();
        dll.printToTail();

        // System.out.println("Size of DLL: " + dll.getSize()); // Output: Size of DLL: 3
    }
    
}
