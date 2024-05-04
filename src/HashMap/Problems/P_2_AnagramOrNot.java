package HashMap.Problems;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//ANAGRAM MEANS 2 WORDS SHOULD CONTAIN THE SAME LETTERS WITH SAME FREQUENCY OF LETTERS, THE ORDER OF LETTERS DOESN'T MATTER

public class P_2_AnagramOrNot {
    public static void makeFrequencyMap(Map<Character, Integer> mp, String str){
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
//            if(mp.get(c) != null) mp.put(c, mp.get(c)+1); //if the char already exists, add one to the value
            if(mp.containsKey(c)) mp.put(c, mp.get(c)+1);
            else mp.put(c, 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        if(str1.length() != str2.length()) System.out.println("Not an Anagram!");
//        else{
//            Map<Character, Integer> mp1 = new HashMap<>();
//            Map<Character, Integer> mp2 = new HashMap<>();
//
//            makeFrequencyMap(mp1, str1);
//            makeFrequencyMap(mp2, str2);
//
//            //check if the frequency of every character matches
////            boolean flag = true;
////            for(int i = 0; i<str1.length(); i++){
////                if(mp1.get(str1.charAt(i)) != mp2.get(str2.charAt(i))){
////                    flag = false;
////                    break;
////                }
////            }
//            boolean flag = mp1.equals(mp2);
//            if(flag) System.out.println("It is Anagram");
//            else System.out.println("Not an Anagram!");
//        }
          else{ //OPTIMIZING SPACE
              Map<Character, Integer> mp = new HashMap<>();
              //WE CAN ADD THE FREQUENCY OF CHARACTERS OF ONE STRING TO THE MAP, AND DECREASE THE FREQUENCY OF CHARACTERS OF OTHER STRING. SO THAT IF IT'S AN ANAGRAM THE RESULTANT MAP SHOULD HAVE 0 AS IT'S FREQUENCY FOR EVERY CHARACTER
             makeFrequencyMap(mp, str1);

             //traverse str2 and decrease the frequency
            boolean flag = true;
            for(int i = 0; i<str2.length(); i++){
                char c = str2.charAt(i);
                if(mp.containsKey(c)) mp.put(c, mp.get(c)-1);
                else {
                    flag = false;
                    break;
                }
            }

            //check if frequency of all the characters is 0 to be an anagram
            for(var item: mp.entrySet()){
                if(item.getValue() != 0){
                    System.out.println("Not an anagram!");
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("It is Anagram");

        }
    }
}
