package Stack.Problems;

import java.util.Stack;

public class P_14_SortStack {
    private static void sortedInsert(Stack<Integer> st, int curr_ele){
        Stack<Integer> temp = new Stack<>();

        if(st.isEmpty() || curr_ele >= st.peek()) st.push(curr_ele);
        else{
            while(!st.isEmpty() && curr_ele < st.peek()) temp.push(st.pop());
            st.push(curr_ele);
            while(!temp.isEmpty()) st.push(temp.pop());
        }
    }
    private static void helper(Stack<Integer> st){
        if(st.isEmpty()) return;

        int curr_ele = st.pop();
        sortStack(st);
        sortedInsert(st, curr_ele);
    }
    public static Stack<Integer> sortStack(Stack<Integer> s) {
        //Write your code here
        helper(s);
        return s;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(0);
        st.push(0);
        st.push(2);
        System.out.println(sortStack(st));
    }
}
