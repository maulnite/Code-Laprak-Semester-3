package PRAKTIKUM_ASD.LiveCoding.Bab11;

import java.util.ArrayList;
import java.util.Comparator; // Diperlukan untuk PriorityQueue
import java.util.List;
import java.util.PriorityQueue; // Diperlukan untuk urutan alfabetis
import java.util.Scanner;

/**
 * Node untuk custom linked list.
 */
class LLNode<T> {
    T data;
    LLNode<T> next;

    LLNode(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Implementasi Linked List sederhana (from scratch).
 * Akan kita gunakan untuk menyimpan daftar tetangga (Adjacency List)
 * dan daftar semua mata kuliah.
 */
class CustomLinkedList<T> {
    private LLNode<T> head;
    private int size;

    public CustomLinkedList() {
        // TODO: Inisialisasi head dan size
        this.head = null;
        this.size = 0;
    }

    /**
     * Menambahkan data baru di akhir linked list.
     * 
     * @param data Data yang akan ditambahkan.
     */
    public void add(T data) {
        // TODO: Implementasikan logika untuk menambah node baru di akhir list.
        // Hati-hati dengan kasus jika list masih kosong (head == null).
        LLNode<T> newNode = new LLNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            LLNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Mengembalikan node pertama (head) dari list.
     * Ini akan kita gunakan untuk iterasi manual.
     * 
     * @return Node pertama.
     */
    public LLNode<T> getHead() {
        // TODO: Kembalikan head
        return this.head;
    }

    /**
     * Mengembalikan jumlah elemen dalam list.
     * 
     * @return Ukuran list.
     */
    public int getSize() {
        // TODO: Kembalikan size
        return this.size; // Placeholder
    }
}

/**
 * Kelas MataKuliah
 * Ini adalah representasi dari 'Vertex' atau 'Node' dalam Graph kita.
 */
class MataKuliah {
    String nama;
    int inDegree;
    CustomLinkedList<MataKuliah> tetangga; // Adjacency list untuk node ini

    public MataKuliah(String nama) {
        // TODO: Inisialisasi semua atribut.
        // 'tetangga' harus diinisialisasi sebagai CustomLinkedList baru.
        // 'inDegree' harus 0.
        this.nama = nama;
        this.inDegree = 0;
        this.tetangga = new CustomLinkedList<MataKuliah>();
    }

    /**
     * Menambahkan mata kuliah lain sebagai tetangga (yang bergantung pada ini).
     */
    public void tambahTetangga(MataKuliah mataKuliah) {
        // TODO: Tambahkan 'mataKuliah' ke 'tetangga'
        this.tetangga.add(mataKuliah);
    }
}

/**
 * Kelas PerencanaStudi
 * Ini adalah representasi dari 'Graph' kita.
 */
class PerencanaStudi {

    // Master list yang menyimpan SEMUA objek MataKuliah yang ada.
    private CustomLinkedList<MataKuliah> semuaMataKuliah;

    public PerencanaStudi() {
        // TODO: Inisialisasi 'semuaMataKuliah'
        this.semuaMataKuliah = new CustomLinkedList<MataKuliah>();
    }

    /**
     * Method bantu untuk mencari MataKuliah berdasarkan nama,
     * atau membuatnya jika belum ada.
     * kembalikan Objek MataKuliah yang sesuai.
     */
    private MataKuliah cariAtauBuat(String nama) {
        // TODO: Implementasikan pencarian di 'semuaMataKuliah'.
        // 1. Dapatkan head dari 'semuaMataKuliah'.
        // 2. Buat loop (while current != null) untuk iterasi.
        // 3. Jika 'current.data.nama' sama dengan 'nama', kembalikan 'current.data'.
        // 4. Jika loop selesai dan tidak ketemu, buat 'MataKuliah' baru.
        // 5. Tambahkan 'MataKuliah' baru itu ke 'semuaMataKuliah'.
        // 6. Kembalikan 'MataKuliah' baru tersebut.

        LLNode<MataKuliah> current = semuaMataKuliah.getHead();
        while (current != null) {
            if (current.data.nama.equals(nama)) {
                return current.data;
            }
            current = current.next;
        }

        MataKuliah baru = new MataKuliah(nama);
        semuaMataKuliah.add(baru);
        return baru;
    }

    /**
     * Method untuk menambahkan aturan prasyarat ke dalam graph.
     */
    public void tambahPrasyarat(String namaPrasyarat, String namaMataKuliah) {
        // TODO: Implementasikan logika penambahan edge:
        // 1. Dapatkan objek 'prasyarat' menggunakan 'cariAtauBuat'.
        // 2. Dapatkan objek 'mataKuliah' menggunakan 'cariAtauBuat'.
        // 3. Panggil method 'tambahTetangga' pada 'prasyarat'.
        // 4. Increment 'inDegree' pada 'mataKuliah'.

        MataKuliah prasyarat = cariAtauBuat(namaPrasyarat);
        MataKuliah mataKuliah = cariAtauBuat(namaMataKuliah);
        prasyarat.tambahTetangga(mataKuliah);
        mataKuliah.inDegree++;
    }

    /**
     * Method utama untuk menyusun rencana studi (Topological Sort).
     * kembalikan List<String> berisi urutan mata kuliah, atau null jika ada siklus.
     */
    public List<String> susunRencanaStudi() {
        // 1. Buat PriorityQueue untuk urutan alfabetis.
        // PriorityQueue perlu Comparator untuk membandingkan nama MataKuliah.
        PriorityQueue<MataKuliah> pq = new PriorityQueue<>(Comparator.comparing(mk -> mk.nama));

        // 2. Buat List<String> untuk hasil akhir.
        List<String> hasilUrutan = new ArrayList<>();

        // 3. (Inisialisasi Antrean)
        // TODO: Iterasi 'semuaMataKuliah' (gunakan loop 'while' dan 'getHead()').
        // Jika 'current.data.inDegree == 0', tambahkan ke 'pq'.
        LLNode<MataKuliah> current = semuaMataKuliah.getHead();
        while (current != null) {
            if (current.data.inDegree == 0) {
                pq.add(current.data);
            }
            current = current.next;
        }

        // 4. (Proses Antrean - Algoritma Kahn)
        while (!pq.isEmpty()) {
            // TODO: Selama 'pq' tidak kosong:
            // a. Ambil (poll) 'MataKuliah' dari 'pq'.
            MataKuliah mk = pq.poll();

            // b. Tambahkan 'nama' mata kuliah tersebut ke 'hasilUrutan'.
            hasilUrutan.add(mk.nama);

            // c. Iterasi 'CustomLinkedList<MataKuliah> tetangga' dari mata kuliah tsb.
            LLNode<MataKuliah> tetanggaNode = mk.tetangga.getHead();
            while (tetanggaNode != null) {
                MataKuliah tetangga = tetanggaNode.data;
                // d. Untuk setiap 'tetangga':
                // i. Kurangi 'inDegree' tetangga.
                tetangga.inDegree--;

                // ii. Jika 'inDegree' tetangga menjadi 0, tambahkan objek 'tetangga' ke 'pq'.
                if (tetangga.inDegree == 0) {
                    pq.add(tetangga);
                }

                tetanggaNode = tetanggaNode.next;

            }
        }

        // 5. (Deteksi Siklus)
        // TODO: Bandingkan 'hasilUrutan.size()' dengan 'semuaMataKuliah.getSize()'.
        // Jika tidak sama, kembalikan 'null' (tanda ada siklus).
        // Jika sama, kembalikan 'hasilUrutan'.

        if (hasilUrutan.size() != semuaMataKuliah.getSize()) {
            return null;
        } else {
            return hasilUrutan;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PerencanaStudi perencana = new PerencanaStudi();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String prasyarat = input[0];
            String mataKuliah = input[1];

            // Panggil method untuk menambahkan prasyarat
            perencana.tambahPrasyarat(prasyarat, mataKuliah);
        }

        // Susun rencana studi
        List<String> rencana = perencana.susunRencanaStudi();

        // Cek hasil dan cetak output
        if (rencana == null) {
            System.out.println("Tidak dapat menyusun rencana studi, terdeteksi siklus prasyarat.");
        } else {
            // Cetak hasil yang sudah terurut
            System.out.println(String.join(" ", rencana));
        }

        scanner.close();
    }
}