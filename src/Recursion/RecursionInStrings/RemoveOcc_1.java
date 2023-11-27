package Recursion.RecursionInStrings;

import java.util.Scanner;

public class RemoveOcc_1 {
    static String removeOccUsingSubStr(String str, char target){
        if(str.length() == 0){
            return "";
        }
        if(str.charAt(0) == target){
            return removeOccUsingSubStr(str.substring(1), target);
        }
        return str.charAt(0) + removeOccUsingSubStr(str.substring(1), target);
    }
    static String removeOcc(String str, char target, int n, int idx){ //str = dacbax
        if(idx >= n){
            return " ";
        }
        if(str.charAt(idx) != target){ //if the current character is != 'a', then add it to recursive work string
            return str.charAt(idx) + removeOcc(str, target, n, idx+1);
            //d + cbx
        }
       return removeOcc(str, target, n, idx+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); //to read a string
        char target = sc.next().charAt(0); //to read a character

//        System.out.println(removeOcc(str, target, str.length(), 0));
        System.out.println(removeOccUsingSubStr(str, target));
    }
}
