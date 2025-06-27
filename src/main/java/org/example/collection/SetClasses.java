package org.example.collection;

import java.util.*;

public class SetClasses {

    public static void main(String[] args){

        Set<Integer> s1 = new HashSet<>();
        // default capacity - 16
        // load factor/fill ratio - 0.75 **once up to this is filled , create new Object

        Set<Integer> s2 = new HashSet<>(1000);
        // initial capacity - 1000
        // load factor/fill ratio - 0.75 **once up to this is filled , create new Object

        Set<Integer> s3 = new HashSet<>(1000, 25);
        // initial capacity - 1000
        // custom load factor/fill ratio - 0.25 **once up to this is filled , create new Object

        Set<Integer> s4 = new HashSet<>(new ArrayList<>());
        // convert any collection to set
//---------------------------------------------------------------

        TreeSet<Integer> tr_set = new TreeSet();
        // default natural sorting order

        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        TreeSet<Integer> tr_set1 = new TreeSet(c);
        // custom sorting order specified by comparator object


        TreeSet<Integer> tr_set2 = new TreeSet(new HashSet<>());
        // conversion from collection to sorted set
             tr_set2.add(7);
             tr_set2.add(5);
             tr_set2.add(11);

             // compareTo(Object)  obj1.compareTo(obj2)

        SortedSet s = null;
        TreeSet<Integer> tr_set3 = new TreeSet(s);
        // conversion from collection to sorted set - based on s sorting order


    }
}
