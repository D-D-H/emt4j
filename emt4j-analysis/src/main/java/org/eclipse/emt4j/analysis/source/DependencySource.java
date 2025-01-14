/********************************************************************************
 * Copyright (c) 2022, 2023 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/
package org.eclipse.emt4j.analysis.source;

import org.eclipse.emt4j.analysis.common.util.Progress;
import org.eclipse.emt4j.common.Dependency;
import org.eclipse.emt4j.common.SourceInformation;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * Abstract when source of dependency
 */
public abstract class DependencySource {

    private final File file;

    private SourceInformation information;

    public DependencySource(File file) {
        this.file = file;
    }

    /**
     * parse it then consumer it
     *
     * @param consumer
     * @param sourceProgress
     * @throws IOException
     */
    public abstract void parse(Consumer<Dependency> consumer, Progress sourceProgress) throws IOException;

    public abstract String desc();

    public final File getFile() {
        return file;
    }

    /**
     * whether this source need to analysis.If no need to analysis,it will pass to report directly.
     */
    public boolean needAnalysis() {
        return true;
    }

    public SourceInformation getInformation() {
        return information;
    }

    public void setInformation(SourceInformation information) {
        this.information = information;
    }
}
