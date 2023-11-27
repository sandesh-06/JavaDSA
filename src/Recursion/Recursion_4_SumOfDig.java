package Recursion;

import java.util.Scanner;

public class Recursion_4_SumOfDig {
    static int sumOfDig(int n){
        //the base case
        if(n>=0 && n<=9){   //eg: sumOfDig(3) is 3 itself
            return n;
        }

        //the recursive work
        int restDig = n/10;

        //self work
        return sumOfDig(restDig) + (n%10);
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println(sumOfDig(n));
    }
}
