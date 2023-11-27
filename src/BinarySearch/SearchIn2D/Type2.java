package BinarySearch.SearchIn2D;

import java.util.Scanner;

/* IN this 2D matrix both rows and colmns are sorted, something like this:
        2   4   5  8
        7  11  15  20
        9  14  21  30

   So the 2nd point in the "Type1" question will not be valid here, how are you gonna solve this?

   CONDITION: If currEle = 8, the elements to it's left are smaller
                               the elements below are greater*/
public class Type2 {
    static boolean searchTarget(int[][] arr, int target){
        int n = arr.length, m = arr[0].length;
       int i = 0, j = m-1;

       while(i<n && j>=0){ //the pointer should be within boundary
           int currEle = arr[i][j];
           if(target == currEle) return true;
           else if (target<currEle) {
               j--;  //if target < currEle move towards left
           }
           else{
               i++; //if target > currEle move downwards
           }
       }
        return false;

    }
    public static void main(String[] args) {
        int[][] arr = {{2, 4, 5, 8}, {7, 11, 15, 20}, {9, 14, 21, 30}};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target element: ");
        int target = sc.nextInt();
        System.out.println(searchTarget(arr, target));

    }
}
