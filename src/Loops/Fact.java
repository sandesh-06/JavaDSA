package Loops;
import java.util.Scanner;

public class Fact {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInp, fact = 1;
        userInp = sc.nextInt();
        while(userInp > 0){
            fact = fact * userInp;
            userInp-=1;
        }
        System.out.println(fact);
    }
}
