package Stack.Problems;

import java.util.Stack;

public class P_5_LargestRectangleInHistogram_Important_LeetCode84 {

    //CONCEPTS:
//    static int[] findNextSmallest(int[] arr){
//        Stack<Integer> st = new Stack<>();
//        int len = arr.length;
//        int[] res = new int[len];
//
//        st.push(arr[len-1]);
//        res[len-1] = -1;
//
//        for(int i = len-2; i>=0; i--){
//            while(st.size()>0 && arr[i]<st.peek())st.pop();
//            if(st.isEmpty()) res[i] = -1;
//            else if(arr[i]>st.peek()) res[i] = st.peek();
//
//            st.push(arr[i]);
//        }
//        return res;
//    }
//    static int[] findPrevSmallest(int[] arr){
//        Stack<Integer> st = new Stack<>();
//        int len = arr.length;
//        int[] res = new int[len];
//
//        st.push(arr[0]);
//        res[0] = -1;
//
//        for(int i = 1; i<len; i++){
//            while(st.size()>0 && arr[i]<st.peek())st.pop();
//            if(st.isEmpty()) res[i] = -1;
//            else if(arr[i]>st.peek()) res[i] = st.peek();
//
//            st.push(arr[i]);
//        }
//        return res;
//    }


    static int[] findPrevSmallest(int[] arr){
        Stack<Integer> st = new Stack<>();
        int len = arr.length;
        int[] res = new int[len];

        st.push(0);
        res[0] = -1;

        for(int i = 1; i<len; i++){
            while(st.size()>0 && arr[i]<=arr[st.peek()])st.pop();
            if(st.isEmpty()) res[i] = -1;
            else if(arr[i]>arr[st.peek()]) res[i] = st.peek();

            st.push(i);
        }
        return res;
    }

    static int[] findNextSmallest(int[] arr){
        Stack<Integer> st = new Stack<>();
        int len = arr.length;
        int[] res = new int[len];

        st.push(len-1);
        res[len-1] = len;

        for(int i = len-2; i>=0; i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()])st.pop();
            if(st.isEmpty()) res[i] = len;
            else if(arr[i]>arr[st.peek()]) res[i] = st.peek();

            st.push(i);
        }
        return res;
    }

    //ACTUAL SUM STARTS HERE:
    static int findLongestRectangle(int[] heights){
        int[] prev_smallest = findPrevSmallest(heights);
        int[] next_smallest = findNextSmallest(heights);

        int max = -1;
        for(int i = 0; i<heights.length; i++){
            int area = heights[i] * (next_smallest[i] - prev_smallest[i] - 1);
            max = Math.max(area, max);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 2, 3, 1};
        System.out.println(findLongestRectangle(arr));
    }
}
