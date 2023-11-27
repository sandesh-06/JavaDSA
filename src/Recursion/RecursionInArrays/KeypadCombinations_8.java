package Recursion.RecursionInArrays;

public class KeypadCombinations_8 {
    static void combination(String str, String[] kp, String res){
        //base case
        if(str.length() == 0){
            System.out.println(res + "");
            return;
        }

        //self work
        int curNum = str.charAt(0) - '0'; //subtraction of ascii values : 50 - 48 = 2
        String curStr = kp[curNum]; //kp[2] = "abc"

        //recursive work
        for(int i = 0; i<curStr.length(); i++){
            combination(str.substring(1), kp, res + curStr.charAt(i));
            //combination(3, kp, res+a);
        }


    }
    public static void main(String[] args) {
        String str = "23";
        String[] kp = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combination(str, kp, "");
    }
}
