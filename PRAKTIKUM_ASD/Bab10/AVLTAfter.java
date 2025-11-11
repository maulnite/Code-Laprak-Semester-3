package PRAKTIKUM_ASD.Bab10;

class NodeB {
    int data;
    int tinggi; // tinggi node
    NodeB pKiri;
    NodeB pKanan;
    NodeB pInduk;// pointer ke induk
    // constructor node

    public NodeB(int dt, int tg, NodeB pKi, NodeB pKa, NodeB pI) {
        this.data = dt;
        this.tinggi = tg;
        this.pKiri = pKi;
        this.pKanan = pKa;
        this.pInduk = pI;
    }
}

public class AVLTAfter {
    private NodeB root;

    public AVLTAfter() {
        root = null;
    }

    /**
     * Method helper baru untuk mengupdate tinggi node
     * Berdasarkan logika di modul.
     */
    private void updateTinggi(NodeB node) {
        if (node != null) {
            node.tinggi = Math.max(tinggi(node.pKiri), tinggi(node.pKanan)) + 1;
        }
    }

    // cari dt di tree, mengembalikan true jika ditemukan
    // dan false jika tidak
    public boolean cariDt(int dt) {
        NodeB temp = root;
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
     * Latihan 1: Method putar Kiri (untuk kasus RR)
     * Logika diambil dari modul baris 129-158
     */
    private NodeB rotasiKiri(NodeB x) {
        NodeB parent = x.pInduk;
        NodeB y = x.pKanan;
        NodeB T2 = y.pKiri;

        // Lakukan rotasi
        y.pKiri = x;
        x.pKanan = T2;

        // Update pInduk
        y.pInduk = parent;
        x.pInduk = y;
        if (T2 != null) {
            T2.pInduk = x;
        }

        // Update tinggi
        updateTinggi(x); // Hitung tinggi x dulu (anak)
        updateTinggi(y); // Hitung tinggi y (parent baru)

        return y; // Kembalikan root baru
    }

    /**
     * Latihan 2: Method putar Kanan (untuk kasus LL)
     * Logika diambil dari modul baris 92-121
     */
    private NodeB rotasiKanan(NodeB y) {
        NodeB parent = y.pInduk;
        NodeB x = y.pKiri;
        NodeB T2 = x.pKanan;

        // Lakukan rotasi
        x.pKanan = y;
        y.pKiri = T2;

        // Update pInduk
        x.pInduk = parent;
        y.pInduk = x;
        if (T2 != null) {
            T2.pInduk = y;
        }

        // Update tinggi
        updateTinggi(y); // Hitung tinggi y dulu (anak)
        updateTinggi(x); // Hitung tinggi x (parent baru)

        return x; // Kembalikan root baru
    }

    /**
     * Latihan 3: Method putar Kiri Kanan (untuk kasus LR)
     * Logika diambil dari modul "kasus 3 dari algoritma AVL"
     */
    private NodeB rotasiKiriKanan(NodeB z) {
        // Panggil method Latihan 1
        z.pKiri = rotasiKiri(z.pKiri);

        // Panggil method Latihan 2
        return rotasiKanan(z);
    }

    /**
     * Latihan 4: Method putar Kanan Kiri (untuk kasus RL)
     * Logika diambil dari modul "kasus 4 dari algoritma AVL"
     */
    private NodeB rotasiKananKiri(NodeB z) {
        // Panggil method Latihan 2
        z.pKanan = rotasiKanan(z.pKanan);

        // Panggil method Latihan 1
        return rotasiKiri(z);
    }

    // sisip dt ke dalam tree, returns true if berhasil,
    // false jika gagal
    // tree diseimbangkan menggunakan algoritma AVL
    public boolean sisipDt(int dt) {
        if (root == null) {
            root = new NodeB(dt, 1, null, null, null);
            return true;
        } else {
            NodeB temp = root;
            NodeB prev = null;
            while (temp != null) {
                if (dt == temp.data)
                    return false;
                else if (dt < temp.data) {
                    prev = temp;
                    temp = temp.pKiri;
                } else {
                    prev = temp;
                    temp = temp.pKanan;
                }
            }
            temp = new NodeB(dt, 1, null, null, prev);
            if (dt < prev.data)
                prev.pKiri = temp;
            else
                prev.pKanan = temp;
            NodeB z = prev;

            while (z != null) {
                updateTinggi(z);
                int balance = tinggi(z.pKiri) - tinggi(z.pKanan);

                NodeB parent = z.pInduk;

                if (balance > 1) {
                    if (tinggi(z.pKiri.pKiri) >= tinggi(z.pKiri.pKanan)) {
                        z = rotasiKanan(z);
                    } else {
                        z = rotasiKiriKanan(z);
                    }
                } else if (balance < -1) {
                    if (tinggi(z.pKanan.pKanan) >= tinggi(z.pKanan.pKiri)) {
                        z = rotasiKiri(z);
                    } else {
                        z = rotasiKananKiri(z);
                    }
                }

                if (parent == null) {
                    root = z;
                } else if (parent.pKiri != null && parent.pKiri.data == z.pInduk.data) {
                    parent.pKiri = z;
                } else {
                    parent.pKanan = z;
                }

                z = parent;
            }
            return true;
        }
    }

    public int tinggi() {
        return root.tinggi;
    }

    private int tinggi(NodeB node) {
        if (node == null)
            return 0;
        else
            return node.tinggi;
    }

    // hitung node-node dari tree
    public int jumlahNode() {
        return jumlahNode(root);
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(NodeB r) {
        if (r == null)
            return;
        inOrder(r.pKiri);
        System.out.printf("-%d", r.data);
        inOrder(r.pKanan);
    }

    // hitung node-node dari tree
    private int jumlahNode(NodeB node) {
        if (node == null)
            return 0;
        else
            return 1 + jumlahNode(node.pKiri)
                    + jumlahNode(node.pKanan);
    }

    public static void main(String[] args) {
        AVLTBefore t = new AVLTBefore();
        t.sisipDt(3);
        t.inOrderTraversal();
        System.out.println();
        t.sisipDt(4);
        t.inOrderTraversal();
        System.out.println();
        t.sisipDt(6);
        t.inOrderTraversal();
        System.out.println();
        t.sisipDt(5);
        t.inOrderTraversal();
        System.out.println();
        t.sisipDt(15);
        t.inOrderTraversal();
        System.out.println();
        t.sisipDt(10);
        t.inOrderTraversal();
        System.out.println();
        t.sisipDt(20);
        t.inOrderTraversal();
        System.out.println();
        t.sisipDt(17);
        t.inOrderTraversal();
        System.out.println();
        t.sisipDt(25);
        t.inOrderTraversal();
        System.out.println();
    }
}