/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1Model;

import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Cluster {
    //center bisa abstrak atau object
    
    private ArrayList<Document> member = new ArrayList<Document>();
    private Document center = new Document();
    
    public Cluster(){
        
    }
    
    public ArrayList<Document> getClusterMember() {
        return member;
    }

    
    
    public void setClusterMember(ArrayList<Document> clusterMember) {
        this.member = clusterMember;
    }

    /**
     * @return the center
     */
    public Document getCenter() {
        return center;
    }

    /**
     * @param center the center to set
     */
    public void setCenter(Document center) {
        this.center = center;
    }

     
}
