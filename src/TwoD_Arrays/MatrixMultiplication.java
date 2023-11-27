package TwoD_Arrays;
import java.util.Scanner;

import static TwoD_Arrays.MatrixAddition.create2DArray;
import static TwoD_Arrays.MatrixAddition.print2DArray;

//public class MatrixMultiplication {
//    static int[][] multiplyMatrix(int[][] arr1, int row1, int column1, int[][] arr2, int row2, int column2){
//        int[][] mulArray = new int[row1][column2];
//        if(column1 == row2){
//            for(int i = 0; i<row1; i++) {
//                for (int j = 0; j < column2; j++) {
//                   for(int k = 0; k < column1; k++){
//                       mulArray[i][j]+= arr1[i][k] * arr2[k][j];
//                   }
//                }
//            }
//        }else {
//            System.out.println("Since row of arr1 and column of arr2 are different, multiplication cannot be performed.");
//        }
//        return mulArray;
//    }
//
//    public static void main(String[] args) {
//        int row1, column1, row2, column2;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter row and column of arr1: ");
//        row1 = sc.nextInt();
//        column1 = sc.nextInt();
//        int[][] arr1 = create2DArray(row1, column1);
//        System.out.println("Enter row and column of arr2: ");
//        row2 = sc.nextInt();
//        column2 = sc.nextInt();
//        int[][] arr2 = create2DArray(row2, column2);
//
//        System.out.println("The multiplication array is: ");
//        int[][] mulArray = multiplyMatrix(arr1, row1, column1, arr2, row2, column2);
//        print2DArray(mulArray);
//    }
//}

public class MatrixMultiplication {
    static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void add(int[][] arr1, int r1, int c1, int[][] arr2, int r2, int c2) {
        if (r1 != r2 || c1 != c2) {
            System.out.println("matrix addition is not possible");
            return;
        } else {
            int[][] sum = new int[r1][c1];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    sum[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            printArray(sum);
        }

    }

    static void multiply(int[][] arr1, int r1, int c1, int[][] arr2, int r2, int c2) {
        if (c1 != r2) {
            System.out.println("matrix multiplication is not possible");
        }
        int[][] product = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += (arr1[i][k] * arr2[k][j]);
//                    System.out.println(product[i][j]);
                }

            }
        }
        printArray(product);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the no.of rows and columns for first matrix: ");
        int row = scan.nextInt();
        int column = scan.nextInt();
        int[][] arr1 = new int[row][column];
        System.out.println("enter the elements for the first matrix");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = scan.nextInt();
            }
        }
        System.out.println("enter the rows and columns of the second matrix");
        int row1 = scan.nextInt();
        int column1 = scan.nextInt();
        int[][] arr2 = new int[row1][column1];
        System.out.println("enter the elements for the second matrix");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = scan.nextInt();
            }
        }
        // int[][]arr={{1,2,3},{3,4,5},{5,6,7}};
        printArray(arr1);
        printArray(arr2);
        // add(arr1, row, column, arr2, row1, column1);
        multiply(arr1, row, column, arr2, row1, column1);
    }
}
