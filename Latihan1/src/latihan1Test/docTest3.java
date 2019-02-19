/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1Test;

import java.util.ArrayList;
import latihan1Model.Document;
import latihan1Model.Posting;

/**
 *
 * @author admin
 */
public class docTest3 {

    public static void main(String[] args) {
        Document doc1 = new Document(1, "computer information retrieval");
        Document doc2 = new Document(2, "computer organization and architecture");
        // Document doc3 = new Document(3, "machine learning architecture");

        ArrayList<Document> listOfDocument = new ArrayList<Document>();
        listOfDocument.add(doc1);
        listOfDocument.add(doc2);
        // mengeluarkan kata computer information retrieval
        // dipotong-potong menjadi 3 string
        String tokenDoc1[] = doc1.getListofTerm();
        String tokenDoc2[] = doc2.getListofTerm();

        ArrayList<Posting> list = new ArrayList<Posting>();
        // loop sebanyak term
        for (int i = 0; i < listOfDocument.size(); i++) {
            String[] termResult = listOfDocument.get(i).getListofTerm();
            //loop sebanyak term
            for (int j = 0; j < termResult.length; j++) {
                //buat object temp posting
                Posting tempPosting = new Posting(termResult[j], listOfDocument.get(i));
                list.add(tempPosting);
            }
        }

        System.out.println("Ukuran = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTerm() + " , " + list.get(i).getDocument().getId());
        }
    }
}
