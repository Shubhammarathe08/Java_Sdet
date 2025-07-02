package org.example.interview.general;

public class Prime_num {

    // normal java
    int num ;

    static  String is_prime_or_not(int num){   // 17 1...8
        for(int i=2; i<num/2; i++){
            if(num%i==0){
                return num+" >> Not Prime";
            }
        }
        return (num+" >> is_prime");
    }

    //using stream

    public static void main(String args[]) {
        System.out.println(is_prime_or_not(92));
        System.out.println(is_prime_or_not(37));
        System.out.println(is_prime_or_not(27));
    }
}

