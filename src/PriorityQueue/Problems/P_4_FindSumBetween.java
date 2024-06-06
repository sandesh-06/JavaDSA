package PriorityQueue.Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
    Given an array A[] of N positive integers and two positive integers K1 and K2.
    Find the sum of all elements between K1th and K2th smallest elements of the array.
    It may be assumed that (1 <= k1<k2 <=n).
    eg:
    arr = {20, 8, 22, 4, 12, 10, 14}
    k1 = 3, k2 = 6
    output = 26

    logic:
    k1th smallest = 10
    k2th smallest = 22
    nos between 10, 22 = 12, 14
    sum of 12 + 14 = 26
*/
public class P_4_FindSumBetween {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(20);
        ls.add(8);
        ls.add(22);
        ls.add(4);
        ls.add(12);
        ls.add(10);
        ls.add(14);
        int k1 = 3;
        int k2 = 6;

        PriorityQueue pq = new PriorityQueue<>(ls);

        //1. remove the top k1 smallest elements
        int k = 1;
        while(k != k1 + 1){
            pq.remove();
            k += 1;
        }

        //2. keep removing and add the top elements until you reach the k2th smallest element
        int sum = 0;
        while(k != k2){
            sum += (int) pq.remove();
            k++;
        }

        //3. return the sum
        System.out.println(sum);
    }
}
