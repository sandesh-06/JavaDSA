package SortingTechniques.Problems;

import java.util.Scanner;

/* in the array {3, 5, 8, 7, 6, 9} the elements 3 and 6 are swapped.
  reswap the elements and return a sorted array.*/
public class SwapIncorrectElements {
    static void swapIncorrect(int[] arr){
        int len = arr.length;

        if(len <=1 ) return; //if the length is <=1 just return

        /* Considering the 2 elements to be swapped as X and Y. Initialize x and y = -1 so that you can know which one should be x and y while traversing, read the code you'll know*/
        int x = -1, y = -1;
        for(int i = 1; i<len; i++){
          if(arr[i-1]>arr[i]){
              if(x == -1){ //if the first incorrect number is not updated to x.
                  x = i-1;
                  y = i; //this is for the case if there exists only 2nos. in the array(workout it'll make sense)
              }else{   //if the first incorrect no. is updated to x, the 2nd incorrect gets updated to y
                  y = i;
              }
          }
        }
        swapElements(arr, x, y); //swap the elements present in the index x and y
    }
    static void swapElements(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array: ");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter " + len + " elements of array: ");
        for(int i = 0; i<len; i++){
            arr[i] = sc.nextInt();
        }

        swapIncorrect(arr);
        for(int val: arr){
            System.out.print(val + " ");
        }
    }
}
