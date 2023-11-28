package OOPS;

public class OOP_9_Practice1 {
    static Fractions add(Fractions f1, Fractions f2){
        int numer = f1.numerator*f2.denominator + f2.numerator*f1.denominator;
        int demom = f1.denominator * f2.denominator;
        Fractions f3 = new Fractions(numer, demom);
        return f3;
    }
    static Fractions mul(Fractions f1, Fractions f2){
        int numer = f1.numerator*f2.numerator;
        int demom = f1.denominator * f2.denominator;
        Fractions f3 = new Fractions(numer, demom);
        return f3;
    }
    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        return gcd(num2, num1%num2);
    }
    public static class Fractions{
        int numerator;
        int denominator;

        public Fractions(int num1, int num2){
            this.numerator = num1;
            this.denominator = num2;
            simplify(); //immediately after assigning, the nos will get simplified
        }
        public void simplify(){
            int hcf = gcd(numerator, denominator); //if you take hcf for both numerator and denominator, and divide it with both the nos, the nos will get simplified
            numerator /= hcf;
            denominator /= hcf;
        }
    }
    public static void main(String[] args) {
        Fractions f1 = new Fractions(35, 7);
        System.out.println("Fraction f1: " + f1.numerator + "/" + f1.denominator);

        Fractions f2 = new Fractions(2, 5);
        System.out.println("Fraction f2: " + f2.numerator + "/" + f2.denominator);

        Fractions f3 = add(f1, f2);
        System.out.println("f1 + f2: " + f3.numerator + "/" + f3.denominator);

        Fractions f4 = mul(f1, f2);
        System.out.println("f1 * f2: " + f4.numerator + "/" + f4.denominator);
    }
}
