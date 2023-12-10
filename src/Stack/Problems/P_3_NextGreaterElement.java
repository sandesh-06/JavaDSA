package Stack.Problems;

import java.util.Stack;

/*
        GIVEN AN ARRAY: arr = [ 1 3 2 1 8 6 3 4 ] find the next greater element for each values in the array, eg 1's next greater is 3, 3s next greater is 8 etc. If there's no greater then return -1
        the ans arr is: arr = [ 3 8 8 8 -1 -1 4 -1 ]


*/
public class P_3_NextGreaterElement {
    static int[] findNextGreater(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];

        st.push(arr[n-1]); //push the last value from array, to the stack
        ans[n-1] = -1; //because for the last element, there's no next greater
//        System.out.println(st);
        for(int i = arr.length-2; i>=0; i--){ //start the i pointer from n-2, and loop backwards
            while(st.size()>0 && arr[i]>st.peek()){ //pop the elements from stack, if the value in the stack is lesser than the array element
                st.pop();
            }
            if(st.isEmpty()){ //if the stack is empty for an element, then there's no next greater for the element.
                ans[i] = -1;
                st.push(arr[i]);
            }
            else if(arr[i]<st.peek()){ //if the peek of stack is greater for the element, then the peek is the next greater for the it.
                ans[i] = st.peek();
                st.push(arr[i]);
            }
        }
//        System.out.println(st);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 8, 6, 3, 4};
        int[] ans = findNextGreater(arr);

        for(int n: ans){
            System.out.print(n + " ");
        }
    }
}
