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
public class docTest1 {

    public static void main(String[] args) {
        Document doc1 = new Document(1, "computer information retrieval");
        // mengeluarkan kata computer information retrieval
        // dipotong-potong menjadi 3 string
        String tokenDoc1[] = doc1.getListofTerm();

        ArrayList<Posting> list = new ArrayList<Posting>();

        for (int i = 0; i < tokenDoc1.length; i++) {
            Posting tempPost = new Posting(tokenDoc1[i], doc1);
            list.add(tempPost);
            System.out.println("term " + i + " = " + tokenDoc1[i]);
        }

        System.out.println("Ukuran = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTerm() + " , " + list.get(i).getDocument().getId());
        }
    }
}
