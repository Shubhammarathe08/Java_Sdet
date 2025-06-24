package org.example.operators_assignment;

public class IncrementAndDecrementOperators {

    /*   Only applicable - variable ** not for const ++10 , --10 x  Invalid | Compile Time Error
    Increment
    pre incr >> ++x  | increment first then use
    post incr >> x++ | use first then increment
    Decrement
    pre decr >> --x | decrement first then use
    post decr >> x-- | use first then decrement
                org val x=10         y         x
    y = ++x     10                  11        11
    y = x++     10                  10        11
    Y = --x     10                   9         9
    y = x--     10                  10         9

       int x = 10;
       int y = ++x; // pre-increment
        System.out.println(x);
        System.out.println(y);
        // x incr = 11 , use y=11 x=11

        int x1 = 10;
        int y1 = x1++; // pre-increment
        System.out.println(x1);
        System.out.println(y1);
       // x use y=10 , incr x=11

        int x12 = 20;
        int y12 = ++ (++x1); // pre-increment   Compile Time Error : ++x1 will become 21 val , cant apply ++21
        System.out.println(y12);

        int x = 0;
        char c = 'A';
        double d = 10.5;
        boolean flag = true;
        x++; // Incrementing integer
        c++; // Incrementing character
        d++; // Incrementing double
        flag++; // Incrementing boolean (not valid in Java, will cause a compile error)

         for FINAL >> incr ad decr - not allowed

       ***  if we apply any ARITHMETIC operation on A and B ,resu;t = max (int,type of a, type of b)
        byte a =10; byte b = 20; byte c = a + b;
        // Compile Time Error: java: incompatible types: possible lossy conversion from int to byte
        correct code >> byte c = (byte) (a + b);

        byte b = 10;
        b = b+1 ;
        System.out.println(b); // java: incompatible types: possible lossy conversion from int to byte

        byte b1 = 10;
        b1++;
        System.out.println(b1); // 11 Internal typecasting gets performed automatically   (type of b1)(b1+1) = byte(11)
  ===========================================================================================================================================

        byte + byte = int
        short + short = int
        byte + short = int

        char + char = int
        byte + char = int
        short + char = int

        char + long = long ... same byte,short
        char + float = float ... same byte,short
        char + double = double ... same byte,short

        long + float = float
        float + double = double
        long + double = double

        System.out.println('a'+'a'); // 194
  ===========================================================================================================================================
         System.out.println(10/0); >> Exception in thread "main" java.lang.ArithmeticException: / by zero
         System.out.println(10/0.0); >>  Infinity | float + double >> POSITIVE_INFINITY, NEGATIVE_INFINITY
         System.out.println(10/0); >> Exception in thread "main" java.lang.ArithmeticException: / by zero
         System.out.println(0/0.0); >> undefined | float + double >>  NaN ( not a number )
  ===========================================================================================================================================
   for any x val including NAN  x <,> <= , >= , ==     | returns false
   except x != NAN | returns true
  ===========================================================================================================================================
      ArithmeticException >> 1. for integral only
                       2. caused by / or %
                       3. runtime exception






    * */
}
