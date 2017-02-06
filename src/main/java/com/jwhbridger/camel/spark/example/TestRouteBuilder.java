/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jwhbridger.camel.spark.example;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class TestRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        // configure we want to use spark-rest on port 8080 as the component for the rest DSL
        // and for the swagger api-doc as well
        restConfiguration().component("spark-rest").port(8080);
                // and we enable json binding mode
//                .bindingMode(RestBindingMode.json)
                // and output using pretty print
//                .dataFormatProperty("prettyPrint", "true");

        rest("/")
                .get("/test")
                .to("http://localhost:9080/library?bridgeEndpoint=true&copyHeaders=true");
    }
}
