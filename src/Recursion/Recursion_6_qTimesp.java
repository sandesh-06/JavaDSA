package Recursion;

import java.util.Scanner;

public class Recursion_6_qTimesp {
    static int qTimep(int p, int q){
//        if(q == 0) return 1; //since anything to power 0 is 1
//        return qTimep(p, q-1) * p;

        //WITH BETTER TIME COMPLEXITY : instead of p^q-1 * p we can do p^q/2 * p^q/2

        if(q == 0) return 1;

        //for even q
        if(q % 2 == 0 ){
            //return qTimep(p, q/2) * qTimep(p, q/2) //if we call the func 2times then the time complex will increase
            int recAns = qTimep(p, q/2);
            return recAns * recAns;
        }

        //for odd q
        int recAns = qTimep(p, q/2);
        return p * recAns * recAns; //for odd q, we need to multiply one extra p

    }
    public static void main(String[] args) {
        int p, q;
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt();
        q = sc.nextInt();

        System.out.println(qTimep(p, q));
    }
}
