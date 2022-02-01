/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.opus.product.tool;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class CommitData {

    private String authorName;
    private String authorEmail;
    private String authorTimeZone;
    private String committerName;
    private String committerEmail;
    private String committerTimeZone;
    private ArrayList<String> branches;
    private int numberOfBranches;
    private String hash;
    private String msg;
    private ArrayList<String> modifiedFiles;
    private ArrayList<String> parents;
    private long date;
    private int numberOfModifiedFiles;

    public void setModifiedFiles(ArrayList<String> modifiedFiles) {
        this.modifiedFiles = modifiedFiles;
    }

    public void setParents(ArrayList<String> parents) {
        this.parents = parents;
    }

    public void setDate(long date) {
        this.date = date;
    }
    
    

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public void setAuthorTimeZone(String authorTimeZone) {
        this.authorTimeZone = authorTimeZone;
    }

    public void setCommitterName(String committerName) {
        this.committerName = committerName;
    }

    public void setCommitterEmail(String committerEmail) {
        this.committerEmail = committerEmail;
    }

    public void setCommitterTimeZone(String committerTimeZone) {
        this.committerTimeZone = committerTimeZone;
    }

    public void setBranches(ArrayList<String> branches) {
        this.branches = branches;
    }

    public void setNumberOfBranches(int numberOfBranches) {
        this.numberOfBranches = numberOfBranches;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setNumberOfModifiedFiles(int numberOfModifiedFiles) {
        this.numberOfModifiedFiles = numberOfModifiedFiles;
    }
    
    

}
