package Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_1_ReverseQueue {
    static void reverseFullQueue(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();

        //push the elements from q to stack
        while(!q.isEmpty()){
            st.push(q.remove());
        }

        //now push the elements from stack to queue
        while(!st.isEmpty()){
            q.add(st.pop());
        }
    }

    static void reverseKelements(Queue<Integer> q, int k){
        Stack<Integer> st = new Stack<>();

        //add the first k elements to the stack, st - [3 4 5]
        for(int i = 0; i<k; i++){
            st.push(q.remove());
        }

        //now push the elements from stack to queue, q - [6 7 8 5 4 3]
        while(!st.isEmpty()){
            q.add(st.pop());
        }

        //remove the len - k elements from the front of the queue, and add it behind, q - [5 4 3 6 7 8]
        for(int i = 0; i<q.size()-k; i++){
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        System.out.println("Original Queue: " + q);
        reverseFullQueue(q);
        System.out.println("Reversed Queue: " + q);
        reverseFullQueue(q); //restoring back to original form

        //WRITE A FUNCITON TO REVERSE UPTO K ELEMENTS ONLY
        System.out.println("Queue before reversing first 3 elements: " + q);
        reverseKelements(q, 3);
        System.out.println("Queue after reversing first 3 elements: " + q);

    }
}
