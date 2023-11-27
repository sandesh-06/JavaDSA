package Arrays.Assingment1;
import java.util.Scanner;
public class Question1 {
    static boolean absoluteDifference(int[] arr, int x){
        for(int i = 0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(Math.abs(arr[i] - arr[j]) == x){
                    return true;
                }
            }
        }
        return false;
    }
    public static int[] createArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        System.out.println("Enter array elements: ");
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static void main(String[] args) {
        int diff;
        Scanner sc = new Scanner(System.in);
        int[] arr = createArray();

        System.out.println("Enter the difference to find a pair: ");
        diff = sc.nextInt();
        System.out.println(absoluteDifference(arr, diff));
    }
}
