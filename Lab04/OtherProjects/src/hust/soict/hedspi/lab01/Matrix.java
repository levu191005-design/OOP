package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class Matrix{
    public static int[][] inputMatrix(Scanner sc, int rows, int cols, String name) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // HÀM MAIN: Gọi các hàm trên để thực hiện chương trình
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số hàng: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột: ");
        int cols = scanner.nextInt();
        System.out.println("Nhập ma trận 1: ");
        int[][] matrix1 = inputMatrix(scanner, rows, cols, "Ma trận 1");
        System.out.println("Nhâp ma trận 2: ");
        int[][] matrix2 = inputMatrix(scanner, rows, cols, "Ma trận 2");
        int[][] sumMatrix = addMatrices(matrix1, matrix2, rows, cols);

        System.out.println("\nMa trận 1:");
        displayMatrix(matrix1);

        System.out.println("\nMa trận 2:");
        displayMatrix(matrix2);

        System.out.println("\nTổng 2 ma trận (Matrix 1 + Matrix 2):");
        displayMatrix(sumMatrix);

        scanner.close();
    }
}