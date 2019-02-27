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
 * @author ASUS
 */
public class docTest8Intersect {

    public static void main(String[] args) {
        Document doc1 = new Document(1, "computer information retrieval");
        Document doc2 = new Document(2, "computer organization and architecture");
        Document doc3 = new Document(3, "machine learning architecture");
        Document doc4 = new Document(4, "machine learning intelegence");

        // buat object invertedIndex
        InvertedIndex index = new InvertedIndex();
        // tambahkan document ke index
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);
        index.addNewDocument(doc4);
        // panggil fungsi search
        index.makeDictionary();
        //ArrayList<Posting> result = index.searchOneWord("learning");
        ArrayList<Posting> result1 = index.search("machine learning intelegence");
        //panggil fungsi intersect
        //ArrayList<Posting> join = index.intersection(result1, result);
        //tampilkan isi document dan id nya
        for (int i = 0; i < result1.size(); i++) {
            System.out.println("id_doc = " + result1.get(i).getDocument().getId());
            System.out.println(result1.get(i).getDocument().getContent());
        }

    }
}
