package Arrays.PrefixSum;

import java.util.Scanner;

import static Arrays.TwoPointerArray.Sort0and1.printArray;

public class PrefixSum {
    static int[] UsingTheSameArray(int[] arr){
        for(int i=1; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i];
        }
        return arr;
    }
    static int[] UsingDiffArray(int[] arr){
        int[] pref = new int[arr.length];
        pref[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            pref[i] = pref[i-1] + arr[i];
        }
        return pref;
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

        System.out.println("The prefix sum array is:");
//        printArray(UsingDiffArray(arr));
        printArray(UsingTheSameArray(arr));
    }
}
