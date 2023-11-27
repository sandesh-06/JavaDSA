package TwoD_Arrays;

import java.util.Scanner;

import static TwoD_Arrays.MatrixAddition.create2DArray;

public class SpiralMatrix {
    public static void spiralElements(int[][] matrix, int row, int col){
        int topRow = 0, bottomRow = row-1, leftRow = 0, rightRow = col-1;
        //run the loop for row * col elements = totalElements;
        int totalElements = 0;
        while (totalElements < row * col){
            //NOTE: i - ROW ; j - COLUMN

            //print topRow = leftRow to rightRow(row same, col++)
            for(int j = leftRow; j<=rightRow && totalElements < row * col ; j++){ //totEle < row * col - this cond is to stop any loop when all the elements are already printed
                System.out.print(matrix[topRow][j] + " ");
                totalElements++;
            }
            topRow++;

            //print rightRow = topRow to bottomRow(col same, row++)
            for(int i = topRow; i<=bottomRow && totalElements < row * col; i++){
                System.out.print(matrix[i][rightRow] + " ");
                totalElements++;
            }
            rightRow--;

            //print bottomRow = rightRow to leftRow (row same, col--)
            for(int j = rightRow; j>=leftRow && totalElements < row * col; j--){
                System.out.print(matrix[bottomRow][j] + " ");
                totalElements++;
            }
            bottomRow--;

            //print leftRow = bottomRow to topRow (col same, row--)
            for (int i = bottomRow; i>=topRow && totalElements < row * col; i--){
                System.out.print(matrix[i][leftRow] + " ");
                totalElements++;
            }
            leftRow++;
        }
    }
    public static void main(String[] args) {
        int row, col;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows and cols: ");
        row = sc.nextInt();
        col = sc.nextInt();

        int[][] matrix = create2DArray(row, col);

        spiralElements(matrix, row, col);
    }
}
