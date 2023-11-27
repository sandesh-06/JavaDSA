package Arrays;
import java.util.Scanner;

//CHECKING IF A NUMBER IS PRESENT IN THE ARRAY USING A "FREQUENCY ARRAY" WHICH HELPS IN REDUCING THE TIME COMPLEXITY
public class IfNumberIsPresent {
    static int[] makeFreqArray(int[] arr){
        int[] freqArray = new int[10005]; //given in the question 10^5
        for(int i=0; i<arr.length; i++){
            freqArray[arr[i]]++;
        }
        return freqArray;

    }
    public static void main(String[] args) {
        int arrSize, element, times;
        System.out.println("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        arrSize = sc.nextInt();
        int[] arr = new int[arrSize];

        System.out.println("Enter array elements:");
        for(int i=0; i<arr.length; i++){
            element = sc.nextInt();
            arr[i] = element;
        }

        int [] freqArray = makeFreqArray(arr);

        System.out.println("How many elements needs to be searched: ");

        int noOfSearches = sc.nextInt();
        while(noOfSearches > 0){
            System.out.println("Enter the element to search: ");
            int x = sc.nextInt();
            if(freqArray[x] > 0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            noOfSearches--;

        }

    }
}
