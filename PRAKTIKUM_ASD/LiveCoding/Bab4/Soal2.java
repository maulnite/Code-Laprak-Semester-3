package PRAKTIKUM_ASD.LiveCoding.Bab4;

import java.util.Scanner;

class Pasien {
    String idPasien, namaPasien, penyakit;
    int levelPrioritas;

    Pasien(String idPasien, String namaPasien, String penyakit, int levelPrioritas) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.penyakit = penyakit;
        this.levelPrioritas = levelPrioritas;
    }

    String getPrioritasText() {
        return switch (levelPrioritas) {
            case 1 -> "Gawat";
            case 2 -> "Cukup Gawat";
            case 3 -> "Tidak Gawat";
            default -> "Tidak Diketahui";
        };
    }
}

class SinglyLinkedList {
    class Node {
        Pasien pasien;
        Node next;

        Node(Pasien pasien) {
            this.pasien = pasien;
        }
    }

    Node head;

    private void addFirst(Pasien pasien) {
        Node input = new Node(pasien);
        input.next = head;
        head = input;
    }

    private void addAfter(Node prev, Pasien pasien) {
        if (prev == null)
            return;
        Node input = new Node(pasien);
        input.next = prev.next;
        prev.next = input;
    }

    private void addLast(Pasien pasien) {
        Node input = new Node(pasien);
        if (head == null) {
            head = input;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = input;
    }

    private void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    void tambah(Pasien pasienBaru) {
        if (head == null) {
            head = new Node(pasienBaru);
            return;
        }

        if (pasienBaru.levelPrioritas == 1) {
            if (head.pasien.levelPrioritas != 1) {
                addFirst(pasienBaru);
            } else {
                Node current = head;
                while (current.next != null && current.next.pasien.levelPrioritas == 1) {
                    current = current.next;
                }
                addAfter(current, pasienBaru);
            }
        } else if (pasienBaru.levelPrioritas == 2) {
            if (head.pasien.levelPrioritas == 3) {
                addFirst(pasienBaru);
            } else {
                Node current = head;
                while (current.next != null && current.next.pasien.levelPrioritas != 3) {
                    current = current.next;
                }
                addAfter(current, pasienBaru);
            }
        } else {
            addLast(pasienBaru);
        }
    }

    void panggil() {
        if (head == null) {
            System.out.println("Antrean kosong. Tidak ada pasien untuk dipanggil.");
            return;
        }
        Pasien p = head.pasien;
        System.out.println("Pasien berikutnya: ID: " + p.idPasien + ", Nama: " + p.namaPasien
                + ", Penyakit: " + p.penyakit + ", Prioritas: " + p.levelPrioritas
                + " (" + p.getPrioritasText() + ")");
        removeFirst();
    }

    void hapus(String idPasien) {
        if (head == null) {
            System.out.println("Antrean sudah kosong.");
            return;
        }
        if (head.pasien.idPasien.equals(idPasien)) {
            removeFirst();
            System.out.println("Pasien dengan ID " + idPasien + " telah dihapus dari antrean.");
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && !current.pasien.idPasien.equals(idPasien)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Pasien dengan ID " + idPasien + " tidak ditemukan.");
            return;
        }

        previous.next = current.next;
        System.out.println("Pasien dengan ID " + idPasien + " telah dihapus dari antrean.");
    }

    void cetak() {
        System.out.println("=".repeat(40));
        System.out.println("DAFTAR ANTRIAN PASIEN UGD");
        System.out.println("=".repeat(40));

        if (head == null) {
            System.out.println("Antrean kosong.");
            System.out.println("=".repeat(40));
            return;
        }

        int amountPasien = 0;
        Node current = head;
        while (current != null) {
            amountPasien++;
            current = current.next;
        }
        System.out.println("Total Pasien: " + amountPasien + "\n");

        current = head;
        int no = 1;
        while (current != null) {
            Pasien p = current.pasien;
            System.out.println(no + ". ID: " + p.idPasien + ", Nama: " + p.namaPasien
                    + ", Penyakit: " + p.penyakit.replace("_", " ")
                    + ", Prioritas: " + p.levelPrioritas + " (" + p.getPrioritasText() + ")");
            current = current.next;
            no++;
        }
        System.out.println("=".repeat(40));
    }
}

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SinglyLinkedList antrean = new SinglyLinkedList();

        while (true) {
            String data = input.nextLine().trim();
            String[] parts = data.split(" ");

            switch (parts[0].toUpperCase()) {
                case "TAMBAH" -> {
                    String id = parts[1];
                    String nama = parts[2];
                    String penyakit = parts[3].replace("_", " ");
                    int prioritas = Integer.parseInt(parts[4]);
                    Pasien p = new Pasien(id, nama, penyakit, prioritas);
                    antrean.tambah(p);
                }
                case "PANGGIL" -> antrean.panggil();
                case "HAPUS" -> antrean.hapus(parts[1]);
                case "CETAK" -> antrean.cetak();
                case "KELUAR" -> {
                    System.out.println("Sistem manajemen antrean ditutup. Terima kasih.");
                    input.close();
                    return;
                }
            }
        }
    }
}
