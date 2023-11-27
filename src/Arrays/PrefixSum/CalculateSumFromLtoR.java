/*
GIVEN AN ARRAY OF INTEGERS OF SIZE N. ANSWER Q QUERIES WHERE YOU NEED TO PRINT THE SUM OF VALUES IN A GIVEN RANGE OF INDICES FROM L TO R (BOTH INCLUDED).
NOTE: THE VALUES OF L AND R IN QUERIES FOLLOW 1 BASED INDEXING.
*/

package Arrays.PrefixSum;
import java.util.Scanner;

import static Arrays.TwoPointerArray.Sort0and1.printArray;

public class CalculateSumFromLtoR {
    static int calculateSum(int[] arr, int l, int r){
        //In this case the time complexity is too large for n queries(we haven't done for n queries, but just saying)
        int sum = 0;
        for(int i = l; i <= r; i++){
            sum += arr[i];
        }
        return sum;
    }

    static int[] prefSum(int[] arr){
//        int[] pref = new int[arr.length];
//        for(int i = 1; i<arr.length; i++){
//            pref[i] = pref[i-1] + arr[i];
//        }
        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i];
        }
        return arr;
    }
    public static void main(String[] args) {
        int arrSize, from, to;
        System.out.println("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        arrSize = sc.nextInt();
        int[] arr = new int[arrSize+1];

        System.out.println("Enter array elements:");
        //for 1 based indexing, as it was given in question to follow 1 based indexing
        for(int i=1; i<=arrSize; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(arr.length);

     /* from = sc.nextInt():
        to = sc.nextInt();
        System.out.println(calculateSum(arr, from, to));*/ //this is not a optimized solution

        //THE OPTIMIZED SOLUTION:

        int[] pref = prefSum(arr);
        printArray(pref);
        int q,l,r, sum = 0;
        System.out.println("Enter the num of queries:");
        q = sc.nextInt();
        while(q-- > 0){
            System.out.println("Enter the range(from and to) of indices: ");
            l = sc.nextInt();
            r = sc.nextInt();
            sum = pref[r] - pref[l - 1];
            System.out.println("The sum from indices " + l + " to " + r + " is " + sum);
        }
    }
}
