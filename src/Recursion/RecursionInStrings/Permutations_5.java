package Recursion.RecursionInStrings;

public class Permutations_5 {
    private static void findPermu(String str, String ans){
        if(str.equals("")){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i); //a
            String left_substr = str.substring(0, i); //""
            String right_substr = str.substring(i+1); //bc
            String curr_str = left_substr + right_substr; //bc
            findPermu(curr_str, ans+ch); //bc , a
        }
    }
    public static void main(String[] args) {
        String str = "abc";

//        System.out.println(right_str + left_str);
        findPermu(str, "");
    }
}
