package org.example.interview.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class Int_arr_remove_duplicate {
    static  int[] remove_duplicate_arr(int[] ip) {
        Set<Integer> temp_set = new LinkedHashSet<>();
        for(Integer ele: ip){
            temp_set.add(ele);
        }
        int[] temp_arr = new int[temp_set.size()];
        int j=0;
        for(Integer i:temp_set){
            temp_arr[j] = i;
            j++;
        }
        return temp_arr;
    }

    public static void main(String[] args){
        int[] int_arr = {7,3,1,2,2,2,4,6,4};
        System.out.println(Arrays.toString(remove_duplicate_arr(int_arr)));
    }
}
