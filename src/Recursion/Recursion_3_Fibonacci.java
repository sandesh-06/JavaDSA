package Recursion;

import java.util.Scanner;

public class Recursion_3_Fibonacci {
    static int fib(int n){
        //the base case
        if(n == 0 || n == 1){
            return n;
        }

        //the sub problem
        int prev = fib(n-1);
        int prevPrev = fib(n - 2);

        //the self work
        return prev + prevPrev;
        //or return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println(fib(n));

        System.out.println("Printing the first " + n + " terms: " );
        for(int i = 0; i <= n; i++){
            System.out.println(fib(i));
        }
    }
}
