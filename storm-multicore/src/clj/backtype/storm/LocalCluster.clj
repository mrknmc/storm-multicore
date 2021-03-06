;; Licensed to the Apache Software Foundation (ASF) under one
;; or more contributor license agreements.  See the NOTICE file
;; distributed with this work for additional information
;; regarding copyright ownership.  The ASF licenses this file
;; to you under the Apache License, Version 2.0 (the
;; "License"); you may not use this file except in compliance
;; with the License.  You may obtain a copy of the License at
;;
;; http://www.apache.org/licenses/LICENSE-2.0
;;
;; Unless required by applicable law or agreed to in writing, software
;; distributed under the License is distributed on an "AS IS" BASIS,
;; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;; See the License for the specific language governing permissions and
;; limitations under the License.

(ns backtype.storm.LocalCluster
  (:use [backtype.storm util config])
  (:require [backtype.storm.daemon.nimbus :as nimbus])
  (:import [java.util Map])
  (:gen-class
    :init init
    :implements [backtype.storm.ILocalCluster]
    :constructors {[] [] [java.util.Map] []}
    :state state))


(defnk mk-local-cluster
  "Reads the daemon config, creates a nimbus thread."
  [:daemon-conf {} :inimbus nil]
  (let [daemon-conf (merge (read-storm-config) daemon-conf)
        nimbus (nimbus/service-handler
                 daemon-conf
                 (if inimbus inimbus (nimbus/standalone-nimbus)))
        shutdown-hook (Thread. (fn [] (.shutdown nimbus)))
        cluster-map {:nimbus nimbus
                     :daemon-conf daemon-conf
                     :shutdown-hook shutdown-hook}]
    (.addShutdownHook (Runtime/getRuntime) shutdown-hook)
    cluster-map))


(defn -init
  ([]
   (let [ret (mk-local-cluster)]
     [[] ret]))
  ([^Map stateMap]
   [[] stateMap]))


(defn -submitTopology
  [this name conf topology]
  (.submitTopology (:nimbus (. this state)) name conf topology))


(defn -shutdown
  [this]
  (.removeShutdownHook (Runtime/getRuntime) (:shutdown-hook (. this state)))
  (.shutdown (:nimbus (. this state))))


(defn -killTopology
  [this name]
  (.killTopology (:nimbus (. this state)) name))


(defn -getState
  [this]
  (.state this))

