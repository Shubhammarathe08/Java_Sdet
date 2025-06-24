package org.example.operators_assignment;

public class Assignment {

    /*
    1. simple assignment operator = >> assigns the value of the right operand to the left operand
    2. compound assignment operators +=, -=, *=, /=, %=, &=, |=, ^=, <<=, >>=, >>>= >> combines assignment with arithmetic or bitwise operations
       - These operators perform the operation and then assign the result to the left operand.
       - Example: x += 5 is equivalent to x = x + 5
       int a=10 ; a += 20;  a= a+20; // a=30
    3. chained assignment operator = >> allows multiple variables to be assigned the same value in a single statement
       - Example: a = b = c = 10 assigns the value 10 to a, b, and c
       cant perform directly at the time of declaration
       int a,b,c,d ;  a=b=c=d=10;
       int a=b=c=d=10// Compile Time Error: cant not find symbol 'b' in class test
       int b,c,d; int a=b=c=d=10; // valid

       byte b= 10;
       b = b+1;
       System.out.println(b);
       // Compile Time Error: incompatible types: possible lossy conversion from int to byte

       byte b= 10;
       b++;
       (byte)b+1
       System.out.println(b); // 11 Internal typecasting gets performed automatically   (type of b)(b+1) = byte(11)

       byte b= 10;
       b+=1; // equivalent to b = (byte)(b + 1);
       System.out.println(b); // 11 Internal typecasting gets performed automatically   (type of b)(b+1) = byte(11)

       byte b= 127;
       b+=3; // equivalent to b = (byte)(b + 1);
       System.out.println(b); // -126 Internal typecasting gets performed automatically, but loss of data


======================================================================================================================================

      int a,b,c,d;
        a = b = c = d = 20; // valid chained assignment
        a += b -= c *= d /= 2; // valid compound assignment with arithmetic operations
        *** assignment happens from right to left
        <    <     <    <    <    <
        d = d/2  >> 20/2  = 10
        c = c*10 >> 20*10 = 200
        b = b-200 >> 20-200 = -180
        a = a+(-180) >> 20+(-180) = -160
======================================================================================================================================
     Conditional and ternary operator

     int x = (10!=20) ? 10 : 20; //10 if condition is true, x = 10, else x = 20
     int x = (10>20) ? 10 : (  (20<30) ? 20 : 30); // 20 nested ternary operator








    */
}
