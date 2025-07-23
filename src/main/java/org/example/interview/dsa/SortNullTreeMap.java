package org.example.interview.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortNullTreeMap {
        public static void main(String[] args) {
            Map<Integer, String> map = new HashMap<>();
            map.put(1, "One");
            map.put(3, "Three");
            map.put(null, "Null");
            map.put(0, "Three");

// TreeMap to sort keys, handling null separately
            Map<Integer, String> sorted = new TreeMap<>(
                    (a,b)->
                    {
                        if(a==null){
                            return -1;
                        }
                        if(b==null){
                            return 1;
                        }
                        return a-b;
                    }
            );
// (a,b) -> { if(a==null) return -1; if(b==null) return 1; return a-b; }
            sorted.putAll(map);
            System.out.println(sorted);
        }
    }
