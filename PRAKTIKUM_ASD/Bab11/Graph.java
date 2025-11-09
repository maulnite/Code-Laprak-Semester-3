package PRAKTIKUM_ASD.Bab11;

public class Graph {
    private class Node {
        private int data;
        private Node next;

        public Node(int dt, Node n) {
            data = dt;
            next = n;
        }

        public int getDt() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node[] node;
    private int jNode;

    public Graph(int n) {
        jNode = n;
        node = new Node[jNode];
    }

    public void addAdj(int head, int adj) {
        Node n = new Node(adj, node[head]);
        node[head] = n;
    }

    /**
     * Latihan 1 - Menghitung Edge Keluar (Out-Degree)
     * Menghitung jumlah edge yang KELUAR dari vertex v.
     */
    public int getOutDegree(int v) {
        int count = 0;
        Node n = node[v]; // Mulai dari list milik vertex v
        while (n != null) {
            count++; // Tambah hitungan untuk setiap koneksi keluar
            n = n.getNext();
        }
        return count;
    }

    /**
     * Latihan 1 - Menghitung Edge Masuk (In-Degree)
     * Menghitung jumlah edge yang MASUK ke vertex v.
     */
    public int getInDegree(int v) {
        int count = 0;
        // Kita harus memeriksa SETIAP vertex di dalam graf
        for (int i = 0; i < jNode; i++) {

            // Jangan periksa diri sendiri (opsional, tapi logis)
            // if (i == v) continue;

            // Telusuri linked list milik vertex i
            Node n = node[i];
            while (n != null) {
                // Jika vertex i menunjuk ke v, tambah hitungan
                if (n.getDt() == v) {
                    count++;
                }
                n = n.getNext();
            }
        }
        return count;
    }

    /**
     * Latihan 2 - Menghitung Jumlah Tetangga
     * Menghitung jumlah tetangga dari vertex v.
     * Logikanya identik dengan getOutDegree.
     */
    public int getJumlahTetangga(int v) {
        int count = 0;
        Node n = node[v]; // Mulai dari list milik vertex v
        while (n != null) {
            count++; // Tambah hitungan untuk setiap tetangga
            n = n.getNext();
        }
        return count;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < jNode; i++) {
            System.out.print("[" + i + "]");
            Node n = node[i];
            while (n != null) {
                System.out.print("->" + n.getDt());
                n = n.getNext();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addAdj(0, 3);
        g.addAdj(0, 1);
        g.addAdj(1, 4);
        g.addAdj(1, 2);
        g.addAdj(2, 4);
        g.addAdj(2, 1);
        g.addAdj(4, 3);
        g.addAdj(4, 3);
        g.cetak("Kondisi awal");

        System.out.println("\n--- Analisis Node (Latihan) ---");

        System.out.println("Analisis Vertex 1:");
        System.out.println("Jumlah Edge Keluar (Out-Degree): " + g.getOutDegree(1));
        System.out.println("Jumlah Edge Masuk (In-Degree)  : " + g.getInDegree(1));
        System.out.println("Jumlah Tetangga : " + g.getJumlahTetangga(1));

        System.out.println("\nAnalisis Vertex 4:");
        System.out.println("Jumlah Edge Keluar (Out-Degree): " + g.getOutDegree(4));
        System.out.println("Jumlah Edge Masuk (In-Degree)  : " + g.getInDegree(4));
        System.out.println("Jumlah Tetangga : " + g.getJumlahTetangga(4));

        System.out.println("\nAnalisis Vertex 3:");
        System.out.println("Jumlah Edge Keluar (Out-Degree): " + g.getOutDegree(3));
        System.out.println("Jumlah Edge Masuk (In-Degree)  : " + g.getInDegree(3));
        System.out.println("Jumlah Tetangga : " + g.getJumlahTetangga(3));
    }
}