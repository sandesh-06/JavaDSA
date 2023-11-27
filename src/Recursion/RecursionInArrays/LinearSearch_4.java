package Recursion.RecursionInArrays;

public class LinearSearch_4 {
    static boolean linearSearch(int[] arr, int target, int n, int idx){
        if(idx >= n){   //if the index value has crossed the length of array
            return false;
        }

        //self work - check for the first element
        if(arr[idx] == target) return true;

        //recursive work - let recursion do for rest of the array
        return linearSearch(arr, target, n, idx+1);
    }
    public static void main(String[] args) {
        int[] arr = {3, 5 ,6, 2, 7, 23, 67};
        int target = 9;
        if(linearSearch(arr, target, arr.length, 0)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
