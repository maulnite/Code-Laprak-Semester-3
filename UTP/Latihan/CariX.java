package UTP.Latihan;

import java.util.*;

public class CariX {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CSLLCariX csll = new CSLLCariX();

        int n = input.nextInt();
        int k = input.nextInt();
        int x = input.nextInt();

        for (int i = 0; i < n; i++) {
            csll.add(input.nextInt());
        }

        System.out.println(csll.cariX(k, x));
        input.close();
    }
}

class NodeCariX {
    int data;
    NodeCariX next;

    public NodeCariX(int data) {
        this.data = data;
        this.next = null;
    }
}

class CSLLCariX {
    NodeCariX head, tail;
    int total = 0;

    void add(int data) {
        NodeCariX input = new NodeCariX(data);
        if (head == null) {
            head = tail = input;
            tail.next = head;
        } else {
            tail.next = input;
            tail = input;
            tail.next = head;
        }
    }

    int cariX(int k, int x) {
        NodeCariX current = head;
        for (int i = 0; i < k; i++) {
            total += current.data;
            if (total == x) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
}