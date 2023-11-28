package OOPS;

public class OOP_6_Getter_Setter {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "mudla da";
        s1.gpa = 0.3;
//        s1.roll_no() - is not possible

        //instead we can use the getter and setter function declared inside the class
        s1.setRoll_no(420); // setting roll no
        System.out.println("Printing the roll no using getter: " + s1.getRoll_no());
    }
}
