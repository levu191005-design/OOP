package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class NumberOfDay {
        public static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
        public static int getMonthNumber(String input) {
            String s = input.toLowerCase().trim();
            if (s.equals("january") || s.equals("jan.") || s.equals("jan") || s.equals("1")) return 1;
            if (s.equals("february") || s.equals("feb.") || s.equals("feb") || s.equals("2")) return 2;
            if (s.equals("march") || s.equals("mar.") || s.equals("mar") || s.equals("3")) return 3;
            if (s.equals("april") || s.equals("apr.") || s.equals("apr") || s.equals("4")) return 4;
            if (s.equals("may") || s.equals("5")) return 5;
            if (s.equals("june") || s.equals("jun.") || s.equals("jun") || s.equals("6")) return 6;
            if (s.equals("july") || s.equals("jul.") || s.equals("jul") || s.equals("7")) return 7;
            if (s.equals("august") || s.equals("aug.") || s.equals("aug") || s.equals("8")) return 8;
            if (s.equals("september") || s.equals("sept.") || s.equals("sep") || s.equals("9")) return 9;
            if (s.equals("october") || s.equals("oct.") || s.equals("oct") || s.equals("10")) return 10;
            if (s.equals("november") || s.equals("nov.") || s.equals("nov") || s.equals("11")) return 11;
            if (s.equals("december") || s.equals("dec.") || s.equals("dec") || s.equals("12")) return 12;

            return -1;
        }
        public static int calculateDays(int month, int year) {
            switch (month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    return 31;
                case 4: case 6: case 9: case 11:
                    return 30;
                case 2:
                    return isLeapYear(year) ? 29 : 28;
                default:
                    return 0;
            }
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int year = -1;
            int month = -1;

            while (true) {
                System.out.print("Nhap nam: ");
                String yearStr = scanner.nextLine();
                try {
                    year = Integer.parseInt(yearStr);
                    if (year >= 0) break;
                    else System.out.println("Nam khong hop le!");
                } catch (Exception e) {
                    System.out.println("Vui long nhap lai!");
                }
            }
            while (true) {
                System.out.print("Nhap thang: ");
                String monthStr = scanner.nextLine();
                month = getMonthNumber(monthStr);

                if (month != -1) break;
                else System.out.println("Thang khong hop le!");
            }
            int days = calculateDays(month, year);
            System.out.println("Thang " + month + " co "+ days + " ngay.");
            scanner.close();
        }
}
