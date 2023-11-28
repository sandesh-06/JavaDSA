package OOPS;

public class Student{
    String name;
    private int roll_no;
    double gpa;

    //SINCE THE PRIVATE ATTRIBUTES CAN BE ACCESSED ONLY INSIDE THE CLASS, We have 2 separate functions called 'getter' and 'setter' to access then

    //getter
    public int getRoll_no(){
        return roll_no;
    }

    //setter
    public void setRoll_no(int roll_no){
//        roll_no = roll;
        //if you use the same variable name for setting the value, make sure you use 'this' keyword. This specifies that access the attribute from this class
        this.roll_no = roll_no;
    }

}
