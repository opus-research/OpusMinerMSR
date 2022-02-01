package les.opus.product.tool;


import java.util.ArrayList;
import les.opus.framework.persistence.PersistenceMechanism;
import les.opus.framework.tool.Tool;
import les.opus.product.tool.developercount.command.GetProjectData;
import org.repodriller.domain.Commit;
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
public class ProjectDataTool extends Tool{
    
    public ProjectDataTool(){
        addCommand(new GetProjectData());
    }

    @Override
    public String name() {
        return "ProjectDataTool";
    }

    @Override
    public String getDescription() {
        return "Count commit number of each developer";
    }

    @Override
    public ArrayList<String> offeredProperties() {
        return new ArrayList<>();
    }


}