package SortingTechniques.BubbleSort;

public class BubbleSort {
    static void bubbleSort(int[] arr){
        /* Time complexity:
            Best case - O(n^2)
            worst case - O(n^2)
            average case - O(n^2)
        */
        int len = arr.length;

        //loop for one pass
        for(int i = 0; i<len-1; i++){
            //loop for comparing adjacent elements in each pass

            /*The last "i" elements are already in correct
             position so we need not swap them, i.e why
             we run the loop until len-i-1*/

            for(int j = 0; j<len-i-1; j++){
                if(arr[j] > arr[j+1]){
                     //swap elements
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void optimizedBubbleSort(int[] arr){
         /* Time complexity:
            Best case - O(n)
            worst case - O(n^2)
            average case - O(n^2)
        */

        int len = arr.length;

        for(int i = 0; i<len-1; i++){
            boolean flag = false; //to check whether any swapping has occurred at a particular pass
            for(int j=0; j<len-i-1; j++){
                if(arr[j] > arr[j+1]){
                    //swap elements
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true; //indicates that swapping has occurred and goes to the next pass
                }
            }
            //if no swapping has occurred in a pass, then the array is already sorted and need not be checked for the next pass
            if(!flag){
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {11, 4, 5, 2, 6, 9, 0};
//        bubbleSort(arr);
        optimizedBubbleSort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
