package org.example.interview.arrays;

import java.lang.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Java program to find the length of the longest
// substring without repeating characters


class GfG {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If closing bracket, check for matching
            else if (c == ')' || c == '}' || c == ']') {
                // If stack empty or mismatch, invalid
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatching(top, c)) {
                    return false;
                }
            }
        }

        // If stack is empty at end, balanced
        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String brac_1 = "([{}])";
        String brac_2 = "(]";

        System.out.println(brac_1 + " is balanced? " + isValid(brac_1));
        System.out.println(brac_2 + " is balanced? " + isValid(brac_2));
    }
}