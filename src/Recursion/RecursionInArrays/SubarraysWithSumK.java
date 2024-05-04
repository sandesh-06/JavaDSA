package Recursion.RecursionInArrays;

import java.util.ArrayList;
import java.util.List;

public class SubarraysWithSumK {
    private static void findSubArrays(int []a, int idx, long k,  List<Integer> curr_ans, long curr_sum, List<List<Integer>>result){

        if(idx == a.length) return;

        if(curr_sum == k){
            System.out.println(curr_ans);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(curr_ans);
            result.add(temp);
            return;
        }
        int curr_num = a[idx];
        if(curr_sum < k){
            curr_ans.add(curr_num);
            findSubArrays(a, idx+1, k, curr_ans, curr_sum+curr_num, result);
            curr_ans.remove(curr_ans.size()-1);
        }
        findSubArrays(a, idx+1, k, curr_ans, curr_sum, result);
    }
    public static List<List< Integer >> subarraysWithSumK(int []a, long k) {
        // Write your code here
        List< List < Integer > > result = new ArrayList<>();
        List<Integer> curr_ans = new ArrayList<>();

        findSubArrays(a, 0, k, curr_ans, 0, result);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1};
        System.out.println(subarraysWithSumK(arr, 3));
    }
}
