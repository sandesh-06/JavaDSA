package OOPS;

import java.util.Arrays;

//CREATE YOUR OWN ARRAYLIST
public class OOP_10_Practice2 {
    public static class Arraylist{
        int[] arr = new int[5]; //initially every arraylist will get size 5
        int idx = 0;
        int size = 0;

        public void add(int ele){
            //if the array is full, then double the size of the array
            if(size == arr.length){
                arr = Arrays.copyOf(arr, arr.length*2); //set the new array name to arr
            }
            arr[idx] = ele;
            idx++;
            size++;
        }
        public int size(){
            return size;
        }
    }
    public static void main(String[] args) {
        Arraylist arr = new Arraylist();
        arr.add(5);
        arr.add(3);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        System.out.println(arr.size());
    }
}
