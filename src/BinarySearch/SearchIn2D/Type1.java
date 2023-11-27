package BinarySearch.SearchIn2D;

/*Search target in 2D array, if not found return false.
    1. Integers in each row are sorted from left to right
    2. The first int of each row is greater than the last integer of the prev row.*/

import java.util.Scanner;

/*NOTE: TO CONVERT A NUMBER TO 2D ARRAY'S INDEX:
  row no = number/col;  col no = number % col*/
public class Type1 {
    static boolean searchTarget(int[][] arr, int target){
        //Use the same binary search concept, all you have to do is  to convert the normal index to 2D index.

        //rows              //cols
        int n = arr.length, m = arr[0].length;
        int start = 0, end = n*m - 1;

        while(start<=end){
            int mid = start + (end - start)/2;
            int midEle = arr[mid/m][mid%m];
            if(midEle == target){
                return true;
            }
            else if (target < midEle) {
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7},
                       {10, 11, 16, 20},
                      {23, 30, 34, 60}};
        //consider the above array in a single line, and give them index accordingly. artham aindha raja? EG: 16 is index 6, 34 is index 10.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target: ");
        int target = sc.nextInt();
        System.out.println(searchTarget(arr, target));
    }
}
