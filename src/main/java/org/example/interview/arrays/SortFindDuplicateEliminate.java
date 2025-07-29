package org.example.interview.arrays;

import java.util.Arrays;

public class SortFindDuplicateEliminate {

    public static void main(String[] args){

        int[] input = { 0, -1 , 4, 1, -2, 0, 5, -3, 2, 3, -1};
        //sort, find duplicate, remove it
        int duplicate=0;
        int org_arr_len=input.length;
        for(int o=0; o<org_arr_len; o++) {
            for (int i = 0; i < org_arr_len - 1; i++) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }
            }
        }
    System.out.println(Arrays.toString(input));
        for(int k=0; k<org_arr_len - 1; k++){
            if(input[k]==input[k+1]){
                duplicate++;
                System.out.println(input[k+1]);
            }
        }
        int unique_int_arr_len=input.length-duplicate;
        System.out.println(" Duplicate ele > "+duplicate+" Unique arr len >"+unique_int_arr_len);

        int[] unique_int = new int[unique_int_arr_len];
        int counter  = 0;
        for(int k=0; k<=org_arr_len-1; k++){
            if( k<org_arr_len-1 && input[k]==input[k+1]){
             continue;
            }
            else if(k<org_arr_len-1)
            {
                unique_int[counter] = input[k];// 0>-3 1>-2 2>-1
                counter++;
            }
            else if (k==org_arr_len-1){
                unique_int[counter] = input[k];// 0>-3 1>-2 2>-1
                counter++;
            }
        }

        System.out.println(Arrays.toString(unique_int));
//--------------------------------------------------------------------------
    }
}
