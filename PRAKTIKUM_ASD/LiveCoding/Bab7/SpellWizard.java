package PRAKTIKUM_ASD.LiveCoding.Bab7;

import java.util.Scanner;

public class SpellWizard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StackSpell stack = new StackSpell();

        while (true) {
            String command = sc.next();

            if (command.equals("LEARN")) {
                String spell = sc.next();
                stack.LEARN(spell);
            }

            else if (command.equals("FORGET")) {
                stack.FORGET();
            }

            else if (command.equals("CAST")) {
                stack.CAST();
            }

            else if (command.equals("SHOW")) {
                stack.SHOW();
            }

            else if (command.equals("COUNT")) {
                stack.COUNT();
            }

            else if (command.equals("CLEAR")) {
                stack.CLEAR();
            }

            else if (command.equals("STOP")) {
                break;
            }
        }
        sc.close();
    }
}

class Node {
    String spell;
    Node next;

    Node(String spell) {
        this.spell = spell;
        this.next = null;
    }
}

class StackSpell {
    private Node top;
    private int size;

    public StackSpell() {
        top = null;
        size = 0;
    }

    boolean isEmpty() {
        return top == null;
    }

    void LEARN(String spell) {
        if (top != null) {
            Node current = top;
            while (current != null) {
                if (current.spell.equals(spell)) {
                    System.out.println(spell + " sudah dipelajari sebelumnya");
                    return;
                }
                current = current.next;
            }
        }

        Node newNode = new Node(spell);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println(spell + " dipelajari");
    }

    void FORGET() {
        if (isEmpty()) {
            System.out.println("Tidak ada mantra yang bisa dilupakan");
            return;
        }
        String spellForgeted = top.spell;
        top = top.next;
        size--;
        System.out.println(spellForgeted + " dihapus");
    }

    void CAST() {
        if (isEmpty()) {
            System.out.println("Tidak ada mantra untuk digunakan");
            return;
        }
        String spellCasted = top.spell;
        System.out.println("Menggunakan mantra " + spellCasted);
    }

    void printSpellsReverse(Node node) {
        if (node == null) {
            return;
        }
        printSpellsReverse(node.next);
        System.out.println(node.spell);
    }

    void SHOW() {
        if (isEmpty()) {
            System.out.println("Buku mantra kosong");
            return;
        }
        printSpellsReverse(top);
    }

    void COUNT() {
        System.out.println("Jumlah mantra: " + size);
    }

    void CLEAR() {
        top = null;
        size = 0;
        System.out.println("Semua mantra dihapus");
    }
}
