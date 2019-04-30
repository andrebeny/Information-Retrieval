/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testLucene;

import latihan1Model.Document;

/**
 *
 * @author admin
 */
public class TestDocumentIndonesiaStemming {

    public static void main(String[] args) {
        Document doc = new Document(1, "Aku membantu membuat roti, dan ia mempelajari cara membuat roti.");
        doc.IndonesiaStemming();
        System.out.println(doc);
    }
}
