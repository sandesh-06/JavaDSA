package HashSet.Problems;

import java.util.HashSet;
import java.util.Map;

// {100, 4, 200, 3, 1, 2} - here longest consecutive sequence is 1 2 3 4 = 4;
public class P_1_LongestConsecutiveSequence {
    public static int longestSequence(int[] arr){
        //1. ADD THE ELEMENTS TO A HASHSET
        HashSet<Integer> set = new HashSet<>();
        for(int n : arr) set.add(n);

        int max_len = 0;
        for(int entry: set){
            //IF THERE DOESN'T EXIST A NUMBER NUM-1, THEN THE NUM IS STARTING POINT
            if(!set.contains(entry-1)){
                int curr_num = entry;
                int curr_len = 0;
                while(set.contains(curr_num)){
                    curr_len++;
                    curr_num++;
                }
                max_len = Math.max(curr_len, max_len);
            }
            //IF THERE EXIST A NUMBER NUM-1, THEN THE NUM IS NOT STARTING POINT
        }
        return max_len;
    }
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 2, 1, 3};
//        int[] arr = {100, 4, 0, 6, 5, 5, 2, 2, 1, 3};
        System.out.println(longestSequence(arr));
    }
}
