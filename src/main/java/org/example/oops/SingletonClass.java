package org.example.oops;

public class SingletonClass {

    /*

     >> private constructor
        used in singleton >> only/at max one object
        Ex. Runtime , Business Delegate , Service Locator
     >> adv :-

    */

    private SingletonClass() {
    }

    public static SingletonClass getSingletonClass() {
        if (obj == null)
            obj = new SingletonClass();
        return obj;
    }

    private static SingletonClass obj = null;
}
