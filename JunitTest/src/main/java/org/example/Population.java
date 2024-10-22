package org.example;

import java.util.HashMap;
import java.util.Map;

public class Population {

    public int getPopulation(String city){
        Map<String, Integer> map  = getPopulationCount();
        return map.get(city);
      //  return 0;
    }

    public int getPopul(String city){
        Map<String, Integer> map  = getPopulationCount();
        return map.getOrDefault(city,0);

    }

    public Map<String, Integer> getPopulationCount(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Mumbai", 20000);
        map.put("Delhi", 30000);
        map.put("Pune", 28000);
        map.put("Nagpur", 12000);
        map.put("Bangalore", 17000);
        return map;
    }
}
