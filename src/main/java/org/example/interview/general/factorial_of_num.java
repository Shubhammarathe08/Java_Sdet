package org.example.interview.general;

public class factorial_of_num {

    static int res = 1;

    // normal w/o recursion
    static  int without_recursion_factorial(int num){
        // 5 4 3 2 1 = 120
        while(num >=1 ){
            res = res*num;
            num--;
        }
        return res;
    }

    // normal with recursion
    static  int recursion_factorial(int num){
        // 5 4 3 2 1 = 120
        if(num>1){
            return num * recursion_factorial(num-1); // 5*4*3*2*1
        }
        else{
            return 1;
        }

    }

    // use streams
    public static void main(String args[]) {
        System.out.println(without_recursion_factorial(5));
        System.out.println(recursion_factorial(5));
    }
}
