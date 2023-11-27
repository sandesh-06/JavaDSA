package Arrays;
import java.util.Scanner;

public class findElement {
    public static void main(String[] args) {
        int userElement, index = -1;
        Scanner sc = new Scanner(System.in);
        userElement = sc.nextInt();
        int[] arr = { 1, 4, 35, 29, 10};
        for(int i=0; i<arr.length; i++){
            if(arr[i] == userElement){
                index = i;
                System.out.println("Your element's index is: " + index);
                break;
            }
        }
        if(index == -1){
            System.out.println("Your element is not present in the array");
        }

    }
}
