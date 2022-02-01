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
package les.opus.product.tool;

import java.util.ArrayList;
import les.opus.framework.CollectorFramework;
import les.opus.framework.CollectorFrameworkException;
import les.opus.framework.repository.AnalysisRepository;
import les.opus.framework.repository.Source;
import les.opus.framework.tool.ToolRegister;
import les.opus.product.tool.developercount.persistence.WriterPersistence;

/**
 *
 * @author danie
 */
public class Main {

    public static void main(String[] args) {

        //URL of repository
        ArrayList<String> repositoriesUrl = new ArrayList<>();
        repositoriesUrl.add("https://github.com/prestodb/presto");

        repositoriesUrl.parallelStream().forEach(repositoryUrl -> {

            try {
                //Define the repository that will be analyzed
                AnalysisRepository repository = AnalysisRepository.buildRepository(repositoryUrl, Source.GIT,
                        repositoryUrl.substring(repositoryUrl.lastIndexOf("/") + 1));

                //Register the tools that will be used
                ToolRegister register = new ToolRegister();
                register.registerTool(new ProjectDataTool(), new WriterPersistence());

                //Run the framework
                CollectorFramework.GetInstance()
                        .repository(repository)
                        .saveLocalGit()
                        .tools(register)
                        .run();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

}
