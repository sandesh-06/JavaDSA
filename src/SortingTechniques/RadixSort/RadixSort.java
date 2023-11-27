package SortingTechniques.RadixSort;
/* In radix sort we do the place wise sorting, first we sort the 1's place of all elements, then 10's then 100's and so on.
 To sort each place(1s, 10s etc) we will be using the stable count sort*/
public class RadixSort {
    static int findMax(int[] arr){
        int maxEle = arr[0];
        for(int i=0; i<arr.length; i++){
            if(maxEle < arr[i]){
                maxEle = arr[i];
            }
        }
        return maxEle;
    }
    static void stableCountSort(int[] arr, int place, int max){
        int[] occArr = new int[10]; //since we are sorting place wise we just need the first 10 naturals nos. (shld make sense)
        int[] ansArr = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            occArr[(arr[i]/place)%10]++; //occArr[(170/1)%10] = occArr[0]++; because we are sorting only the 'place no.' not the element
        }
        //find prefix sum array for occARR:
        //the occArr tells us the at which position the element should belong(position = index+1)
        for(int i = 1; i<occArr.length; i++){
            occArr[i] = occArr[i] + occArr[i-1];
        }
        //for 1s: 2 2 4 4 4 6 6 6 6 6
        //for 10s: 2 2 2 2 3 3 3 5 5 6
        //for 100s: 4 5 5 5 5 5 5 5 6 6

//        Now traverse the occArr from reverse
        for(int i = arr.length-1; i>=0; i--){
            int idx = occArr[(arr[i]/place)%10]-1;
            ansArr[idx]= arr[i];
            occArr[(arr[i]/place)%10]--;
        }
        //copy elements from ans array to original array
        for(int i = 0; i<arr.length; i++){
            arr[i] = ansArr[i];
        }
    }
    static void radixSort(int[] arr){
        int maxEl = findMax(arr); //the max ele will be 802

        //we need to call countSort for 1s 10s 100s etc, so lets use for loop
        for(int place = 1; maxEl/place>0; place*=10){ //when place = 1000; 802/1000>0; the loops breaks. It sorts upto 100s place.
            stableCountSort(arr, place, maxEl);
        }
        for (int val: arr) {
            System.out.print(val + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 2};
        radixSort(arr);
    }
}
