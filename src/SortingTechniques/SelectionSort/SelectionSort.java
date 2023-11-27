package SortingTechniques.SelectionSort;

public class SelectionSort {
    //select an element and place it in the correct position
    static void selectionSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i<len-1; i++){
           //to find minimum from ith index
            int minEleIdx = i;
            for(int j = i+1; j<len; j++){
                if(arr[minEleIdx] > arr[j]){
                    minEleIdx = j;
                }
            }
            //swap the minIdx and minEleIdx
            int temp = arr[i]; //temp = arr[0] = 11
            arr[i] = arr[minEleIdx]; //arr[0] = arr[4] = 0
            arr[minEleIdx] = temp;  //arr[4] = 11
        }
    }
    public static void main(String[] args) {

        int[] arr = {11, 2, 4, 9, 0, 1};
        selectionSort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}

/*
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    static int findMin(int[] arr, int st, int end){
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("");
        int minIdx = st;
        for(int i = st; i <= end; i++){
            if(arr[i] < arr[minIdx]){
                minIdx = i;
            }
            //  System.out.println("Min: " + i);
        }
        return minIdx;
    }
    static void selectionSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i<len; i++){
                int minIdx = findMin(arr, i, len-1);
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 0, -1};
        selectionSort(arr);

        for(int num: arr){
            System.out.print(num + " ");
        }

    }
}
*/
