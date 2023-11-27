package Loops;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 1, b = 1, c,i, userInp;
        userInp = sc.nextInt();
        System.out.print(a + " " + b);
        for(i=0;i<userInp-2; i++){
           c = a + b;
           System.out.print(" " + c);
           a = b;
           b = c;
        }
    }
}