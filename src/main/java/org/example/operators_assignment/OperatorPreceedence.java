package org.example.operators_assignment;

public class OperatorPreceedence {

    /*
    1. Arithmetic Operators: +, -, *, /, % , =
       - These operators perform basic arithmetic operations.


       highest >>          unary |   x++, x--, +x, ++x, --x, new , <type>, []
       arithmetic >>       *,/, % , +, -   [* / same precedence]
       shift >>             >> , <<, >>>
       comparison >>        <, >, <=, >=, instanceof
       equality >>          ==, !=
       bitwise >>           &, |, ^, ~
       shortcircuit >>      &&, ||
      assignment >>        =, +=, -=, *=, /=, %=, &=, |=, ^=, <<=, >>=, >>>=
       - Precedence: lowest (=)
      *** operand evaluation order is from left to right for most operators,
          ** in case of multiple operators with the same precedence, the evaluation order is determined by associativity.

          1 + 2 * 3 / 4 + 5 * 6
          L-R  1 + 6 / 4 + 5 * 6
          1 + 1 + 5 * 6
          1 + 1 + 30
          32
    */
}
