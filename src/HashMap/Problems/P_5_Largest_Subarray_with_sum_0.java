package HashMap.Problems;

import java.util.HashMap;
import java.util.Map;

//FROM AN ARRAY FIND THE LARGEST SUBARRAY WHOSE SUM IS 0.

//THE LOGIC IS THAT, WHEN THE PREFIX SUM IS SAME AT 2 INDICES, THE THE SUM IN BETWEEN THOSE INDICES ADDS UP TO ZERO
//EG: {15, -2, 2, -8, 1, 7, 10} - PREFIX SUM {15, 13, 15, 7, 8, 15, 25}, SINCE THERE'S 15 AT 2ND INDEX, THE SUM OF ELEMENTS OF 1ST AND 2ND INDEX ADDS UP TO 0. ALSO THE 15 AT 5TH INDEX SAYS THAT THE SUM OF ELEMENTS FROM 1-5 INDEX ADDS TO 0
public class P_5_Largest_Subarray_with_sum_0 {
    public static int subarrayWithZero(int[] arr){
        int prefix_sum = 0;
        int max_length = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i<arr.length; i++){
            //1. FIND THE PREFIX SUM UPTO "i" INDEX
            prefix_sum += arr[i];
            mp.put(0, -1); //take the case {15, -2, 2, -8, 1, 7, 10, -25} and it will make sense
            if(!mp.containsKey(prefix_sum)) { //if the map doesn't contain the prefix sum
                mp.put(prefix_sum, i); //add the prefix sum with the index, eg: 15 -> 0. until 0 index the prefix sum is 15
            }else{ //if it contains the prefix sum already, update the max length, if the length is small
                int curr_length = i - mp.get(prefix_sum);
                if(curr_length > max_length) max_length = curr_length;
            }
        }
        return max_length;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10};

        System.out.println("The length of largest sub array with sum 0 is: " + subarrayWithZero(arr));
    }
}
