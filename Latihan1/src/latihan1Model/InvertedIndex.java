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

    public ArrayList<Posting> getSortedPostingListWithTermNumber() {
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
        ArrayList<Posting> tempPosting = new ArrayList<>();

        for (int i = 0; i < tempQuery.length; i++) {
            String string = tempQuery[i];
            if (i == 0) {
                tempPosting = searchOneWord(tempQuery[i]);
            } else {
                ArrayList<Posting> tempPosting1 = searchOneWord(tempQuery[i]);
                tempPosting = intersection(tempPosting, tempPosting1);
            }
        }
        return tempPosting;
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

    public void makeDictionaryWithTermNumber() {
        // cek deteksi ada term yang frekuensinya lebih dari 
        // 1 pada sebuah dokumen
        // buat posting list term terurut
        ArrayList<Posting> list = getSortedPostingListWithTermNumber();
        // looping buat list of term (dictionary)
        for (int i = 0; i < list.size(); i++) {
            // cek dictionary kosong?
            if (getDictionary().isEmpty()) {
                // buat term
                Term term = new Term(list.get(i).getTerm());
                // tambah posting ke posting list utk term ini
                term.getPostingList().add(list.get(i));
                // tambah ke dictionary
                getDictionary().add(term);
            } else {
                // dictionary sudah ada isinya
                Term tempTerm = new Term(list.get(i).getTerm());
                // pembandingan apakah term sudah ada atau belum
                // luaran dari binarysearch adalah posisi
                int position = Collections.binarySearch(getDictionary(), tempTerm);
                if (position < 0) {
                    // term baru
                    // tambah postinglist ke term
                    tempTerm.getPostingList().add(list.get(i));
                    // tambahkan term ke dictionary
                    getDictionary().add(tempTerm);
                } else {
                    // term ada
                    // tambahkan postinglist saja dari existing term
                    getDictionary().get(position).
                            getPostingList().add(list.get(i));
                    // urutkan posting list
                    Collections.sort(getDictionary().get(position)
                            .getPostingList());
                }
                // urutkan term dictionary
                Collections.sort(getDictionary());
            }

        }

    }

//    public int getDocumentFrequency(String term) {
//        ArrayList<Posting> tempPostings = new ArrayList<Posting>();
//        String[] query = term.split(" ");
//        int N = 0, ni = 0;
//        for (int i = 0; i < listOfDocument.size(); i++) {
//            N = listOfDocument.get(i).getId();
//            ni = tempPostings.get(i).getNumberOfTerm();
//        }
//        return N / ni;
//    }
    public int getDocumentFrequency(String term) {
        Term tempTerm = new Term(term);

        int post = Collections.binarySearch(getDictionary(), tempTerm);
        if (post > 0) {
            return getDictionary().get(post).getPostingList().size();
        }
        return 0;
    }

    public double getInverseDoumentFrequency(String term) {
        double N = this.listOfDocument.size();
        double n = getDocumentFrequency(term);
        double idf = Math.log10(N / n);

        return idf;
    }

    public int getTermFrequency(String term, int idDocument) {
        int a = 0;
        for (int i = 0; i < getListOfDocument().size(); i++) {
            if (getListOfDocument().get(i).getId() == idDocument) {
                String[] terms = getListOfDocument().get(i).getListofTerm();
                for (int j = 0; j < terms.length; j++) {
                    if (term.equalsIgnoreCase(terms[j])) {
                        a = a + 1;
                    }
                }
            }
        }
        return a;
    }
//cobaaaa

    public ArrayList<Posting> makeTFIDF(int idDocument) {
        //Posting tempPosting = new Posting();
        //membuat objek temp dari arraylist posting
        ArrayList<Posting> temp = new ArrayList<>();
        //membuat objek baru dari arraylist term = dictionary
        ArrayList<Term> tempTerm = getDictionary();

        for (int i = 0; i < tempTerm.size(); i++) {
            //rumus menghitung weight, hasil term x dengan document
            double weight = getTermFrequency(tempTerm.get(i).getTerm(), idDocument) * getInverseDoumentFrequency(tempTerm.get(i).getTerm());

            Posting tempPosting = new Posting();
            tempPosting.setTerm(tempTerm.get(i).getTerm());
            tempPosting.setWeight(weight);

            //hasil weight dan term ditambahkan ke temp posting
            temp.add(tempPosting);
        }
        return temp;
    }

//    public ArrayList<Posting> makeTFIDF(int idDoc) {
//        Document doc = new Document();
//        doc.setId(idDoc);
//
//        int a = Collections.binarySearch(listOfDocument, doc);
//        ArrayList<Term> tempTerm = getDictionary();
//        if () {
//
//        } else {
//
//        }
//    }
    public double getInnerProduct(ArrayList<Posting> p1,
            ArrayList<Posting> p2) {
        return 0.0;
    }

    public ArrayList<Posting> getQueryPosting(String query) {
        return null;
    }
}
