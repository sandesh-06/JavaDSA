package SortingTechniques.QuickSort;
/* in Quick Sort we have chose a pivot element and arrange the pivot element in it's correct position
     and then arrange the elements less than pivot on the left side of pivot and the elements greater on the right side*/
public class QuickSort {
    static void swapElements(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    static void printArray(int[] arr){
        for (int val: arr) {
            System.out.print(val + " ");
        }
    }
    static int partition(int[] arr, int start, int end){
        int pivotElement = arr[start]; //taking the first element as the pivot
        int eleLessThanPivot = 0; //using this to find the right position of the pivot
        //NOTE: assuming that duplicate elements, i.e elements that is equal to pivot as eleLessThanPivot and arranging them to the left of pivot

        for(int i = start+1; i<=end; i++){  //i = start+1 because the start element is pivot and check until the end of the array
            if(arr[i]<=pivotElement){   //<= because of including the duplicate elements
                eleLessThanPivot++;
            }
        }
        //the correct index for pivot is:
        int pivotIndex = start + eleLessThanPivot; //because while divide and conquer the start index may vary, so the pivot element should be placed after "eleLessThanPivot" elements from the start
        swapElements(arr, start, pivotIndex); //swap the pivot element from start to it's correct index

        //before returning the pivotIndex, arrange the elements <pivot on left and >pivot on right
        int i=start, j=end;
        while(i<pivotIndex && j>pivotIndex){
            while(arr[i]<=pivotElement) i++; //if the element is already less than pivot ignore
            while(arr[j]>pivotElement) j--; //if the element is already greater then ignore
            //if the element on the left is greater than pivot and vice versa swap the elements
            if(i<pivotIndex && j>pivotIndex){  //we need to check for the condition again, since we are increasing the index value in the above 2statements
                swapElements(arr, i, j);
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    static void quicksort(int[] arr, int start, int end){
        //base case
        if(start >= end) return;

        int pivotIndex = partition(arr, start, end); //to find the correct index of the pivot element
        quicksort(arr, start, pivotIndex-1); //for elements before the pivot
        quicksort(arr, pivotIndex+1, end); //for elements after the pivot
    }


    public static void main(String[] args) {
        int[] arr = {15, 1, 10, 9, 9, 9, 32, 17, 25};
        System.out.println("Array before sorting: ");
        printArray(arr);
        quicksort(arr, 0, arr.length-1);
        System.out.println();
        System.out.println("Array after sorting: ");
        printArray(arr);
    }
}

/*The worst case time complexity of this algo is O(n^2)
 i.e when we get a already sorted array like {1,2,3,4}. This happens because the pivot element is at the start.
 This can be avoided by choosing a random pivot element btw start and end index. THIS IS CALLED RANDOMIZED QUICK SORT*/
