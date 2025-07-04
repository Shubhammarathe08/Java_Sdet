package org.example.interview.string;

import java.util.Arrays;

public class CombineCharFrom2Str {

    static String my_method(String str){
        StringBuilder sb = new StringBuilder("");
        try {
            if(str!=null && !str.equals("") && str.equals("*")){ // null , "" , "*"
                System.out.println(">>>>");
                return ">>>>";
            }
            String[] t_arr = str.split("\\*"); //  12|  ,123|1 , 1|345  111|222
            if(t_arr.length!=2 || t_arr[0].length() != t_arr[1].length()){ //   123* , 12*3456
                System.out.println(">>>>");
                return "";
            }
            for(int i=0; i<=t_arr[0].length()-1; i++){
                sb.append(t_arr[0].charAt(i));
                sb.append(t_arr[1].charAt(i));
            }
            System.out.println(sb);
        }
        catch(Exception e) {
            System.out.println(" null caught ");
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        my_method(null);
        my_method("");
        my_method("*");
        my_method(" * ");
        my_method(" #*3 ");
        my_method(" 3*% ");
        my_method(" *123 ");
        my_method("123*");
        my_method("123*45");
        my_method("13*24");
    }
}
