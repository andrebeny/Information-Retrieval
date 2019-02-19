/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1Model;

/**
 *
 * @author admin
 */
public class Term {

    private String term;
    private PostingList list;

    public Term(String term, PostingList list) {
        this.term = term;
        this.list = list;
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
    public PostingList getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(PostingList list) {
        this.list = list;
    }
    
}
