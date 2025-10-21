package PRAKTIKUM_ASD.LiveCoding.Bab8;

import java.util.Scanner;

class Process {
    String id;
    int time;
    Process next;

    Process(String id, int time) {
        this.id = id;
        this.time = time;
        this.next = null;
    }
}

class Queue {
    private Process front, rear;

    public Queue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(String id, int time) {
        Process newNode = new Process(id, time);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Process dequeue() {
        if (isEmpty())
            return null;
        Process temp = front;
        front = front.next;
        if (front == null)
            rear = null;
        return temp;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Tidak ada proses dalam antrian");
            return;
        }
        Process current = front;
        while (current != null) {
            System.out.println(current.id + " " + current.time);
            current = current.next;
        }
    }
}

public class CPUUUU {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue queue = new Queue();

        while (true) {
            String command = input.next();

            if (command.equals("ARRIVE")) {
                String id = input.next();
                int burst = input.nextInt();
                queue.enqueue(id, burst);
                System.out.println("Proses " + id + " tiba dengan waktu eksekusi " + burst);
            }

            else if (command.equals("RUN")) {
                if (queue.isEmpty()) {
                    System.out.println("Tidak ada proses yang siap dijalankan");
                } else {
                    Process current = queue.dequeue();
                    current.time -= 1;
                    if (current.time == 0) {
                        System.out.println("Proses " + current.id + " dijalankan (sisa 0)");
                        System.out.println("Proses " + current.id + " selesai");
                    } else {
                        System.out.println("Proses " + current.id + " dijalankan (sisa " + current.time + ")");
                        queue.enqueue(current.id, current.time);
                    }
                }
            }

            else if (command.equals("STATUS")) {
                queue.display();
            }

            else if (command.equals("STOP")) {
                break;
            }
        }
        input.close();
    }
}