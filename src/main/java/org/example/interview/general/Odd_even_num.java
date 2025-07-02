package org.example.interview.general;

public class Odd_even_num {
    //normal
    int num ;

    static void is_odd_even(int num){
        if(num%2==0){
            System.out.println(num+" >> even");
        }
        else{
            System.out.println(num+" >> odd");
        }
    }

     //using streams

    // using lambda

    public static void main(String args[]) {
        is_odd_even(11);
        is_odd_even(24);
    }


}
