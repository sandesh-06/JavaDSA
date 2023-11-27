package Arrays.Assingment1;
import java.util.Scanner;

import static Arrays.TwoPointerArray.Sort0and1.printArray;


public class Question3 {
    static int findMissing(int[] arr, int size) {
        int[] findArr = new int[size + 2];
        for (int i = 0; i < arr.length; i++) {
            findArr[arr[i]] = 1;
        }
        int missing = 0;
        for (int i = 1; i < findArr.length; i++) {
            if (findArr[i] < 1) {
                missing = i;
                break;
            }
        }
        return missing;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //create an array with size-1
        int arrSize;
        System.out.println("Enter the array size: ");
        arrSize = sc.nextInt();
        int[] arr = new int[arrSize-1];

        //adding elements to array
        System.out.println("Enter array elements: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("The missing element is: ");
        System.out.println(findMissing(arr, arrSize));
    }
}
