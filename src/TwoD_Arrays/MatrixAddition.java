package TwoD_Arrays;
import java.util.Scanner;
public class MatrixAddition {
    public static int[][] create2DArray(int row, int column){
        int[][] twoDArray = new int[row][column];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<row; i++){
            System.out.println("Enter row " + (i+1) + " elements: ");
            for(int j=0; j<column; j++){
                twoDArray[i][j] = sc.nextInt();
            }
        }
        return twoDArray;
    }
    public static void print2DArray(int[][] arr) {
        System.out.println("The 2D array is: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] calculateSum(int[][] arr1, int row1, int column1, int[][] arr2, int row2, int column2){
        int[][] sumArray = new int[row1][column1];
        if(row1 == row2 && column1 == column2){
            for(int i =0;i<row1;i++){
                for(int j=0; j<column1; j++){
                    sumArray[i][j] = arr1[i][j]+arr2[i][j];
                }
            }
        }else {
            System.out.println("Rows and columns do not match - Addition cannot be performed");
        }
        return sumArray;
    }
    public static void main(String[] args) {
        int row1, column1, row2, column2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of row and column of array1: ");
        row1 = sc.nextInt();
        column1 = sc.nextInt();
        int[][] arr1 = create2DArray(row1, column1);

        System.out.println("Enter the no.of row and column of array2: ");
        row2 = sc.nextInt();
        column2 = sc.nextInt();
        int[][] arr2 = create2DArray(row2, column2);

        int[][] sumArray = calculateSum(arr1, row1, column1, arr2, row2, column2);
        print2DArray(sumArray);

    }
}
