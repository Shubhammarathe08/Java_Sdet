package org.example.interview.dsa;

public class BinarySearch {

    static String binary_search_no_index(int[] input, int num_to_search){
         // keep 2 pointers and shift
        // calculate mid every loop

        int left =0;
        int right =input.length-1;

        while(left<=right) {
            int mid =left+right/2;
            if (input[mid] == num_to_search) {
                return "num found at >> " + mid;
            } else if (input[mid] > num_to_search) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return "num not found";
    }
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        System.out.println( binary_search_no_index(input,10) );

        /*
           L   M    R
           L   R
               L    R

         shift index to
        */
    }
}
