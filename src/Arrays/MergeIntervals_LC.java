package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;

public class MergeIntervals_LC {
    public static List<List<Integer>> findAns(int[][] arr){
        Arrays.sort(arr, (a,b)-> Integer.compare(a[0], b[0]));
        //1 3; 2 6; 8 10; 15 18;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<arr.length;i++){
            int st = arr[i][0]; //1
            int end = arr[i][1]; //3

            //skip the merged intervals
//            if(!ans.isEmpty() && end<=ans.get(ans.size()-1).get(1)) continue;
            for(int j = i+1; j<arr.length; j++){
                if(end > arr[j][0]) end = Math.max(end, arr[j][1]);
                else break;
            }
            ans.add(Arrays.asList(st, end));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = findAns(arr);
        System.out.println(ans);
//        for(int i  = 0; i<arr.length; i++){
//            for(int j = 0; j<arr[i].length; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
