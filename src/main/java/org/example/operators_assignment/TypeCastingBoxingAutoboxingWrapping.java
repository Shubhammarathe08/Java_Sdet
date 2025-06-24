package org.example.operators_assignment;

public class TypeCastingBoxingAutoboxingWrapping {

    /*
     Implicit Type casting / Up casting (Widening Conversion)
     *** when we assign smaller type to bigger data type variable >> implicit type casting happens
     keeping small value in big container , no loss of information >> Widening Conversion

     int x  = 'a'; // 97 char to int -> internally compiler converts char to int
     double d = 10; // 10.0 int to double -> internally compiler converts int to double

     Explicit Type casting (Narrowing Conversion)
     *** when we assign bigger type to smaller data type variable >> explicit type casting happens
     keeping bigger value in small container , loss of information >> Narrowing Conversion
     programmer is responsible for this conversion, as there is a loss of information

     int x  = 130;
     byte b = (byte) x; // 130 int to byte -> explicit type casting required as there is a loss of information
     System.out.println(b); // -126 (130 exceeds byte range -128 to 127, wraps around)


    * */
}
