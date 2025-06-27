package org.example.collection;

import java.util.*;

public class Cursors {

    /*
    get objects one by one from collection

    Enumeration
               >> only for legacy | stack, vector, Dictionary , Hashtable, Properties
               >> Enumeration e = obj.elements();
               >>  boolean e.hasMoreElements() , Object e.hasNextElement()
               >> no discard/remove , navigation  | only read access

    Iterator
              >> universal cursor [List, Set, Queue ]
              >> Iterator<String> itr2 =  str.iterator();
              >> boolean itr2.hasNext() , Object itr2.next() , void itr2.remove()
              >> can only move forward | unidirectional cursor
              >> read + remove | no add/replace present

    ListIterator
              >> only on List Object - List Classes [ArrayList, LinkedList,Stack,Vector]
              >> bidirectional cursor
              >> read , remove, add, replace - possible
              >> boolean itr2.hasNext() , Object itr2.next() ,  int itr2.nextIndex()
              >> boolean itr2.hasPrevious() , Object itr2.previous() ,  int itr2.previousIndex()
              >> void itr2.add(Object) , void itr2.remove(), void itr2.set(Object)



    */

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);


        List<String> str = new ArrayList<>();
        str.add("aaa");
        str.add("bbb");
        str.add("ccc");

        //enumeration
        Enumeration<Integer> e = s.elements();

        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        for (Integer i : s) {
            System.out.println(i);
        }
/*
        for(ElementType i:Expression){}
        expression should be iterable, Enumeration doesn't extends or implements iterable , sp foreach loop won't work

        Enumeration<String> e1 =  str.elements();
        java: cannot find symbol symbol:   method elements() location: variable str of type java.util.List<java.lang.String>
*/

//-------------------------------------------------------------------------------------------------------------------------
        //iterator
        Iterator<Integer> itr1 = s.iterator();
        Iterator<String> itr2 = str.iterator();


        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }

        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }

        for (String i : str) {
            System.out.println(i);
        }
//------------------------------------------------ ListIterator   -------------------------------------------

            //iterator
            ListIterator<Integer> list_itr1 = s.listIterator();
            ListIterator<String> list_itr2 = str.listIterator();


            while (list_itr1.hasNext()) {
                System.out.println(list_itr1.next());
                System.out.println(list_itr1.nextIndex());
            }

            while (list_itr2.hasNext()) {
                System.out.println(list_itr2.hasPrevious());
                System.out.println(list_itr2.previousIndex());
            }

        while (list_itr2.hasNext()) {
            String temp = (String)list_itr2.next();
            if( temp == "aaa"){
                list_itr2.add("AAA");
            }
            else if(temp == "bbb"){
                list_itr2.remove();
            }
            else if(temp == "ccc"){
                list_itr2.set("CAT");
            }
        }

        System.out.println(str.toString());

            for (String j : str) {
                System.out.println(j);
            }
//---------------------------------------------------------------------------------------------------------------------

    }
}
