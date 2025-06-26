package org.example.exception_handling;

public class TryCatchFinallyThrowThrows {

    /*
    w/o >>   Try Catch Finally
    stmt 1
    Exception in thread "main" java.lang.ArithmeticException: / by zero
	at org.example.exception_handling.TryCatchFinally.main(TryCatchFinally.java:9)

    w >> Try Catch Finally
    stmt 1
    5
    finally
    stmt 2

    Print Exception Information |*** On ANy Exception/Error + child class objects

            e.printStackTrace(); // complete info
            java.lang.ArithmeticException: / by zero
	        at org.example.exception_handling.TryCatchFinally.main(TryCatchFinally.java:28)

            System.out.println(e); //only description
            java.lang.ArithmeticException: / by zero

            System.out.println(e.toString()); // string
            java.lang.ArithmeticException: / by zero

            System.out.println(e.getMessage()); // only exact msg
            / by zero



    */

    static ClassCastException ce = new ClassCastException(); // runtime exception , unchecked

    public static void main(String[] args) throws CustomClass2 {

        System.out.println("stmt 1");

        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            e.printStackTrace(); // complete info
            System.out.println(e); //
            System.out.println(e.toString()); //
            System.out.println(e.getMessage()); //
            System.out.println(10 / 2);
        } finally {
            System.out.println("finally 1");
        }
//----------------------------------------------------------------------------------------------------------------------
        try {
            throw ce;
            //  System.out.println(" check ");
        } catch (ClassCastException e) {
            System.out.println(" class cast exception e captured 1");
        } finally {
            System.out.println("finally 2");
        }
//----------------------------------------------------------------------------------------------------------------------

        try {
            ce = null;
            throw ce;
        } catch (NullPointerException e) {
            System.out.println(" null pointer exception e captured");
        } finally {
            System.out.println("finally 2");
        }

//----------------------------------------------------------------------------------------------------------------------

        try {
            throw new CustomClass(); // un checked exception
            // java: incompatible types: org.example.exception_handling.CustomClass cannot be converted to java.lang.Throwable
        } catch (CustomClass e) {
            System.out.println(" custom class exception e captured");
        }

        try {
            throw new CustomClass1(); // partially checked exception
            // java: incompatible types: org.example.exception_handling.CustomClass1 cannot be converted to java.lang.Throwable
        } catch (CustomClass1 e) {
            System.out.println(" custom class 1 exception e captured");
        }

        System.out.println("stmt last outside any block");

        throw new CustomClass2(); // fully checked exception
        // java: unreported exception org.example.exception_handling.CustomClass2; must be caught or declared to be thrown

    }
}
