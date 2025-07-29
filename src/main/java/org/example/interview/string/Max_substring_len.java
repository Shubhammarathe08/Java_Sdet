package org.example.interview.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class Max_substring_len {

    static int non_rpeat_max_sub_str(String ip_str1) {
        //geeksforgeeks
        int max_len=0;
        int start=0;
        Map<Character,Integer> my_map = new LinkedHashMap<>();
        for(int end=0; end<ip_str1.length(); end++)
        {
           if(my_map.containsKey(ip_str1.charAt(end))  &&  my_map.get(ip_str1.charAt(end)) >=start )
            {
               start = end;
           }
            my_map.put(ip_str1.charAt(end),end);
            max_len = Integer.max( (end-start+1) ,  max_len );
        }

        return max_len;
    }

    public static void main(String[] args) {
        String ip_str1 = "geeksforgeeks";
        System.out.println(non_rpeat_max_sub_str(ip_str1));
    }
}


