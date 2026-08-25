package org.example.language_fundamentals_01;

public class N_ArraysClass {

    /*
    ================= ARRAYS IN JAVA 17 =================

    Array:
    Object used to store multiple values of same data type.

    Features:
    - Fixed size
    - Homogeneous elements
    - Index based (starts from 0)
    - Arrays are objects in Java
    - Stored in Heap memory
    - Can be multidimensional

    ================= ARRAY DECLARATION =================

    Declaration:
    int[] arr;

    Creation:
    arr = new int[5];

    Declaration + Creation:
    int[] arr = new int[5];

    Initialization:
    int[] arr = {1,2,3,4,5};

    Anonymous Array:
    new int[]{1,2,3};


    ================= MEMORY =================

    Reference variable -> Stack
    Array object -> Heap


    Example:

    int[] a = new int[3];

    Stack:
    a -------> Heap Array Object


    ================= DEFAULT VALUES =================

    int[]      -> 0
    double[]   -> 0.0
    boolean[]  -> false
    char[]     -> '\u0000'
    Object[]   -> null


    ================= ARRAY TYPE =================

    Primitive Array:

    int[] a = new int[5];


    Element promotion allowed:

    byte b = 10;
    a[0] = b;


    Array level promotion not allowed:

    int[] a = {1,2,3};
    char[] b = {'a','b'};

    int[] c = b; // Compile error


    ================= OBJECT ARRAY =================

    Object[] obj = new Object[5];

    obj[0] = "Hello";
    obj[1] = 10;


    Avoid deprecated:

    new Integer(10);

    Use:

    Integer i = 10;


    ================= ARRAY COVARIANCE =================

    Child array can be assigned to parent array.

    String[] s = {"A","B"};

    Object[] obj = s;


    ================= MULTIDIMENSIONAL ARRAY =================

    Java implements 2D arrays as Array of Arrays.

    int[][] arr = new int[2][];

    arr[0] = new int[2];
    arr[1] = new int[4];


    Jagged array:
    Different rows can have different sizes.


    ================= ARRAY CLASS =================

    int[] arr = new int[3];

    arr.getClass().getName();

    Output:

    class [I


    String[]:

    class [Ljava.lang.String;


    ================= ARRAY ASSIGNMENT =================

    int[] a = {1,2,3};
    int[] b = {4,5};

    a = b;

    Elements are not copied.
    Reference is reassigned.


    ================= LENGTH =================

    Array:

    arr.length


    String:

    str.length()


    ================= JAVA 17 FEATURES =================


    1. var with Arrays

    var arr = new int[]{1,2,3};


    2. Pattern Matching instanceof

    Object obj = new int[]{1,2,3};

    if(obj instanceof int[] arr){
        System.out.println(arr.length);
    }


    3. Records with Arrays

    record Box(int[] data){}

    Arrays.equals() required for content comparison.


    4. Arrays Utility

    Arrays.toString(arr)

    Arrays.deepToString(arr)

    Arrays.equals(a,b)

    Arrays.deepEquals(a,b)

    Arrays.sort(arr)

    Arrays.fill(arr,value)

    Arrays.copyOf(arr,size)

    Arrays.stream(arr)


    ================= EXAMPLES =================

    int[] x = {1,2,3};

    int[][] y = {
        {1,2},
        {3,4}
    };

    int[][][] z = {
        {
            {1,2},
            {3,4}
        }
    };

    */

}