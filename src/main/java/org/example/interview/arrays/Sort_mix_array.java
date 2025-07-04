package org.example.interview.arrays;

public class Sort_mix_array {

        // lowest 4th num >>no sort+collection
        public static void main(String[] args) {
            int[] input_arr = {1,3,5,6,2,4};  // 4th ele
            int[] input_arr1 = {-8,1,3,-5,6,2,-4}; // 4th ele

            for(int j=0; j<input_arr.length-1; j++){
                for(int i=0; i<input_arr.length-1; i++){  // 2 3
                    if(input_arr[i]>input_arr[i+1]){
                        int temp = input_arr[i];
                        input_arr[i] = input_arr[i+1];
                        input_arr[i+1] = temp;
                    }
                }
            }
            int req = input_arr[3];
            System.out.println(req);
//----------------------------------------------
    }

}
