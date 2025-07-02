package org.example.interview.arrays;

import java.util.Arrays;

public class Max_Min_Array {

    static String[] max_min(int[] input){
        String[] temp = new String[4]; // 5, 2, 9, 1, 6, 3
        int min_1=Integer.MAX_VALUE;
        int min_2=Integer.MAX_VALUE;
        int max_1=Integer.MIN_VALUE;
        int max_2=Integer.MIN_VALUE;
        for(Integer ele:input){
            if((int)ele > max_1){
                max_2 = max_1;
                max_1 = (int)ele;
            }
            else if((int)ele != max_1 && (int)ele>max_2 )
            {
                max_2 = (int)ele;
            }
            if((int)ele < min_1){
                min_2 = min_1;
                min_1 = (int)ele;
            }
            else if((int)ele != min_1 && (int)ele<min_2 )
            {
                min_2 = (int)ele;
            }
        }
        temp[0] = min_1+" >> min";
        temp[1] = min_2+" >> second min";
        temp[2] = max_1+" >> max";
        temp[3] = max_2+" >> second max";
        return temp;
    }
    public static void main(String[] args){
        int[] array = {5, 2, 9, 1, 6, 3};
        System.out.println(Arrays.toString(max_min(array)));
    }
}
