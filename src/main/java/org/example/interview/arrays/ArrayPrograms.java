package org.example.interview.arrays;

import java.util.Arrays;

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
            int[] int_arr1 = {8, 3, 2, 1, 4, 1, 6, 7};

            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;


            for(int i=0; i<int_arr1.length; i++ ){  // {8, 3, 2, 1, 4, 5, 6, 7};
                // 2 brother assume same age =0,0 |
                // priority to who came first max1 >> if found big assign to max1 brother
                // next if found smaller than big , assign to smaller brother
                // check every person who claims he is 2nd big
                // if not check with younger ones | is anybody claiming to be second ?- replace if found true
                if(int_arr1[i]>max1){
                    max2 = max1; // 0
                    max1 = int_arr1[i]; // 8
                }
                else if(int_arr1[i]!=max1 && int_arr1[i]>max2){
                    max2=int_arr1[i];
                }

                // 2 brother assume same age =0,0 |
                // priority to who came first min1 >> if found smaller assign to min1 brother
                // next if found bigger than smaller , assign to smaller brother
                // check every person who claims he is 2nd small
                // if not check with older ones | is anybody claiming to be second ?- replace if found true
                if(int_arr1[i]<min1){ // {8, 3, 2, 1, 4, 5, 6, 7};
                    min2 = min1; // 1000
                    min1 = int_arr1[i]; // 5 3 2 1
                }
                else if(int_arr1[i]!=min1 &&  int_arr1[i]<min2)
                {
                    min2 = int_arr1[i]; // 5 3 2
                }
            }

            System.out.println("Max1: " + max1);
            System.out.println("Max2: " + max2);
            System.out.println("Min1: " + min1);
            System.out.println("Min2: " + min2);
//----------------------------------------------------------------------------------------------------------

            // sort array {0100011001}
            // check brackets [{{}}]()
            // left shift {01020} - {001020}
            // right shift {01020} - {10200}
            // fins biggest substring - non-repeating
            // permutation and combination

        }

}
