package org.example.interview.string;

import java.util.regex.*;

public class Pattern_matcher {

    static int matched_pattern_count(String str,String pattern){
        Pattern pat = Pattern.compile(pattern);
        Matcher m = pat.matcher(str);
        int count=0;
        while(m.find()){
            count++;
        }
    return count;
    }
    public static void main(String[] args){
        String ip = "11Hdns&53211ff11f"; //pattern = 11 count ??
        System.out.println( matched_pattern_count(ip,"11") );
    }
}
