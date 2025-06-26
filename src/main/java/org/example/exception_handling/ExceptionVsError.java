package org.example.exception_handling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExceptionVsError {
     /*
         only 1 Thread >> main
         doMoreStuff() - Hello       XX remove once hello is printed
         doStuff()                   XX remove no other code to execute
         main()                      XX remove no other code to execute
      ------------------------------
      (every row -activation record/ stack frame)
      Runtime Stack \
      Before terminating Thread main , empty stack destroyed

     * */

    public static void main(String[] args) throws FileNotFoundException {
        doStuff();

    }

    public static void doStuff() throws FileNotFoundException {
        doMoreStuff();
    }

    public static void doMoreStuff() throws FileNotFoundException {
        System.out.println("hello");
        System.out.println(10/0);

        PrintWriter pw = new PrintWriter("hello.txt");
    }



}
