package OOPS;

public class OOP_3_Scope_of_Class {
    //5. when a class is declared outside the main, the scope of the class is extended to the whole program
    public static class Student{
        String name;
        int roll_no;
        double gpa;
    }
    static void func(Student a){
        System.out.println("Printing using the function: " + a.gpa);
        return;
    }
    public static void main(String[] args) {
        //1. we can create a class inside the main function also
//        class Student{
//            String name;
//            int roll_no;
//            double gpa;
//        }

       Student a = new Student(); //declaration of the object
        a.name = "Sandesh"; // initialization part
        a.roll_no = 112;
        a.gpa = 9.1;
        System.out.println(a.name); //2. for class inside main, works perfectly fine
        //3. but when we pass the object to a function say,
        func(a); //4. this won't work if the class is declared inside main function, because the scope of the class is only for the main
    }
}
