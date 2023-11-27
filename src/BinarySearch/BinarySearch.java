package BinarySearch;

import java.util.Scanner;

/* Binary search only works on Sorted Array.
   Everytime the array is divided into half to search of the element, which reduces the time complexity*/
public class BinarySearch {
    static boolean binarySearch(int[] arr, int start, int end, int target){
       /*int len = arr.length;
       int start = 0, end = len-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(arr[mid] == target) return true;
            else if (target > arr[mid]) start = mid+1;
            else end = mid-1;
        }
        return false;*/

        //Recursive approach
        if(start>end) return false;
        int mid = start + (end - start)/2; //this is done to avoid overflow of value. This is a better way to find mid in any case

        if(arr[mid] == target) return true;
        else if (target > arr[mid]) return binarySearch(arr, mid+1, end, target);
        else return binarySearch(arr, start, mid-1, target);

    }
    public static void main(String[] args) {
        int[] arr = { 2, 4, 8, 11, 17, 24, 44, 76, 92};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to be searched: ");
        int target = sc.nextInt();
//        boolean res = binarySearch(arr, target); loop approach
        boolean res = binarySearch(arr, 0, arr.length-1, target); //recursive approach
        System.out.println(res);
    }
}
