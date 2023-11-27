package SortingTechniques.MergeSort;
/* mergeSort is done using divide and conquer method, where the array is divided into 2sub arrays and each array is sorted separately using recursion
 and again merged */
public class MergeSort {
    static void mergeSort(int[] arr, int l, int r){ //l and r are left and right index, i.e the array should be sorted from l index to r index
        if (l>=r) return;
        int mid = (l+r)/2; //to divide the array into 2 halves we need to find the mid index value
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);

        //merge the 2 sorted arrays
        merge(arr, l, mid, r);
    }
    static void merge(int[] arr, int l, int mid, int r){
        //find length of both left and right arrays
        int[] leftArray = new int[mid-l+1];
        int[] rightArray = new int[r-mid];
        int i=0, j=0, k=l; //NOTE: k should be initialized from start index
        //copy the elements from arr to leftArray and rightArray
        for(int m = 0; m<leftArray.length; m++) leftArray[m] = arr[l+m]; //because l is not 0 in all the cases, so m + starting index
        for(int n = 0; n<rightArray.length; n++) rightArray[n] = arr[(mid+1) + n]; //n + starting index
        //assuming both the left and right sub arrays are sorted, we need to add the elements in sorted manner to the main array
        while(i<leftArray.length && j<rightArray.length){
            if(leftArray[i]<rightArray[j]){
                arr[k++] = leftArray[i++];
            }
            else{
                arr[k++] = rightArray[j++];
            }
        }
        //to add the remaining elements after comparing either in left or right Array
        while (i<leftArray.length){
            arr[k++] = leftArray[i++];
        }
        while (j<rightArray.length){
            arr[k++] = rightArray[j++];
        }
    }
    public static void main(String[] args) {
        int[] arr = {7, 11, 60, 22, 10, 9, 48};
        mergeSort(arr, 0, arr.length-1);
        for (int val: arr) {
            System.out.print(val + " ");
        }
    }
}
