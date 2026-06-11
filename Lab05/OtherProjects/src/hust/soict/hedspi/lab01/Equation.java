package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class Equation {
    public static void solveLinearEquation(Scanner sc) {
        System.out.println("ax + b = 0");
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập b: ");
        double b = sc.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình có vô số nghiệm.");
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        } else {
            double x = -b / a;
            System.out.println("Nghiệm x =" + x);
        }
    }

    public static void solveLinearSystem(Scanner sc) {
        System.out.println("Hệ tuyến tính bậc nất 2 ẩn: ");
        System.out.println("Dạng: a11*x1 + a12*x2 = b1 | a21*x1 + a22*x2 = b2");
        System.out.print("Nhập a11, a12, b1: ");
        double a11 = sc.nextDouble();
        double a12 = sc.nextDouble();
        double b1 = sc.nextDouble();
        System.out.print("Nhập a21, a22, b2: ");
        double a21 = sc.nextDouble();
        double a22 = sc.nextDouble();
        double b2 = sc.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            System.out.println("Hệ có nghiệm duy nhất: x1 = " + (D1 / D) + ", x2 = " + (D2 / D));
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Hệ phương trình có vô số nghiệm.");
            } else {
                System.out.println("Hệ phương trình vô nghiệm.");
            }
        }
    }

    public static void solveQuadraticEquation(Scanner sc) {
        System.out.println("ax^2 + bx + c = 0");
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập b: ");
        double b = sc.nextDouble();
        System.out.print("Nhập c: ");
        double c = sc.nextDouble();

        if (a == 0) {
            if (b == 0) {
                if (c == 0) System.out.println("Vô số nghiệm.");
                else System.out.println("Vô nghiệm.");
            } else {
                System.out.println("Nghiệm x = " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println(" 2nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                System.out.println("Nghiệm kép: x = " + (-b / (2 * a)));
            } else {
                System.out.println("Phương trình vô nghiệm thực.");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chon chuong trình");
            System.out.println("1. Phương trình bậc nhất 1 ẩn");
            System.out.println("2. Hệ phương trình bậc nhất 2 ẩn");
            System.out.println("3. Phương trình bậc hai 1 ẩn");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                solveLinearEquation(scanner);
            } else if (choice == 2) {
                solveLinearSystem(scanner);
            } else if (choice == 3) {
                solveQuadraticEquation(scanner);
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Không hợp lệ!");
            }
        }
        scanner.close();
    }
}
