package Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_2_ImplementStackUsingQueue {
    public static class StackUsingQueue{
       Queue<Integer> q = new LinkedList<>();

       void push(int val){
           q.add(val);
       }

       int pop(){
           //take the elements from the start and push it to the last until the last elements comes at front
           for(int i = 0; i< q.size()-1; i++){
               q.add(q.remove());  //5 1 2 3 4
           }
           return q.remove(); //5 remove and return the front element
       }

       int peek(){
           for(int i = 0; i< q.size()-1; i++){
               q.add(q.remove()); //5 1 2 3 4
           }
           int ele = q.peek(); //5
           q.add(q.remove()); //push the peek element again to the back, 1 2 3 4 5
           return ele;
       }

       void display(){
           System.out.println(q);
       }
    }
    public static void main(String[] args) {

        StackUsingQueue stq = new StackUsingQueue();
        stq.push(1);
        stq.push(2);
        stq.push(3);
        stq.push(4);
        stq.push(5);
        stq.display();

        stq.pop();
        stq.display();

        System.out.println(stq.peek());
    }
}
