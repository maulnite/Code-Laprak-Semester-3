package PRAKTIKUM_ASD.LiveCoding.Bab10;

import java.util.Scanner;

class Node {
    int idKursi;
    int tinggi;
    Node kiri;
    Node kanan;

    Node(int idKursi) {
        this.idKursi = idKursi;
        this.tinggi = 1;
    }
}

class AVLTreeKetersediaan {

    private Node root;
    private boolean isFirstInorder = true;

    public boolean tambahKetersediaan(int idKursi) {
        if (cekKetersediaan(idKursi)) {
            return false;
        }

        this.root = insert(this.root, idKursi);
        return true;
    }

    // Public method untuk memesan kursi (PESAN).
    public boolean hapusKetersediaan(int idKursi) {
        // Sama seperti tambah, tangani update root dan output.

        if (!cekKetersediaan(idKursi)) {
            return false;
        }
        this.root = delete(this.root, idKursi);
        return true;
    }

    // Public method untuk mengecek ketersediaan kursi (CEK).
    public boolean cekKetersediaan(int idKursi) {
        return search(this.root, idKursi);
    }

    // Public method untuk menampilkan semua kursi tersedia (LIST).
    public void tampilkanSemuaKursiTersedia() {
        if (this.root == null) {
            System.out.println("Tidak ada kursi yang tersedia.");
            return;
        }
        System.out.print("Kursi tersedia: [");
        this.isFirstInorder = true;
        inorderTraversal(this.root);
        System.out.println("]");
    }

    // Method rekursif untuk menyisipkan node baru.
    private Node insert(Node node, int idKursi) {
        // TODO: 1. Lakukan operasi insert BST standar (rekursif).
        // TODO: 2. Jika node adalah null (base case), buat node baru.
        if (node == null) {
            return new Node(idKursi);
        }

        // TODO: 3. Jika idKursi < node.idKursi, rekursi ke kiri.
        if (idKursi < node.idKursi) {
            node.kiri = insert(node.kiri, idKursi);
            // TODO: 4. Jika idKursi > node.idKursi, rekursi ke kanan.
        } else if (idKursi > node.idKursi) {
            node.kanan = insert(node.kanan, idKursi);
            // TODO: 5. Jika idKursi == node.idKursi, return node (menangani duplikat).
        } else {
            return node;
        }

        // TODO: 6. Update tinggi (height) dari node saat ini.
        node.tinggi = 1 + max(getTinggi(node.kiri), getTinggi(node.kanan));

        // TODO: 7. Dapatkan balance factor dari node ini.
        int balance = getBalanceFactor(node);

        // TODO: 8. Lakukan Rebalancing jika diperlukan (4 kasus: LL, RR, LR, RL).
        if (balance > 1 && idKursi < node.kiri.idKursi) {
            return rotasiKanan(node);
        }
        if (balance < -1 && idKursi > node.kanan.idKursi) {
            return rotasiKiri(node);
        }
        if (balance > 1 && idKursi > node.kiri.idKursi) {
            node.kiri = rotasiKiri(node.kiri);
            return rotasiKanan(node);
        }
        if (balance < -1 && idKursi < node.kanan.idKursi) {
            node.kanan = rotasiKanan(node.kanan);
            return rotasiKiri(node);
        }

        return node;
    }

    // Method rekursif untuk menghapus node.
    private Node delete(Node node, int idKursi) {
        // TODO: 1. Lakukan operasi delete BST standar (rekursif).
        if (node == null) {
            return node;
        }

        if (idKursi < node.idKursi) {
            node.kiri = delete(node.kiri, idKursi);
        } else if (idKursi > node.idKursi) {
            node.kanan = delete(node.kanan, idKursi);
        } else {
            // TODO: 2. Handle 3 kasus delete:
            // a. Node adalah leaf
            // b. Node punya 1 anak
            // c. Node punya 2 anak (cari In-order Successor/Predecessor)
            if (node.kiri == null || node.kanan == null) {
                Node temp = (node.kiri != null) ? node.kiri : node.kanan;
                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node temp = getMinValueNode(node.kanan);
                node.idKursi = temp.idKursi;
                node.kanan = delete(node.kanan, temp.idKursi);
            }
        }

        // TODO: 3. Jika tree menjadi kosong setelah delete, return null.
        if (node == null) {
            return node;
        }

        // TODO: 4. Update tinggi (height) dari node saat ini.
        node.tinggi = 1 + max(getTinggi(node.kiri), getTinggi(node.kanan));

        // TODO: 5. Dapatkan balance factor.
        int balance = getBalanceFactor(node);

        // TODO: 6. Lakukan Rebalancing jika diperlukan (4 kasus).
        // Kasus 1: Left Left (LL)
        if (balance > 1 && getBalanceFactor(node.kiri) >= 0) {
            return rotasiKanan(node);
        }

        // Kasus 2: Left Right (LR)
        if (balance > 1 && getBalanceFactor(node.kiri) < 0) {
            node.kiri = rotasiKiri(node.kiri);
            return rotasiKanan(node);
        }

        // Kasus 3: Right Right (RR)
        if (balance < -1 && getBalanceFactor(node.kanan) <= 0) {
            return rotasiKiri(node);
        }

        // Kasus 4: Right Left (RL)
        if (balance < -1 && getBalanceFactor(node.kanan) > 0) {
            node.kanan = rotasiKanan(node.kanan);
            return rotasiKiri(node);
        }

        return node;
    }

    private boolean search(Node node, int idKursi) {
        // TODO: Implementasikan pencarian BST standar (rekursif).
        if (node == null) {
            return false;
        }

        if (idKursi == node.idKursi) {
            return true;
        }

        if (idKursi < node.idKursi) {
            return search(node.kiri, idKursi);
        } else {
            return search(node.kanan, idKursi);
        }
    }

    // Method rekursif untuk In-order Traversal (Kiri - Induk - Kanan).
    private void inorderTraversal(Node node) {
        // TODO: Implementasikan in-order traversal (rekursif).
        if (node != null) {
            inorderTraversal(node.kiri);

            // Cetak node.idKursi di antara pemanggilan rekursif kiri dan kanan.
            // Gunakan flag untuk formatting koma
            if (isFirstInorder) {
                isFirstInorder = false;
            } else {
                System.out.print(", ");
            }
            System.out.print(node.idKursi);

            inorderTraversal(node.kanan);
        }
    }

    private int getTinggi(Node node) {
        // TODO: Kembalikan tinggi node, atau 0 jika node null.
        if (node == null) {
            return 0;
        }
        return node.tinggi;
    }

    private int getBalanceFactor(Node node) {
        // TODO: Hitung balance factor menggunakan getTinggi().
        // Selisih tinggi (tinggi kiri - tinggi kanan).
        if (node == null) {
            return 0;
        }
        return getTinggi(node.kiri) - getTinggi(node.kanan);
    }

    private Node rotasiKanan(Node y) {
        // TODO: Implementasikan algoritma rotasi kanan.
        Node x = y.kiri;
        Node T2 = x.kanan;

        x.kanan = y;
        y.kiri = T2;

        y.tinggi = max(getTinggi(y.kiri), getTinggi(y.kanan)) + 1;
        x.tinggi = max(getTinggi(x.kiri), getTinggi(x.kanan)) + 1;

        return x;
    }

    // Melakukan rotasi ke kiri (Left Rotation) pada node x.
    private Node rotasiKiri(Node x) {
        // TODO: Implementasikan algoritma rotasi kiri.
        Node y = x.kanan;
        Node T2 = y.kiri;

        y.kiri = x;
        x.kanan = T2;

        x.tinggi = max(getTinggi(x.kiri), getTinggi(x.kanan)) + 1;
        y.tinggi = max(getTinggi(y.kiri), getTinggi(y.kanan)) + 1;

        return y;
    }

    // Helper untuk mencari nilai maksimum (untuk update tinggi).
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node getMinValueNode(Node node) {
        // TODO: Cari node paling kiri di subtree.
        Node current = node;
        while (current.kiri != null) {
            current = current.kiri;
        }
        return current;
    }
}

// kelas Main
public class live_coding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTreeKetersediaan tree = new AVLTreeKetersediaan();

        // Loop untuk membaca perintah dari pengguna
        while (true) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equals("KELUAR")) {
                System.out.println("Terima kasih telah menggunakan sistem reservasi bioskop.");
                break;
            }

            // Deklarasikan idKursi di luar switch agar bisa di-parse
            int idKursi = 0;
            if (parts.length > 1) {
                idKursi = Integer.parseInt(parts[1]);
            }

            switch (command) {
                case "TAMBAH_KURSI":
                    // TODO: Panggil tree.tambahKetersediaan(idKursi)
                    // Cetak output yang sesuai
                    boolean berhasilTambah = tree.tambahKetersediaan(idKursi);
                    if (berhasilTambah) {
                        System.out.println("Kursi " + idKursi + " berhasil ditambahkan ke daftar tersedia.");
                    } else {
                        System.out.println("Kursi " + idKursi + " sudah tersedia.");
                    }
                    break;

                case "PESAN":
                    // TODO: Panggil tree.hapusKetersediaan(idKursi)
                    // Cetak output yang sesuai (berhasil atau tidak tersedia)
                    boolean berhasilPesan = tree.hapusKetersediaan(idKursi);
                    if (berhasilPesan) {
                        System.out.println("Kursi " + idKursi + " berhasil dipesan.");
                    } else {
                        System.out.println("Kursi " + idKursi + " tidak tersedia untuk dipesan.");
                    }
                    break;

                case "BATAL":
                    // TODO: Panggil tree.tambahKetersediaan(idKursi) lagi
                    // Cetak output yang sesuai
                    boolean berhasilBatal = tree.tambahKetersediaan(idKursi);
                    if (berhasilBatal) {
                        System.out.println("Pesanan kursi " + idKursi + " dibatalkan, kursi kembali tersedia.");
                    } else {
                        System.out.println("Kursi " + idKursi + " sudah tersedia.");
                    }
                    break;

                case "CEK":
                    // TODO: Panggil tree.cekKetersediaan(idKursi)
                    // Cetak output yang sesuai (tersedia atau tidak)
                    boolean cek = tree.cekKetersediaan(idKursi);
                    if (cek) {
                        System.out.println("Kursi " + idKursi + " tersedia.");
                    } else {
                        System.out.println("Kursi " + idKursi + " tidak tersedia.");
                    }
                    break;

                case "LIST":
                    tree.tampilkanSemuaKursiTersedia();
                    break;

                default:
                    System.out.println("Perintah tidak dikenali.");
                    break;
            }
        }
        scanner.close();
    }
}