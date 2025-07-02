package org.example.interview.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class String_duplicate_char {

    public static void main(String[] args){
        // repeated character
        String str5 = "The Tea is Totally Fine";

        HashMap<Character, Integer> hmap1 = new HashMap<>();

        for(int i=0; i<=str5.length()-1; i++){
            Character temp = (Character) str5.charAt(i);
            if(hmap1.containsKey(temp)){
                hmap1.put(temp,hmap1.get(temp)+1);
            }
            else{
                hmap1.put(temp,1);
            }
        }

        for(Map.Entry<Character, Integer> xx :hmap1.entrySet()){
            if( xx.getValue()>1) {
                System.out.println(xx);
            }
        }

        Set<Map.Entry<Character,Integer>> entry = hmap1.entrySet();
        Iterator<Map.Entry<Character,Integer>> itr = entry.iterator();

        while(itr.hasNext()){
            Map.Entry<Character,Integer> t = itr.next();
            if(t.getValue()>1) {
                System.out.println(t);
            }
        }
        System.out.println(hmap1);

    }
}
