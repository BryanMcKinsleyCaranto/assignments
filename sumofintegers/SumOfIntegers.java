package sumofintegers;

import java.util.Scanner;

public class SumOfIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        
        System.out.println("Enter integers (enter a non-integer to finish):");

       
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            sum += number;
        }

       
        System.out.println("Sum of all integer inputs: " + sum);

        scanner.close();
    }
}
