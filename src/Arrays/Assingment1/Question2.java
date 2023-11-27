package Arrays.Assingment1;
import java.util.Arrays;
import java.util.Scanner;

import static Arrays.Assingment1.Question1.createArray;
import static Arrays.TwoPointerArray.Sort0and1.printArray;

public class Question2 {
    static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static  int findOccurrence(int[] arr, int x){
        int max = findMax(arr);
        int[] occArr = new int[max + 1];
        for(int i = 0; i<arr.length; i++){
            occArr[arr[i]]++;
        }
        return occArr[x];
    }
    public static void main(String[] args) {
        int[] arr = createArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to find it's occurrence: ");
        int x = sc.nextInt();
        System.out.println("The occurrence of " + x + " is:" );
        System.out.println(findOccurrence(arr, x));

    }
}
