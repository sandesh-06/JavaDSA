package SortingTechniques.InsertionSort;

public class InsertionSort {
    /*
        insertion sort - 8 | 2 4 5 1 0
                   sorted  | unsorted

         compare the elements one by one from the unsorted with sorted array and insert them in their right spot, by swapping the adjacent elements
    */
    static void insertionSort(int[] arr){
        int len = arr.length;

        for(int i = 1; i<len; i++){
            //initialise j as i, because you need the check the current i element with the previous sorted array
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                //swap elements
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }

        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        insertionSort(arr);

        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
