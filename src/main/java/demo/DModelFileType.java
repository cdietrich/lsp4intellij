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

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class DModelFileType extends LanguageFileType {
    protected DModelFileType() {
        super(new Language("DModel") {
        });
    }

    @Override
    public @NonNls
    @NotNull String getName() {
        return "DModel";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Domain Model";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "dmodel";
    }

    @Override
    public @Nullable Icon getIcon() {
        return null;
    }
}
