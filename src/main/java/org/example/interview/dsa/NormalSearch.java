package org.example.interview.dsa;

public class NormalSearch {

    static String search_no_index(int[] input, int num_to_search){
        for(int i=0; i<input.length-1; i ++){
            if(input[i] == num_to_search){
                return input[i]+" >> at index "+i;
            }
        }
        return "num not found";
    }
    public static void main(String[] args) {
        int[] input = {9, 4, 8, 5, 3, 7, 1, 6, 2, 10};
        System.out.println( search_no_index(input,1) );
    }
}
