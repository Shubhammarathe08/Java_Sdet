package org.example.interview.string;

import java.util.Arrays;

public class ReverseExceptFixedPart {


        static String input = "HelloworlD";//10
        public static void main(String[] args) {

            String pivot = "ow";
            String rev = "";
            String[] temp = input.replace(pivot," ").split(" ");
            System.out.println(Arrays.toString(temp));
            for(int i=temp[0].length()-1; i>=0; i--){
                rev = rev + temp[0].charAt(i);
            }
            rev = rev + pivot;
            for(int i=temp[1].length()-1; i>=0; i--){
                rev = rev + temp[1].charAt(i);
            }
            System.out.println(rev);

        }
}
