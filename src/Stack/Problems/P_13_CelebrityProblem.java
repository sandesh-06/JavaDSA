package Stack.Problems;

import java.util.Stack;

//https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

public class P_13_CelebrityProblem {
    int celebrity(int M[][], int n)
    {
        // code here
        Stack<Integer> possible_celeb = new Stack<>();

        for(int i = 0; i<M.length; i++){ //m.length gives no.of persons
            possible_celeb.push(i);
        }


        while(possible_celeb.size()>1){
            int per1 = possible_celeb.pop();
            int per2 = possible_celeb.pop();

            if(M[per1][per2] == 1) possible_celeb.push(per2); //if per1 knows per2, then per2 may be a celeb, but per1 not a celeb for sure
            else if(M[per1][per2] == 0) possible_celeb.push(per1); //if per1 dk per2, then per1 may be a celeb, but per2 not a celeb for sure
        }

        if(possible_celeb.isEmpty()) return -1;

        //check if the row of celeb consist of 0, and col consist 1;
        int celeb = possible_celeb.pop();
        for(int j = 0; j<M.length; j++){
            if(M[celeb][j] == 1) return -1;
        }

        for(int i = 0; i<M.length; i++){
            if(i == celeb) continue;
            if(M[i][celeb] == 0) return -1;
        }

        return celeb;
    }
}
