package TwoD_Arrays;

import java.util.Scanner;

import static TwoD_Arrays.MatrixAddition.create2DArray;
import static TwoD_Arrays.MatrixAddition.print2DArray;

public class RectangleSum {
    static void calculateColumnPrefixArray(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length; //considering col will be same for all the rows, if not use (if col>0)
        for(int j = 0; j<col; j++){
            for(int i = 1; i<row; i++){
                matrix[i][j] = matrix[i][j] + matrix[i-1][j];
            }
        }
    }
    static int rowColumnPrefixArr(int[][] matrix, int l1, int b1, int l2, int b2){
        calculate2DPrefixArray(matrix);
        calculateColumnPrefixArray(matrix);
        print2DArray(matrix);

        int ans = 0, sum = 0 , up = 0, left = 0, upLeft = 0;
        sum = matrix[l2][b2];
        if(l1 > 0)
            up = matrix[l1-1][b2];

        if(b1 > 0)
             left = matrix[l2][b1-1];


        if(l1 > 0 && b1 > 0)
            upLeft = matrix[l1-1][b1-1];

        ans = sum - up - left + upLeft;

        System.out.print("The sum using method 3 is: ");
        return ans;
    }
    static int[][] calculate2DPrefixArray(int[][] matrix){
        for(int i = 0; i<matrix.length; i++){
            for(int j = 1; j<matrix[i].length; j++){
                matrix[i][j] = matrix[i][j] + matrix[i][j-1];
            }
        }
        return matrix;
    }

    static int PrefixSumMethod(int[][] matrix, int l1, int b1, int l2, int b2){
        int[][] prefArr = calculate2DPrefixArray(matrix);
        int sum = 0;
        for(int i = l1; i<=l2; i++){
            if(b1 > 0) //if b1 = 0 then the index will become -1
                sum += prefArr[i][b2] - prefArr[i][b1-1];
            else
                sum += matrix[i][b2];
        }
        return sum;
    }

    static int BrutForceApproach(int[][] matrix, int l1, int b1, int l2, int b2){
        int sum=0;
        for(int i = l1; i<=l2; i++){
            for(int j = b1; j<=b2; j++){
                sum+=matrix[i][j];
            }
        }
        System.out.print("The sum of rectangle is: ");
        return sum;
    }

    public static void main(String[] args) {
        int row, col, l1, b1, l2, b2; //l and b are the points like in a graph - not length and breadth
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows and cols: ");
        row = sc.nextInt();
        col = sc.nextInt();
        int[][] matrix = create2DArray(row, col);
        print2DArray(matrix);

        System.out.println("Enter point l1 and r1(using 0th index): ");
        l1 = sc.nextInt();
        b1 = sc.nextInt();

        System.out.println("Enter point l2 and r2(using 0th index): ");
        l2 = sc.nextInt();
        b2 = sc.nextInt();

        //1. using Brut force approach
//        System.out.println(BrutForceApproach(matrix, l1, r1, l2, r2));

        //2. using prefix sum method
//        System.out.println(PrefixSumMethod(matrix, l1, b1, l2, b2));

        //3. using row and column prefix sum
        System.out.println(rowColumnPrefixArr(matrix, l1, b1, l2, b2));

    }
}
