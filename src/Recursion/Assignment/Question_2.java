package Recursion.Assignment;

import java.util.Scanner;

public class Question_2 {
    static int printMthSummation(int n, int m){
       if(m==1){
           return (n * (n+1) / 2 ); //formula for 1st n natural nos.
       }
       int sum = printMthSummation(n, m-1);
       return (sum * (sum + 1 ) / 2);

    }
    public static void main(String[] args) {
        int n, m;
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        System.out.println(printMthSummation(n, m));
    }
}
