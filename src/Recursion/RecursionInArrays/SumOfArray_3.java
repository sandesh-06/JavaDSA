package Recursion.RecursionInArrays;

public class SumOfArray_3 {
    static int sumOfArray(int[] arr, int idx){
        if(idx == arr.length){
            return 0; //works for empty array too
        }
        return sumOfArray(arr, idx+1) + arr[idx];

    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 12, 5, 2};
        System.out.println(sumOfArray(arr, 0));
    }
}
