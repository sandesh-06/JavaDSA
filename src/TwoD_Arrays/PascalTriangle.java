package TwoD_Arrays;
import java.util.Scanner;

import static TwoD_Arrays.MatrixAddition.print2DArray;

public class PascalTriangle {
    static int[][] createPascalTriangle(int n){
        int[][] ans = new int[n][];
        int j = 0;
        while (j < n){ //run for no.of rows
            //to create new cols for each row
            ans[j] = new int[j+1]; //for 0th row 1 col, 1st row 2col;
            //first and last element should be 1
            ans[j][0] = ans[j][j] = 1;

            //give values expect 0th and last index
            for(int i = 1;i<j; i++){ //caz first and last is 1
                ans[j][i] = ans[j-1][i-1] + ans[j-1][i];
            }
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("No.of rows you need in a pascal's triangle: ");
        n = sc.nextInt();
        print2DArray(createPascalTriangle(n));
    }
}
