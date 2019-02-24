/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 *
 * @author admin
 */
public class InvertedIndex {

    private ArrayList<Document> listOfDocument = new ArrayList<Document>();
    private ArrayList<Term> dictionary = new ArrayList<Term>();

    public InvertedIndex() {

    }

    public void addNewDocument(Document document) {
        this.getListOfDocument().add(document);
    }

    //belum diurutkan berdasarkan term
    public ArrayList<Posting> getUnsortedPostingList() {
        ArrayList<Posting> list = new ArrayList<Posting>();

        // loop sebanyak term
        for (int i = 0; i < getListOfDocument().size(); i++) {
            String[] termResult = getListOfDocument().get(i).getListofTerm();
            //loop sebanyak term
            for (int j = 0; j < termResult.length; j++) {
                //buat object temp posting
                Posting tempPosting = new Posting(termResult[j], getListOfDocument().get(i));
                list.add(tempPosting);
            }
        }
        return list;
    }

    public ArrayList<Posting> getSortedPostingList() {
        // siapkan posting List
        ArrayList<Posting> list = new ArrayList<Posting>();
        // panggil list yang belum terurut
        list = this.getUnsortedPostingList();
        // urutkan
        Collections.sort(list);
        return list;
    }

    public ArrayList<Posting> search(String query) {
        // buat index/dictionary
        makeDictionary();
        String tempQuery[] = query.split(" ");
        for (int i = 0; i < tempQuery.length; i++) {
            String string = tempQuery[i];
        }
        return null;
    }
    
    public ArrayList<Posting> intersection(ArrayList<Posting> p1, ArrayList<Posting> p2){
       //
        
        return null;
    }

    public ArrayList<Posting> searchOneWord(String word) {
        Term tempTerm = new Term(word);
        if (getDictionary().isEmpty()) {
            // dictionary kosong
            return null;
        } else {
            int positionTerm = Collections.binarySearch(dictionary, tempTerm);
            if (positionTerm < 0) {
                // tidak ditemukan
                return null;
            } else {
                return dictionary.get(positionTerm).getPostingList();
            }
        }
    }

    public void makeDictionary() {
        //load sorted list
        ArrayList<Posting> list = this.getSortedPostingList();
        //cek dictionary apakah kosong
        for (int i = 0; i < list.size(); i++) {
            //cek dictionary kosong atau tidak
            if (getDictionary().isEmpty()) {
                Term term = new Term(list.get(i).getTerm());
                term.getPostingList().add(list.get(i));
                //tambah ke dictionary
                getDictionary().add(term);
            } else {
                // dictionary tidak kosong
                Term tempTerm = new Term(list.get(i).getTerm());
                // cek sudah ada di dictionary atau belum
                int position = Collections.binarySearch(getDictionary(), tempTerm);
                if (position < 0) {
                    //term baru
                    //tambah postinglist ke term
                    tempTerm.getPostingList().add(list.get(i));
                    //tambahkan term ke dictionary
                    getDictionary().add(tempTerm);
                } else {
                    //term sudah ada
                    //tambahkan psotinglist saja dari existing term
                    getDictionary().get(position).getPostingList().add(list.get(i));
                    //urutkan posting list
                    Collections.sort(getDictionary().get(position).getPostingList());
                }
                //urutkan term dictionary
                Collections.sort(getDictionary());
            }
        }

    }

    /**
     * @return the listOfDocument
     */
    public ArrayList<Document> getListOfDocument() {
        return listOfDocument;
    }

    /**
     * @param listOfDocument the listOfDocument to set
     */
    public void setListOfDocument(ArrayList<Document> listOfDocument) {
        this.listOfDocument = listOfDocument;
    }

    /**
     * @return the dictionary
     */
    public ArrayList<Term> getDictionary() {
        return dictionary;
    }

    /**
     * @param dictionary the dictionary to set
     */
    public void setDictionary(ArrayList<Term> dictionary) {
        this.dictionary = dictionary;
    }

}
