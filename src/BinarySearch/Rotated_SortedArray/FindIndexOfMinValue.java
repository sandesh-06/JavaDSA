package BinarySearch.Rotated_SortedArray;

/*Find the index of min value in a rotated sorted array
[10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9]*/
public class FindIndexOfMinValue {
    static int findMinEleIdx(int[] arr){
        //we can do this in O(logN) using Binary search

        /*We will be using the last element to check if the 'mid' is present in first sorted part
         or the 2nd sorted part. Since the minimum element will always lie on 2nd sorted part, we need to keep looking in 2nd part
         Eg: if mid = 3 and 3 is < 9, so we know mid is in second sorted part
         Eg: if mid = 12 and 12 is > 9, now we knw mid is in first sorted part*/

        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]>arr[arr.length-1]){  //if mid > last ele, then mid is in first part, look to the right
               start = mid + 1;
            }
            else if (arr[mid]<=arr[arr.length-1]) { //if mid < last ele, then mid is in 2nd part. Either the current mid is out element or keep looking towards left
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] arr = {10, 11, 12, 13, 14, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.printf("The minimum element is in index: %d", findMinEleIdx(arr));


    }
}
