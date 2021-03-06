/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1Model;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Term implements Comparable<Term> {

    private String term;
    private ArrayList<Posting> postingList = new ArrayList<Posting>();

    public Term() {

    }

    public Term(String term) {
        this.term = term;
    }

    public int getNumberOfDocument() {
        return getPostingList().size();
    }

    /**
     * @return the term
     */
    public String getTerm() {
        return term;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * @return the list
     */
    public ArrayList<Posting> getPostingList() {
        return postingList;
    }

    /**
     * @param list the list to set
     */
    public void setPostingList(ArrayList<Posting> postingList) {
        this.postingList = postingList;
    }

    @Override
    public int compareTo(Term o) {
        return term.compareToIgnoreCase(o.getTerm());
    }

}
