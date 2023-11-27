package TwoD_Arrays;
import java.util.Scanner;

import static TwoD_Arrays.MatrixAddition.create2DArray;
import static TwoD_Arrays.MatrixAddition.print2DArray;


public class TransposeOfMatrix{
    static int[][] findTranspose(int[][] arr, int row, int column){
        int[][] tranArr = new int[column][row]; //if the input is n x m then output will be m x n obviously you dumb.
        for (int i = 0; i<arr.length; i++){
            for(int j = 0 ; j<arr[i].length; j++){
                tranArr[j][i] = arr[i][j];
            }
        }
        return tranArr;
    }

    static void transposeUsingSameArray(int[][] arr, int row, int column){
        //NOTE: THIS ONLY WORKS FOR SQUARE MATRIX (N X M WHERE N = M)
        for(int i = 0; i<column; i++){
            for(int j = i; j<row; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        print2DArray(arr);
    }
    public static void main(String[] args){
        int row, column;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of rows and col for the 2D array: ");
        row = sc.nextInt();
        column = sc.nextInt();
        int[][] arr = create2DArray(row, column);
        System.out.println("The matrix is: ");
        print2DArray(arr);
        System.out.println("The Transpose of the matrix is: ");
//        print2DArray(findTranspose(arr, row, column));

        transposeUsingSameArray(arr, row, column);
    }
}
