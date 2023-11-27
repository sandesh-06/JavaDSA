package SortingTechniques.BucketSort;

import java.util.ArrayList;
import java.util.Collections;

/* In bucket sorting we can take any number of buckets to sort the elements
  based on any criteria that is suitable for the given range of nos.*/
public class BucketSort {
    static void bucketSort(float[] arr){
        int n = arr.length; //length of original array

        //1. creating buckets using arr[ArrayList](Array of ArrayLists) //the arralists inside the array is the bucket
        //int[] arr = new int[n]; //integers inside array
        ArrayList<Float>[] buckets = new ArrayList[n];//this array will contain arraylist

        //2. Create empty buckets(ArrayList) inside the array
        for(int i = 0; i<n; i++){
            buckets[i] = new ArrayList<Float>(); //n empty array lists are created
        }

        //3. Add elements into the buckets.
        for(int i = 0; i<n; i++){
            int bucketIndex = (int) arr[i] * n; //bucketIndex(for 0.4) = (int) 0.4*5 = 2
            buckets[bucketIndex].add(arr[i]);
        }

        //4. Sort each bucket individually(rn we are sorting using the 'sort' function in Collections class
        for(int i = 0; i<buckets.length; i++){
            Collections.sort(buckets[i]);
        }

        //5. Merge all the buckets to get sorted array
        int index = 0; //to traverse in the original array to put the elements
        for(int i = 0; i<buckets.length; i++){
            ArrayList<Float> currBucket = buckets[i]; //writing the elements from buckets[i] to currBucket
            for(int j = 0; j<currBucket.size(); j++){
                arr[index++] = currBucket.get(j);
            }
        }

    }
    public static void main(String[] args) {
        float[] arr = {0.4f, 0.5f, 0.1f, 0.3f, 0.2f};
        bucketSort(arr);
        for(float val: arr){
            System.out.print(val + ", ");
        }
    }
}
