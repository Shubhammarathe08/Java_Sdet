package org.example.interview.string;

import java.util.Stack;

public class Brackets_checking {

     static boolean is_matched(char popped, char curr_ele){
         if( popped=='(' && curr_ele==')' ||
                 popped=='{' && curr_ele=='}' ||
                 popped=='[' && curr_ele==']'){
             return true;
         }
         else{
             return false;
         }
     }

     static boolean is_balanced(String str){
         // ([{ }])   // }])   // }[]()  // (())  // ({   // [)
         Stack<Character> temp_stack = new Stack<>();
         for(Character curr_ele : str.toCharArray()){
             if(curr_ele=='(' || curr_ele=='{' || curr_ele=='['){
                 temp_stack.push(curr_ele); // ( [ {
             }
             else if(temp_stack.isEmpty()){   // }
                 return false;
             }
             else{
                 char popped_ele = temp_stack.pop(); // [ )
                  if(!is_matched(popped_ele,curr_ele)){
                      return false;
                  }
             }
         }
         System.out.println(temp_stack.size()+" << size "+str);
         return true;
     }
     // ) } ]

    public static void main(String[] args) {
        String brac_1 = "([{}])"; //6
        String brac_2 = "([)}]{"; //6
        String brac_3 = ""; //6

        is_balanced("([{}])");
        is_balanced("([)}]{");
        is_balanced("");




    }
}
