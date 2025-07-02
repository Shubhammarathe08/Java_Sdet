package org.example.interview.string;

public class Sum_Int_From_String {

    static int sum_int(String ip){
        int sum =0;
        for(Character s:ip.toCharArray()) {
            try {
               sum = sum + Integer.parseInt(s+"");
            } catch (NumberFormatException e) {
            }
        }
        return sum;
    }
    public static void main(String[] args){
         String ip = "#4h2AAr5i6k2";
         System.out.println(sum_int(ip));
    }
}
