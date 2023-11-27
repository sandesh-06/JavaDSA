package ArrayList;
import java.util.ArrayList;

public class Introduction {
    public static void main(String[] args) {
        //NOTE: ARRAY LIST WORKS ON WRAPPER CLASSES ONLY
        Integer in = 5;
        Float f = 5.2f;

        //to initiate an Array List:
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Boolean> l2 = new ArrayList<>();

        //1. to add an element:
        l1.add(5);
        l1.add(6);
        l1.add(7);
        l1.add(8);

        //2. get an element at index i
        System.out.println(l1.get(1)); //prints element at index 1
        System.out.println(l1.get(3));

        //3. print ArrayList using for Loop:
        for(int i = 0; i<l1.size(); i++){ //.size() is used to find the length
            System.out.println(l1.get(i));
        }

        //4. print the array list:
        System.out.println(l1);

        //5. add element at index i:
        l1.add(1, 100); //add 100 at 1st index.
        System.out.println(l1);

        //6. modify element at index i:
        l1.set(1, 50); //change the value at index 1 to 50
        System.out.println(l1);

        //7 .remove element at index i:
        l1.remove(2);
        System.out.println(l1);

        //8. remove an element:
        l1.remove(Integer.valueOf(8));
        System.out.println(l1);

        //9. check if element exists:
        boolean ans = l1.contains(7);
        System.out.println(ans);

        //10. if you don't specify the class, you can add anything into the Array List:
        ArrayList l = new ArrayList();
        l.add("This is string");
        l.add(5);
        l.add(true);
        System.out.println(l);




    }
}
