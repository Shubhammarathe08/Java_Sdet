package org.example.operators_assignment;

public class InstanceOf {

    /*
     instanceof operator is used to test >> whether an object is an instance of a specific class or interface.
     return type = boolean -> true/false

     *** to use instanceof, there should be some relation between the object and the class/interface being checked.
     ex. child > parent / parent > child / same class / same interface
     *** null instanceof ClassName >> false  | ALWAYS FALSE

     Object 0 = l.get(0);

     if(o instanceof Student) {
         Student s = (Student) o; // downcasting
         System.out.println(s.getName());
     }
     else if(o instanceof Teacher) {
         Teacher t = (Teacher) o; // downcasting
         System.out.println(t.getSubject());
     }


     Object           Runnable (I)

     Thread

     Thread t = new Thread();
     System.out.println(t instanceof Thread); // true
     System.out.println(t instanceof Runnable); // true
     System.out.println(t instanceof Object); // true


##########################################################################################################################################
         Bitwise operators  - >>, << , & , | , ^ , ~
         Negation operator  !  |  boolean only

         & - bitwise AND operator | both args should be true (boolean + integral) | both arg evaluation
         && - logical AND operator | both args should be true (boolean) | if one is true then other will be evaluated
         | - bitwise OR operator | at least one arg should be true (boolean + integral)  | both arg evaluation
         || - logical OR operator | at least one arg should be true (boolean) | if one is true then other will be evaluated
         ^ - bitwise XOR operator | true - both args differ | false - both args are same (boolean + integral)
         ! - logical NOT operator | inverts the boolean value of the operand (boolean )
         ~ - bitwise NOT operator | inverts the bits of the operand (integral)

         >> - right shift operator | shifts bits to the right
         << - left shift operator | shifts bits to the left

         System.out.println( 4 & 5); // 4 Apply logic to binary representation
         1 0 0
         1 0 1
         =======
         1 0 0  - 4
            System.out.println( 4 | 5); // 5
            System.out.println( 4 ^ 5); // 1
##########################################################################################################################################

       int x=10 ; int y=15;
       if( ++x<10  &  ++y>15){
       x++;
       }
       else{
       y++;
       }
       System.out.println(X+"..."+y);

       &     x=11 (11<10 false)  y=16 (16>15 true) y++| false  11 17
       &&    x=11 (11<10 false) y=15 y++| false  11 16
       |     x=11 (11<10 false)  y=16 (16>15 true) x++| true  12 16
       ||    x=11 (11<10 false)  y=16 (16>15 true) x++| true  12 16


       int x = 10;
       if( ++x<10  &&  (x/0) > 15){
           System.out.println("hello");
       }
       else{
           System.out.println("hi");
       }
       //output: hi
       ** if & instead of && then output will be:- RuntimeException: java.lang.ArithmeticException: / by zero







    */
}
