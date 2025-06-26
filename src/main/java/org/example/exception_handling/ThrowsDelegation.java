package org.example.exception_handling;

public class ThrowsDelegation {

    /*
    doMuchMuchMoreStuff() asks caller doMoreStuff() to handle - Throws
    doMuchMoreStuff() asks caller doStuff() to handle - Throws
    doStuff() asks caller main() to handle - Throws
    main() asks caller JVM to handle - Throws
    */

    public static void main(String[] args) throws InterruptedException {
        doStuff();
    }

    static void doStuff() throws InterruptedException {
         doMoreStuff();
    }

    static void doMoreStuff() throws InterruptedException {
        doMuchMuchMoreStuff();
    }

    static void doMuchMuchMoreStuff() throws InterruptedException {

        Thread.sleep(10000);

    }
}
