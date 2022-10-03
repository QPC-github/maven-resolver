package org.eclipse.aether.spi.connector.checksum;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.List;
import java.util.Map;

import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.spi.connector.ArtifactDownload;

/**
 * Component able to provide (expected) checksums to connector beforehand the download happens. Checksum provided by
 * this component are of kind {@link org.eclipse.aether.spi.connector.checksum.ChecksumPolicy.ChecksumKind#PROVIDED}.
 *
 * @since 1.8.0
 */
public interface ProvidedChecksumsSource
{
    /**
     * May return the provided checksums (for given artifact transfer) from trusted source other than remote
     * repository, or {@code null}.
     *
     * @param transfer The transfer that is about to be executed.
     * @param checksumAlgorithmFactories The checksum algorithms that are expected.
     * @return Map of expected checksums, or {@code null}.
     */
    Map<String, String> getProvidedArtifactChecksums( RepositorySystemSession session,
                                                      ArtifactDownload transfer,
                                                      List<ChecksumAlgorithmFactory> checksumAlgorithmFactories );
}
