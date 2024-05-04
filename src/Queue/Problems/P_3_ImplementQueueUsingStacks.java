package Queue.Problems;

import java.util.Stack;

public class P_3_ImplementQueueUsingStacks {
    class MyQueue {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        public MyQueue() {

        }

        //MAKING THE QUEUE POP EFFICIENT, I.E TRYING TO ACHIEVE POP AND PEEK AT O(1) AND PUSH AT O(N)
        public void push(int x) {
            if(st.isEmpty()) st.push(x);
            else{
                //move all the elements to a temp stack, push the element at the bottom
                while(!st.isEmpty()){
                    temp.push(st.pop());
                }

                st.push(x);

                //move back the elements from temp to stack
                while(!temp.isEmpty()){
                    st.push(temp.pop());
                }
            }
        }

        public int pop() {
            //just pop the top element
            return st.pop();
        }

        public int peek() {
            return st.peek();
        }

        public boolean empty() {
            return st.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
