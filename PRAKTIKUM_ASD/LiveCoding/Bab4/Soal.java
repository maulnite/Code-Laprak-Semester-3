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
        switch (levelPrioritas) {
            case 1:
                return "Gawat";
            case 2:
                return "Cukup Gawat";
            case 3:
                return "Tidak Gawat";
            default:
                return "Tidak Diketahui";
        }
    }
}

class SinglyLinkedList {
    class Node {
        Pasien pasien;
        Node next;

        Node(Pasien pasien) {
            this.pasien = pasien;
            this.next = null;
        }
    }

    Node head;

    void tambah(Pasien pasienBaru) {
        Node input = new Node(pasienBaru);
        if (head == null) {
            head = input;
        } else {
            if (pasienBaru.levelPrioritas == 1) {
                if (head.pasien.levelPrioritas != 1) {
                    input.next = head;
                    head = input;
                } else {
                    Node current = head;
                    while (current.next != null && current.next.pasien.levelPrioritas == 1) {
                        current = current.next;
                    }
                    input.next = current.next;
                    current.next = input;
                }
            } else if (pasienBaru.levelPrioritas == 2) {
                if (head.pasien.levelPrioritas == 3) {
                    input.next = head;
                    head = input;
                } else {
                    Node current = head;
                    while (current.next != null && current.next.pasien.levelPrioritas != 3) {
                        current = current.next;
                    }
                    input.next = current.next;
                    current.next = input;
                }
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = input;
            }
        }
    }

    void panggil() {
        if (head == null) {
            System.out.println("Antrean kosong. Tidak ada pasien untuk dipanggil.");
            return;
        }
        System.out.println("Pasien berikutnya: ID: " + head.pasien.idPasien + ", Nama: " + head.pasien.namaPasien
                + ", Penyakit: " + head.pasien.penyakit + ", Prioritas: " + head.pasien.levelPrioritas);
        head = head.next;
    }

    void hapus(String idPasien) {
        if (head == null) {
            System.out.println("Antrean sudah kosong.");
            return;
        }
        if (head.pasien.idPasien.equals(idPasien)) {
            head = head.next;
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
            Pasien pasien = current.pasien;
            System.out.println(no + ". ID: " + pasien.idPasien + ", Nama: " + pasien.namaPasien + ", Penyakit: "
                    + pasien.penyakit.replace("_", " ") + ", Prioritas: " + pasien.levelPrioritas + " ("
                    + pasien.getPrioritasText() + ")");
            current = current.next;
            no++;
        }
        System.out.println("=".repeat(40));
    }

}

public class Soal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SinglyLinkedList antrean = new SinglyLinkedList();
        while (true) {
            String data = input.nextLine();
            String[] parts = data.split(" ");

            if (parts[0].equalsIgnoreCase("TAMBAH")) {
                String id = parts[1];
                String nama = parts[2];
                String penyakit = parts[3].replace("_", " ");
                int prioritas = Integer.parseInt(parts[4]);
                Pasien p = new Pasien(id, nama, penyakit, prioritas);
                antrean.tambah(p);
            } else if (parts[0].equalsIgnoreCase("PANGGIL")) {
                antrean.panggil();
            } else if (parts[0].equalsIgnoreCase("HAPUS")) {
                antrean.hapus(parts[1]);
            } else if (parts[0].equalsIgnoreCase("CETAK")) {
                antrean.cetak();
            } else if (parts[0].equalsIgnoreCase("KELUAR")) {
                System.out.println("Sistem manajemen antrean ditutup. Terima kasih.");
                break;
            }
        }
        input.close();
    }
}
