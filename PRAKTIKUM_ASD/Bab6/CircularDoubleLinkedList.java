package PRAKTIKUM_ASD.Bab6;

class NodeCDLL {
    Object data;
    NodeCDLL sebelum, setelah;
}

public class CircularDoubleLinkedList {
    private NodeCDLL pAwal, pAkhir;
    private int jumlah;

    public CircularDoubleLinkedList() {
        pAwal = null;
        pAkhir = null;
        jumlah = -1;
    }

    public void sisipDataDiAwal(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
            jumlah++;
        }
    }

    public void sisipDataDiAkhir(Object data) {
        // lengkapi bagian ini
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAkhir = pBaru;
            jumlah++;
        }
    }

    public void hapusData(Object dtHapus) {
        // lengkapi bagian ini
        if (pAwal != null) {
            NodeCDLL pKini;
            pKini = pAwal;
            boolean ketemu = false;
            int i = 0;

            while (!ketemu && (i <= jumlah)) {
                if (pKini.data.equals(dtHapus)) {
                    ketemu = true;
                } else {
                    pKini = pKini.setelah;
                }
                i++;
            }

            if (ketemu) {
                if (pAwal == pAkhir) {
                    pAwal = pAkhir = null;
                } else if (pKini == pAwal) {
                    pAwal = pAwal.setelah;
                    pAwal.sebelum = pAkhir;
                    pAkhir.setelah = pAwal;
                } else if (pKini == pAkhir) {
                    pAkhir = pAkhir.sebelum;
                    pAkhir.setelah = pAwal;
                    pAwal.sebelum = pAkhir;
                } else {
                    pKini.sebelum.setelah = pKini.setelah;
                    pKini.setelah.sebelum = pKini.sebelum;
                }
                jumlah--;
            }
        }
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        NodeCDLL pCetak;
        pCetak = pAwal;
        int i = -1;
        while (i < jumlah) {
            System.out.print(pCetak.data + "->");
            pCetak = pCetak.setelah;
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        // cdll.sisipDataDiAwal(new Integer(50));
        // cdll.sisipDataDiAwal(new Integer(60));
        // cdll.sisipDataDiAwal(new Integer(70));
        // cdll.sisipDataDiAwal(new Integer(8));
        // cdll.sisipDataDiAwal(new Integer(9));
        // cdll.sisipDataDiAwal(new Integer(90));
        // cdll.sisipDataDiAwal(new Integer(19));
        cdll.cetak("cdll Asal");
        cdll.sisipDataDiAkhir(10);
        cdll.cetak("cdll stl sisip diakhir");
        cdll.hapusData(10);
        cdll.cetak("cdll stl hapus 10");
    }
}
