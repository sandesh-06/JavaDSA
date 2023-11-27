package Recursion.RecursionInArrays;

import java.util.ArrayList;

public class ReturnIndex_5 {
    static ArrayList<Integer> returnIndexArrayList(int[] arr, int target, int n, int idx){
        if(idx >= n){
            return new ArrayList<Integer>(); //if no element present return empty array list
        }

        //Self work
        ArrayList<Integer> firstEle = new ArrayList<Integer>();
        if(arr[idx] == target){   //if the target element is present in the first index all the index of the element
            firstEle.add(idx);
        }

        //recursive work
        ArrayList<Integer> allEle = returnIndexArrayList(arr, target, n, idx+1);

        //merge firstEle + allEle
        firstEle.addAll(allEle);
        return firstEle;



    }
    static void returnAllIndex(int[] arr, int target, int n, int idx){
        if(idx >= n){
            return;
        }

        //self work
        if(arr[idx] == target) System.out.println(idx);

        //recursive work
        returnAllIndex(arr, target, n, idx + 1);


    }
    static void returnFirstIndex(int[] arr, int target, int n, int idx){
        if(idx >= n){   //if the index value has crossed the length of array
            System.out.println("Not found");
            return;
        }

        //self work - check for the first element
        if(arr[idx] == target) System.out.println("Found at index " + idx);

        //recursive work - let recursion do for rest of the array
       returnFirstIndex(arr, target, n, idx+1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5 ,6, 3, 2, 7, 23, 67};
        int target = 3;
//       returnFirstIndex(arr, target, arr.length, 0);
//        returnAllIndex(arr, target, arr.length, 0);
        System.out.println(returnIndexArrayList(arr, target, arr.length, 0));
    }

}
