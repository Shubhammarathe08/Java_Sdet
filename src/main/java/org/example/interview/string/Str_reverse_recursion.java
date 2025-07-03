package org.example.interview.string;

public class Str_reverse_recursion {

    static String str_rev_recurse(String ip){  // t o o l s  | sloot
           if(ip.length()>0){
               int letter = ip.length()-1;
               String temp = ip.substring(0,ip.length()-1);//tool
               return ""+ip.charAt(letter)+str_rev_recurse(temp);
           }else{
               return "";
           }
    }
    public static void main(String[] args){
        String ip ="ToolS"; //
        System.out.println( str_rev_recurse("tools") );
    }
}
