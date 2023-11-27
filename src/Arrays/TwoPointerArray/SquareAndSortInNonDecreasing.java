//GIVEN AN INTEGER ARRAY 'A' SORTED IN NON-DECREASING ORDER, RETURN AN ARRAY OF THE SQUARES OF EACH NUMBER SORTED IN NON-DECREASING ORDER
package Arrays.TwoPointerArray;

import static Arrays.TwoPointerArray.Sort0and1.printArray;
import static Arrays.TwoPointerArray.Sort0and1.swapElement;

public class SquareAndSortInNonDecreasing {
    static void reverseArray(int[] arr){
        int i=0, j = arr.length-1;
        while(i<j){
            swapElement(arr, i, j);
            i++;
            j--;
        }
        printArray(arr);
    }
    static void sortTheArray(int[] arr){
        int left = 0, right = arr.length-1;
        int[] ans = new int[arr.length];
        int j = 0;
        while(left <= right){
            if(Math.abs(arr[left]) > Math.abs(arr[right])){
                ans[j] = arr[left] * arr[left];
                j++;
                left++;
            } else{
                ans[j] = arr[right] * arr[right];
                j++;
                right--;
            }
        }
        printArray(ans);
        reverseArray(ans);
        //NOTE IF YOU FILL THE ELEMENTS IN THE ANS ARRAY FROM THE LAST(j=arr.length - 1 and ans[j--] there is no need to reverse the array)
    }
    public static void main(String[] args) {
        int[] arr = {-10, -3, -2, 1, 4, 5};
        sortTheArray(arr);
    }
}
