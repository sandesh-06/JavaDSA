package Recursion;

import java.util.Scanner;

public class Recursion_5_NoOfDig {
    static int NoOfDig(int n){
        if(n>=0 && n<=9) return 1;
        return NoOfDig(n/10) + 1;
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println(NoOfDig(n));
    }
}
