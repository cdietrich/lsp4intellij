/*
 * Copyright (c) 2023 Christian Dietrich All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo;

import com.intellij.openapi.application.PreloadingActivity;
import com.intellij.openapi.progress.ProgressIndicator;
import org.jetbrains.annotations.NotNull;
import org.wso2.lsp4intellij.IntellijLanguageClient;
import org.wso2.lsp4intellij.client.languageserver.serverdefinition.ProcessBuilderServerDefinition;
import org.wso2.lsp4intellij.client.languageserver.serverdefinition.RawCommandServerDefinition;

import java.io.File;
import java.io.IOException;

public class DModelPreloadingActivity extends PreloadingActivity {
    @Override
    public void preload(@NotNull ProgressIndicator indicator) {
        ProcessBuilder process = new ProcessBuilder("/Users/cdietrich/.nvm/versions/node/v18.13.0/bin/node", "out/language-server/main.js", "--stdio");
        process.directory(new File("/Users/cdietrich/langium/1x/my-domainmodel"));
        RawCommandServerDefinition definition = new RawCommandServerDefinition("dmodel",
                new String[]{"/Users/cdietrich/.nvm/versions/node/v18.13.0/bin/node","/Users/cdietrich/langium/1x/my-domainmodel/out/language-server/main.js", "--stdio"});
                //new String[]{"/Users/cdietrich/eclipse-workspaces/E202303M2/org.xtext.example.mydsl.parent/" +
                //        "org.xtext.example.mydsl.ide/build/distributions/org.xtext.example.mydsl.ide-1.0.0-SNAPSHOT/bin/org.xtext.example.mydsl.ide","-log","debug","-trace"});
                //ProcessBuilderServerDefinition definition = new ProcessBuilderServerDefinition("dmodel", process);
        IntellijLanguageClient.addServerDefinition(definition);
    }


    public static void main(String[] args) throws IOException {
        ProcessBuilder process = new ProcessBuilder("/Users/cdietrich/.nvm/versions/node/v18.13.0/bin/node", "out/language-server/main.js", "--stdio");
        process.directory(new File("/Users/cdietrich/langium/1x/my-domainmodel"));
        process.start();
    }
}
