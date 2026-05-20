package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class ManipulateDouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so thu nhat: ");
        String strNum1 = sc.nextLine();
        System.out.println("Nhap sos thu hai: ");
        String strNum2 = sc.nextLine();

        Double num1 = Double.parseDouble(strNum1);
        Double num2 = Double.parseDouble(strNum2);

        System.out.println("Tong 2 so la: " + (num1 + num2));
        System.out.println("Hieu 2 so la: " + (num1 - num2));
        System.out.println("Tich 2 so la: " + (num1 * num2));
        if(num2 == 0) {
            System.out.println("Khong chia duoc cho 0!");
        } else {
            System.out.println("Thuong 2 so la: " + (num1 / num2));
        }
        sc.close();
    }
}
