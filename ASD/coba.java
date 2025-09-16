package ASD;

import java.util.Scanner;

public class coba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListAntrean antrean = new LinkedListAntrean();

        while (true) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            if (parts[0].equalsIgnoreCase("TAMBAH")) {
                String id = parts[1];
                String nama = parts[2];
                String penyakit = parts[3].replace("_", " ");
                int prioritas = Integer.parseInt(parts[4]);
                Pasien p = new Pasien(id, nama, penyakit, prioritas);
                antrean.tambahPasien(p);
            } else if (parts[0].equalsIgnoreCase("PANGGIL")) {
                antrean.panggilPasien();
            } else if (parts[0].equalsIgnoreCase("HAPUS")) {
                antrean.hapusPasienById(parts[1]);
            } else if (parts[0].equalsIgnoreCase("CETAK")) {
                antrean.cetakAntrean();
            } else if (parts[0].equalsIgnoreCase("KELUAR")) {
                System.out.println("Sistem manajemen antrean ditutup. Terima kasih.");
                break;
            }
        }
        sc.close();
    }
}

class Pasien {
    String idPasien;
    String namaPasien;
    String penyakit;
    int levelPrioritas;

    Pasien(String id, String nama, String penyakit, int prioritas) {
        this.idPasien = id;
        this.namaPasien = nama;
        this.penyakit = penyakit;
        this.levelPrioritas = prioritas;
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

class LinkedListAntrean {
    class Node {
        Pasien data;
        Node next;

        Node(Pasien data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Tambah pasien sesuai aturan prioritas
    void tambahPasien(Pasien baru) {
        Node nodeBaru = new Node(baru);
        if (head == null) {
            head = nodeBaru;
        } else {
            if (baru.levelPrioritas == 1) {
                if (head.data.levelPrioritas != 1) {
                    nodeBaru.next = head;
                    head = nodeBaru;
                } else {
                    Node temp = head;
                    while (temp.next != null && temp.next.data.levelPrioritas == 1) {
                        temp = temp.next;
                    }
                    nodeBaru.next = temp.next;
                    temp.next = nodeBaru;
                }
            } else if (baru.levelPrioritas == 2) {
                if (head.data.levelPrioritas > 2) {
                    nodeBaru.next = head;
                    head = nodeBaru;
                } else {
                    Node temp = head;
                    while (temp.next != null && temp.next.data.levelPrioritas <= 2) {
                        temp = temp.next;
                    }
                    nodeBaru.next = temp.next;
                    temp.next = nodeBaru;
                }
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = nodeBaru;
            }
        }
        System.out.println("Pasien " + baru.namaPasien + " (" + baru.idPasien +
                ") dengan prioritas " + baru.levelPrioritas +
                " telah berhasil ditambahkan.");
    }

    // Panggil pasien terdepan
    void panggilPasien() {
        if (head == null) {
            System.out.println("Antrean kosong. Tidak ada pasien untuk dipanggil.");
            return;
        }
        Node temp = head;
        head = head.next;
        Pasien p = temp.data;
        System.out.println("Pasien berikutnya: ID: " + p.idPasien +
                ", Nama: " + p.namaPasien +
                ", Penyakit: " + p.penyakit +
                ", Prioritas: " + p.levelPrioritas);
    }

    // Hapus pasien berdasarkan ID
    void hapusPasienById(String id) {
        if (head == null) {
            System.out.println("Antrean sudah kosong.");
            return;
        }
        if (head.data.idPasien.equals(id)) {
            head = head.next;
            System.out.println("Pasien dengan ID " + id + " telah dihapus dari antrean.");
            return;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.data.idPasien.equals(id)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Pasien dengan ID " + id + " tidak ditemukan.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Pasien dengan ID " + id + " telah dihapus dari antrean.");
        }
    }

    // Cetak isi antrean
    void cetakAntrean() {
        System.out.println("========================================");
        System.out.println("DAFTAR ANTRIAN PASIEN UGD");
        System.out.println("========================================");
        if (head == null) {
            System.out.println("Antrean kosong.");
            System.out.println("========================================");
            return;
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Pasien: " + count + "\n");

        temp = head;
        int no = 1;
        while (temp != null) {
            Pasien p = temp.data;
            System.out.println(no + ". ID: " + p.idPasien +
                    ", Nama: " + p.namaPasien +
                    ", Penyakit: " + p.penyakit +
                    ", Prioritas: " + p.levelPrioritas +
                    " (" + p.getPrioritasText() + ")");
            temp = temp.next;
            no++;
        }
        System.out.println("========================================");
    }
}
