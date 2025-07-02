package org.example.interview.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

    static boolean matching(char out_char, char to_compare) {
        if (out_char == '(' && to_compare == ')'
                || out_char == '{' && to_compare == '}'
                || out_char == '[' && to_compare == ']') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        int[] int_arr = {8, 2, 5, 7, 6, 4, 3, 1}; // 8 index 7
        // sorting - bubble sort /
        for (int j = 0; j < int_arr.length - 1; j++) {
            for (int i = 0; i < int_arr.length - 1; i++) {
                if (int_arr[i] > int_arr[i + 1]) {
                    int temp = int_arr[i];
                    int_arr[i] = int_arr[i + 1];
                    int_arr[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(int_arr));
//-------------------------------------------------------------------------------------------------------------------
        // max and min - 1st max-min 2nd max-min
        int[] int_arr1 = {8, 3, 2, 1, 4, 1, 6, 7};

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;


        for (int i = 0; i < int_arr1.length; i++) {  // {8, 3, 2, 1, 4, 5, 6, 7};
            // 2 brother assume same age =0,0 |
            // priority to who came first max1 >> if found big assign to max1 brother
            // next if found smaller than big , assign to smaller brother
            // check every person who claims he is 2nd big
            // if not check with younger ones | is anybody claiming to be second ?- replace if found true
            if (int_arr1[i] > max1) {
                max2 = max1; // 0
                max1 = int_arr1[i]; // 8
            } else if (int_arr1[i] != max1 && int_arr1[i] > max2) {
                max2 = int_arr1[i];
            }

            // 2 brother assume same age =0,0 |
            // priority to who came first min1 >> if found smaller assign to min1 brother
            // next if found bigger than smaller , assign to smaller brother
            // check every person who claims he is 2nd small
            // if not check with older ones | is anybody claiming to be second ?- replace if found true
            if (int_arr1[i] < min1) { // {8, 3, 2, 1, 4, 5, 6, 7};
                min2 = min1; // 1000
                min1 = int_arr1[i]; // 5 3 2 1
            } else if (int_arr1[i] != min1 && int_arr1[i] < min2) {
                min2 = int_arr1[i]; // 5 3 2
            }
        }

        System.out.println("Max1: " + max1);
        System.out.println("Max2: " + max2);
        System.out.println("Min1: " + min1);
        System.out.println("Min2: " + min2);
//----------------------------------------------------------------------------------------------------------
        // find the biggest substring - non-repeating
        String ip_str1 = "geeksforgeeks"; // 0-2 2-9
        int start = 0; // minus 0 ,2 , 3 , 4 ,4 //table
        int max_len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < ip_str1.length(); end++) {
            System.out.println("end >>" + end);
            char c = ip_str1.charAt(end);
            System.out.println("char >>" + c);
            if (map.containsKey(c) && map.get(c) >= start) {
                System.out.println("start before >>" + start);
                start = map.get(c) + 1;
                System.out.println("start after >>" + start);
            }
            map.put(c, end); //start=3 e=10
            System.out.println("entry >>" + map);
            System.out.println("len before >>" + max_len);
            max_len = Math.max(max_len, end - start + 1);
            System.out.println("len after >>" + max_len);

        }
        System.out.println(max_len);
//----------------------------------------------------------------------------------------------------------------------
        String brac_1 = "([{}])"; //6
        String brac_2 = "([)}]{"; //6

        boolean is_balanced = true;
        Stack<Character> ss = new Stack<>();

        for (Character c : brac_1.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                ss.push(c);
            } else {
                if (ss.isEmpty()) {
                    is_balanced = false;
                    break;
                }
                char out_char = ss.pop();
                if (!matching(out_char, c)) {
                    is_balanced = false;
                    break;
                }
            }
        }

        if (is_balanced == true) {
            System.out.println("balanced");
        } else {
            System.out.println("NOT balanced");
        }

//----------------------------------------------------------------------------------------------------------------------
        int num = 123456; // "123456"
        String res = "";
        System.out.println(num + "");
        for (int i = (num + "").length() - 1; i >= 0; i--) {
            res = res + (num + "").charAt(i) + "";
        }
        int rev_num_str = Integer.parseInt(res);
        System.out.println(rev_num_str);
        System.out.println(((Object) rev_num_str).getClass().getName());

        int quotient = num;
        int remainder = 0; //123456
        int rev_num = 0;

        while (num != 0) {
            remainder = num % 10; //6
            rev_num = (rev_num * 10) + remainder;//
            quotient = num / 10;
            num = quotient;
        }
        System.out.println("rev >>" + rev_num);
    }
}
