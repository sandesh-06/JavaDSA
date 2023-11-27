package StringBuilder;

//Given a string s, return the no. of palindromic substrings in it.
public class Builder_3_Palindromic_Substrings {
    static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
//    static void findSubstr(String str, String ans){
//        if(str.length() == 0){
//            System.out.println(ans);
//            return;
//        }
//
//        char ch = str.charAt(0);
//        String rem = str.substring(1);
//
//        findSubstr(rem, ans+ch);
//        findSubstr(rem, ans);
//    }
    public static void main(String[] args) {
//        //LETS LOOK AT A EXAMPLE TO IDENTIFY PALINDROME, NOTE: TWO POINTER APPROACH IS THE BEST
//        String str1 = "abcdcba";
//        StringBuilder str2 = new StringBuilder(str1);
//        str2.reverse();
////        if(str1.equals(str2)) System.out.println(true); //it wont work, because we are comparing a String with a StringBuilder
//        //a hack to convert StringBuilder to string:
//        String str3 = str2 + "";
//        System.out.println(str1 + " " + str3);
//        System.out.println(str1.equals(str3));


        String str1 = "ababa";
        int count = 0;
        for(int i = 0; i<str1.length(); i++){
            for(int j = i+1; j<=str1.length(); j++){
                if(isPalindrome(str1.substring(i, j))){
                    System.out.println(str1.substring(i, j));
                    count++;
                }
            }
        }
        System.out.println("Total palindromic substrings is: " + count);
    }
}
