package mrknmc.storm.topology;

import java.util.Map;

public class StormTopology {

  private Map<String, SpoutSpec> spouts; // required
  private Map<String, Bolt> bolts; // required

  public Map<String, SpoutSpec> getSpouts() {
    return spouts;
  }

  public void setSpouts(Map<String, SpoutSpec> spouts) {
    this.spouts = spouts;
  }

  public Map<String, Bolt> getBolts() {
    return bolts;
  }

  public void setBolts(Map<String, Bolt> bolts) {
    this.bolts = bolts;
  }

  public StormTopology(Map<String, SpoutSpec> spouts, Map<String, Bolt> bolts) {
    this.spouts = spouts;
    this.bolts = bolts;
  }

}
