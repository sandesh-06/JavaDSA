package ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReverseArrayList {
    static void reverseList(ArrayList<Integer> list){
        int i=0, j = list.size() - 1;
        while(i<j){
            Integer temp = Integer.valueOf(list.get(i));
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int totEle;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter total elements in array list: ");
        totEle = sc.nextInt();

        for(int i = 0; i<totEle; i++){
            list.add(sc.nextInt());
        }
//        reverseList(list);
//        System.out.print("Reversed using user defined function: ");
//        System.out.println(list);

        //reverse using inbuilt method
        System.out.print("Using inbuilt method: ");
        Collections.reverse(list);
        System.out.println(list);

    }
}
