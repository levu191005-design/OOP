<<<<<<< HEAD
import java.util.Scanner;

public class timnghiem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Phương trình bậc 1: ax + b = 0

        System.out.println("phương trình bậc 1: ax + b = 0 ");
        System.out.print("a: ");
        double a = sc.nextDouble();
        System.out.print("b: ");
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


        // 2. Hệ phương trình 2 ẩn

        System.out.println("hệ phương trình 2 ẩn");
        System.out.print(" a11: ");
        double a11 = sc.nextDouble();
        System.out.print(" a12: ");
        double a12 = sc.nextDouble();
        System.out.print(" b1: ");
        double b1 = sc.nextDouble();

        System.out.print("a21: ");
        double a21 = sc.nextDouble();
        System.out.print("a22: ");
        double a22 = sc.nextDouble();
        System.out.print("b2: ");
        double b2 = sc.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("vô số nghiệm");
            } else {
                System.out.println("vô nghiệm");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }


        // 3. Phương trình bậc 2: ax^2 + bx + c = 0

        System.out.println("phương trình bậc 2: ax^2 + bx + c = 0 ");
        System.out.print("a: ");
        double a2 = sc.nextDouble();
        System.out.print("b: ");
        double b22 = sc.nextDouble();
        System.out.print("c: ");
        double c = sc.nextDouble();

        if (a2 == 0) {
            if (b22 == 0) {
                if (c == 0) {
                    System.out.println("vô số nghiệm");
                } else {
                    System.out.println("vô nghiệm");
                }
            } else {
                double x = -c / b22;
                System.out.println("nghiệm duy nhất x = " + x);
            }
        } else {
            double delta = b22 * b22 - 4 * a2 * c;

            if (delta > 0) {
                double x1 = (-b22 + Math.sqrt(delta)) / (2 * a2);
                double x2 = (-b22 - Math.sqrt(delta)) / (2 * a2);
                System.out.println("nghiệm: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b22 / (2 * a2);
                System.out.println("nghiệm kép x = " + x);
            } else {
                System.out.println("vô nghiệm");
            }
        }

        sc.close();
    }
=======
import java.util.Scanner;

public class timnghiem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Phương trình bậc 1: ax + b = 0

        System.out.println("phương trình bậc 1: ax + b = 0 ");
        System.out.print("a: ");
        double a = sc.nextDouble();
        System.out.print("b: ");
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


        // 2. Hệ phương trình 2 ẩn

        System.out.println("hệ phương trình 2 ẩn");
        System.out.print(" a11: ");
        double a11 = sc.nextDouble();
        System.out.print(" a12: ");
        double a12 = sc.nextDouble();
        System.out.print(" b1: ");
        double b1 = sc.nextDouble();

        System.out.print("a21: ");
        double a21 = sc.nextDouble();
        System.out.print("a22: ");
        double a22 = sc.nextDouble();
        System.out.print("b2: ");
        double b2 = sc.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("vô số nghiệm");
            } else {
                System.out.println("vô nghiệm");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }


        // 3. Phương trình bậc 2: ax^2 + bx + c = 0

        System.out.println("phương trình bậc 2: ax^2 + bx + c = 0 ");
        System.out.print("a: ");
        double a2 = sc.nextDouble();
        System.out.print("b: ");
        double b22 = sc.nextDouble();
        System.out.print("c: ");
        double c = sc.nextDouble();

        if (a2 == 0) {
            if (b22 == 0) {
                if (c == 0) {
                    System.out.println("vô số nghiệm");
                } else {
                    System.out.println("vô nghiệm");
                }
            } else {
                double x = -c / b22;
                System.out.println("nghiệm duy nhất x = " + x);
            }
        } else {
            double delta = b22 * b22 - 4 * a2 * c;

            if (delta > 0) {
                double x1 = (-b22 + Math.sqrt(delta)) / (2 * a2);
                double x2 = (-b22 - Math.sqrt(delta)) / (2 * a2);
                System.out.println("nghiệm: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b22 / (2 * a2);
                System.out.println("nghiệm kép x = " + x);
            } else {
                System.out.println("vô nghiệm");
            }
        }

        sc.close();
    }
>>>>>>> af00c4e3566c8644ae165e5d9e480545198b2258
}