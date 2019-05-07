/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testIRIndonesian;

import java.util.ArrayList;
import latihan1Model.Document;
import latihan1Model.InvertedIndex;
import latihan1Model.Posting;
import latihan1Model.Term;

/**
 *
 * @author User
 */
public class TestStemmingAndIndexingDocument {

    public static void main(String[] args) {
        // seting dokumen
        Document doc1 = new Document(1, "Fahri Hamzah Usul Ibu Kota Pindah ke Kepulauan Seribu");
        Document doc2 = new Document(2, "Gaya Nyentrik Menteri Susi Saat Pimpin Penenggelaman 13 Kapal Vietnam di Kalbar ");
        Document doc3 = new Document(3, "TNI AL: KRI Tjiptadi-381 Diprovokasi Kapal Pengawas Ikan Vietnam ");
        InvertedIndex index = new InvertedIndex();
        // lakukan stemming untuk semua dokumen
        doc1.IndonesiaStemming();
        doc2.IndonesiaStemming();
        doc3.IndonesiaStemming();
        System.out.println(doc1);
        // tmbahkan document ke index
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);
        // bikin dictionary
        index.makeDictionaryWithTermNumber();
        // tampilkan dictionary
        ArrayList<Term> dictionary = index.getDictionary();
        for (Term temp : dictionary) {
            System.out.println(temp);
        }
        System.out.println("Jumlah Term = " + dictionary.size());
        System.out.println("");
        ArrayList<Posting> listDoc1 = index.makeTFIDF(1);
        for (Posting temp : listDoc1) {
            System.out.println(temp);
        }
    }
}
