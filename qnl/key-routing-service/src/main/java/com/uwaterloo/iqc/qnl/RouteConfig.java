package com.uwaterloo.iqc.qnl;

import java.util.Map;

public class RouteConfig {
    //adjacent - key:siteid, value:ip address
    public Map<String, String> adjacent;
    //non-adjacent -  key:siteid of non-adjacent node,
    //value:siteid of adjacent node through which the key
    //is reachable
    public Map <String, String> nonAdjacent;

    public boolean isIdAdjacent(String key) {
        return adjacent.containsKey(key);
    }

    public String getAdjacentId(String key) {
        if (adjacent.containsKey(key))
            return key;
        else
            return nonAdjacent.get(key);
    }

    public String getOtherAdjacentId(String key) {
        for (String k : adjacent.keySet()) {
            if (!k.equals(key))
                return k;
        }
        return null;
    }

    public String[] getAdjacentIdAddress(String key) {
        if (adjacent.containsKey(key)) {
            return adjacent.get(key).split(":");
        }

        return null;
    }

}
