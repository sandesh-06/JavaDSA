package SortingTechniques.Problems;

/* Sorting the array that contains 0 1 2 using 3 pointers or Dutch National Flag method*/
public class Sort012 {
    /* CONDITION: [ 0, low-1] --> 0
     *             [ low, mid-1] --> 1
     *             [mid, high-1] ---> unknown
     *             [high, len-1] ---> 2*/
    static void sort012(int[] arr){
        //the 3 pointers are low, mid and high.
        //at first the whole array is unknown region.
        int low = 0, mid=0, high=arr.length-1;
        while (mid<=high){  //exploring the unknown region and sorting the elements in it's right region
            if(arr[mid] == 0){
                swapElements(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            }else{
                swapElements(arr, mid, high);
                high--;
            }
        }
    }
    static void swapElements(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 2, 1, 0, 1, 2, 2, 0, 1, 2};
        sort012(arr);
        for(int val: arr){
            System.out.print(val + " ");
        }
    }
}
