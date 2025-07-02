package org.example.selenium;

import lombok.Data;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ParallelExecutionTestng {

    @Test(dataProvider = "dp")
    void method_1(String username , String password){
        System.out.println("method_1");
        System.out.println(username+" <> "+password);
    }

    @Test
    void method_2(){
        System.out.println("method_2");
    }

    @Test
    void method_3(){
        System.out.println("method_3");
    }

    @Test
    void method_4(){
        System.out.println("method_4");
    }

    @Test
    void method_5(){
        System.out.println("method_5");
    }


    @DataProvider(name="dp")
    static Object[][] provide_data(){
        Object[][] temp_arr = {
                {"username_1","password_1"},
                {"username_2","password_2"},
                {"username_3","password_3"},
                {"username_4","password_4"}
        };
        return temp_arr;
    }
}
