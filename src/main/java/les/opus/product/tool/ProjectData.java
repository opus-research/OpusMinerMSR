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
public class ProjectData {

    private String name;
    private ArrayList<CommitData> commits = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void addCommit(CommitData commit) {
        commits.add(commit);
    }

    public String getName() {
        return name;
    }

    
}
