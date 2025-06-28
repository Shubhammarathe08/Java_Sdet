package org.example.interview.string;

import java.util.*;

public class StringPrograms {


    public static String subtractStrings(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1); // keep //kee //ke //k
        for (char c : s2.toCharArray()) { // peek
            int index = sb.indexOf(c+""); // p>>3 e>>2 e>>1 k>>0
            System.out.println(index+" "+sb);
            if (index != -1) // delete ? -1
                sb.deleteCharAt(index);

        }
        return sb.toString();
    }


    public static void main(String[] args){

        /*

              String s1 = "shu1";
              String s2 = "shu1";

        // ==  VS .equals()
        String

        StringBuffer

        StringBuilder

//-----------------------------------    String Comparison Program    -------------------------------------------------

        // scp pointing to same content
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s3 = new String("shu1");

        // scp pointing to same content BUT s3 created using new
        System.out.println(s2 == s3);
        System.out.println(s2.equals(s3));


        // scp pointing to same content BUT s3 created using replace
        String s4 = "naveen";
        String s5 =s4.replace("n","N");

        System.out.println(s4 == s5);
        System.out.println(s4.equals(s5));

        String s6 = "NaveeN";
        // replace - if executed successfully created new string -> address differs than SCP
        System.out.println(s5 == s6);
        System.out.println(s5.equals(s6));

        String str = null;
        System.out.println(str.valueOf(10)); // equivalent to 10+"" -> covert to String Object
        // 10 >> Even though str is null | static method >> valueOf
        // Java resolves static method calls using the class type (String) not the reference (str).

        String s1 = "xxx";
        StringBuffer s2 = new StringBuffer(s1);
        System.out.println(s1.equals(s2));
        // false - obj1 and obj2 should be of String type only


        String s11 = new String("javaguides");
        String s22 = new String("javaguides");
        System.out.println(s11 = s22);
        // s11 will be printed

//-----------------------------------    String intern()   -------------------------------------------------
        String s111 = "hello"; // scp
        String s222 = new String("hello"); // heap + -->>>

        System.out.println(" intern >>> "+s222.intern());
        s222 = s222.intern(); // return scp ref ->> hello
        System.out.println(s111 == s222); // hello == hello  -> true

        String s000 = "Bello"; //Bello
        String s1111 = s000.replace("B","b"); // heap
        System.out.println(" intern >>> "+s1111.intern());
        s222 = s1111.intern(); // return scp ref ->> s222 = bello
        System.out.println(s111 == s222); //  ->

        // checks SCP - if string present >> return string | if not - then add + return





        String str2 = "175345";
        String str3 = "Test@123MY_Foort#";
        String str4 = "MyBatIsBad";
        String[] str_arr = {"check" ,"may" ,"day", "may", "day","captain"};


        String str1 = "wow what a day";

        //reverse str1 - whole >> yad a tahw wow
       char[] ch1 = str1.toCharArray();
       for(int i=ch1.length-1; i>=0; i--){
           System.out.print(ch1[i]);
       }

         System.out.println();

       // reverse whole string but keep words straight >> day a what wow
        String[] st_arr1 = str1.split(" ");

       for(int i = st_arr1.length - 1; i >= 0; i--) {
           System.out.print(st_arr1[i]);
           if(i != 0){
               System.out.print(" ");
           }
       }

        System.out.println();

        // reverse whole string but keep words straight >>wow tahw a yad
        System.out.println(Arrays.toString(st_arr1));
        for(int k=0; k<=st_arr1.length-1;k++) {
            for(int l= st_arr1[k].length()-1; l>=0; l-- ){
                System.out.print(st_arr1[k].charAt(l));
            }
            if(k < st_arr1.length-1 ){
                System.out.print(" ");
            }
        }

        System.out.println();

        String result = subtractStrings("keep", "peek");

        System.out.println(result.isEmpty()+" >> result >>"+result);
        // System.out.println(String.valueOf('c').getClass());

        // repeated character
        String str5 = "The Tea is Totally Fine";

        HashMap<Character, Integer> hmap1 = new HashMap<>();

        for(int i=0; i<=str5.length()-1; i++){
            Character temp = (Character) str5.charAt(i);
            if(hmap1.containsKey(temp)){
                hmap1.put(temp,hmap1.get(temp)+1);
            }
            else{
                hmap1.put(temp,1);
            }
        }

        for(Map.Entry<Character, Integer> xx :hmap1.entrySet()){
            if( xx.getValue()>1) {
                System.out.println(xx);
            }
        }

        Set<Map.Entry<Character,Integer>> entry = hmap1.entrySet();
        Iterator<Map.Entry<Character,Integer>> itr = entry.iterator();

        while(itr.hasNext()){
            Map.Entry<Character,Integer> t = itr.next();
            if(t.getValue()>1) {
                System.out.println(t);
            }
        }
        System.out.println(hmap1);

        //remove duplicate
        HashSet<String> my_set = new HashSet<>(Arrays.asList(str5.split("")));
        System.out.println(my_set.toString());


         */







//-------------------------------------------------------------------------------------------------------------------
    }



}
