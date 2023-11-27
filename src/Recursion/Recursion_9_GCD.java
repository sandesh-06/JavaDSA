package Recursion;

import java.util.Scanner;

public class Recursion_9_GCD {
    static void bruteForceGCD(int a, int b){
        int min = Math.min(a, b);
        int gcd = 0;
        for(int i = min; i >=1; i--){
            if(a % i== 0 && b % i == 0){
                gcd = i;
                break;
            }
        }
        System.out.println("The GCD for " + a + " and " + b + " is " + gcd);
    }

    static int longDivisionGCD(int a, int b){
        while(a % b!=0){
            int reminder = a % b;
            a = b;
            b = reminder;
        }
        return b;
    }

    static int euclidAlgoGCD(int a, int b){
        //EUCLID'S ALGO: gcd(x,y) = gcd(y, x%y)
        // and gcd(x,0) = x
        //eg gcd(24, 15) = gcd(15, 9) = gcd(9, 6) = gcd(6, 3) = gcd(3, 0) --> this is the base case

        if(b == 0){
            return a;
        }
        return euclidAlgoGCD(b, a%b);
    }
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
//        bruteForceGCD(a, b);
//        System.out.println(longDivisionGCD(a, b));
        System.out.println(euclidAlgoGCD(a, b));

        //IF YOU WANT TO FIND LCM:
        //LCM * GCD = X * Y -----> LCM = X * Y / GCD
    }

}
