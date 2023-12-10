package Stack.Problems;

import java.util.Stack;

/*
        if an array contains elements: arr = [ 1 2 2 3 10 10 10 4 4 4 5 7 7 2 ]

        the resultant array should contain only those elements which is not repeating elements as continuous sub array: ans = [ 1 3 5 2 ]

*/
public class P_2_NoRepeatingElements {
    static int[] removeRepeating(int[] arr){
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<arr.length; i++){
            if(st.isEmpty()) st.push(arr[i]); //if the stack is empty directly push the element
            else if(arr[i]!=st.peek()) st.push(arr[i]); //if the peek of stack is not equal to array's element, push the element

            //if the peek is equal to the element, then we don't need the value right. so perform operation accordingly
            else if( arr[i] == st.peek()){
                //if it's the last element or if the adjacent element is not equal
                if(i==arr.length-1 || arr[i+1]!=arr[i]) st.pop();

                //if the adjacent element is equal just skip it
            }
        }

        int[] ans = new int[st.size()];

        for(int i = ans.length-1; i>=0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2};
        int[] ans = removeRepeating(arr);

        for(int n: ans){
            System.out.print(n + " ");
        }
    }
}
