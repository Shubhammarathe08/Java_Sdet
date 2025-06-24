package org.example.flow_control;

public class WhileDoWhile {

    /*

      while (boolean expression) {
          // code block to be executed, actions to be repeated
      }

      while (rs.next()) result set |  while (e.hasMoreElements() enumeration |  while (itr.hasNext()) iterator
      // when u don't know iteration in advance

        do {
            // first time mamdatory code block to be executed, after than it should pass condition in while
        } while (boolean expression);
     // do while is used when you want to execute the code block at least once, even if the condition is false

        while(true)
            System.out.println("test");

        do
        while (true);

        do
        System.out.println("test");
        while (true);

        do
           while()
             System.out.println("test");
        while (true)

        do
        int x = 10;
        while (true); //not allowed

        // only 1 statement allowed in the block without curly braces , statement should not be declarative

        // compiler checks , boolean expression -
        if its always true - infinite loop + no chance of next statements to executed
        if it is always false  - no chance of entering the loop
        *** Throws compile time error => unreachable code

        while(true) {
            System.out.println("in loop");
        }
        System.out.println("after");
        //unreachable code

        while(false) {
            System.out.println("in loop");
        }
        System.out.println("after");
        //unreachable code


        final int a = 5, b = 10; // its final and always true
         while(a < b) {
            System.out.println("in loop");
        }
        System.out.println("after");
        //unreachable code

         final int a = 5, b = 10; // its final and never going to be true
         while(a > b) {
            System.out.println("in loop");
        }
        System.out.println("after");
        //unreachable code


        / every final var , will; be replaced by val , at compile time only
        final int a =10, c=30;
        int b = 30;
        Sop(10)
        Sop(b)
        Sop(a,b) => Sop(true)


        do {
            System.out.println("in loop");
        } while(true);
        System.out.println("after"); // unreachable code => after

         do {
            System.out.println("in loop");
        } while(false);
        System.out.println("after"); // op: in loop, after

        final int a = 5, b = 10; // its final and always true
        do {
            System.out.println("in loop");
        } while( a<b );
        System.out.println("after"); //  unreachable code => after

        final int a = 5, b = 10; // its final and always true
        do {
            System.out.println("in loop");
        } while( a>b );
        System.out.println("after"); //  in loop , after

        // unreachable code => after

        int a = 5, b = 10; // its final and always true
        do {
            System.out.println("in loop");
        } while( a<b );
        System.out.println("after"); //  infinite loop - in loop

        int a = 5, b = 10; // its final and always true
        do {
            System.out.println("in loop");
        } while( a>b );
        System.out.println("after"); // in loop, after

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    */

    public static void main(String[] args) {


        int a = 5 , b = 10;
        while(a > b) {
            System.out.println("First");
        }
        System.out.println("Second");

    // infinite loop example
        while(a > b) {
            System.out.println("First");
        }
        System.out.println("Second");

        while (true){
            System.out.println("test");
        }




    }


}
