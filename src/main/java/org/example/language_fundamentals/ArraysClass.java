package org.example.language_fundamentals;

public class ArraysClass {


    /*
    Arrays ( objects ) >> store multiple variables of the same type.
    Indexed collection of , fixed no. of homogeneous elements.
    1. fixed size
    2. homogeneous data type (same type of data)
    3. index based traversal (first element is at index 0)
    4. contiguous memory allocation (elements stored in adjacent memory locations)
    5. can be multidimensional (1D, 2D , 3D etc) | int[] x , int[][] y , int[][][] z
    6. DataType[] arrayName = new dataType[size]; // int[] x = new int[5];
    7. Arrays can be of any data type, including primitive types and objects.
    8. Arrays are reference types in Java, meaning they store a reference to the actual data in memory.
    9. Arrays can be passed as arguments to methods and returned from methods >>> my_method(int[] x)
    10. for every array >> there is a corresponding class in java.lang package, Not available to programmer.
         a.getClass().getName() >> returns the class name of the array
    11. Allowed data type to specify size are  >> [ byte, short, int, char ]
         int[] x = new int[5]; // valid
            int[] x = new int['a'];
    12. Array size is always a non-negative integer, if negative then runtime exception >> NegativeArraySizeException
    13. in case of Primitive type array, as Array Element we can provide any type ** which can be implicitly promoted to declared type.
    ** Ex int[] x = new int[5]; // valid
       x[0] = 10; // valid
       byte b = 1;
       x[1] = b; // valid, byte is implicitly promoted to int
       short s = 2;
       x[2] = s; // valid, short is implicitly promoted to int
       char ch = 'A';
       x[3] = ch; // valid, char is implicitly promoted to int (ASCII value of 'A' is 65)

     *** ELEMENT level promotion, not applicable to ARRAY level
     int[] x = {10,20,30}
     char ch = {'a',''b','c'};
     int[] b = x //valid
     int[] c =  ch // compile time error incompatible types: char[] cannot be converted to int[]


     int[] a = {1,2,3,4,5};
     int[] b = {5,6};
     a = b >> ele wont be copied, ref variable will be reassigned to b
     b = a >> ele wont be copied, ref variable will be reassigned to a
     elements >> type should match

     14. in case of OBJECT type Arrays, we can provide declared class objs  or child class objects and elements
        Object[] obj = new Object[5]; // valid
        x[0] = new String("Hello"); // valid, String is an object
        x[1] = new Integer(10); // valid, Integer is an object
        x[2] = new Object; // valid
     *** ELEMENT level promotion,  applicable to ARRAY level ( child to parent )
     String[] s = {"a", "b", "c"};
     Object[] o = s; // valid, String is a subclass of Object

     15. in case of abstract class type Arrays, we can provide child class objects and elements
        Number[] ac = new Number[5]; // valid
        ac[0] = new Integer(10); // valid, Integer is a subclass of Number
        ac[1] = new Double(3.14); // valid, Double is a subclass of Number

     16. in case of INTERFACE type Arrays, we can provide implementing class objects and elements
        Runnable[] r = new Runnable[5]; // valid
        r[0] = new Thread(); // valid, Thread implements Runnable interface

     17. int[][] x = new int[4][3];  >> obj - 5
        a[0] =  new int[4]  >> obj - 1
        a[1] =  new int[2]  >> obj - 1
        a = new int[3][2]  >> obj - 4

     [            |           |            |             ]  => a   <=  [       |        |        ]
         [ | | ]     [ | | ]      [ | | ]      [ | | ]                   [ | ]    [ | ]   [ | ]
          => a[0]      a[1]         a[2]         a[3]
          [ | | | ]    [ | ]


         | **Array Type** | **Value Type**    | **1D Array Class**          | **2D Array Class**           |
| -------------- | ----------------- | --------------------------- | ---------------------------- |
| `int[]`        | `int`             | `class [I`                  | `class [[I`                  |
| `float[]`      | `float`           | `class [F`                  | `class [[F`                  |
| `double[]`     | `double`          | `class [D`                  | `class [[D`                  |
| `long[]`       | `long`            | `class [J`                  | `class [[J`                  |
| `short[]`      | `short`           | `class [S`                  | `class [[S`                  |
| `byte[]`       | `byte`            | `class [B`                  | `class [[B`                  |
| `char[]`       | `char`            | `class [C`                  | `class [[C`                  |
| `boolean[]`    | `boolean`         | `class [Z`                  | `class [[Z`                  |
| `String[]`     | `String` (object) | `class [Ljava.lang.String;` | `class [[Ljava.lang.String;` |
| `Object[]`     | `Object`          | `class [Ljava.lang.Object;` | `class [[Ljava.lang.Object;` |



       declaration >> DataType[] arrayName; // int[] x;
       *** At the time of declaration, we cant specify the size of the array.

       creation >> arrayName = new DataType[size];
       // x = new int[5]; *** Compulsory

       few combinations >> int[] a,b = D [1,1] | int[][] a,b = D [2,2] | int[] a[],b[] = D [2,2] | int[][] a[],b = D [2,1]
       *** int[] []a,[]b  X compile time error | Only allowed for first var, not for all
       *** better to declare after variable  int a[],b[] = D [2,2] | int[][] a,b = D [2,2]

       initialization >> arrayName = new DataType[size]; // x = new int[5];
       declaration + initialization >> DataType[] arrayName = new DataType[size]; // int[] x = new int[5];


       main method >> public static void main(String[] args)
       // args is an array of String type  | Size 0
       // int[] x = new int[-3]  | No compiler error, but runtime exception >> NegativeArraySizeException

       int[] x = new int[2147483647]; // valid BUT ( may face insufficient memory error due to HEAP memory limit )
       int[] x = new int[2147483648]; // compile time error : integer number too large

=======================================================================================================================================

                                           2 D Arrays [Matrix]
        Array of Arrays


        matrix >>   1 2 3
                    4  5 6
                    7 8 9
       memory gaps >> 1   2  3  4
                      5
                      9  10 11
                      13 14

    s = [         |    |          |        ]
         [1,2,3,4]  [5]  [9,10,11]   [13,14]

in java 2d arrays are implemented as arrays of arrays, meaning each row is an independent array.
This allows for flexibility in row sizes,
but it also means that the memory layout is not contiguous like in some other languages.
NOT LIKE - Matrix Style Representation

Base Size >> first dimension (number of rows)
Element Size >> second dimension (number of columns)

x =  [       |           ]
    [ 1,2 ]    [1,2,3,4]

    int[][] x = new int[2][]; // valid, first dimension specified, second dimension not specified
    x[0] = new int[2]; // first row with 2 columns
    x[1] = new int[4]; // second row with 4 columns

x =  [                |                     ]
    [   |    |     ]      [      |      ]

     []  [ | ]  [ | ]      [ | ]   [ | ]

     int[][][] x = new int[2][][]; // valid, first dimension specified, second dimension not specified

     x[0] = new int[3][];
     x[0][0] = new int[1]; // first row with 2 columns
     x[0][1] = new int[2]; // second row with 2 columns
     x[0][2] = new int[2]; // third row with 2 columns

     x[1] = new int[2][2];
     ============================================================================================================

         int[] x  = new int[3];
         System.out.println(a);  >> [I@3fee733d >> class name  with hashcode
         This is the default toString() representation of an array object in Java.
        System.out.println(a[0]); >> 0
     *** Once we create Array >> ALL/EVERY elements are initialized to default values

           int[][] a = new int[3][];
        System.out.println(a);
        System.out.println(a[0]);
        System.out.println(a[0][0]);
    *** NullPointerException as a[0] is null


    int[] x = new int[2]; | 0, 1
    x[0] = 10;
    x[1] = 20;
    x[2] = 30;
    // ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    x[4.5] ?? >> java: incompatible types: possible lossy conversion from double to int

    ===============================================================================================================

                         Short Cut

    int[] x = {1,2,3,4,5}; // array initialization with values
    int[][] y = { {1},{2,3} }; // 2D array initialization with values
    int[][][] z = { { { 1,2 },{ 3,4 } }, { { 5,6 },{ 7,8 } } }; // 3D array initialization with values
    int[] x ; x = {10,20,30}; // compile time error : java: illegal start of expression
    Anonymous Array Initialization >> one time use
    new int[]{1,2,3,4,5}; // anonymous array initialization with values
    int[] x = new int[]{1,2,3,4,5}; // we can give name to anonymous array but then its not anonymous anymore
    Object[] obj = new Object[]{1, "Hello", 3.14, new Integer(10) }; // array of objects with mixed types


         [                        |                            ]
             [        |        ]        [        |         ]
               [  |  ] [  |  ]           [  |  ]   [  |  ]
    char[] ch = {'a', 'b', 'c'}; // character array initialization with values
    String[] str = {"Hello", "World"}; // string array initialization with values

    *** Every java object >> Memory HEAP

    // Array of objects

======================================================================================================================

        length (final variable) >> returns the size of the array
        *** Applicable for Arrays only | represents Base Size only {in multi dimensional array}

        length() (final method) >> not applicable for arrays, only for String and other collections

        int[] arr = new int[5];
        System.out.println(arr.length); // 5

        String s = "Hello";
        System.out.println(s.length()); // 5

        int[][] arr2D = new int[6][3];   // [ 1| 2| 3| 5| 5|6] >> [1|2|3]
        arr2D.length; // 6 (number of rows)





    */
}
