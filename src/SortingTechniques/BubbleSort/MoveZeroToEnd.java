package SortingTechniques.BubbleSort;

public class MoveZeroToEnd {
    static void moveZero(int[] arr) {
        //using bubble sort, acc to bubble sort the elements are move to the end of the array

        int len = arr.length;
        int i = 0, j = len-1;

        while(i<j){
            while(i!=0) i++;
            while(j==0) j--;
            if(i<j){
                if(arr[i]==0 && arr[j] != 0){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 4, 0, 23, 5, 0, 1};
        moveZero(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
