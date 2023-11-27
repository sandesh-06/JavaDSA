package Arrays.PrefixSum;
import java.util.Scanner;
import static Arrays.TwoPointerArray.Sort0and1.printArray;

public class EqualPartitionSum {
    //extra question
    static int[] findSuffixSumArray(int[] arr){
        for(int i = arr.length-2; i >= 0; i--){
            arr[i] = arr[i+1] + arr[i];
        }
        return arr;
    }
    static int calculateTotalSum(int[] arr){
        int totalSum = 0;
        for(int i=0; i<arr.length; i++){
            totalSum+=arr[i];
        }
        return totalSum;
    }
    static boolean isPrefixSumEqualsSuffixSum(int[] arr){
        int totalSum = calculateTotalSum(arr);
        int prefSum = 0;
        for(int i = 0; i<arr.length; i++){
            prefSum += arr[i];
            int suffSum = totalSum - prefSum;
            if(suffSum == prefSum){
                return true;
            }
        }
        return false;
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

        System.out.println("Equal partition is possible in the array: " + isPrefixSumEqualsSuffixSum(arr));

        System.out.println("The suffix sum array is: ");
        printArray(findSuffixSumArray(arr));
    }
}
