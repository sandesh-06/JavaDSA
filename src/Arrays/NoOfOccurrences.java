package Arrays;
import java.util.Scanner;

public class NoOfOccurrences {
    public static void findOccurrences(int[] arr, int element){
        int count = 0;
        for(int value: arr){
            if(element == value){
                count+=1;
            }
        }
        System.out.println("The element " + element + " has occurred " + count + " times");
    }

    public static void main(String[] args) {
        int element;
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("Enter the elements of array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the element to find occurrence: ");
        element = sc.nextInt();
        findOccurrences(arr, element);


    }
}
