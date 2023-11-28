package OOPS;

public class OOP_2_Passing_class_to_function {
    public static class Student{
        String name;
        int roll_no;
        double gpa;
    }
    static void change(Student s){
        s.name = "Sandy";
    }
    public static void main(String[] args) {
        Student a = new Student();
        a.name = "Sandesh";
        a.roll_no = 112;
        a.gpa = 9.1;

        //while passing a class to a function, does it pass by value or reference. Lets see..
        System.out.println("Before: " + a.name); //before passing
        change(a);
        System.out.println("After: " + a.name); //after passing

        //So the value does change, Hence passing a class is PASS BY REFERENCE

    }
}
