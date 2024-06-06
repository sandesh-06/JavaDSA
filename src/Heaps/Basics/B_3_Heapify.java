package Heaps.Basics;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

/*              Before Heapify:
                                                            60
                                                          /    \
                                                        50      40
                                                     /    \    /  \
                                                   30     20  10   5

                                                             5
                                                          /     \
                                                        20       10
                                                     /    \    /   \
                                                   30     50  60    40


Formulas:
Left Child: (2 * i) + 1
Right Child: (2 * i) + 2
Parent of a node: (i - 1)/2

*/
public class B_3_Heapify {
    private static void heapify(List<Integer> heap){
        int idxOfFirstNonLeaf = ((heap.size()-1) - 1) / 2;

        for(int i = idxOfFirstNonLeaf; i>=0; i--) pushDownElement(heap, i, heap.size()-1);
    }

    private static void pushDownElement(List<Integer> heap, int idx, int lastIdx) {
        if( idx == lastIdx ) return;

        int leftChildIdx = (2 * idx) + 1;
        int rightChildIdx = (2 * idx) + 2;
        int smallestEleIdx = idx;

        if(leftChildIdx <= lastIdx && heap.get(leftChildIdx) < heap.get(smallestEleIdx)) smallestEleIdx = leftChildIdx;
        if(rightChildIdx <= lastIdx && heap.get(rightChildIdx) < heap.get(smallestEleIdx)) smallestEleIdx = rightChildIdx;

        if(smallestEleIdx == idx) return; //if neither left nor right is smaller

        swap(heap, idx, smallestEleIdx);
        pushDownElement(heap, smallestEleIdx, lastIdx);
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

        System.out.println("Before heapify: " + heap);
        heapify(heap);
        System.out.println("After heapify: " + heap);
    }
}
