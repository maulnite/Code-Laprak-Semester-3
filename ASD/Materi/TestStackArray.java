package ASD.Materi;

public class TestStackArray {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.print();

        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.peek());

    }
}
