package PRAKTIKUM_ASD.Bab6;

class NodeCSLL {
    Object data;
    NodeCSLL setelah;
}

public class CircularSingleLinkedList {
    private NodeCSLL pAwal, pAkhir;
    private int jumlah;

    public CircularSingleLinkedList() {
        pAwal = null;
        pAkhir = null;
        jumlah = -1;
    }

    public void sisipDataDiAwal(Object data) {
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.setelah = pAwal;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
            jumlah++;
        }
    }

    public void sisipDataDiAkhir(Object data) {
        // lengkapi bagian ini
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pAkhir = pBaru;
            jumlah = 0;
        } else {
            pAkhir.setelah = pBaru;
            pBaru.setelah = pAwal;
            pAkhir = pBaru;
            jumlah++;
        }
    }

    public void hapusData(Object dtHapus) {
        if (pAwal != null) {
            NodeCSLL pSbl, pKini, pHapus;
            pSbl = null;
            pKini = pAwal;
            boolean ketemu = false;
            int i = 0;

            while (!ketemu && (i <= jumlah)) {
                if (pKini.data.equals(dtHapus)) {
                    ketemu = true;
                } else {
                    pSbl = pKini;
                    pKini = pKini.setelah;
                }
                i++;
            }
            if (ketemu) {
                if (pSbl == null) {
                    pHapus = pAwal;
                    pAwal = pKini.setelah;
                    pAkhir.setelah = pAwal;
                    pHapus = null;
                } else {
                    if (pAkhir == pKini) {
                        pAkhir = pSbl;
                    }
                    pSbl.setelah = pKini.setelah;
                    pHapus = pKini;
                    pHapus = null;
                }
                jumlah--;
            }
        }
    }

    public void hapusSatuDiAwal() {
        if (pAwal != null) {
            pAkhir.setelah = pAwal.setelah;
            pAwal = pAwal.setelah;
            jumlah--;
        }
    }

    public void hapusSatuDiAkhir() {
        if (pAwal != null) {
            NodeCSLL pKini;
            pKini = pAwal;

            while (pKini.setelah != pAkhir) {
                pKini = pKini.setelah;
            }
            pKini.setelah = pAwal;
            pAkhir = pKini;
            jumlah--;
        }
    }

    public void cetak(String komentar) {
        System.out.println(komentar);

        NodeCSLL pCetak;
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
        CircularSingleLinkedList csll = new CircularSingleLinkedList();
        csll.sisipDataDiAwal(new Integer(50));
        csll.sisipDataDiAwal(new Integer(60));
        csll.sisipDataDiAwal(new Integer(70));
        csll.sisipDataDiAwal(new Integer(8));
        csll.sisipDataDiAwal(new Integer(9));
        csll.sisipDataDiAwal(new Integer(90));
        csll.sisipDataDiAwal(new Integer(19));
        csll.cetak("csll Asal");
        csll.hapusData(8);
        csll.cetak("csll stl 8 dihapus");
        csll.hapusData(90);
        csll.cetak("csll stl 90 dihapus");
        csll.hapusSatuDiAwal();
        csll.cetak("csll awal dihapus");
        csll.hapusSatuDiAkhir();
        csll.cetak("csll akhir dihapus");
    }
}
