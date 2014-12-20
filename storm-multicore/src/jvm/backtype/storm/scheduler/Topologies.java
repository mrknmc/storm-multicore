/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package backtype.storm.scheduler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Topologies {
    // TODO: make private final
    Map<String, TopologyDetails> topologies;
    Map<String, String> nameToId;
    
    public Topologies(Map<String, TopologyDetails> topologies) {
        // TODO: fix this, could be done more nice
        if(topologies==null) topologies = new HashMap();
        this.topologies = new HashMap<String, TopologyDetails>(topologies.size());
        this.topologies.putAll(topologies);
        this.nameToId = new HashMap<String, String>(topologies.size());
        
        for (String topologyId : topologies.keySet()) {
            TopologyDetails topology = topologies.get(topologyId);
            this.nameToId.put(topology.getName(), topologyId);
        }
    }
    
    public TopologyDetails getById(String topologyId) {
        return this.topologies.get(topologyId);
    }
    
    public TopologyDetails getByName(String topologyName) {
        String topologyId = this.nameToId.get(topologyName);
        
        if (topologyId == null) {
            return null;
        } else {
            return this.getById(topologyId);
        }
    }
    
    public Collection<TopologyDetails> getTopologies() {
        return this.topologies.values();
    }
}