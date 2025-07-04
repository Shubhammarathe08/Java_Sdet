package org.example.interview.string;

import java.util.Stack;

public class To_remove_extra_bracket {
    static int count_to_remove(String input) {
        Stack<Character> my_stack = new Stack<>();
        int to_remove = 0;
        for (Character c : input.toCharArray()) {
            if (c == '(') {
                my_stack.push(c);
            }
            if (c == ')') {
                if (my_stack.isEmpty()) {   //{[(}
                    to_remove++;
                }
                char popped;
                if (!my_stack.isEmpty()) {
                    popped = my_stack.pop();
                }
            }
        }
        System.out.println(my_stack.size() + " >> " + to_remove);
        System.out.println(Math.max(my_stack.size(), to_remove));
        return Math.max(my_stack.size(), to_remove);
    }


    public static void main(String[] args) {
        String brac_1 = "([{}])"; //6
        String brac_2 = "([)}]{"; //6
        String brac_3 = "(()))"; //6
        String brac_4 = "(()())((("; //3
        String brac_5 = "(()("; //
        String brac_6 = ""; //6
        String brac_7 = ")))()"; //3
        String brac_8 = ")())"; //6

        // brac_4 -   (()())(((   stack.length=3 | to_remove=0
        // brac_7 -    )))()     stack.length=0  | to_remove=3
        // brac_5 = "(()(";  stack.length=2  | to_remove=0
         count_to_remove(brac_4);
         count_to_remove(brac_5);
         count_to_remove(brac_7);
         count_to_remove(brac_8);

//----------------------------------------------------------------------------------------------------
    }
    //---------------------------------
}
