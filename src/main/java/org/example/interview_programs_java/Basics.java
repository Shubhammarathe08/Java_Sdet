
package org.example.interview_programs_java;
import javax.management.MBeanFeatureInfo;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;


public class Basics {

    public static void main (String[] args) throws IOException {
/*

1. What is a stream?
A stream is a flow of data.
Keyboard/File  --->  InputStream  --->  Your Java program
Your program   --->  OutputStream --->  Console/File

| Type         | Direction          | Data                |
| ------------ | ------------------ | ------------------- |
| InputStream  | Into the program   | Bytes               |
| OutputStream | Out of the program | Bytes               |
| Reader       | Into the program   | Characters/text     |
| Writer       | Out of the program | Characters/text     |
| Stream<T>    | Processes data     | Objects/collections |

System.in ==> is the standard input stream
System.out  ==>  is the standard output stream
Scanner tokenizes input, using whitespace as the default delimiter

readLine() always returns a complete line as a String, so numeric conversion is required:


 */
        // print hello world
        System.out.println( "hello world" );

        // print hello world w/o print

        Scanner sc = new Scanner(System.in);
        System.out.println("enter int");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println("enter string");
        String sample = sc.next();
        sc.nextLine();
        System.out.println("formed >> "+num+" "+sample);

        BufferedReader bf_read = new BufferedReader(new InputStreamReader(System.in));
        int age  = Integer.parseInt(bf_read.readLine().trim());
        String name_1 = bf_read.readLine();
        System.out.println("formed >> "+age+" "+name_1);


        System.out.println("enter array size");
        int size  = Integer.parseInt(bf_read.readLine().trim());
        System.out.println("enter array ele");
        int [] nums = Arrays.stream(bf_read.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(Arrays.toString(nums));
        System.out.println("enter array size - rows | col");
        int[] r_c = Arrays.stream( bf_read.readLine().trim().split("\\s+") )
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = r_c[0];
        int cols = r_c[1];
        int[][] matrix = new int[rows][cols];
        System.out.println("enter array ele row wise");
        for (int i=0 ; i<rows; i++){
            matrix[i] = Arrays.stream( bf_read.readLine().trim().split("\\s+") )
                        .mapToInt(Integer::parseInt)
                       .toArray();
        }

        for (  int[] ff : matrix){
            System.out.println(Arrays.toString(ff));
        }

//        String line  = bf_read.readLine().trim();
//        String[] nums = line.split("\\s+");
//
//
//        if(nums.length < size) {
//           System.out.println("missing values as per size >>"+(size-nums.length));
//        }
//
//        int[] num_array = new int[size];
//
//       for( int i=0; i<nums.length; i++){
//           num_array[i] = Integer.parseInt(nums[i]);
//       }
//       System.out.println(Arrays.toString(num_array));

    }

}