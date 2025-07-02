package org.example.interview.dsa;

import java.util.Arrays;

public class Arr_sort_bubble {

    static int[] sort_arr_bubble(int[] input){
        for(int j=0; j<input.length-1; j++) {
            for (int i = 0; i < input.length - 1; i++) { // 5, 3, 2, 6, 1, 4 - 6
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }
            }
        }
        return input;
    }

    public static void main(String[] args){
        int[] input = { 5, 3, 2, 6, 1, 4 };
        System.out.println( Arrays.toString( sort_arr_bubble(input) ));
    }
}
