package PriorityQueue.Problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
    Given an array of n integers. You are supposed to perform k operations on it. At each operation,
    the smallest 2 elements of the array are removed from the array, multiplied by each other, and the product is added back to the array.
    Return the largest element of the array after the k operations.
    It is guaranteed that at least one element will remain after the k operations.

    eg:
    n = 5, k = 3
    arr = {2, 4, 3, 1, 5}
    output = 20

    logic:
    min 2 = 1, 2 => mul and add to array = {4, 3, 5, 2}
    min 2 = 2, 3 => mul and add to array = {4, 5, 6}
    min 2 = 4, 5 => mul and add to array = {6, 20}
    3 operations done, now return the max one = 20
*/
public class P_3_PerformKOperations {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(2);
        ls.add(4);
        ls.add(3);
        ls.add(1);
        ls.add(5);
        int k = 3;

        //1. add all the elements to the pq.
        PriorityQueue<Integer> pq = new PriorityQueue<>(ls);


        //2. iterate k times
        for(int i = 0; i < k; i++){
            //3. remove the top 2 elements of the PQ (2 min elements)
            int ele1 = pq.remove();
            int ele2 = pq.remove();

            //4. mul the two elements and add to the pq again
            pq.add(ele1 * ele2);
        }
        //5. to get the max element from the min heap(PQ), keep removing elements until only 1 element left
        while(pq.size() != 1) pq.remove();

        //6. return the peek element
        System.out.println(pq.peek());
    }
}
