package org.example.interview.streams;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Predicate_example {

    /*
      Functional Interface
      -> max 1 abstract method
      -> can have rest default, static | more than 1

      Represents a predicate (boolean-valued function) of one argument.

      to check - true/false
      holds condition
      <T> any type of object - input to the predicate
      t - arg var

      boolean test(T t);
    */

    public static void main(String[] args){

        Predicate p;

        Predicate<String> p1 = (a) -> a.startsWith("A");
        BiPredicate<Integer,Integer> p2 = (a, b) -> a>=b;


    }
}
