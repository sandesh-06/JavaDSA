package TwoD_Arrays;
import java.util.Scanner;
public class Sample {
    static Scanner sc = new Scanner(System.in);
    static void printArray(int[][] arr, int r, int c){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    static void findPrefixSum(int[][] arr, int r, int c){
        for(int i = 0; i < r; i++){
            for(int j = 1; j < c; j++){
                arr[i][j] = arr[i][j] + arr[i][j-1];
            }
        }
        printArray(arr, r, c);
    }
    static int findSum(int[][] arr, int r, int c){
        System.out.println("Prefix sum matrix: ");
        findPrefixSum(arr, r, c);
        int l1, r1, l2, r2, sum=0;
        System.out.println("Enter l1 r1 l2 r2");
        l1 = sc.nextInt();
        r1 = sc.nextInt();
        l2 = sc.nextInt();
        r2 = sc.nextInt();

        for(int i = l1; i<=l2; i++){
            if(r1>0)
                sum+= arr[i][r2] - arr[i][r1-1];
            else
                sum+=arr[i][r2];
        }
        return sum;
    }
    public static void main(String[] args) {
        int r, c;
        System.out.println("Row and Col:");
        r = sc.nextInt();
        c = sc.nextInt();
        int[][] arr = new int[r][c];

        System.out.println("Enter " + r*c + " elements: ");
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Initial Matrix:");
        printArray(arr, r, c);

        System.out.println("The sum is : " + findSum(arr, r, c));
    }
}
