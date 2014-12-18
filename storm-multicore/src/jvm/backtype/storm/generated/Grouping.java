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

import backtype.storm.grouping.CustomStreamGrouping;

import java.util.*;

public class Grouping {

  private final List<String> fields; //empty list means global grouping
  private final CustomStreamGrouping customGrouping;
  private final GroupingType type;

  public GroupingType getType() {
    return type;
  }

  public List<String> getFields() {
    return fields;
  }

  public CustomStreamGrouping getCustomGrouping() {
    return customGrouping;
  }

  public Grouping(GroupingType type, CustomStreamGrouping customGrouping, List<String> fields) {
    this.type = GroupingType.FIELDS;
    this.customGrouping = customGrouping;
    this.fields = fields;
  }

  public static Grouping fields(List<String> fields) {
    return new Grouping(GroupingType.FIELDS, null, fields);
  }

  public static Grouping shuffle() {
    return new Grouping(GroupingType.SHUFFLE, null, null);
  }

  public static Grouping all() {
    return new Grouping(GroupingType.ALL, null, null);
  }

  public static Grouping none() {
    return new Grouping(GroupingType.NONE, null, null);
  }

  public static Grouping direct() {
    return new Grouping(GroupingType.DIRECT, null, null);
  }

  public static Grouping customObject(CustomStreamGrouping customGrouping) {
    return new Grouping(GroupingType.CUSTOM_OBJECT, customGrouping, null);
  }

  public static Grouping localOrShuffle() {
    return new Grouping(GroupingType.LOCAL_OR_SHUFFLE, null, null);
  }

  public enum GroupingType {
    FIELDS,
    SHUFFLE,
    ALL,
    NONE,
    DIRECT,
    CUSTOM_OBJECT,
    LOCAL_OR_SHUFFLE,
  }

}
