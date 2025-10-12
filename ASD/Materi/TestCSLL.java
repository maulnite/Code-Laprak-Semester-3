package ASD.Materi;

public class TestCSLL {
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        System.out.println("=== Testing SinglyLinkedList ===");

        // Add first
        csll.addFirst("C");
        csll.print();
        csll.addFirst("B");
        csll.addFirst("A");
        csll.print();

        // Add last
        csll.addLast("D");
        csll.addLast("E");
        csll.print();

        // Insert after
        csll.inserAfter("C", "C+");
        csll.print();

        // Insert before
        csll.insertBefore("C", "B+");
        csll.print();

        // Remove first
        csll.removeFirst();
        csll.print();

        // Remove last
        csll.removeLast();
        csll.print();

        // Remove by key
        csll.remove("C+");
        csll.print();

        // Get element
        System.out.println();
        csll.print();
        System.out.println("Element at index 2: " + csll.get(2));

        // Index of element
        System.out.println();
        csll.print();
        System.out.println("Index of 'B+': " + csll.indexOf("B+"));
        System.out.println("Index of 'Z': " + csll.indexOf("Z"));

        // Insert at index
        csll.print();
        csll.insertAt(2, "X");
        csll.print();

        // Remove at index
        System.out.println();
        csll.print();
        csll.removeAt(2);
        csll.print();

        // Contains
        System.out.println();
        csll.print();
        System.out.println("Contains 'C'? " + csll.contains("C"));
        System.out.println("Contains 'Z'? " + csll.contains("Z"));
    }
}