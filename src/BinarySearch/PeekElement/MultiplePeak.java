package BinarySearch.PeekElement;

/* In this problem there may be multiple peak element, just return the index of any peak element idc.
 EG: [1, 2, 3, 4, 2, 1, 3, 4, 5, 6, 2] here "4" and "6" are peak elements
 CONDITIONS: 1. The index before first ele and after last ele is said to have values -infinity
             2. adjacent element won't be equal*/
public class MultiplePeak {
    static int findAnyPeak(int[] arr){
        int start = 0, end = arr.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start + (end - start)/2;
            // Check if mid is a peak element
            //if mid is 0, then we can't acces mid-1 (or) if mid is last ele, we can't access mid+1
            if((mid == 0 || arr[mid-1]<arr[mid]) && (mid == arr.length-1 ||arr[mid]>arr[mid+1])){
                ans = mid;
                break;
            }
            // Move towards the higher side of the array
            else if (arr[mid]<arr[mid+1]) {
                start = mid+1;
            }
            // Move towards the lower side of the array
            else{
                end = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 1, 3, 4, 5, 6, 2};
        System.out.println("One of the peak index is: " + findAnyPeak(arr));
    }
}
