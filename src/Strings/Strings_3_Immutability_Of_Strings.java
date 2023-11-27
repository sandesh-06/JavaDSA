package Strings;

public class Strings_3_Immutability_Of_Strings {
    public static void main(String[] args) {
        String str = "Hello Bro";
        str.charAt(3); //gives 'l'
        //but can we update the character at a index?
//        str.charAt(3) = 'D'; //this gives error.

        //Unlike arrays we cannot replace a character at any particular index in a STRING. This is called immutability of Strings

        //But what if we want to change a character?
        String str1 = "Dello"; //either change the whole string

        //efficient way is by using substring() method.
        //suppose say you wanna change "Hello Bro" to "Heylow Bro";
        str = str.substring(0, 2) + 'y' + str.substring(3, 5) + 'w' + str.substring(5);
        System.out.println(str);
        //but note that it may have some performance issue caz, 5 separate strings(for the above case) are created and joined together
    }
}
