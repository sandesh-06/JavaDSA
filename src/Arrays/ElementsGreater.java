package Arrays;

import java.util.Scanner;

public class ElementsGreater {
    static void noOfGreaterElements(int[] arr, int element){
        int count = 0;
        for(int ele: arr) {
            if(ele > element){
                count++;
            }
        }
        System.out.println("The no.of elements greater than " + element + " is " + count);
    }
    public static void main(String[] args) {
        int element;
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the element: ");
        element = sc.nextInt();
        noOfGreaterElements(arr, element);

    }
}
