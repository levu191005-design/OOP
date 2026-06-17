package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class TriangleWithHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap chieu cao cua tam giac: ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
