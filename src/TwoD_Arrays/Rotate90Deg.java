package TwoD_Arrays;

import java.util.Scanner;

import static TwoD_Arrays.MatrixAddition.create2DArray;
import static TwoD_Arrays.MatrixAddition.print2DArray;

/*ALGORITHM: 1. Find transpose
             2. Find reverse of each row - arr[i]*/

public class Rotate90Deg {
    static void swapElements(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void reverse(int[] arr){
        int i = 0, j = arr.length-1;
        while(i < j){
            swapElements(arr, i, j);
            i++;
            j--;
        }
    }
    static void findTranspose(int[][] matrix){
        for(int i =0; i<matrix.length; i++){
            for (int j = i; j<matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    static int[][] rotate90Deg(int[][] matrix){
        findTranspose(matrix);
        for(int i = 0; i<matrix.length; i++){
            reverse(matrix[i]);
        }
        return matrix;
    }
    public static void main(String[] args) {
        int row, col;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows and clos: ");
        row = sc.nextInt();
        col = sc.nextInt();
        int[][] matrix = create2DArray(row, col);

        print2DArray(matrix);
        print2DArray(rotate90Deg(matrix));

    }
}
