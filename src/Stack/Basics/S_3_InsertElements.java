package Stack.Basics;

//TO INSERT STACK AT ANY GIVEN INDEX.

import java.util.Stack;

public class S_3_InsertElements {
    static void insertAtBottom(Stack<Integer> st, int ele){
        if(st.isEmpty()){
            st.push(ele);
            return;
        }

        int temp = st.pop();
        insertAtBottom(st, ele);
        st.push(temp);
    }
    static void rev(Stack<Integer> st){
        if(st.size() == 1) return;

        int top = st.pop();
        rev(st);
       insertAtBottom(st, top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println("Original stack: " + st);

        //to insert at any given index
        int ele = 100;
        int idx = 3;

        Stack<Integer> temp = new Stack<>();

        //use while loop to move the elements to temp
        while(st.size()>idx){
            temp.push(st.pop());
        }

        //now push the ele to the stack
        st.push(ele);

        //now again move back the elements from temp
        while(temp.size()>0){
            st.push(temp.pop());
        }

        System.out.println("Final stack: " + st);

        //DISPLAY REVERSE USING RECURSION
        rev(st);
        System.out.println("rev: " + st);
    }
}
