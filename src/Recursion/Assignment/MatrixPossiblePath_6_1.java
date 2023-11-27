package Recursion.Assignment;

import java.util.Scanner;

public class MatrixPossiblePath_6_1 {
    static int findPaths(int m, int n){
        //if there is only 1 row or 1 column, only one way is possible
        if(m==1 || n == 1){
            return 1;
        }

        //asking recursion to find for the previous row + previous column
        return findPaths(m-1, n) + findPaths(m, n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n; //where m is no. of rows and n is no. of columns
        m = sc.nextInt();
        n = sc.nextInt();
        System.out.println(findPaths(m, n));
    }
}
