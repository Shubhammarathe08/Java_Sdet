package org.example.interview.string;

public class Reverse_str_extract_alphabet {


    static void rev_alphabet_only(String input){
        for(int i=input.length()-1; i>=0; i--){
            if(Character.isAlphabetic(input.charAt(i))){
                System.out.print(input.charAt(i));
            }
        }
    }
    public static void main(String[] args){
        String input = "#Looo@143T%1";
        rev_alphabet_only(input);
    }
}
