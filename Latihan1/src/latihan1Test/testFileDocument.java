/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1Test;

import java.io.File;
import latihan1Model.Document;

/**
 *
 * @author admin
 */
public class testFileDocument {

    public static void main(String[] args) {
        Document doc = new Document();
        File file = new File("doc1.txt");
        doc.readFile(1, file);
        System.out.println("Isi Dokumen:");
        System.out.println(doc.getContent());
    }
}
