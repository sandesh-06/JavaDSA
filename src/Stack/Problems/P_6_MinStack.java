package Stack.Problems;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
//At any point of the stack you need to get the minimum value
//You need to achieve the getMin() function in O(1) time and O(1) space.
public class P_6_MinStack {
    public static class MinStack {
        static Stack<Integer> st = new Stack<>();
        static Stack<Integer> min = new Stack<>();
        //APPROACH 1: Use another stack and store the minimum value, for every element you push. So that at the point you know the minimum value of the stack
        static void push(int val) {
            //1. if stack is empty just push the value to both the stacks
            if(st.isEmpty()){
                st.push(val);
                min.push(val);
            }
            //IF WE DON'T WANT ANY VALUE
            else{
                //2. if the val < peek of min stack, then push val to both
                if(val<min.peek()){
                    st.push(val);
                    min.push(val);
                }
                //3. if val > peek of min, then again push peek of stack to min
                else{
                    st.push(val);
                    min.push(min.peek());
                }
            }
        }

        static void pop() {
            st.pop();
            min.pop();
        }

        static int top() {
            return st.peek();
        }

        static int getMin() {
            return min.peek();
        }
    }

    public static class OptimizedMinStack{
        Stack<Integer> st = new Stack<>();
        int min = -1; //we are gonna use only this variable to retrieve min at any given point of time in stack
        void push(int val){
            if(st.isEmpty()){
                st.push(val);
                min = val;
            }
            else{
               if(val < min){ //say 3 < 5.
                 st.push(val-min); //push(-2)....when val < min, push an imposter value, which is less than val itself.
                 min  = val;  //min = 3.
               }
               else{
                   st.push(val);
               }
            }
        }

        void pop(){
            if(st.peek() > min) st.pop();
            else { //-2 < 3
                //when peek < min, imposter value found. Use the imposter value to restore the min value.
                //peek = newMin - oldMin; => oldMin = newMin - peek;
                min = min - st.peek();
                st.pop();
            }
        }

        int top(){
            if(st.peek() < min){ //imposter value encountered, in this condition the actual top value is stored in 'min'
                return min;
            }
            else return st.peek();
        }

        int getMin(){
            return min;
        }
    }

    public static void main(String[] args) {
        //perform stack operations and try to find after certain operations
        MinStack.push(8);
        MinStack.push(7);
        MinStack.push(5);
        MinStack.push(6);
        MinStack.push(3);
        System.out.print("the min for stack " + MinStack.st + " is: " + MinStack.getMin());
        System.out.println();
        MinStack.pop();

        System.out.print("the min for stack " + MinStack.st + " is: " + MinStack.getMin());
        System.out.println();
        System.out.println();
        //THIS METHOD HAS O(1) TIME COMP. BUT O(N) SPACE COMP.


        //NOW TRY TO ACHIEVE THE SAME IN O(1) TIME AND SPACE COMPLEXITY
        System.out.println("Trying in O(1) complexity for both Time and Space: ");
        OptimizedMinStack obj = new OptimizedMinStack();
        obj.push(8);
        obj.push(7);
        obj.push(5);
        obj.push(6);
        obj.push(3);

        System.out.print("the min for stack " + obj.st + " is: " + obj.getMin());
        System.out.println();
        obj.pop();

        System.out.print("the min for stack " + obj.st + " is: " + obj.getMin());
        System.out.println();

        /*NOTE THERE'S A SMALL CATCH IN THIS CODE, WHEN WE ADD NEGATIVE VALUES TO THE STACK, IT DOESN'T FIT BECAUSE WHEN WE TRY TO
                              (peek = -2 - (-3)) = 1                                      (min = 1 - (-2)) = 3 (but ans is -3)
          CALCULATE MIN USING "PEEK = VALUE - MIN"  AND AGAIN WHEN WE RETRIEVE THE VALUE "MIN = PEEK - VALUE"   WE MAY GET WRONG VALUE IN CASE OF NEGATIVE INTEGERS

          SO WE NEED TO USE 2*VAL -  MIN, AS 2*VAL - MIN, WILL ALWAYS GIVE A VALUE LESS THAN MIN.

        */
    }
}

/*  LEETCODE ANSWER
class MinStack {
    Stack<Long> st = new Stack<>();
    long min = -1; //we are gonna use only this variable to retrieve min at any given point of time in stack

    public MinStack() {

    }

    public void push(long val){
        if(st.isEmpty()){
            st.push(val);
            min = val;
        }
        else{
            if(val < min){ //say 3 < 5.
                st.push(2*val-min); //push(-2)....when val < min, push an imposter value, which is less than val itself.
                min  = val;  //min = 3.
            }
            else{
                st.push(val);
            }
        }
    }

    public void pop(){
        if(st.peek() > min) st.pop();
        else { //-2 < 3
            //when peek < min, imposter value found. Use the imposter value to restore the min value.
            //peek = 2*newMin - oldMin; => oldMin = newMin - peek;
            min = 2*min - st.peek();
            st.pop();
        }
    }

    public int top(){
        if(st.peek() < min){ //imposter value encountered, in this condition the actual top value is stored in 'min'
            return (int) min;
        }
        else{
            long peek = st.peek();
            return (int)peek;
        }
    }

    public int getMin(){
        return (int) min;
    }
}

*/