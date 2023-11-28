package OOPS;

public class OOP_1_Creating_Class {

    //Creating a class is like creating our own data type, here the datatype is 'Student'
    public static class Student {
        String name;
        int roll_no;
        double gpa;
    }

    public static void main(String[] args) {
        //creating an object for the class Student
        Student a = new Student(); //declaration of the object
//        a.name = "Sandesh"; // initialization part
        a.roll_no = 112;
        a.gpa = 9.1;
//        System.out.println(a); //output - OOPS.OOP_1_Creating_Class$Student@58372a00
        System.out.println(a.name + " " + a.roll_no + " " + a.gpa); //to print the properties

        //DEFAULT VALUES
        //when we don't initialize a attribute/property, we get it's default value
        //say name is not initialized and we try to print it
        System.out.println(a.name); //we get null value
        //similarty int will have 0 as default and double will have 0.0
    }
}
