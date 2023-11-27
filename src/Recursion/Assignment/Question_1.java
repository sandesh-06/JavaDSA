package Recursion.Assignment;
//Q1 - Given a number n, print the following pattern without using any loop.
//n, n-5, n-10, ..., 0, 5, 10, ..., n-5, n

import java.util.Scanner;

public class Question_1 {
    static void printPattern(int n, int m, boolean flag){
        System.out.println(m + " "); //eg: if n = 16... prints 16 at first

        //base case
        if(flag == false && n == m){  //i.e false is used to represent the 2nd half of the pattern, hence in second half if n == m, i.e if 16 == 16 return.
            return;
        }

        if(flag == true){   //prints the first half of the pattern
            if(m-5 > 0){
                printPattern(n, m-5, true);
            }else {
                printPattern(n, m-5, false);
            }
        }else{ //prints the 2nd half of the pattern
            printPattern(n, m+5, false);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPattern(n, n, true); //n - original no; n - copy of original no. which will be manipulated; true - flag condition to print 1st and 2nd half of the pattern
    }
}
