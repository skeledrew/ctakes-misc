/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ctakes.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.ctakes.core.cr.XMIReader;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.CollectionReaderFactory;

/**
 * Various useful classes and methods.
 */
public class Utils {
  
  public static final String embeddingPath = "/Users/dima/Boston/Vectors/Python/sharp-arg-head-word-vectors.txt";
  
  /**
   * Instantiate an XMI collection reader.
   */
  public static CollectionReader getCollectionReader(File inputDirectory) throws Exception {

    List<String> fileNames = new ArrayList<>();
    for(File file : inputDirectory.listFiles()) {
      if(! (file.isHidden())) {
        fileNames.add(file.getPath());
      }
    }

    String[] paths = new String[fileNames.size()];
    fileNames.toArray(paths);

    return CollectionReaderFactory.createReader(
        XMIReader.class,
        XMIReader.PARAM_FILES,
        paths);
  }
}