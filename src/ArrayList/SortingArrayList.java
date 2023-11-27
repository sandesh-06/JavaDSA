package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortingArrayList {
    public static void main(String[] args) {
        int totEle;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter total elements in array list: ");
        totEle = sc.nextInt();

        for(int i = 0; i<totEle; i++){
            list.add(sc.nextInt());
        }

        //TO SORT IN ASCENDING ORDER:
        Collections.sort(list);
        System.out.print("Ascending order: ");
        System.out.println(list);

        //TO SORT IN DESCENDING ORDER:
        Collections.sort(list, Collections.reverseOrder());
        System.out.print("Descending order: ");
        System.out.println(list);

        //SORT THE STRING ARRAY LIST:
        ArrayList<String> s1 = new ArrayList<>();
        s1.add("Hello");
        s1.add("What");
        s1.add("Is");
        s1.add("Surprise");
        System.out.println("ASCENDING - ");
        System.out.println("Original: " + s1);
        Collections.sort(s1);
        System.out.println("Sorted: " + s1);

        System.out.println("DESCENDING - ");
        System.out.println("Original: " + s1);
        Collections.sort(s1, Collections.reverseOrder());
        System.out.println("Sorted: " + s1);
    }
}
