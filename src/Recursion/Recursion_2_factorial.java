package Recursion;

import java.util.Scanner;

public class Recursion_2_factorial {
    //effective method
//    static int findFact(int n){
//        if(n == 1) return 1;
//
//       return n * findFact(n-1);
//
//    }

    static int findFact(int n){
        if(n == 1){
            return 1;
        }
        //the subproblem
        int smallAns = findFact(n-1);

        //the self work
        return n * smallAns;

    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(findFact(n));
    }
}
