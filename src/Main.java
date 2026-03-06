
import java.util.Scanner;
import java.lang.Math;
public class Main {
    //factorial
    public static double getFactorial(int f) {
        double result = 1.0;
        for (int i = 1; i <= f; i++) {
            result = result * i;
            if (Double.isInfinite(result)) {
                return result;
            }
        }
        return result;
    }
    //Macularien series
    public static double Macularien(double x){
        double result = 0;
        int f  = 0;
        double a = 0;
            for (int i = 0; i<Integer.MAX_VALUE;i++) {
                f = 2 * i + 1;
                a = (Math.pow(-1, i) / getFactorial(f)) * Math.pow(x, 2 * i + 1);
                if (a == 0.0) {
                    System.out.println( i-- + " last n that could be calculated");
                    break;
                }
                result +=a;
            }
        return result;
    }

    public static void main(String[] args){
        System.out.println("Provide sin x ");
        Scanner scr = new Scanner(System.in);
        double x = scr.nextDouble();
        x = x % (2.0 * Math.PI);
        System.out.println(Macularien(x));
        System.out.println();
    }
}
