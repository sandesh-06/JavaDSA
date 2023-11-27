//SORT EVEN ELEMENTS AT THE FRONT AND ODD ELEMENTS AT THE END
package Arrays.TwoPointerArray;
import static Arrays.TwoPointerArray.Sort0and1.printArray;
import static Arrays.TwoPointerArray.Sort0and1.swapElement;

public class SwapEvenOdd {
    static void swapUsingPointer(int[] arr){
        int left = 0, right = arr.length-1;
        while(left < right){
            if(arr[left]%2!=0 && arr[right]%2==0){
                swapElement(arr, left, right);
                left++;
                right--;
            } else if (arr[left]%2==0) {
                left++;
            }else if(arr[right]%2!=0){
                right--;
            }
        }
        printArray(arr);
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 11, 2, 34, 12, 7};
        System.out.println("Original array: ");
        printArray(arr);
        swapUsingPointer(arr);
        System.out.println("Array after Sorting: ");
    }
}
