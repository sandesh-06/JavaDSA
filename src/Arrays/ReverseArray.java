package Arrays;

import java.util.Scanner;

public class ReverseArray {
    static void swapElements(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void usingSameArray(int[] arr){
        int i=0, j=arr.length-1;
        while(i < j){
            swapElements(arr, i, j);
            i++;
            j--;
        }
    }
    static int[] usingAnotherArray(int[] arr) {
        int[] ansArray = new int[arr.length];
        int j=0;
        for(int i = arr.length - 1; i>=0; i--){
            ansArray[j++] = arr[i];
        }
        return ansArray;
    }
    static void printArray(int[] arr){
        for(int ele: arr){
            System.out.print(ele + " ");
        }
    }
    public static void main(String[] args) {
        int arrSize, element;
        System.out.println("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        arrSize = sc.nextInt();
        int[] arr = new int[arrSize];

        System.out.println("Enter array elements:");
        for(int i=0; i<arr.length; i++){
            element = sc.nextInt();
            arr[i] = element;
        }
//        int[] ansArray = usingAnotherArray(arr);
//        printArray(ansArray);

        usingSameArray(arr);
        printArray(arr);
    }
}
