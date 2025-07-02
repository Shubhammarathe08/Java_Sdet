package org.example.interview.arrays;

import java.util.*;

public class Non_repeated_num {

    static void unique_ele_arr(int[] input) {
            HashMap<Integer,Integer> hmap = new LinkedHashMap<>();
            for(Integer t : input){
                if(hmap.containsKey(t)){
                    hmap.put(t,hmap.get(t)+1);
                }
                else{
                    hmap.put(t,1);
                }
            }
        System.out.println(hmap);
            for(Map.Entry<Integer,Integer> t1 : hmap.entrySet()){
                if(t1.getValue()==1){
                    System.out.println(t1.getKey());
                }
            }
    }

    public static void main(String args[]) {
        int[] temp = {1, 4, 4, 2, 3, 6, 3, 4, 3, 5};
        unique_ele_arr(temp);
    }
}
