package Recursion.RecursionInArrays;

public class PrintArrayElements_1 {
    static void printElements(int[] arr, int idx){
        //base case
        if(idx == arr.length){
            return; //eg: if len of arr is 4, there is no index 4, hence just return
        }

        //self work
        System.out.println(arr[idx]);

        //recursive work
        printElements(arr, idx+1);

    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8 };
        printElements(arr, 0); //initially the passed index value is 0;
    }
}
