package Stack.Basics;

import java.util.Stack;

//STACK FOLLOWS LAST IN FIRST OUT PRINCIPLE
/*
        STACK:    5 - PEEK ELEMENT.
                  4
                  3
                  2
                  1
*/
public class S_1 {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        //1. PUSH AN ELEMENT IN STACK
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);

        //2. POP OPERATION
        st.pop(); //5 will be popped
        System.out.println(st);

        //3. PEEK ELEMENT
        System.out.println("current peek element is: " + st.peek());

        //4. SIZE FUNCTION
        System.out.println("size of stack is: " + st.size());

        //5. ISEMPTY FUNCTION
        System.out.println("Is stack empty: " + st.isEmpty());
    }
}
