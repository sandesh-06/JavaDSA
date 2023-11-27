package Arrays.Assingment3;
import java.util.Scanner;

import static Arrays.Assingment1.Question1.createArray;
import static Arrays.MaxElement.findMax;

public class Question1 {
    static boolean uniqueElements(int[] arr, int m){
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 1){
                count++;
            }
        }
        return count >= m;
    }
    static int[] createOccurrenceArray(int[] arr){
        int maxElement = findMax(arr);
        int[] occArray = new int[maxElement + 1];
        for(int i = 0; i<arr.length; i++){
            occArray[arr[i]]++;
        }
        return occArray;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m;
        int[] arr = createArray();

        //find occurrence array of the given array
        int[] occArr = (createOccurrenceArray(arr));

        System.out.println("Enter the no.of expected unique elements: ");
        m = sc.nextInt();

        System.out.println(uniqueElements(occArr, m));
    }
}
