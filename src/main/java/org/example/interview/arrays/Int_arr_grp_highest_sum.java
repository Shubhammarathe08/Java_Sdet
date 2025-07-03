package org.example.interview.arrays;

import java.util.Arrays;

public class Int_arr_grp_highest_sum {
    static int sort_grp_max(int[] ip, int grp_into){
        for(int j=0; j<ip.length-1; j++) {
            for (int i = 0; i < ip.length - 1; i++) {
                if (ip[i] > ip[i + 1]) {
                    int temp = ip[i];
                    ip[i] = ip[i + 1];
                    ip[i + 1] = temp;
                }
            }
        }
        System.out.println( Arrays.toString(ip) );
        int sum=0;
        for(int i=ip.length-grp_into; i<=ip.length-1;i++){
            sum = sum + ip[i];
        }
        return sum;
    }
    public static void main(String[] args){
        int[] ip = {10,1000,20,5,30,2000,6,3000,7};
        System.out.println( sort_grp_max(ip,2) );

 //================================================================
    }
}
