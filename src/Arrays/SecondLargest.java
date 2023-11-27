package Arrays;
import java.util.Scanner;

public class SecondLargest {
    static int findLargest(int[] arr){
        int max = Integer.MIN_VALUE;//gives the least value possible
        for(int ele: arr){
            if(ele > max){
                max = ele;
            }
        }
        return max;
    }

    static int findSecondLargest(int[] arr){
        int max = findLargest(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i] == max){ //taking the largest value and replacing it with the minimum possible value
                arr[i] = Integer.MIN_VALUE;
            }
        }
       return findLargest(arr); //now if we try to find the largest value, the 2nd largest will now be the largest
    }

    public static void main(String[] args) {
        int arrSize, element;
        System.out.println("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        arrSize = sc.nextInt();
        int[] arr = new int[arrSize];

        System.out.println("Enter array elements:");
        for(int i=0; i<arr.length; i++){
            element = sc.nextInt();
            arr[i] = element;
        }
        System.out.println("The second largest element is: " + findSecondLargest(arr));
    }
}
