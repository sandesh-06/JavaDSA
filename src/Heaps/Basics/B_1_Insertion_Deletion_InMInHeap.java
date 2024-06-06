package Heaps.Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
                                                             10
                                                          /     \
                                                        20       30
                                                     /     \   /    \
                                                   40      50 60    70


Formulas:
Left Child: (2 * i) + 1
Right Child: (2 * i) + 2
Parent of a node: (i - 1)/2

*/
public class B_1_Insertion_Deletion_InMInHeap {
    private static void swap(List<Integer> heap, int x, int y){
        int temp = heap.get(x); //25
        heap.set(x, heap.get(y));
        heap.set(y,temp);
    }

    //INSERTION
    private static void insertIntoMinHeap(List<Integer> heap, int num){
        /*
            Steps:
            1. Add the number to the end of the array.
            2. Compare the number with it's parent node, if lesser than parent then swap until correct position found, (i.e) in a tree structure if the node is lesser than parent node, push the node up.
            3. Or Until the element reaches the root
        */

        heap.add(num);
        int idx = heap.size()-1;

        while(num < heap.get((idx-1)/2)){
            int parent_idx = (idx-1)/2;
            swap(heap, idx, parent_idx);
            idx = (idx-1)/2;
        }
    }
    private static void pushUpInheap(List<Integer> heap, int idx){
        int parent_idx = (idx-1)/2;
        if(idx == 0 || heap.get(parent_idx) < heap.get(idx)) return;

        swap(heap, idx, parent_idx);

        pushUpInheap(heap, parent_idx);
    }
    private static void insertionUsingRecursion(List<Integer> heap, int num){
        //1. add the element to array
        heap.add(num);

        int idx = heap.size()-1;
        pushUpInheap(heap, idx);
    }

    //DELETION
    private static void deletionInMinHeap(List<Integer> heap){
        /*
            Steps to delete the root node:
            1. Swap the first and last elements
            2. Remove the last element
            3. Now perform heapify which is push down the first element down, until it's correct position
        */
        //1.
        swap(heap, 0, heap.size()-1);
        //2.
        heap.remove(heap.size()-1);
        //3. Heapify - push down
        pushDownElements(heap, 0, heap.size()-1);
    }
    private static void pushDownElements(List<Integer> heap, int idx, int lastIdx){

        //1. find left and right child indices
        int left = (2 * idx) + 1;
        int right = (2 * idx) + 2;
        int smallestElementIdx = idx; //set it for curr idx initially

        //base condition
        if(idx == lastIdx) return;

        //2.check if left element is lesser than curr and check if left in inbound (i.e) it's not exceeding the last idx
        if(left <= lastIdx && heap.get(left) < heap.get(smallestElementIdx)) smallestElementIdx = left;
        if(right <= lastIdx && heap.get(right) < heap.get(smallestElementIdx)) smallestElementIdx = right;
        //what we are doing is comparing left and right child of curr node, and assign the index of the smallest among them.

        if(smallestElementIdx == idx) return; //if the curr element itself is the smallest

        //3. Now swap the element in curr idx with the index of smallest element
        swap(heap, idx, smallestElementIdx);

        //4. Now perform heapify until the heap is heaped.
        pushDownElements(heap, smallestElementIdx, lastIdx);


    }

    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(50);
        heap.add(60);
        heap.add(70);
        System.out.println("Heap: " + heap);
        System.out.println("Enter a number to add in the heap: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

//        insertIntoMinHeap(heap, num);
//        System.out.println("Heap after insertion using while loop: " + heap);

        insertionUsingRecursion(heap, num);
        System.out.println("Heap after insertion using Recursion: " + heap);

        deletionInMinHeap(heap);
        System.out.println("Heap after deletion: " + heap);
    }
}
