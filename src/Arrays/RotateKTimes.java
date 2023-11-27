package Arrays;

import java.util.Scanner;

public class RotateKTimes {
    static void swapElements(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void reverseArray(int[] arr, int st, int end){
        while(st < end){
            swapElements(arr, st, end);
            st++;
            end--;
        }
    }
    static void rotateKUsingSameArray(int[] arr, int k){
        //taking arr = 1 2 3 4 5 6 7, rotate 2 times
        int n = arr.length; //7
        k = k % n; //2 % 7 = 2
         reverseArray(arr, 0, n-k-1); //st 0, end 4 - 5 4 3 2 1 | 6 7
         reverseArray(arr, n-k, n-1); //st 5, end 6 - 5 4 3 2 1 | 7 6
         reverseArray(arr, 0, n-1); //reverse fully - 6 7 1 2 3 4 5 and hence the array is rotated 2 times

        System.out.println("The array after rotating " + k + " times is: ");
        printArray(arr);
    }
    static void rotateK(int[] arr, int k){
        int n = arr.length;
        k = k % n; //because suppose say n = 5 and k = 6, 6 % 5 = 1. Which means we just need to rotate it one time. i.e 1 rotation = 6 rotation for n = 5.
        int[] ans = new int[n];
        int j = 0;
        //we are taking the elements from n-k to n-1.i.e 5-1=4 to 5-1=4.
        for(int i = n-k; i < n ; i++){
            ans[j++] = arr[i]; //ans[0] = arr[4]. hence the last element has come to the first indicating that array has been rotated once
        }
        for(int i = 0; i <= n-k-1; i++){ //remaining elements 0 to 5-1-1 = 3 to be added in the ans array
            ans[j++] = arr[i];
        }
        System.out.println("The array after rotating " + k + " times is: ");
        printArray(ans);
    }
    static void printArray(int[] arr){
        for(int ele: arr){
            System.out.print(ele + " ");
        }
    }
    public static void main(String[] args) {
        int arrSize, element, times;
        System.out.println("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        arrSize = sc.nextInt();
        int[] arr = new int[arrSize];

        System.out.println("Enter array elements:");
        for(int i=0; i<arr.length; i++){
            element = sc.nextInt();
            arr[i] = element;
        }

        System.out.println("How many times do you want to rotate: ");
        times = sc.nextInt();

//        rotateK(arr, times);
        rotateKUsingSameArray(arr, times);
    }
}
