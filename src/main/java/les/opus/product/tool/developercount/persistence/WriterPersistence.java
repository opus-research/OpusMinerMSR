package les.opus.product.tool.developercount.persistence;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import les.opus.framework.persistence.Bundle;
import les.opus.framework.persistence.PersistenceMechanism;

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
public class WriterPersistence implements PersistenceMechanism {

    @Override
    public void write(Bundle bundle) {
        File f = new File("./"+bundle.get("projectName")+".txt");
        try {
            FileWriter writer = new FileWriter(f);
            writer.write(bundle.get("project").toString());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void close() {
    }
}
