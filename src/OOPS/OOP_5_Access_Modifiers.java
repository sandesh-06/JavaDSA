package OOPS;

public class OOP_5_Access_Modifiers {
//    public static class Student{
//    public String name;
//    private int roll_no;
//    default double gpa; //or double gpa (no need to specify default)
//}
//IF THE PRIVATE KEY IS DEFINED FOR A CLASS INSIDE THE SAME FILE, THEN IT IS VALID IN THAT FILE
    public static void main(String[] args) {
        Student s1 = new Student(); //WE ARE USING THE CLASS FROM THE FILE "STUDENT"
        s1.name ="Sandesh";
//        s1.roll_no = 112; //this line gives error, because the roll_no is declared private in class Student
        s1.gpa = 9.1;
//        System.out.println(s1.roll_no);
    }

    /*
        READ THIS TO UNDERSTAND PUBLIC, PRIVATE AND DEFAULT:

        //DEFAULT:
        1. When a class is defined at say package A, and you can access this class and create an object at package B by importing the class.
           But you cannot access the properties or attributes of the class, if it has access modifier of 'default' or nothing. Not specifying anything means default
           If you need to access the same class inside the same package, then that is totally allowed.

           short: Default values cannot be access outside a package

        2. When a attribute is declared as private, then it cannot be used outside of the class, or outside the file.

        3. If you declare a attribute as public then it can be access in any package by importing it

    */
}
