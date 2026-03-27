import java.util.Scanner;

public class motan{

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("ax + b = 0 ");
    System.out.print(" a: ");
    double a = sc.nextDouble();
    System.out.print(" b: ");
    double b = sc.nextDouble();

    if (a == 0) {
        if (b == 0) {
            System.out.println("vô số nghiệm");
        } else {
            System.out.println("vô nghiệm");
        }
    } else {
        double x = -b / a;
        System.out.println("nghiệm x = " + x);
    }
}
}
