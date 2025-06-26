package org.example.oops;

public class ObjectCreation {
    /*
| # | Method                        | Example Code                                                                                  | Use Case / When to Use                                             |
|---|-------------------------------|-----------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
| 1 | Using `new` operator          | Test t = new Test();                                                                          | Direct object creation, most common approach in standard coding     |
| 2 | Using `Class.forName()`       | Test t = (Test) Class.forName("Test").newInstance();                                          | Dynamic class loading, frameworks like JDBC or Spring use this      |
| 3 | Using Factory Method          | Runtime r = Runtime.getRuntime();                                                             |
|                                   | DateFormat df = DateFormat.getInstance();                                                     | Singleton or centralized object creation logic                      |
| 4 | Using `clone()` method        | Test t1 = new Test();                                                                         |
|                                   | Test t2 = (Test) t1.clone();                                                                  | Copying objects without calling constructor (needs Cloneable)       |
| 5 | Using Deserialization         | FileInputStream fis = new FileInputStream("abc.ser");                                        |
|                                   | ObjectInputStream ois = new ObjectInputStream(fis);                                        |
|                                   | Dog d2 = (Dog) ois.readObject();                                                          | Restoring object from file or stream (needs Serializable interface) |

    * */
}
