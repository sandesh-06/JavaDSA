package Recursion.RecursionInStrings;

import java.util.ArrayList;
import java.util.List;

public class MoreSubsequence_6 {
    private static boolean isStrDistinct(String str, List<String> ls){
        for(String s: ls){
            if(str.equals(s)) return false;
        }

        return true;
    }

    private static void helper(List<String> ls, int len, String str, String curr_ans){
        if(str.equals("")){
            if(!isStrDistinct(curr_ans, ls)) return;
            ls.add(curr_ans);
            return;
        }

        char curr_char = str.charAt(0); //a
        String rem_str = str.substring(1); //bc

        //char wants to be part of the ans
        helper(ls, len, rem_str, curr_ans+curr_char);

        //char doesn't want to be a part in the ans
        helper(ls, len, rem_str, curr_ans);
    }
    private static List<String> findSubsequence(int len, String str){
        List<String> ls = new ArrayList<>();
        helper(ls, len, str, "");

        return ls;
    }
    public static String moreSubsequence(int n, int m, String a, String b) {
        // Write your code here
        List<String> subs_of_A = findSubsequence(n, a);
        List<String> subs_of_B = findSubsequence(m, b);
        System.out.println(subs_of_A);
        System.out.println(subs_of_B);
        return subs_of_A.size() >= subs_of_B.size() ? a : b;
    }

    public static void main(String[] args) {
        System.out.println(moreSubsequence(3, 4, "abc", "dddd"));
    }
}
