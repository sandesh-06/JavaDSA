package Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    QUESTION: given q = [ 1 2 3 4 5 6 7 8 ], contains only even length of elements, arrange the queue in such fashion that 1st half and 2nd half are interleaved

            ans = [ 1 5 2 6 3 7 4 8 ];

*/
public class P_5_ReorderQueueUsingStack {
    static void rearrangeQueue(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();

        int mid = q.size()/2;

        //1. move the first half of the elements to the stack and push it behind the queue
        for(int i = 0; i<mid; i++){
            st.push(q.remove()); //st = [1, 2, 3, 4]
        }
        while(!st.isEmpty()) q.add(st.pop()); //q = [5 6 7 8 4 3 2 1]

        //2. now again move the first half of queue into the stack
        for(int i = 0; i<mid; i++){
            st.push(q.remove()); //st = [5, 6, 7, 8]
        }

        //3. Now first pop the top element from stack and add it in the queue, then remove the front element from q and push it to the back. Do this until the stack is empty
        while(!st.isEmpty()){
            q.add(st.pop());
            q.add(q.remove());
        }
        //the result after this while loop will be something like this, q = [8 4 7 3 6 2 5 1]

        //4. Now just reverse the queue using the stack
        while(!q.isEmpty()){
            st.push(q.remove());
        }
        while (!st.isEmpty()){
            q.add(st.pop());
        }

        //END RESULT: [ 1 5 2 6 3 7 4 8 ]
    }
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        System.out.println("Queue before reordering: " + q);
        rearrangeQueue(q);
        System.out.println("Queue after reordering: " + q);


    }
}
