package Recursion;

import java.util.Scanner;

public class Recursion_8_AlternateSum {
    static int alternateSum(int n){
        //eg for n=5: 1-2+3-4+5
        //eg for n=4: 1-2+3-4

        if(n == 0) return 0;

        if(n % 2 == 0) return alternateSum(n-1) - n; //if n is odd
        else return alternateSum(n-1) + n; //if n is even
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        System.out.println(alternateSum(n));

    }
}
