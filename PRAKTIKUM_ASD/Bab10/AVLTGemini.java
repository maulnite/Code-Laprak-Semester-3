package PRAKTIKUM_ASD.Bab10;

public class AVLTGemini {

    // 1. Node dijadikan private inner class
    private class Node {
        int data;
        int tinggi; // tinggi node
        Node pKiri;
        Node pKanan;
        Node pInduk; // pointer ke induk

        // constructor node
        public Node(int dt, Node pI) {
            this.data = dt;
            this.pInduk = pI;
            this.tinggi = 1; // Node baru awalnya punya tinggi 1
            this.pKiri = null;
            this.pKanan = null;
        }
    }

    private Node root;

    public AVLTGemini() {
        root = null;
    }

    // == HELPER METHODS (PUBLIC) ==

    /**
     * Mengembalikan tinggi dari tree.
     */
    public int tinggi() {
        return (root == null) ? 0 : root.tinggi;
    }

    /**
     * Menghitung jumlah total node di tree.
     */
    public int jumlahNode() {
        return jumlahNode(root);
    }

    /**
     * Menampilkan tree secara In-Order.
     */
    public void inOrderTraversal() {
        inOrder(root);
    }

    // == HELPER METHODS (PRIVATE) ==

    /**
     * Helper rekursif untuk menghitung jumlah node.
     */
    private int jumlahNode(Node node) {
        if (node == null)
            return 0;
        else
            return 1 + jumlahNode(node.pKiri) + jumlahNode(node.pKanan);
    }

    /**
     * Helper rekursif untuk traversal In-Order.
     */
    private void inOrder(Node r) {
        if (r == null)
            return;
        inOrder(r.pKiri);
        System.out.printf("-%d", r.data);
        inOrder(r.pKanan);
    }

    /**
     * Helper untuk mendapatkan tinggi node, aman untuk null node.
     */
    private int tinggi(Node node) {
        if (node == null)
            return 0;
        return node.tinggi;
    }

    /**
     * Helper untuk mendapatkan balance factor dari node.
     * (Tinggi kiri - Tinggi kanan)
     */
    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return tinggi(node.pKiri) - tinggi(node.pKanan);
    }

    /**
     * Helper untuk mengupdate tinggi node berdasarkan anak-anaknya.
     */
    private void updateTinggi(Node node) {
        if (node != null) {
            node.tinggi = 1 + Math.max(tinggi(node.pKiri), tinggi(node.pKanan));
        }
    }

    // == FUNGSI UTAMA (CARI & SISIP) ==

    /**
     * Mencari dt di tree, mengembalikan true jika ditemukan
     * dan false jika tidak.
     */
    public boolean cariDt(int dt) {
        Node temp = root;
        while (temp != null) {
            if (dt == temp.data)
                return true;
            // cariDt subtree pKiri
            else if (dt < temp.data)
                temp = temp.pKiri;
            // cariDt subtree pKanan
            else
                temp = temp.pKanan;
        }
        // dt tidak ditemukan
        return false;
    }

    /**
     * Menyisipkan dt ke dalam tree.
     * Tree diseimbangkan menggunakan algoritma AVL.
     * Returns true jika berhasil, false jika gagal (data sudah ada).
     */
    public boolean sisipDt(int dt) {
        if (root == null) {
            // Sisip dt di root
            root = new Node(dt, null);
            return true;
        } else {
            // Tree tidak kosong, cari lokasi penyisipan
            Node temp = root;
            Node prev = null;
            while (temp != null) {
                if (dt == temp.data) {
                    return false; // Data duplikat, gagal sisip
                }
                prev = temp;
                if (dt < temp.data) {
                    temp = temp.pKiri;
                } else {
                    temp = temp.pKanan;
                }
            }

            // Buat node baru
            Node nodeBaru = new Node(dt, prev);
            if (dt < prev.data) {
                prev.pKiri = nodeBaru;
            } else {
                prev.pKanan = nodeBaru;
            }

            // Panggil penyeimbang (rebalance)
            rebalance(prev);
            return true;
        }
    }

    // == LOGIKA ROTASI & REBALANCE (INTI DARI AVL) ==

    /**
     * Menyeimbangkan tree mulai dari node 'z' ke atas menuju root.
     */
    private void rebalance(Node z) {
        // Mulai dari parent node yang baru disisipkan,
        // bergerak menuju root
        while (z != null) {
            // 1. Update tinggi node saat ini
            updateTinggi(z);

            // 2. Dapatkan balance factor
            int balance = getBalance(z);

            Node parent = z.pInduk; // Simpan parent sebelum rotasi

            // 3. Cek 4 kasus ketidakseimbangan
            if (balance > 1) { // L (Left)
                if (getBalance(z.pKiri) >= 0) { // LL (Left-Left) -> Case 1
                    z = rotasiKanan(z);
                } else { // LR (Left-Right) -> Case 3
                    z.pKiri = rotasiKiri(z.pKiri);
                    z = rotasiKanan(z);
                }
            } else if (balance < -1) { // R (Right)
                if (getBalance(z.pKanan) <= 0) { // RR (Right-Right) -> Case 2
                    z = rotasiKiri(z);
                } else { // RL (Right-Left) -> Case 4
                    z.pKanan = rotasiKanan(z.pKanan);
                    z = rotasiKiri(z);
                }
            }

            // 4. Sambungkan subtree yang sudah seimbang ke parent-nya
            if (parent == null) {
                root = z; // z sekarang adalah root baru
            } else if (parent.pKiri == z.pInduk) { // Cek 'z.pInduk' (node z SEBELUM rotasi)
                parent.pKiri = z; // z adalah root baru dari subtree
            } else {
                parent.pKanan = z;
            }

            // 5. Pindah ke atas
            z = parent;
        }
    }

    /**
     * Melakukan rotasi ke kanan pada node y (Unbalanced node).
     *
     *
     * y x
     * / \ / \
     * x T3 -- Rotasi Kanan --> T1 y
     * / \ (pada y) / \
     * T1 T2 T2 T3
     *
     * @param y Node yang tidak seimbang (kakek dari node baru)
     * @return Node root baru dari subtree (yaitu x)
     */
    private Node rotasiKanan(Node y) {
        Node x = y.pKiri;
        Node T2 = x.pKanan;
        Node parent = y.pInduk;

        // Lakukan rotasi
        x.pKanan = y;
        y.pKiri = T2;

        // Update pointer pInduk
        x.pInduk = parent;
        y.pInduk = x;
        if (T2 != null) {
            T2.pInduk = y;
        }

        // Update tinggi
        updateTinggi(y); // Update y dulu (karena jadi anak)
        updateTinggi(x); // Update x (karena jadi parent)

        return x; // Kembalikan root baru
    }

    /**
     * Melakukan rotasi ke kiri pada node x (Unbalanced node).
     *
     *
     * x y
     * / \ / \
     * T1 y -- Rotasi Kiri --> x T3
     * / \ (pada x) / \
     * T2 T3 T1 T2
     *
     * @param x Node yang tidak seimbang (kakek dari node baru)
     * @return Node root baru dari subtree (yaitu y)
     */
    private Node rotasiKiri(Node x) {
        Node y = x.pKanan;
        Node T2 = y.pKiri;
        Node parent = x.pInduk;

        // Lakukan rotasi
        y.pKiri = x;
        x.pKanan = T2;

        // Update pointer pInduk
        y.pInduk = parent;
        x.pInduk = y;
        if (T2 != null) {
            T2.pInduk = x;
        }

        // Update tinggi
        updateTinggi(x); // Update x dulu (karena jadi anak)
        updateTinggi(y); // Update y (karena jadi parent)

        return y; // Kembalikan root baru
    }

    // == MAIN METHOD (Test) ==
    public static void main(String[] args) {
        AVLTGemini t = new AVLTGemini();
        System.out.println("Input: 3");
        t.sisipDt(3);
        t.inOrderTraversal();
        System.out.println(" (Tinggi: " + t.tinggi() + ")");

        System.out.println("Input: 4");
        t.sisipDt(4);
        t.inOrderTraversal();
        System.out.println(" (Tinggi: " + t.tinggi() + ")");

        System.out.println("Input: 6 (Rotasi Kiri di 3)");
        t.sisipDt(6);
        t.inOrderTraversal();
        System.out.println(" (Tinggi: " + t.tinggi() + ")");

        System.out.println("Input: 5 (Rotasi Kanan-Kiri di 3)");
        t.sisipDt(5);
        t.inOrderTraversal();
        System.out.println(" (Tinggi: " + t.tinggi() + ")");

        System.out.println("Input: 15");
        t.sisipDt(15);
        t.inOrderTraversal();
        System.out.println(" (Tinggi: " + t.tinggi() + ")");

        System.out.println("Input: 10 (Rotasi Kiri di 5)");
        t.sisipDt(10);
        t.inOrderTraversal();
        System.out.println(" (Tinggi: " + t.tinggi() + ")");

        System.out.println("Input: 20");
        t.sisipDt(20);
        t.inOrderTraversal();
        System.out.println(" (Tinggi: " + t.tinggi() + ")");

        System.out.println("Input: 17 (Rotasi Kanan-Kiri di 15)");
        t.sisipDt(17);
        t.inOrderTraversal();
        System.out.println(" (Tinggi: " + t.tinggi() + ")");

        System.out.println("Input: 25");
        t.sisipDt(25);
        t.inOrderTraversal();
        System.out.println(" (Tinggi: " + t.tinggi() + ")");

        /*
         * Output yang Diharapkan:
         * Input: 3
         * -3 (Tinggi: 1)
         * Input: 4
         * -3-4 (Tinggi: 2)
         * Input: 6 (Rotasi Kiri di 3)
         * -3-4-6 (Tinggi: 2) -> Pohon jadi: 4, anak kiri 3, anak kanan 6
         * Input: 5 (Rotasi Kanan-Kiri di 3)
         * -3-4-5-6 (Tinggi: 3) -> Pohon jadi: 4, kiri 3, kanan 6, 5 jadi anak kiri 6
         * Input: 15
         * -3-4-5-6-15 (Tinggi: 3)
         * Input: 10 (Rotasi Kiri di 5)
         * -3-4-5-6-10-15 (Tinggi: 3) -> Pohon jadi: 6, kiri 4, kanan 15, ...
         * Input: 20
         * -3-4-5-6-10-15-20 (Tinggi: 4)
         * Input: 17 (Rotasi Kanan-Kiri di 15)
         * -3-4-5-6-10-15-17-20 (Tinggi: 4) -> Pohon jadi: 10, kiri 5, kanan 17, ...
         * Input: 25
         * -3-4-5-6-10-15-17-20-25 (Tinggi: 4)
         */
    }
}