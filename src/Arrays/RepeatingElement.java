package Arrays;
import java.util.Scanner;

public class RepeatingElement {
    static  int firstRepeatingElement(int[] arr){
        int  repeatingElement = arr[0];
        for(int i=0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    repeatingElement = arr[i];
                    return repeatingElement; //method ends here
                }
            }
        }
       return -1;
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
        System.out.println("The first repeating element is: " + firstRepeatingElement(arr));
    }
}
