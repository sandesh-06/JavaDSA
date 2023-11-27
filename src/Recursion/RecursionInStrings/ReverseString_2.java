package Recursion.RecursionInStrings;

import java.util.Scanner;

public class ReverseString_2 {
    static boolean palindromeTwoPointer(String str, int l, int r){
        if(l >= r){
            return true;
        }
       return (str.charAt(l) == str.charAt(r) && palindromeTwoPointer(str, l+1, r-1));

    }
    static boolean palindromeStr(String str){
       String checkStr = reverseStr(str);
       if(checkStr.equals(str)) return true;
       else return false;
    }
    static String reverseStr(String str){
        if(str.length() == 0){
            return "";
        }
        return reverseStr(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); //used to fetch a sentence or more than a word

//        System.out.println(reverseStr(str));
//        System.out.println(palindromeStr(str));
        System.out.println(palindromeTwoPointer(str, 0, str.length()-1));
    }

}
