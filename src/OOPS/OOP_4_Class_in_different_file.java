package OOPS;

public class OOP_4_Class_in_different_file {
//    I HAVE CREATED A STUDENT CLASS IN STUDENT FILE IN THIS SAME PACKAGE
//    So we can use the class without importing it, if it's declared in the same package
//    But suppose if we need a class from different package, then we need to import it
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Sandlo";
        System.out.println(s1.name);
    }
}
