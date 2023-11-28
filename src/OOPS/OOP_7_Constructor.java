package OOPS;

public class OOP_7_Constructor {
    public static class Cars{
        String name;
        int reg_num;
        double weight;

        //2. Create a constructor WITH THE SAME NAME AS THE CLASS
        public Cars(String name, int num, double weight){
            this.name = name;
            reg_num = num;
            this.weight = weight;

        }

        //default constructor
        public Cars(){

        }
    }
    public static void main(String[] args) {
//            Cars c1 = new Cars();
//            c1.name = "Alto";
//            c1.reg_num = 1234;
//            c1.weight = 899.2;
            //1. Instead of giving values to attributes separately, we can do it with help of constructor

            Cars c2 = new Cars("Kia", 1235, 2398.2);
        System.out.println(c2.name + " " + c2.reg_num + " " + c2.weight);

        //without default constructor, it becomes compulsory to give arguments inside the Cars(). But with default constructor it isn't
            Cars c3 = new Cars();
            c3.name = "Alto";
            c3.reg_num = 1234;
            c3.weight = 899.2;
        System.out.println(c3.name + " " + c3.reg_num + " " + c3.weight);

    }
}
