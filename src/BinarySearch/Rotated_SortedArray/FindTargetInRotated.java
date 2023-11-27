package BinarySearch.Rotated_SortedArray;

import java.util.Scanner;

/* 1. In rotated array [5, 6, 7, 1, 2, 3, 4] if you take x and y as some elements
          if x<y then we can say x to y is sorted, eg: x = 1, y = 4: we can say 1 to 4 is sorted
          if x!<y then x to y is unsorted, eg: x = 5, y = 2: we can say 5 to 1 is unsorted

          2. If you cut the array at a point into two halves:
               a. either both are sorted
               b. either one is sorted or one is unsorted
           There can never be a situation where both the parts are unsorted.

          3. If we take any range from x to y, say 1 to 4 and the target element is 3, we can look at the x and y values and say that the target is present btw them,
               i.e we can say that the target is in sorted part
        */

public class FindTargetInRotated {
    static int findTarget_NoDuplicates(int[] arr, int target) {


        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
             return mid;
            }
            else if (arr[mid] < arr[end]) { //checking if mid to end is sorted
                if (target > arr[mid] && target <= arr[end]) {  //if target lies btw them
                    start = mid + 1; //will be present somewhere towards right
                } else {
                    end = mid - 1;  //present somewhere towards left
                }
            }
            else{ //checking if start to mid is sorted
                if(target>=arr[start] && target<arr[mid]) { //if target lies btw start and mid
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    static int findTarget_withDuplicates(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
            }
            else if (arr[mid] <= arr[end]) { //checking if mid to end is sorted
                if (target > arr[mid] && target <= arr[end]) {  //if target lies btw them
                    start = mid + 1; //will be present somewhere towards right
                } else {
                    end = mid - 1;  //present somewhere towards left
                }
            }
            else{ //checking if start to mid is sorted
                if(target>=arr[start] && target<arr[mid]) { //if target lies btw start and mid
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 1, 1, 1, 2, 3, 4, 5, 1, 1};
        System.out.println("Enter the element to search: ");
        int target = sc.nextInt();
//        System.out.printf("%d is found at index %d", target, findTarget_NoDuplicates(arr, target));
        System.out.printf("%d is found at index %d", target, findTarget_withDuplicates(arr, target));
    }
}
