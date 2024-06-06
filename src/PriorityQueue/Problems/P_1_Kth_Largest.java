package PriorityQueue.Problems;

import java.util.PriorityQueue;

//Given an array and integer k, return the kth largest element in the array.
public class P_1_Kth_Largest {
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 9, 5};
        int k = 3;
        /*
            1. Maintain a PQ of size 'k'.
            2. Add first k elements to the PQ.
            3. The top will always have the minimum value.
            4. Traverse the array and if a value > PQ.peek(), swap the value
            5. Once all the elements are traversed the PQ will have k largest elements from the array, and the smallest among the k largest
                will be on the top of the PQ
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            if(pq.size() == k){
                if(pq.peek() < arr[i]) {
                    pq.remove();
                    pq.add(arr[i]);
                }else continue;
            }else{
                pq.add(arr[i]);
            }
        }
        System.out.println(pq.peek());
    }
}
