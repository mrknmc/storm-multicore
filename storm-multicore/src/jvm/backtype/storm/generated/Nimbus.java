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
/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package backtype.storm.generated;

import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.generated.NotAliveException;
import backtype.storm.generated.KillOptions;
import backtype.storm.generated.StormTopology;
import backtype.storm.generated.SubmitOptions;

import java.util.Map;

public class Nimbus {

  public interface Iface {

    public void submitTopology(String name, Map conf, StormTopology topology) throws AlreadyAliveException, InvalidTopologyException;

    public void submitTopologyWithOpts(String name, Map conf, StormTopology topology, SubmitOptions options) throws AlreadyAliveException, InvalidTopologyException;

    public void killTopology(String name) throws NotAliveException;

    public void killTopologyWithOpts(String name, KillOptions options) throws NotAliveException;

    public void activate(String name) throws NotAliveException;

    public void deactivate(String name) throws NotAliveException;

    public Map getNimbusConf();

//    public ClusterSummary getClusterInfo();

//    public TopologyInfo getTopologyInfo(String id) throws NotAliveException;

    public Map getTopologyConf(String id) throws NotAliveException;

    public StormTopology getTopology(String id) throws NotAliveException;

    public StormTopology getUserTopology(String id) throws NotAliveException;

  }
}