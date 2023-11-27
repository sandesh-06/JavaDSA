package Arrays;

import java.util.Scanner;

public class UniqueElement {
    static void findUniqueElement(int[] arr){
        int flag = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i + 1;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }

        for (int j : arr) {
            if (j != -1) {
                System.out.println("The unique element is: " + j);
                flag = 1;
            }
        }
        if(flag == 0){
            System.out.println("There is no unique element in the array");
        }
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


        findUniqueElement(arr);
    }
}
