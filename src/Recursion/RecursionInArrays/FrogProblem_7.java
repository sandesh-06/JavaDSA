package Recursion.RecursionInArrays;

public class FrogProblem_7 {

        static int jumps(int[] arr, int idx){
            if(idx == arr.length-1) return 0; //if the frog is on last index

            int x = Math.abs(arr[idx] - arr[idx+1]) + jumps(arr, idx+1);
            if(idx == arr.length-2) return x; //if the frog is on n-2th index it only has one option

            int y = Math.abs(arr[idx] - arr[idx+2]) + jumps(arr, idx+2);

            return Math.min(x, y);

        }
        public static void main(String[] args) {
            //   System.out.println(subStr("abc", ""));
            // subStr("abc", "");
            int[] arr = {10, 30, 40, 20};
            System.out.println(jumps(arr, 0));
        }
}
