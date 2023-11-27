package Recursion;

import java.util.Scanner;

public class Recursion_7_Multiples {
    static void printMultiples(int n, int k){
        int subProb;
        if(k == 1){
            System.out.println(n);
            return;
        }

        printMultiples(n, k-1);
        System.out.println(n * k);
    }

    public static void main(String[] args) {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        printMultiples(n, k);
    }
}
