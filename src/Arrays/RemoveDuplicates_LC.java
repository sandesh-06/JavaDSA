package Arrays;
import java.util.*;

public class RemoveDuplicates_LC {
    public static int removeDuplicates(int[] nums) {
        int unique_nums = 1;
        int i = 0;
        int j = i+1;
        while(j < nums.length){
            System.out.println("i: " + i + " j: " + j);
            while(nums[i] == nums[j]){
                nums[j] = Integer.MAX_VALUE;
                j++;
            }
            i = j;
            j++;
            unique_nums++;
        }

        Arrays.sort(nums);
        return unique_nums;
    }

    public static void main(String[] args){
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println( removeDuplicates(arr));

        for(int n: arr) System.out.print(n + " ");
    }
}
