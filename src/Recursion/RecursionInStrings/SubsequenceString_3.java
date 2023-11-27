package Recursion.RecursionInStrings;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsequenceString_3 {
    //eg: subsequence of 'abc' - ['abc', 'ab', 'ac', 'a', 'bc', 'b', 'c', ' ']
    static ArrayList<String> findSubsequenceStr(String str){
        ArrayList<String> ans = new ArrayList<>();
        //base case
        if(str.length() == 0){
           ans.add(" "); //because subsequence of an empty string is the empty string itself
           return ans;
        }

        char curr = str.charAt(0);

        //recursive work
        ArrayList<String> recAns = findSubsequenceStr(str.substring(1)); //will give ['bc', 'b', 'c', ' ']

        //self work
        for(String ss: recAns){
            ans.add(ss); //adds 'bc', 'b', 'c', ' '
            ans.add(curr + ss); //adds 'abc', 'ab', 'ac', 'a'
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(findSubsequenceStr(str));
    }
}
