package PRAKTIKUM_ASD.LiveCoding.Bab9;

import java.util.Scanner;

class PohonKodeMorse {

    private static class Node {
        char karakter;
        Node kiri;
        Node kanan;

        public Node(char karakter) {
            this.karakter = karakter;
            this.kiri = null;
            this.kanan = null;
        }
    }

    private Node root;

    public PohonKodeMorse() {
        root = new Node('\0');

        tambahKode(".-", 'A');
        tambahKode("-...", 'B');
        tambahKode("-.-.", 'C');
        tambahKode("-..", 'D');
        tambahKode(".", 'E');
        tambahKode("..-.", 'F');
        tambahKode("--.", 'G');
        tambahKode("....", 'H');
        tambahKode("..", 'I');
        tambahKode(".---", 'J');
        tambahKode("-.-", 'K');
        tambahKode(".-..", 'L');
        tambahKode("--", 'M');
        tambahKode("-.", 'N');
        tambahKode("---", 'O');
        tambahKode(".--.", 'P');
        tambahKode("--.-", 'Q');
        tambahKode(".-.", 'R');
        tambahKode("...", 'S');
        tambahKode("-", 'T');
        tambahKode("..-", 'U');
        tambahKode("...-", 'V');
        tambahKode(".--", 'W');
        tambahKode("-..-", 'X');
        tambahKode("-.--", 'Y');
        tambahKode("--..", 'Z');
        tambahKode("-----", '0');
        tambahKode(".----", '1');
        tambahKode("..---", '2');
        tambahKode("...--", '3');
        tambahKode("....-", '4');
        tambahKode(".....", '5');
        tambahKode("-....", '6');
        tambahKode("--...", '7');
        tambahKode("---..", '8');
        tambahKode("----.", '9');
    }

    private void tambahKode(String kode, char karakter) {
        tambahKodeRekursif(root, kode, karakter);
    }

    private void tambahKodeRekursif(Node node, String kode, char karakter) {
        if (kode.length() == 0) {
            node.karakter = karakter;
            return;
        }

        char simbol = kode.charAt(0);
        String sisaKode = kode.substring(1);

        if (simbol == '.') {
            if (node.kiri == null) {
                node.kiri = new Node('\0');
            }
            tambahKodeRekursif(node.kiri, sisaKode, karakter);
        } else if (simbol == '-') {
            if (node.kanan == null) {
                node.kanan = new Node('\0');
            }
            tambahKodeRekursif(node.kanan, sisaKode, karakter);
        }
    }

    private char dekodeKarakter(String kode) {
        return dekodeKarakterRekursif(root, kode);
    }

    private char dekodeKarakterRekursif(Node node, String kode) {
        if (node == null)
            return '?';
        if (kode.length() == 0) {
            if (node.karakter != '\0') {
                return node.karakter;
            } else {
                return '?';
            }
        }

        char simbol = kode.charAt(0);
        String sisaKode = kode.substring(1);

        if (simbol == '.') {
            return dekodeKarakterRekursif(node.kiri, sisaKode);
        } else if (simbol == '-') {
            return dekodeKarakterRekursif(node.kanan, sisaKode);
        } else {
            return '?';
        }
    }

    public String dekodePesan(String pesanMorse) {
        String hasilDekode = "";
        String[] kataMorse = pesanMorse.trim().split(" / ");
        for (int i = 0; i < kataMorse.length; i++) {
            String[] kodeKarakter = kataMorse[i].split(" ");
            for (String kode : kodeKarakter) {
                char huruf = dekodeKarakter(kode);
                hasilDekode += huruf;
            }
            if (i < kataMorse.length - 1) {
                hasilDekode += " ";
            }
        }

        return hasilDekode.toUpperCase();
    }
}

public class binary_tree {
    public static void main(String[] args) {
        PohonKodeMorse dekoder = new PohonKodeMorse();

        Scanner scanner = new Scanner(System.in);
        String kodeMorse = scanner.nextLine();

        System.out.println(dekoder.dekodePesan(kodeMorse));
        scanner.close();
    }
}