package HashMap.Problems;

import java.util.HashMap;
import java.util.Map;

// FIND THE PAIR OF NOS WHICH ADDS UP TO THE GIVEN TARGET AND RETURN THEIR INDEX, IF PAIR NOT FOUND RETURN -1
public class P_4_TwoSum {
    public static int[] findTwoSum(int[] arr, int target){
        int[] ans = {-1};
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i<arr.length; i++){
            int curr_ele = arr[i];
            int partner_ele = target - curr_ele;

            if(mp.containsKey(partner_ele)){ //if the partner element is present in the map, return the index of curr ele and partner element
                ans = new int[]{i, mp.get(partner_ele)};
                return ans;
            } else{ //if partner element is not present, add the cur ele with it's index to the map
                mp.put(curr_ele, i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] arr = {10, 4, 2, 0, 8, 9, 7};
        int target = 39;

        int[] ans = findTwoSum(arr, target);
        for(var num: ans) System.out.print(num + " ");
    }
}
