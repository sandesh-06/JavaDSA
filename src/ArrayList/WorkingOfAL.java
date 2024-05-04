package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class WorkingOfAL {
    public static void main(String[] args) {
        //what we need to achieve [[1], [1, 2]]
        List<List<Integer>> output1 = new ArrayList<>();
        List<List<Integer>> output2 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(1);
        output1.add(l1);
        l1.add(2);
        output1.add(l1);
        System.out.println("output 1: " + output1);

        l2.add(1);
        output2.add(new ArrayList<>(l2)); //create a copy of l2 and then add it to the output

        l2.add(2);
        output2.add(new ArrayList<>(l2));
        System.out.println("output 2: " + output2);
    }
}
