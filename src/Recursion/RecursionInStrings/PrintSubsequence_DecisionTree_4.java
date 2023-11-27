package Recursion.RecursionInStrings;

import java.util.Scanner;

public class PrintSubsequence_DecisionTree_4 {
    static void printSubsequence(String str, String currAns){   //str - 'abc, currAns - " "
        //base case
        if(str.length() == 0){     //at the last when the tree looks like  " ", 'abc';  " ", 'bc' etc
            System.out.println(currAns);
            return;
        }

        char curr = str.charAt(0); // a
        String remainingStr = str.substring(1); // bc

        //currAns --> when the character decides to be a part of ans
        printSubsequence(remainingStr, currAns + curr);  // bc, a

        //currAns --> when the character decides not to be a part of ans
        printSubsequence(remainingStr, currAns);  //bc, " "
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        printSubsequence(str, " ");


    }

}
