package org.example.exception_handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AdvancedConcepts {

    /*
         Try with Resources

     >> reader obj ref -  can be used inside Try block
     >> reader, will be closed automatically, once control reached end of try block
     >> either normally / ab normally , programmer not responsible for closing resources

     try(R1 ; R2 ; R3){
     }
     catch(){
     }
     >> R- should be autocloseable
     >> corresponding class should implement java.lang.AutoCloseable
     >> contain only 1 method - public void close()
     >> all R ref var >> we cant perform re-assignment of resource ref var - implicitly final
---------------------------------------------------------------------------------------------------------------
         Multi Catch Block

         try{
         }
         catch(   ){
         }
      >>  separate by | operator
      >> for same handling code , we can combine exception
      >> order of exception should be
      >> parent > child | child > parent | same type  - relation should not be there
-----------------------------------------------------------------------------------------------------------------
         Re Throwing Exception

        // catching A throwing B

         try{
           System.out.println(10/0);
         }
         catch(ArithmeticException e){
           throw new NullPointerException();
         }
    */

    public static void main(String[] args){
        String filePath = "example.txt";

        // Try-with-resources ensures automatic closing of resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("I/O error occurred: " + e.getMessage());
        }
    }
}
