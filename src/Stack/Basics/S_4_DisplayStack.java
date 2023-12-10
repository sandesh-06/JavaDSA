package Stack.Basics;

import java.util.Stack;

public class S_4_DisplayStack {
    static void displayRecursively(Stack<Integer> st){
        if(st.size()==0)return;
        int top = st.pop();
        displayRecursively(st);
        System.out.print(top + " ");
        //after printing put that element back in stack
        st.push(top);

    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        //WE CAN USE ANOTHER STACK TO DISPLAY THE STACK, BUT THAT MAY CONSUME MORE SPACE. IF WE USE AN ARRAY WE CAN CONTROL THE SIZE, SO IT'S BETTER TO USE AN ARRAY
        int n = st.size();
        int[] temp = new int[n];
       for(int i = n-1; i>=0; i--){
           temp[i] = st.pop();
       }

       //NOW WHILE AGAIN MOVING THE ELEMENTS FROM ARRAY TO STACK, PRINT THE ELEMENTS ON THE GO.
       for(int i = 0; i<temp.length; i++){
           System.out.print(temp[i] + " ");
           st.push(temp[i]);
       }

        System.out.println("\nThe stack: " + st);

        System.out.print("Displaying using recursion: ");
       displayRecursively(st);

    }
}
