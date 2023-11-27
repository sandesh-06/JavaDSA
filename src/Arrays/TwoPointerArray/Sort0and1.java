package Arrays.TwoPointerArray;

public class Sort0and1 {
    static void swapElement(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    static void sortUsingTwoPointer(int[] arr){
        int left = 0, right = arr.length-1;
        while(left < right){
            if(arr[left] == 1 && arr[right] == 0){
                swapElement(arr, left, right);
                left++;
                right--;
            } else if (arr[left] == 0) {
                left++;
            } else if (arr[right] == 1) {
                right--;
            }
        }
        printArray(arr);
    }
    static int[] sortUsingSameArray(int[] arr){
        int count = 0;
        //to count the no.of zeroes
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                count++;
            }
        }

        //to sort 0's and 1's
        for(int j=0; j<arr.length; j++){
            if(j < count){
                arr[j] = 0;
            }else {
                arr[j] = 1;
            }
        }
        return arr;
    }
    public static void printArray(int[] arr){
        for(int ele: arr){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0, 1, 0, 1, 1, 0};
        System.out.println("Original array: ");
        printArray(arr);
//        sortUsingSameArray(arr);
//        printArray(arr);
        System.out.println("Sorted using two pointer: ");
        sortUsingTwoPointer(arr);

    }
}
