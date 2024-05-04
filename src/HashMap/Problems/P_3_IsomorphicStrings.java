package HashMap.Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// aabc - xxyz : isomorphic ; abbcd - xyzyd : not isomorphic
public class P_3_IsomorphicStrings {
    public static boolean isIsomorphic(String s1, String s2){
        Map<Character, Character> mp = new HashMap<>();

        for(int i = 0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(!mp.containsKey(c1)){//if the char doesn't exists, add the character with it's corresponding char from str2
//                for(var item: mp.values()){
//                    if(c2 == item) return false;
//                }
                if(mp.containsValue(c2)) return false;
                else mp.put(c1, c2);
            }
            else{ //if it already exists, check if the corresponding char from str2 matches
                if(mp.get(c1) != c2) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(isIsomorphic(s1, s2));
    }
}
