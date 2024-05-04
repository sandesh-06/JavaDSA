package Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

public class P_4_FirstNegativeElementInWindow {
    class Compute {

        public long[] printFirstNegativeInteger(long A[], int N, int K)
        {
            long[] ans = new long[N-K+1];
            Queue<Integer> q = new LinkedList<>();

            for(int i = 0; i<N; i++){
                if(A[i]<0){
                    q.add(i); //add all the index of -ve values
                }
            }


            //form the answer array
            for(int i = 0; i<N-K+1; i++){

                if(q.size()>0 && q.peek()<i) q.remove(); //if the peek element is less than current element, it's out of window

                if(q.size()>0 && q.peek()>=i && q.peek()<i+K) ans[i] = A[q.peek()]; //if the peek element is within the current window
                else if(q.size()>0 && q.peek()>i && q.peek()>=i+K) ans[i] = 0; //if the peek element is out of window
                else if(q.isEmpty()) ans[i] = 0;
            }

            return ans;
        }
    }
}
