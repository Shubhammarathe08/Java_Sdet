package org.example.interview.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Vowel_count_str {

    static void return_vowel_count_sensitive(String str){
        HashMap<Character,Integer> hmap = new LinkedHashMap<>();
        for(Character ele:str.toCharArray()){
            if(hmap.containsKey(ele)){
                hmap.put(ele,hmap.get(ele)+1);
            }
            else{
                hmap.put(ele,1);
            }
        }
        for(Map.Entry<Character,Integer> ele:hmap.entrySet()){
            if(ele.getKey()=='a'
               || ele.getKey()=='e'
               || ele.getKey()=='i'
               || ele.getKey()=='o'
               || ele.getKey()=='u'){
                System.out.print(ele+" ");
            }
        }
    }
    //----------------------------------------------------------------------------

    static void return_vowel_count_in_sensitive(String str1) {
        HashMap<Character, Integer> hmap1 = new LinkedHashMap<>();
        for (Character ele : str1.toLowerCase().toCharArray()) {
            if (hmap1.containsKey(ele)) {
                hmap1.put(ele, hmap1.get(ele) + 1);
            } else {
                hmap1.put(ele, 1);
            }
        }
        for (Map.Entry<Character, Integer> ele : hmap1.entrySet()) {
            if (ele.getKey() == 'a'
                    || ele.getKey() == 'e'
                    || ele.getKey() == 'i'
                    || ele.getKey() == 'o'
                    || ele.getKey() == 'o'
                    || ele.getKey() == 'u') {
                System.out.print(ele + " ");
            }
        }
    }
//------------------------------------------------------------------------------
public static void main(String[] args){
    // " Try @ Programming Io Website "  - case sensitive
    // " Oooo! thats really great... " - case in sensitive
    return_vowel_count_sensitive(" Try @ Programming Io Website ");
    System.out.println();
    return_vowel_count_sensitive(" OooO! thats really great... ");

    System.out.println();

    return_vowel_count_in_sensitive(" Try @ Programming Io Website ");
    System.out.println();
    return_vowel_count_in_sensitive(" OooO! thats really great... ");
}
}
