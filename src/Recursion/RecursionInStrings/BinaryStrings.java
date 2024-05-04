package Recursion.RecursionInStrings;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/-binary-strings-with-no-consecutive-1s._893001?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

public class BinaryStrings {

    private static void generateBinaryStringsHelper(int N, String currentString, List<String> result) {
        // Base case: If the length of the current string is equal to N, add it to the result
        if (currentString.length() == N) {
            result.add(currentString);
            return;
        }
        //add 0s to the string
        generateBinaryStringsHelper(N, currentString + '0', result);

        //if the last char is not '1' add, '1' to the string
        if (currentString.isEmpty() || currentString.charAt(currentString.length() - 1) != '1') {
            generateBinaryStringsHelper(N, currentString + '1', result);
        }


    }
    public static List<String> generateBinaryStrings(int N) {
        List<String> result = new ArrayList<>();
        generateBinaryStringsHelper(N, "", result);
        return result;
    }

    public static void main(String[] args) {
        int N = 3;
        System.out.println(generateBinaryStrings(N));
    }
}
