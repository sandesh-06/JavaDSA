package BinarySearch.PeekElement;


/*Find the index of the peek element. Eg for peek element:
       [1 3 4 9 8 4 3] in this array "9" is the peek element, since the elements towards left and right is smaller
       CONDITIONS: in the left of peek the condition is arr[i]<arr[i+1]
                   in the right of peek the condition is arr[i]>arr[i+1]
*/

public class FindIndex {
    static int findPeekIndex(int[] arr){
        int start = 0, end = arr.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start + (end - start)/2;
//            System.out.println("Mid: " + mid);
            if(arr[mid]<arr[mid+1]){     //if the mid is towards left,
                ans = mid+1;  //either the mid+1 th element is peek (or),
                start = mid+1; // the peek will exist somewhere towards left of mid
            }
            else{ //if mid > mid+1, then mid was found on the right of peek, so initialize end as mid-1 to search only the left side
                end = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 0, 1, 2};
        System.out.println("The peek index is: " + findPeekIndex(arr));
    }
}
