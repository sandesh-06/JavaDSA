package Strings;
import java.util.*;
public class Strings_1_Basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1. String declaration
        String str = "This is a strings";
        System.out.println(str);

        //2. Get string input
        String str1 = sc.next(); //doesn't read after a space, i.e reads only one word
        String str2 = sc.nextLine(); //reads the whole string

        //3. charAt() and length();
        char ch = str.charAt(3); //prints 'i'
        int len = str.length(); //prints 17;

        //4. indexOf() and compareTo()
        int idx = str.indexOf("i"); //returns the index of first occurrence of 'i';

        //the compareTo() func returns 0 - if str1 == str2; returns >0 - str1>str2; returns <0 - str1<str2
        //the strings are compared lexographically
        String str3 = "Second string";
        System.out.println("compareTo function: " + str1.compareTo(str3));

        //5. contains() and startsWith()
        String str4 = "Another strings";
        System.out.println(str4.contains("other")); //gives true

        System.out.println(str4.startsWith("Ano")); //true
        System.out.println(str4.startsWith("ano")); //false
        System.out.println(str4.endsWith("rings")); //false

        //6. toLowerCase(), toUpperCase(), concat()
        System.out.println(str4.toLowerCase()); //prints "another strings"
        System.out.println(str4.toUpperCase()); //prints "ANOTHER STRINGS"

        String str5 = "This is String 5";
        String str6 = "String 6 is me";
        System.out.println(str5.concat(str6)); //prints "This is String 5String 6 is me" as a new string

        //7. str + str/int/char
        str6 += "okay ah da";
        System.out.println(str6); //prints "String 6 is meokay ah da

        str5 += 'e';
        System.out.println(str5); //prints "This is String 5e"

        str5 += 10;
        System.out.println(str5); //prints "This is String 5e10"

        System.out.println("Hello" + 10 + 20); //prints "Hello1020"

        //7. substring()
        String str7 = "Even im a string";
        System.out.println(str7.substring(10)); //"string"
        System.out.println(str7.substring(3, 8)); //prints from index 3 to 7;

    }
}
