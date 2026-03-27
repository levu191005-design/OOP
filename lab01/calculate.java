import java.util.Scanner;

public class calculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        String strNum1 = sc.nextLine();

        System.out.print("Enter second number: ");
        String strNum2 = sc.nextLine();

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + difference);
        System.out.println("Product = " + product);

        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Quotient = " + quotient);
        } else {
            System.out.println("Cannot divide by zero!");
        }

        sc.close();
    }
}