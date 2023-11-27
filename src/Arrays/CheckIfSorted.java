package Arrays;
import java.util.Scanner;

public class CheckIfSorted {
    static void CheckSorted(int[] arr){
        int flag = 0;
        for(int i=1; i<arr.length;i++){
            if(arr[i-1] > arr[i]){
                System.out.println("The array is not sorted");
                flag = 1;

                break;
            }
        }
        if(flag == 0){
            System.out.println("The array is sorted in ascending order");
        }
    }
    public static void main(String[] args) {
        int element;
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array elements:");
        for(int i=0; i<arr.length; i++){
            element = sc.nextInt();
            arr[i] = element;
        }

        CheckSorted(arr);


    }
}
