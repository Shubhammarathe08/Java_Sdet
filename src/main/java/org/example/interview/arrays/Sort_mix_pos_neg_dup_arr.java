package org.example.interview.arrays;

import java.util.Arrays;

public class Sort_mix_pos_neg_dup_arr {

    public static void main(String[] args){
        // int_arr = {-4, 3, 8, -4, 1, 2, 5, -3, -1, 0, 1};
        int[] input_arr = {-4, 3, 8, -4, 1, 2, 5, -3, -1, 0, 1};
        // remove duplicate
        int ele = 0;
        int unique =0;
        for(int j=0; j<input_arr.length-1; j++){
            for(int i=0; i<input_arr.length-1; i++){  // 2 3
                if(input_arr[i]>input_arr[i+1]){
                    int temp = input_arr[i];
                    input_arr[i] = input_arr[i+1];
                    input_arr[i+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(input_arr));
        int req = input_arr[3];
        System.out.println(req);
//-------------------------------------------------------------
    }

}
