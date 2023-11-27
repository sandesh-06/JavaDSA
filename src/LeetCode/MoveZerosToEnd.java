package LeetCode;

public class MoveZerosToEnd {
    public void printArray(int[] arr){
        for(int n: arr) System.out.print(n + " ");
    }
    public void moveZeroes(int[] nums) {
        //MY SOLUTION WAS USING BUBBLE SORT - COMPLEXITY IS O(N^2)
        // int len = nums.length;
        // for(int i = 0; i<len; i++){
        //     for(int j = 0; j<len-i-1; j++){
        //         if(nums[j] == 0){
        //             int temp = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = temp;
        //         }
        //     }
        // }

        // for(int n : nums) System.out.println(n + " ");

        //OPTIMAL APPROACH IS TWO POINTERS - COMPLEXITY IS O(N)
        int j = -1;
        int len = nums.length;
        for(int i = 0; i<len; i++){
            if(nums[i] == 0){
                j = i;
                break;
            }
        }
        if(j==-1){
            printArray(nums);
            return;
        }

        for(int i = j+1; i<len; i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        printArray(nums);
    }
}
