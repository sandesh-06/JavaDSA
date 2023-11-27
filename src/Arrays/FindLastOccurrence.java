package Arrays;
import java.util.Scanner;

public class FindLastOccurrence {

    static void lastOccurrence(int[] arr, int element) {
        int lastIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                lastIndex = i;
            }

        }
        System.out.println("The element " + element + " was last occurred at index " + lastIndex);
        if(lastIndex == -1){
            System.out.println("Your element doesn't exist");
        }
    }

    public static void main(String[] args) {
        int element;
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the element to find last occurrence: ");
        element = sc.nextInt();
        lastOccurrence(arr, element);
    }
}