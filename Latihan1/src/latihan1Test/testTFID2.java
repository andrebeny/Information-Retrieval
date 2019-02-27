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
public class testTFID2 {

    public static void main(String[] args) {
        // seting dokumen
        Document doc2 = new Document(2, "delivery of silver arrived in a silver truck");

        // buat arrayList posting untuk result
        ArrayList<Posting> result = doc2.getListofPosting();

        // tampilan posting list untuk doc2
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getTerm() + ","
                    + result.get(i).getNumberOfTerm());
        }

    }
}
