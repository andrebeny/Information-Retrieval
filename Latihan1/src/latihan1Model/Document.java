/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author admin
 */
public class Document {

    private int id;
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public Document(int id, String content) {
        this.id = id;
        this.content = content;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String[] getListofTerm() {
        String value = this.getContent();
        value = value.replaceAll("[.,?!]", "");
        return value.split(" ");
    }

    public ArrayList<Posting> getListofPosting() {
        // panggil fungsi getListOfTerm
        String[] tempString = getListofTerm();
        // buat objek ArrayList<Posting> result untuk menampung hasil
        ArrayList<Posting> result = new ArrayList<Posting>();
        // buat looping sebanyak listOfTerm
        for (int i = 0; i < tempString.length; i++) {
            if (i == 0) {
                // buat object tempPosting
                Posting temPosting = new Posting(new Document(tempString[0]));
                // set atribut document, gunakan this
                // tambahkan ke ArrayList result
                result.add(temPosting);
            } else {
                // sorting ArayList result
                Collections.sort(result);
                // cek apakah term sudah ada
                Posting tempPosting = new Posting(tempString[i], this);
                int indexCari = Collections.binarySearch(result, tempPosting); // set atribut document, gunakan this
                // jika hasil cari kurang dari 0  (obyek tidak ada)
                if (indexCari < 0) {
                    // buat object tempPosting
                    //tambahkan kxe Arraylist Result
                    result.add(tempPosting);
                } else {
                    //lainnya (objek ada)
                    //ambil postingnya, tambahkan 1 ke numberoftermnya 
                    //dengan fungsi 
                    int TempNumber = result.get(indexCari).getNumberOfTerm() + 1;
                    result.get(indexCari).setNumberOfTerm(TempNumber);
                }

            }
        }
        return result;
    }
}
