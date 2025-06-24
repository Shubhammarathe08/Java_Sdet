package org.example.operators_assignment;

public class StringConcatenationOperators {

    /*
     Only Overloaded operator in java >> +
     int + int = sum
     string + string = concatenation
     ** if one of the operands is a string, the other operand is converted to a string and concatenated

     "a" + "b" = "ab"
     10 + 20 = 30
     "a" + 10 = "a10"
     10 +20 + "b" = "30b"
================================================================================================================

    relational operators >>, >, <, >=, <=
    *** Except -
    1. boolean can be applied to every primitive type
    2. object type ex. "durga" > "durga" //compile time error
    3. nesting of relational operators NOT ALLOWED | 10 <20 <30 // compile time error |  true ,30
        System.out.println("a" > "a"); // true
        System.out.println(10 < 20); // true
        System.out.println('a' < 20); // false
        System.out.println('a' > 'A'); // true
================================================================================================================

   equality operators

   *** Applicable for every primitive type
                  for object type
                  *** Some relation should be there >> parent-child, same class, same interface
                  1. r1 == r2  // true if both refer to same object , same address , reference comparison
                  Thread t1 = new Thread();
                  Thread t2 = new Thread();
                  t3 = t1
                  t1 == t2 // false
                  t1 == t3 // true
=================================================================================================================

 Reference Comparison | ==  >>    System.out.println("a" == "a"); // true
 Content Comparison | .eqauls() >>  System.out.println("a".equals("a")); // true

    String s1 = new String("durga");
    String s2 = new String("durga");

    System.out.println(s1 == s2); // false (reference comparison)
    System.out.println(s1.equals(s2)); // true (content comparison)

    nul == null >> always true

    *** .eqauls() at one place >> meant for reference comparison where ? ->


        System.out.println(10 == 20); // false
        System.out.println('a' == 'b'); // false
        System.out.println('a' == 97.0; // true
        System.out.println(false == false); // true








    */
}
