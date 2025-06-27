package org.example.collection;

public class ComparableComparator {

    /*
      Comparable (I) - default , natural sorting order
       public int compareTo(Object)  >> obj1.compareTo(obj2)
       +ve => obj1 before obj2
       -ve => obj2 before obj1
       0  => equal

       a.compareTo(z) >> -ve
       d.compareTo(a) >> +ve
       a.compareTo(a) >> 0
       a.compareTo(null) >> NPE

       // obj1 - obj which is to be inserted
       // obj2 - which is already present

       k , Z , A , A , k
       z.compareTo(k)  >> A
       A.compareTo(z)  >> k
       A.compareTo(A)  >> Z
       // comparable + homogeneous
//----------------------------------------------------------------------------------------------------------------------
      Comparator (I) - customised sorting order ( if ** default natural sorting order Not available / not satisfied )

      customised sorting



    */
}
