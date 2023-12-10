package Stack.Problems;

//https://www.geeksforgeeks.org/the-stock-span-problem/
//solve using previous greater element method
import java.util.Stack;

public class P_4_StockSpanGFG {
    static int[] findStockSpan(int[] arr){
        Stack<Integer> st = new Stack<>();
        int len = arr.length;
        int[] res = new int[len];

        st.push(0); //index of firsts element;
        res[0] = 1;

        for(int i = 1; i<len; i++){
            while(arr[i]>arr[st.peek()] && st.size()>0) st.pop();
            if(st.isEmpty()){
                res[i] = 1;
            }
            else if(arr[st.peek()] > arr[i]){
                res[i] = i-st.peek();
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        int[] ans = findStockSpan(arr);

        for(int n: ans) System.out.print(n + " ");
    }
}
