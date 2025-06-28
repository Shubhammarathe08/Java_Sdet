package org.example.interview.string;

import java.util.Arrays;
import java.util.Stack;

public class ArrayPrograms {

//        public static boolean areBracketsBalanced(String expression) {
//            Stack<Character> stack = new Stack<>();
//
//            for (char ch : expression.toCharArray())
//            {
//                if (ch == '(' || ch == '{' || ch == '[')
//                {
//                    stack.push(ch);
//                }
//                else if (ch == ')' || ch == '}' || ch == ']')
//                {
//                    if (stack.isEmpty())
//                    {
//                        return false; // Unmatched closing bracket
//                    }
//                    char top = stack.pop();
//                    if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '['))
//                    {
//                        return false; // Mismatched brackets
//                    }
//                }
//            }
//            return stack.isEmpty(); // True if all brackets are matched
//        }

        public static void main(String[] args) {
            String expr1 = "{[()]}";
            String expr2 = "([{}])";
            String expr3 = "{[(])}";
            String expr4 = "[[";

            int[] int_arr = {8,2,5,7,6,4,3,1}; // 8 index 7

            // sorting - bubble sort /
            for(int j=0; j<int_arr.length-1; j++) {
                for (int i = 0; i < int_arr.length - 1; i++) {
                    if (int_arr[i] > int_arr[i + 1]) {
                        int temp = int_arr[i];
                        int_arr[i] = int_arr[i + 1];
                        int_arr[i + 1] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(int_arr));

            // max and min - 1st max-min 2nd max-min
            int_arr = new int[]{5, 3, 2, 1, 4 ,8, 6, 7};
            int max_1 = 0; //3
            int max_2 = 0; //3
            int min_1 = 0; //3
            int min_2 = 0; //3
            for(int i=0; i<=int_arr.length-1; i++){
                if( int_arr[i] > max_1 ){
                    max_2 = max_1;
                    max_1 = int_arr[i];
                }
                else if( int_arr[i] > max_2 && int_arr[i] != max_1 ){
                    max_2 = int_arr[i];
                }
                if( int_arr[i] > min_1 ){
                    min_2 = min_1;
                    min_1 = int_arr[i];
                }
                else if( int_arr[i] < min_2 && int_arr[i] != min_1 ){
                    min_2 = int_arr[i];
                }

            }

            System.out.println(max_1+"<>"+max_2);
            System.out.println(min_1+"<>"+min_2);





        }

}
