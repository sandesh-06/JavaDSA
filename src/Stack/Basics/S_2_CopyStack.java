package Stack.Basics;

/*
    MOVE THE ELEMENTS FROM ONE STACK TO ANOTHER - FROM 'ST' TO 'CT'
*/

import java.util.Stack;
public class S_2_CopyStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println("Original Stack st: " + st);
        //to move elements from one stack to another, we need a 3rd stack
        Stack<Integer> temp_stack = new Stack<>();
        //move elements from st to temp: the order is 5 4 3 2 1
        while(st.size()>0){
            temp_stack.push(st.pop());
        }
        System.out.println("Temporary Stack: " + temp_stack);

        //now move from temp to ct
        Stack<Integer> ct = new Stack<>();
        while(temp_stack.size()>0){
            ct.push(temp_stack.pop());
        }
        System.out.println("Final stack ct: " + ct);
    }
}
