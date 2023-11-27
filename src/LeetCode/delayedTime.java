package LeetCode;

import java.util.Scanner;

public class delayedTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aT, dT;
        aT = sc.nextInt();
        dT = sc.nextInt();

        int finalTime = aT + dT;
        int formatTime = finalTime % 24;

        System.out.println(formatTime);

    }
}
