package ASD;

public class TestDLL {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println("=== Testing DoublyLinkedList ===");

        dll.addFirst("C");
        dll.addFirst("B");
        dll.addFirst("A");
        dll.printForward();
        dll.printReverse();

        dll.addLast("D");
        dll.addLast("E");
        dll.printForward();

        dll.insertAfter("C", "C+");
        dll.printForward();

        dll.insertBefore("C", "B+");
        dll.printForward();

        dll.removeFirst();
        dll.printForward();

        // dll.removeLast();
        // dll.printForward();

        // dll.remove("C+");
        // dll.printForward();

        // System.out.println("Element at index 2: " + dll.get(2));
        // System.out.println("Index of 'B+': " + dll.indexOf("B+"));

        // System.out.println();
        // dll.printForward();
        // dll.insertAt(2, "X");
        // dll.printForward();

        // System.out.println();
        // dll.printForward();
        // dll.removeAt(2);
        // dll.printForward();

        // System.out.println();
        // dll.printForward();
        // System.out.println("Index of 'B+': " + dll.indexOf("B+"));
        // System.out.println("Index of 'Z': " + dll.indexOf("Z"));

        // Get element
        // System.out.println();
        // dll.printForward();
        // System.out.println("Element at index 2: " + dll.get(2));

        System.out.println();
        dll.printForward();
        System.out.println("Contains 'C'? " + dll.contains("C"));
        System.out.println("Contains 'Z'? " + dll.contains("Z"));

        // dll.printReverse();
    }
}
