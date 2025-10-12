package ASD.Materi;

public class TestSLL {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        System.out.println("=== Testing SinglyLinkedList ===");

        // Add first
        sll.addFirst("C");
        sll.addFirst("B");
        sll.addFirst("A");
        sll.print();

        // Add last
        sll.addLast("D");
        sll.addLast("E");
        sll.print();

        // Insert after
        sll.inserAfter("C", "C+");
        sll.print();

        // Insert before
        sll.insertBefore("C", "B+");
        sll.print();

        // Remove first
        sll.removeFirst();
        sll.print();

        // Remove last
        sll.removeLast();
        sll.print();

        // Remove by key
        sll.remove("C+");
        sll.print();

        // // Get element
        // System.out.println();
        // sll.print();
        // System.out.println("Element at index 2: " + sll.get(2));

        // // Index of element
        // System.out.println();
        // sll.print();
        // System.out.println("Index of 'B+': " + sll.indexOf("B+"));
        // System.out.println("Index of 'Z': " + sll.indexOf("Z"));

        // Insert at index
        // sll.print();
        // sll.insertAt(2, "X");
        // sll.print();

        // Remove at index
        // System.out.println();
        // sll.print();
        // sll.removeAt(2);
        // sll.print();

        // Contains
        System.out.println();
        sll.print();
        System.out.println("Contains 'C'? " + sll.contains("C"));
        System.out.println("Contains 'Z'? " + sll.contains("Z"));
    }
}