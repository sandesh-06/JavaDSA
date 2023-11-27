package SortingTechniques.SelectionSort;
import java.util.Scanner;
public class CodeVita_1 {
    static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    static int findMinIdx(int[] arr, int st){
        int minIdx = st;
        for(int i = st; i<arr.length; i++){
            if(arr[i]<arr[minIdx]) minIdx = i;
        }
        return minIdx;
    }
    static void reflectSort(int[] arr1, int[] arr2, int k){
        int len = arr1.length;

        for(int i = 0; i<k; i++){
            int minIdx = findMinIdx(arr1, i);
            //swap elements
            swap(arr1, i, minIdx);
            swap(arr2, i, minIdx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] A = sc.nextLine().split(" ");
        String[] B = sc.nextLine().split(" ");
        int arr_len = A.length;
        int[] arr1 =new int[arr_len];
        int[] arr2 = new int[arr_len];
        for(int i = 0; i<arr_len; i++){
            arr1[i] = Integer.parseInt(A[i]);

        }
        for(int i = 0; i<arr_len; i++){
            arr2[i] = Integer.parseInt(B[i]);
        }
        int rotate_times = sc.nextInt();
        reflectSort(arr1, arr2, rotate_times);

        for(int n : arr2) System.out.print(n + " ");
    }
}
