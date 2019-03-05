/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1Test;

import java.util.ArrayList;
import latihan1Model.Document;
import latihan1Model.InvertedIndex;
import latihan1Model.Posting;

/**
 *
 * @author admin
 */
public class testMakeTFIDF {
    
    public static void main(String[] args) {
        // seting dokumen
        Document doc1 = new Document(1, "Shipment of gold damaged in a fire");
        Document doc2 = new Document(2, "delivery of silver arrived in a silver truck");
        Document doc3 = new Document(3, "shipment of gold arrived in a truck");

        // buat object invertedIndex
        InvertedIndex index = new InvertedIndex();
        // tmbahkan document ke index
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);

        // panggil fungsi search
        index.makeDictionaryWithTermNumber();
        ArrayList<Posting> result = index.makeTFIDF(3);
        // tampilkan isi document dan id-nya
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getTerm() + " : " + result.get(i).getWeight());
        }
        
    }
}
