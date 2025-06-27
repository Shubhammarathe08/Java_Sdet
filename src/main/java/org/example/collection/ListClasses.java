package org.example.collection;


import java.util.*;

public class ListClasses {

    public static void main(String[] args){

        List<String> l = new ArrayList<>();
        // empty default 10 , next (curr *3/2)+1

        List<Object> l1 = new ArrayList<Object>(1000);
        // initial capacity passed through constructor >> 1000

        List<Object> l2 = new ArrayList<>(new ArrayList<>());
        // equivalent List obj for given collection

        System.out.println(l); // []


        // synchronised
        ArrayList<Integer> al = new ArrayList<>();
        Collections.synchronizedList(al);
//-------------------------------------    Linked List   ---------------------------------------------------------

        List<Integer> ll1 = new LinkedList();
        // empty default 10 , next (curr *3/2)+1

        LinkedList<Integer> ll2 = new LinkedList(new LinkedList<>());
        // equivalent linked list obj for given collection
        ll2.addFirst(1);

//----------------------------------------   Array Based Stack/Queue   ---------------------------------------------
//----------------------------------------   LinkedList Based Stack/Queue   ---------------------------------------------
       //  stack >>LIFO , queue >>FIFO
//----------------------------------------   Vector  ---------------------------------------------

        Vector<Integer> v1 = new Vector<Integer>();
        // initial cap = 10 , new capacity = curr*2

        List<Integer> v2 = new Vector<>(1000);
        // initial custom cap = 1000 , new capacity = curr*2

        List<Integer> v21 = new Vector<>(1000 ,10);
        // initial custom cap = 1000 , new capacity = curr*10

        Vector<Integer> v3 = new Vector<>(new Vector<>());
        // equivalent vector object for given collection

//----------------------------------------   Stack  ---------------------------------------------

        Stack<Integer> i1 = new Stack<>();











    }
}
