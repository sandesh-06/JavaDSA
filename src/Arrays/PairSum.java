package Arrays;

import java.util.Scanner;

//find the total no of pairs in the array whose sum is equal to the given target
public class PairSum {
    static void FindNoOfTripletSum(int[] arr, int target){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] == target){
                        System.out.println("[" +arr[i] + "," + arr[j] + "," + arr[k] + "]");
                        sum++;
                    }
                }
            }
        }
        System.out.println("There are " + sum + " triplets which adds up to " + target);
    }
    static void FindNoOfPair(int[] arr, int target){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == target){
                    System.out.println(arr[i] + " and " + arr[j]);
                    sum++;
                }
            }
        }
        System.out.println("There are " + sum + " pairs which adds up to " + target);
    }
    public static void main(String[] args) {
        int arrSize, element, sumToFind;
        System.out.println("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        System.out.println("Enter array elements:");
        for(int i=0; i<arr.length; i++){
            element = sc.nextInt();
            arr[i] = element;
        }

        System.out.println("Enter the target sum: ");
        sumToFind = sc.nextInt();

        FindNoOfPair(arr, sumToFind);
//        FindNoOfTripletSum(arr, sumToFind);
    }

}
