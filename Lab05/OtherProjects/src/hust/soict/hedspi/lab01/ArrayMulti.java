package hust.soict.hedspi.lab01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMulti {
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static double calculateAverage(int[] arr) {
        if (arr.length == 0) return 0;
        int sum = calculateSum(arr);
        return (double) sum / arr.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap 1 de nhap mang tu ban phim");
        System.out.println("Nhap 2 de su dung mang hang so");
        int choice = scanner.nextInt();

        int[] my_array1;

        if (choice == 1) {
            System.out.print("Vui long nhap do dai mang ");
            int size = scanner.nextInt();
            my_array1 = new int[size];
            for (int i = 0; i < size; i++) {
                my_array1[i] = scanner.nextInt();
            }
        } else {
            my_array1 = new int[]{1789, 2035, 1899, 1456, 2013};
            System.out.println("Mang hang so: " + Arrays.toString(my_array1));
        }
        System.out.println("Mang ban dau: " + Arrays.toString(my_array1));

        Arrays.sort(my_array1);
        System.out.println("Mang da sap xep:   " + Arrays.toString(my_array1));

        int sum = calculateSum(my_array1);
        double average = calculateAverage(my_array1);

        System.out.println("Tong phan tu trong mang: " + sum);
        System.out.printf("Trung binh: %.2f\n", average);
        scanner.close();
    }
}
