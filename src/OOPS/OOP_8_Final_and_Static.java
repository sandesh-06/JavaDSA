package OOPS;

public class OOP_8_Final_and_Static {
    public static class Cars {
        String name;
        int reg_num;
        double weight;
        final String country = "India";  //ATTRIBUTE WITH 'FINAL' KEYWORD CANNOT BE MANIPULATED AT ALL
//        int no_of_cars;
       static int no_of_cars;
        //constructor
        public Cars(String name, int num, double weight) {
            this.name = name;
            reg_num = num;
            this.weight = weight;
            no_of_cars++; //whenever a car object is created increment the no of cars.
        }
        public Cars(){

        }
    }
        public static void main(String[] args) {
            Cars c1 = new Cars("Figo", 9898, 1291.2);
//            c.country = "Japan"; - cannot change a final value
            System.out.println("Testing final keyword: " + c1.country);
            System.out.println("No of cars after c1: " + c1.no_of_cars);
            Cars c2 = new Cars("Punto", 2932, 1921.3);
            System.out.println("No of cars after c2: " + c2.no_of_cars);

            //ONCE WE DECLARE A STATIC ATTRIBUTE, It belongs to the class instead of the object. If it belonged to an object, then everytime an object is created it would
            //have had separate space for it in every object. Since it belongs to the class, it becomes a common attribute for all the objects
            //so we can call it as:
            System.out.println("No of cars using class name: " + Cars.no_of_cars);

            //NOTE: IF YOU WANT TO ACCESS A FUNCTION DEFINED IN A CLASS USING <classname>.<func_name> THEN THE FUNCTION MUST BE STATIC FUNCTION

        }
}
