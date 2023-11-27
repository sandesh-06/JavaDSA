package Loops;
import java.util.Scanner;
public class Loop_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInp, sum = 0;
        while(sc.hasNextInt()){
            userInp = sc.nextInt();
            if(userInp >= 0){
                sum += userInp;
            }
            else {
                sum = -1;
                break;
            }
        }
        System.out.println(sum);
    }
}
