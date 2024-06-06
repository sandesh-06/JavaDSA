package Heaps;

import java.util.ArrayList;
import java.util.List;
/*
                                            99
                                       87       66
                                    47   8    18   51
                                 23  34

 */
import static java.util.Collections.swap;

public class B_4_HeapSort {
    private static void sortTheHeap(List<Integer> arr, int lastIdx, boolean isMaxHeap) {
        //1. Swap the root with the last element
        swap(arr, 0, lastIdx);

        //2. Now pushDown
        if (isMaxHeap) pushDownElementForMaxHeap(arr, 0, lastIdx - 1); //don't perform the operation for the last index
        else pushDownElementForMinHeap(arr, 0, lastIdx - 1);
    }

    //FOR ASCENDING ORDER
    private static void pushDownElementForMaxHeap(List<Integer> arr, int idx, int lastIdx){
        if(idx == lastIdx) return;

        int leftChildIdx = ( 2 * idx ) + 1;
        int rightChildIdx = ( 2 * idx ) + 2;
        int greatestEleIdx = idx;

        if(leftChildIdx <= lastIdx && arr.get(leftChildIdx) > arr.get(greatestEleIdx)) greatestEleIdx = leftChildIdx;
        if(rightChildIdx <= lastIdx && arr.get(rightChildIdx) > arr.get(greatestEleIdx)) greatestEleIdx = rightChildIdx;

        if(greatestEleIdx == idx) return;

        swap(arr, idx, greatestEleIdx);
        pushDownElementForMaxHeap(arr, greatestEleIdx, lastIdx);
    }
    private static void heapifyToMaxHeap(List<Integer> arr){
        int firstNonLeafIdx = ((arr.size()-1) - 1) / 2;

        for(int i = firstNonLeafIdx; i>=0;i--) pushDownElementForMaxHeap(arr, i, arr.size()-1);
    }
    public static void heapSortInAscending(List<Integer> arr){
        //1. Heapify
        heapifyToMaxHeap(arr);

        //2. Sort the elements using the same method for deletion (but don't delete).
        for(int lastIdx = arr.size()-1; lastIdx >= 0; lastIdx--) sortTheHeap(arr, lastIdx, true);
    }

    //FOR DESCENDING ORDER
    private static void pushDownElementForMinHeap(List<Integer> arr, int idx, int lastIdx) {
        if(idx == lastIdx) return;

        int leftChildIdx = ( 2 * idx ) + 1;
        int rightChildIdx = ( 2 * idx ) + 2;
        int smallestEleIdx = idx;

        if(leftChildIdx <= lastIdx && arr.get(leftChildIdx) < arr.get(smallestEleIdx)) smallestEleIdx = leftChildIdx;
        if(rightChildIdx <= lastIdx && arr.get(rightChildIdx) < arr.get(smallestEleIdx)) smallestEleIdx = rightChildIdx;

        if(smallestEleIdx == idx) return;

        swap(arr, idx, smallestEleIdx);
        pushDownElementForMinHeap(arr, smallestEleIdx, lastIdx);
    }
    private static void heapifyToMinHeap(List<Integer> arr){
        int firstNonLeafIdx = ((arr.size()-1) - 1) / 2;

        for(int i = firstNonLeafIdx; i>=0;i--) pushDownElementForMinHeap(arr, i, arr.size()-1);
    }
    public static void heapSortInDescending(List<Integer> arr){
        //1. Heapify
        heapifyToMinHeap(arr);

        //2. Sort
        for(int lastIdx = arr.size()-1; lastIdx >= 0; lastIdx--) sortTheHeap(arr, lastIdx, false);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(34);
        arr.add(18);
        arr.add(23);
        arr.add(87);
        arr.add(66);
        arr.add(51);
        arr.add(99);
        arr.add(47);

        System.out.println("Array before sorting: " + arr);
        heapSortInAscending(arr);
        System.out.println("Array after sorting in ascending: " + arr);

        heapSortInDescending(arr);
        System.out.println("Array after sorting in descending: " + arr);
    }
}
