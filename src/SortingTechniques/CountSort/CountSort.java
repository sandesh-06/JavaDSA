package SortingTechniques.CountSort;

/* In count sort, first we find the max element to know the range of nos.
  Then we traverse the array and count the occurrences of elements in another array.
  With the help of occurreces of elements we overwrite the array and sort the elements in order*/
public class CountSort {
    static int findMax(int[] arr){
        int maxEle = arr[0];
        for(int i=0; i<arr.length; i++){
            if(maxEle < arr[i]){
                maxEle = arr[i];
            }
        }
        return maxEle;
    }
    static void stableCountSort(int[] arr){
        int maxEle = findMax(arr);
        int[] occArr = new int[maxEle+1];
        int[] ansArr = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            occArr[arr[i]]++;
        }
        //find prefix sum array for occARR:
        //the occArr tells us the at which position the element should belong(position = index+1)
        for(int i = 1; i<occArr.length; i++){
            occArr[i] = occArr[i] + occArr[i-1]; //prefix sum: 2 2 4 4 4 4 4 4 4 4 4 5 6 6 7
        }
        for (int val: occArr) {
            System.out.print(val + " ");
        }
        //Now traverse the occArr from reverse
        for(int i = arr.length-1; i>=0; i--){
            ansArr[occArr[arr[i]]-1]= arr[i]; //ansArr[occArr[arr[6]]-1] = ansArr[occArr[14]-1] = ansArr[7-1] = ansArr[6] = 14
            occArr[arr[i]]--; //occArr[arr[6]] = occArr[14] = 7-1 = 6. Now next time if 14 is encountered it is stored at 6th position(5th index)
        }
       for (int val: ansArr) {
            System.out.print(val + " ");
       }
    }
    static void countSort(int[] arr){ //NOTE THIS ALGORITHM IS NOT STABLE!! To make the algorithm stable use prefix sum array for occArray.
        int max = findMax(arr);
        int[] occArray = new int[max+1]; //create the occurrence array with length max+1

        //count the occ of elements in original array
        for(int i = 0; i<arr.length; i++){
            occArray[arr[i]]++;
        }

        //now overwrite the array in sorted order using occurrence array
        int k = 0;
        for(int i = 0; i<occArray.length; i++){ //2 0 2 0 0 0 0 0 0 0 0 1 1 0 1
            for(int j = 0; j<occArray[i]; j++){  //for first loop, j = 0; j<2; j++. Since element 2 is present 2 times, the first 2 index of 'arr' will be 2
             arr[k++] = i; //arr[0] = 0, arr[1] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 0, 12, 11, 2, 0, 14};
//        countSort(arr);
        stableCountSort(arr);
//        for (int val: arr) {
//            System.out.print(val + " ");
//        }
    }
}
