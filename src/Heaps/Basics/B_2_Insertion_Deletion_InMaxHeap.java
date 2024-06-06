package Heaps.Basics;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
                                                            60
                                                          /    \
                                                        50      40
                                                     /    \    /  \
                                                   30     20  10   5


Formulas:
Left Child: (2 * i) + 1
Right Child: (2 * i) + 2
Parent of a node: (i - 1)/2

*/

public class B_2_Insertion_Deletion_InMaxHeap {
    private static void swap(List<Integer> heap, int x, int y){
        int temp = heap.get(x);
        heap.set(x, heap.get(y));
        heap.set(y, temp);
    }

    //INSERTION
    public static void insertIntoMinHeap(List<Integer> heap, int num){
        //1. Insert the value to the end of array
        heap.add(num);

        //2. get the index of value
        int idx = heap.size()-1;

        //3. Keep pushing up until the node reaches root, or is lesser than it's parent
        //you literally don't have to check for root condition because when an element reaches root, it compares with itself and the loop gets ended.
        while(heap.get(idx) > heap.get((idx-1)/2)){
            int parent_idx = (idx-1)/2;
            swap(heap, idx, parent_idx);
            idx = parent_idx;
        }
    }
    public static void insertIntoHeapRecursion(List<Integer> heap, int num){
        heap.add(num);

        int idx = heap.size()-1;
        //push the num up
        pushUp(heap, idx);
    }
    private static void pushUp(List<Integer> heap, int idx){
        int parent_idx = (idx-1)/2;
        if(idx == 0 || heap.get(idx) < heap.get(parent_idx)) return;

        swap(heap, idx, parent_idx);
        pushUp(heap, parent_idx);
    }

    //DELETION
    private static void deletionInMaxHeap(List<Integer> heap){
        //1. swap the first and last elements
        swap(heap, 0, heap.size()-1);

        //2. remove the last element
        heap.remove(heap.size()-1);

        //3. Now perform heapify
        pushDownElements(heap, 0, heap.size()-1);
    }
    private static void pushDownElements(List<Integer> heap, int idx, int lastIdx){
        if( idx == lastIdx ) return;

        int leftIdx = (2 * idx) + 1;
        int rightIdx = (2 * idx) + 2;
        int greatestEleIdx = idx;

        if(leftIdx <= lastIdx && heap.get(leftIdx) > heap.get(greatestEleIdx)) greatestEleIdx = leftIdx;
        if(rightIdx <= lastIdx && heap.get(rightIdx) > heap.get(greatestEleIdx)) greatestEleIdx = rightIdx;

        if(greatestEleIdx == idx) return;

        swap(heap, idx, greatestEleIdx);

        pushDownElements(heap, greatestEleIdx, lastIdx);
    }
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(60);
        heap.add(50);
        heap.add(40);
        heap.add(30);
        heap.add(20);
        heap.add(10);
        heap.add(5);

        System.out.println("Heap before insertion: " + heap);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to insert in heap: ");
        int num = sc.nextInt();

//        insertIntoMinHeap(heap, num);
//        System.out.println("Heap after insertion using while loop: " + heap);

        insertIntoHeapRecursion(heap, num);
        System.out.println("Heap after insertion using recursion: " + heap);

        deletionInMaxHeap(heap);
        System.out.println("Heap after deletion: " + heap);
    }
}
