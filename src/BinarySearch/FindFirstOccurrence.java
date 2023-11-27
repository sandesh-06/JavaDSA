package BinarySearch;

import java.util.Scanner;

/* FINDING THE FIRST OCCURRENCE OF AN ELEMENT USING BINARY SEARCH*/

public class FindFirstOccurrence {
    static int findFirstOccur(int[] arr, int target){
        int arrLen = arr.length;
        int start = 0, end = arrLen-1;
        int firstOccIdx = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(target==arr[mid]){
                firstOccIdx = mid; //if the target is found at mid, update the firstOccIdx and check if any other number exists to it's left. If it does then that will be the first occurring element
                end = mid-1;
            }
            else if(target > arr[mid]) start = mid+1;
            else end = mid-1;
        }
        return firstOccIdx;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 5, 5, 5, 5, 8, 9, 9};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. to find it's first occ: ");
        int target = sc.nextInt();
        System.out.printf("The fist occurring %d is at index %d", target, findFirstOccur(arr, target));
    }
}
