package Arrays;
import java.util.Scanner;

public class SwapNumbers {
    static void swapUsingSumAndDiff(int num1, int num2){
        System.out.println("Before swapping - num1: " + num1 + " num2: " + num2);
        //considering num1 = 9 and num2 = 3
        num1 = num1 + num2; //num1 = 9 + 3 = 12
        num2 = num1 - num2; //num2 = 12 - 3 = 9
        num1 = num1 - num2; //num1 = 12 - 9 = 3
        System.out.println("After swapping - num1: " + num1 + " num2: " + num2);

    }
    static void swapUsingTemp(int num1, int num2){
        int temp;
        temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.println("After swap- num1: " + num1 + " num2: " + num2);
    }
    public static void main(String[] args) {
        int num1, num2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1: ");
        num1 = sc.nextInt();
        System.out.println("Enter num2: ");
        num2 = sc.nextInt();
//        swapUsingTemp(num1, num2);
        swapUsingSumAndDiff(num1, num2);
    }
}
