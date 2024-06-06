package PriorityQueue.Basics;

import java.util.PriorityQueue;

public class B_1_Operations {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //by default implements min heap

        //1. Add
        pq.add(20);
        pq.add(30);
        pq.add(10);
        pq.add(7);

        //The minimum element is always at the top
        System.out.println(pq.peek()); // 7

        //2. Delete
        pq.remove(); //removes 7
        System.out.println(pq.remove()); //removes and prints 10
        System.out.println(pq.peek()); // 20
    }
}
