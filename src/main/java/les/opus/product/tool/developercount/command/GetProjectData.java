package les.opus.product.tool.developercount.command;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import les.opus.framework.persistence.Bundle;
import les.opus.framework.tool.ToolCommand;
import les.opus.framework.tool.ToolState;
import les.opus.framework.tool.state.ExecutionState;
import les.opus.framework.tool.state.PosExecutionState;
import les.opus.framework.tool.state.PreExecutionState;
import les.opus.product.tool.CommitData;
import les.opus.product.tool.ProjectData;
import org.repodriller.domain.Modification;
import org.repodriller.scm.SCMRepository;

/*
 * Copyright 2018 Daniel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 * @author Daniel
 */
public class GetProjectData implements ToolCommand {

    private HashMap<String, Integer> count = new HashMap<>();
    private ProjectData pdata = new ProjectData();
    private Gson gson = new Gson();
    private int i =0;
    @Override
    public void run(ToolState state) {

        if (state instanceof PreExecutionState) {
            PreExecutionState ee = (PreExecutionState) state;
            SCMRepository repository = ee.getRepo();

            pdata.setName(repository.getLastDir());

        }
        if (state instanceof ExecutionState) {
            i++;
            System.out.println(pdata.getName()+"-"+i);
            
            ExecutionState ee = (ExecutionState) state;
            SCMRepository repository = ee.getRepo();
                      
            CommitData cData = new CommitData();
            cData.setAuthorName(ee.getCommit().getAuthor().getName());
            cData.setAuthorEmail(ee.getCommit().getAuthor().getEmail());
            cData.setAuthorTimeZone(ee.getCommit().getAuthorTimeZone().getDisplayName());
            cData.setCommitterName(ee.getCommit().getCommitter().getName());
            cData.setCommitterEmail(ee.getCommit().getCommitter().getEmail());
            cData.setCommitterTimeZone(ee.getCommit().getCommitterTimeZone().getDisplayName());
            cData.setDate(ee.getCommit().getDate().getTimeInMillis());
            ArrayList<String> modifiedFiles = new ArrayList<>();
            ee.getCommit().getModifications().forEach((m) -> {
                modifiedFiles.add(m.getFileName());
            });
            cData.setModifiedFiles(modifiedFiles);
            cData.setHash(ee.getCommit().getHash());
            cData.setMsg(ee.getCommit().getMsg());
            cData.setNumberOfModifiedFiles(ee.getCommit().getModifications().size());
            
            pdata.addCommit(cData);
            

        }

        if (state instanceof PosExecutionState) {
            PosExecutionState pstate = (PosExecutionState) state;
            Bundle b = new Bundle();
            b.put("projectName", pstate.getRepo().getLastDir());
            b.put("project", gson.toJson(pdata));
            pstate.getWriter().write(b);
        }

    }

    @Override
    public String getName() {
        return "Count command";
    }

    @Override
    public String getDescription() {
        return "Count different developers that worked on project";
    }

}
