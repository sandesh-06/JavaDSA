package Recursion;

import java.util.Scanner;

//RECURSION METHOD:
//1. IDENTIFY BASE CASE
//2. IDENTIFY THE RECURSIVE WORK
//3. IMPLEMENT THE SELF WORK

public class Recursion_1_PrintNumbers {
    static void printNumbers(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }

//        System.out.println(n); //prints decreasing
        printNumbers(n-1);//Assume this prints from 1 2 3....n-1
        System.out.println(n);//this prints the remaining 'n'
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNumbers(n);
    }
}
