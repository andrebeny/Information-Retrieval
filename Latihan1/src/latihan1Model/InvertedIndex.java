/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1Model;

import java.util.ArrayList;
import java.util.Collections;

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

    public ArrayList<Document> getListOfDocument() {
        return listOfDocument;
    }

    public void setListOfDocument(ArrayList<Document> listOfDocument) {
        this.listOfDocument = listOfDocument;
    }

    public ArrayList<Term> getDictionary() {
        return dictionary;
    }

    public void setDictionary(ArrayList<Term> dictionary) {
        this.dictionary = dictionary;
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
        String[] tempQuery = query.split(" ");
        ArrayList<ArrayList<Posting>> string = new ArrayList<>();

        for (int i = 0; i < tempQuery.length; i++) {
            string.add(searchOneWord(tempQuery[i]));
        }
        return intersection(string.get(0), string.get(1));
    }

    public ArrayList<Posting> intersection(ArrayList<Posting> p1, ArrayList<Posting> p2) {
        //initialize menggunakan object result
        ArrayList<Posting> result = new ArrayList<>();
        //variable baru indexP1 dan indexp2
        int indexP1 = 0;
        int indexP2 = 0;

        //membuat variable pst1 dan pst2
        Posting pst1 = p1.get(indexP1);
        Posting pst2 = p2.get(indexP2);

        //cek apakah p1 dan p2 sama dengan null
        if (p1 == null && p2 == null) {
            return new ArrayList<>();
        }

        while (true) {
            //cek apakah id dokumen pst1 == id odokumen pst2
            if (pst1.getDocument().getId() == pst2.getDocument().getId()) {
                try {
                    //pst1 ditambahkan ke result
                    result.add(pst1);
                    indexP1++;
                    indexP2++;
                    pst1 = p1.get(indexP1);
                    pst2 = p2.get(indexP2);
                } catch (Exception e) {
                    break;
                }

            } //cek apakah id dokumen pst1 < id dokumen pst2
            else if (pst1.getDocument().getId() < pst2.getDocument().getId()) {
                try {
                    indexP1++;
                    pst1 = p1.get(indexP1);
                } catch (Exception e) {
                    break;
                }

            } else {
                try {
                    indexP2++;
                    pst2 = p2.get(indexP2);
                } catch (Exception e) {
                    break;
                }
            }
        }
        //mengembalikan ke result
        return result;
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

}
