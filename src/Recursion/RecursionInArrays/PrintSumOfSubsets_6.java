package Recursion.RecursionInArrays;

public class PrintSumOfSubsets_6 {
    static void sumOfSubsets(int[] arr, int len, int idx, int currSubSetSum){
        //base case
        if(idx >= len){
            System.out.println(currSubSetSum);
            return;
        }
        //include curr value in prev sum
        sumOfSubsets(arr, len, idx+1, currSubSetSum + arr[idx]);

        //exclude curr value in prev sum
        sumOfSubsets(arr, len, idx+1, currSubSetSum);

    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 5};
        sumOfSubsets(arr, arr.length, 0, 0);
    }
}
