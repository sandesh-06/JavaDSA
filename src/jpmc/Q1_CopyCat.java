package jpmc;

import javax.swing.plaf.IconUIResource;
import java.util.HashSet;

//https://prepinsta.com/jp-morgan-coding-questions/
public class Q1_CopyCat {
    public static String swap(String str, int x, int y){
        char[] arr = str.toCharArray();
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        return String.valueOf(arr);
    }
    public static void generatePermutation(String str, HashSet<String> hs, int st, int end){
        if (st == end){
            hs.add(str);
            return;
        }
        for(int i = st; i<str.length(); i++){
            str = swap(str, st, i);
            generatePermutation(str, hs, st+1, end);
            str = swap(str, st, i);
        }
    }
    public static int findDiff(String currStr, String oriStr){
        int diff = 0;
        for(int i = 0; i<oriStr.length(); i++){
            if(currStr.charAt(i) != oriStr.charAt(i)) diff++;
        }
        return diff;
    }
    public static void main(String[] args) {
        String str = "abababa";

        //1. Store the permutations of the string in a hashset
        HashSet<String> hs = new HashSet<>();
        generatePermutation(str, hs, 0, str.length()-1);

        //2. Now find the diff for each permutation and return the max
        int max = 0;
        for(String s: hs){
            int diff = findDiff(s, str);
            max = Math.max(diff, max);
//            System.out.println(s + " " + diff);
        }
        System.out.println(max);
    }
}
