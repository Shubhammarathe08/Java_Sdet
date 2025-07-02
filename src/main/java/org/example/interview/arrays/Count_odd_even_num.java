package org.example.interview.arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Count_odd_even_num {


    static int[] even_0_odd_1_arr_count(int[] input) {
        int even = 0, odd = 0;
        for (Integer i : input) {
            if ((int) i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int[] res = new int[2];
        res[0] = even;
        res[1] = odd;
        return res;
    }

    public static void main(String[] args) {
        int[] test = {43, 2, 4, 58, 10, 35};
        System.out.println(even_0_odd_1_arr_count(test)[0]);
        System.out.println(even_0_odd_1_arr_count(test)[1]);
    }
}
