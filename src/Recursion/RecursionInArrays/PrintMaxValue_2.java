package Recursion.RecursionInArrays;

public class PrintMaxValue_2 {
    static int maxValue(int[] arr, int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        //recursive work -- give me the max from idx+1 to end of array
        int cmpMax = maxValue(arr, idx+1);

        //self work -- comp ans of recursive work to the first element
        return Math.max(arr[idx], cmpMax);

    }
    public static void main(String[] args) {
        int[] arr = {15, 6, 7, 10, 9 };
        System.out.println(maxValue(arr, 0));
    }
}
