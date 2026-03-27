import java.util.Scanner;

public class haian {

    public static void main(String[] args) {
        System.out.println("\n=== System of equations ===");
        System.out.print("Enter a11: ");
        double a11 = sc.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = sc.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = sc.nextDouble();

        System.out.print("Enter a21: ");
        double a21 = sc.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = sc.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = sc.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
}