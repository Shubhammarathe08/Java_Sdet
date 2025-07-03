package org.example.interview.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Rev_list {

    public static void main(String[] args){

        ArrayList<Integer> li = new ArrayList<>();
        li.addAll(Arrays.asList(5,3,7,4,6,1,2,8));
        // cant use lambda function its not functional interface
        Comparable c = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

        Comparator c1 = (o1,  o2)->  (int)o1-(int)o2;
        Comparator c2 = (o1,  o2)->  (int)o2-(int)o1;
        Collections.sort(li);
        System.out.println(li);
        Collections.sort(li,c1);
        System.out.println(li);
        Collections.sort(li,c2);
        System.out.println(li);

        ArrayList<String> str_li = new ArrayList<>();
        str_li.addAll(Arrays.asList("test","my","patience","you","will","know"));

        Comparator str_c1 = (Object o1,  Object o2)->  ((String)o1).compareTo((String)o2);
        Comparator str_c2 = (Object o1,  Object o2)->  ((String)o2).compareTo((String)o1);
        Collections.sort(str_li);
          System.out.println(str_li);
        Collections.sort(str_li,str_c1);
        System.out.println(str_li);
        Collections.sort(str_li,str_c2);
        System.out.println(str_li);
    }
}
