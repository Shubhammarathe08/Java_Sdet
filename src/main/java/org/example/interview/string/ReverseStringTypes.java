package org.example.interview.string;

import java.util.Arrays;

public class ReverseStringTypes {

    // str =   " test my skill "
    // str =   "   test  my    skill "

    /*
   static String s1 = "How are you";
    // result: "you are How";
	    String[] temp = s1.split(" "); // how, are, you  you"" are"" how // 0 1 2 3
	    for(int i=temp.length-1; i>=0; i--){
	        System.out.print(temp[i]);
	        if(i>0){ System.out.print(" ");}
	    }
 */

    static String rev_str_with_spaces(String ip){
        String temp = "";
        String[] temp_arr =  ip.trim().split("\\s+");
        System.out.println(Arrays.toString(temp_arr));
        for(int i=temp_arr.length-1; i>=0; i--){
            temp = temp+temp_arr[i];
            if(i!=0){
                temp = temp+" ";
            }
        }
        System.out.println(temp);
        return temp;
    }

    public static void main(String[] rags){
         String ip = "   my new home    is too               far  ";
         // "far too is home new my"
        rev_str_with_spaces(ip);


    }
}
