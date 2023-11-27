package TwoD_Arrays;

import java.util.Scanner;

import static TwoD_Arrays.MatrixAddition.print2DArray;

public class CreateSpiralMatrix {
    static int[][] printSpiralMatrix(int n){
        int[][] spiralMat = new int[n][n];
        int currentElement = 1;
        int topRow = 0, bottomRow = n-1, leftCol = 0, rightCol = n-1;
        while(currentElement <= n*n){

            //add ele in topRow - from left to right
            for(int j = leftCol; j<=rightCol && currentElement <= n*n; j++){
                spiralMat[topRow][j] = currentElement;
                currentElement++;
            }
            topRow++;

            //add ele in rightCol - from top to bottom
            for(int i = topRow; i<=bottomRow && currentElement <= n*n; i++){
                spiralMat[i][rightCol] = currentElement;
                currentElement++;
            }
            rightCol--;

            //add ele in bottomRow - from right to left
            for(int j = rightCol; j>=leftCol && currentElement <= n*n; j--){
                spiralMat[bottomRow][j] = currentElement;
                currentElement ++;
            }
            bottomRow--;

            //add ele in leftCol - from bottom to top
            for(int i = bottomRow; i>=topRow && currentElement <= n*n; i--){
                spiralMat[i][leftCol] = currentElement;
                currentElement++;
            }
            leftCol++;
        }
        return spiralMat;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.println("Enter the number to print spiral matrix: ");
        num = sc.nextInt();

        print2DArray(printSpiralMatrix(num));
    }
}
