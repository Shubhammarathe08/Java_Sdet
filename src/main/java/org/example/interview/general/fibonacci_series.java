package org.example.interview.general;

import java.util.Arrays;

public class fibonacci_series {


    static int prev=0;
    static int curr=1;
    static int next;

    // normal w/o recursion
    static  int[] fibonacci(int ele){   // 0 1 1 2 3 5 8
        int[] temp = new int[ele+2];
        temp[0] =prev;
        temp[1] =curr;
        for(int i=2; i<temp.length; i++){
            next = prev + curr;
            prev = curr;
            curr = next;
            temp[i] = next;
        }
        return temp;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(fibonacci(5)));
    }
}
