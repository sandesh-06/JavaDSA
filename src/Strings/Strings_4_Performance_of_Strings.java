package Strings;

public class Strings_4_Performance_of_Strings {
    public static void main(String[] args) {
        //Because of the immutability of Strings, their performance is not that efficient. Lets look at a example
        String str = "";
        for(int i = 1; i<=10; i++){
            str+=i;
        }
        System.out.println(str);
        //the above code will print "12345678910" as expected. But its not like first "1" is added then 2 is added to become "12".
        //how it works is:
        //"" , "1", "12", "123", "1234", .... so everytime the old string is copied to a new string before adding the character. All the old strings are left as garbage values.
        //Efficient use of strings can be done using STRING BUILDER
    }
}
