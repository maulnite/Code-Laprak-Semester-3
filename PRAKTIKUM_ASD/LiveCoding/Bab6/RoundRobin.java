package PRAKTIKUM_ASD.LiveCoding.Bab6;

import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nProses = input.nextInt();
        int nQuantum = input.nextInt();
        input.nextLine();
        SchedulerRoundRobin srr = new SchedulerRoundRobin(nQuantum);
        for (int i = 0; i < nProses; i++) {
            String idProses = input.next();
            String namaProses = input.next();
            int waktuEksekusiProses = input.nextInt();
            input.nextLine();
            srr.addProses(new Proses(idProses, namaProses, waktuEksekusiProses));
        }

        srr.printKondisiAwal();
        srr.execute();

        input.close();
    }
}

class Proses {
    String idProses;
    String namaProses;
    int waktuEksekusiProses;
    Proses next;

    public Proses(String idProses, String namaProses, int waktuEksekusiProses) {
        this.idProses = idProses;
        this.namaProses = namaProses;
        this.waktuEksekusiProses = waktuEksekusiProses;
        this.next = null;
    }
}

class SchedulerRoundRobin {
    Proses head, tail, current;
    int size = 0;
    int quantum = 0;

    public SchedulerRoundRobin(int quantum) {
        this.quantum = quantum;
    }

    void addProses(Proses newProses) {
        if (head == null) {
            head = tail = newProses;
            newProses.next = head;
        } else {
            tail.next = newProses;
            tail = newProses;
            tail.next = head;
        }
        size++;
    }

    void printKondisiAwal() {
        System.out.println("Kondisi Awal:");
        Proses temp = head;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                System.out.println("-> Proses " + temp.idProses + " (" + temp.namaProses + "), Sisa Waktu: "
                        + temp.waktuEksekusiProses + " (CURRENT)");
            } else {
                System.out.println("-> Proses " + temp.idProses + " (" + temp.namaProses + "), Sisa Waktu: "
                        + temp.waktuEksekusiProses);
            }
            temp = temp.next;
        }
        System.out.println();
        current = head;
    }

    void printSiklus(Proses currentProses) {
        Proses temp = currentProses;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                System.out.println("-> Proses " + temp.idProses + " (" + temp.namaProses + "), Sisa Waktu: "
                        + temp.waktuEksekusiProses + " (CURRENT)");
            } else {
                System.out.println("-> Proses " + temp.idProses + " (" + temp.namaProses + "), Sisa Waktu: "
                        + temp.waktuEksekusiProses);
            }
            temp = temp.next;
        }
    }

    void remove(Proses proses) {
        if (size == 1) {
            head = tail = current = null;
            size = 0;
            return;
        }

        Proses temp = head;
        Proses prev = null;

        do {
            if (temp == proses) {
                if (prev != null) {
                    prev.next = temp.next;
                }
                if (temp == head) {
                    head = head.next;
                }
                if (temp == tail) {
                    tail = prev;
                }
                size--;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void execute() {
        int siklus = 1;

        while (size > 0) {
            System.out.println(" ----- Siklus ke-" + siklus + " -----");
            if (current.waktuEksekusiProses <= quantum) {
                System.out.println("Proses " + current.idProses + " (" + current.namaProses + ") telah selesai.");
                remove(current);
                if (size == 0) {
                    System.out.println("Tidak ada proses tersisa.");
                    break;
                }
                current = current.next;
                printSiklus(current);
            } else {
                current.waktuEksekusiProses -= quantum;
                current = current.next;
                printSiklus(current);
            }
            System.out.println();
            siklus++;
        }
    }
}