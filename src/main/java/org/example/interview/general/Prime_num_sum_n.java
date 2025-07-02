package org.example.interview.general;

import java.util.ArrayList;
import java.util.List;

public class Prime_num_sum_n {

    static List<Integer> n_prime_no(int start, int end, int n_prime_no) {

        // % ,/ ,resetable cond in loops

        int num_count=0;
        List<Integer> li =new ArrayList<>();

        for(int j=start; j<=end; j++) {
             int num=j;
             boolean is_prime=true;

            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime == true && num_count<=n_prime_no) {
                li.add(num);
                num_count++;
            }
        }
        return li;
    }
    static int prime_num_sum(List<Integer> li){
        int res=0;
        for(Integer i:li){
            res = res+i;
        }
        return res;
    }

    public static void main(String[] args) {
       System.out.println(n_prime_no(1, 50,3)); // 1,3,5,7
        System.out.println( prime_num_sum(n_prime_no(1, 50,3))); // 1,3,5,7
    }
}
