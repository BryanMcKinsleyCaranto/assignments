package sumandaverage;

import java.util.Scanner;

public class ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

       
        int[] numbers = new int[size];

        
        System.out.println("Enter the numbers of the array:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        
        double average = (double) sum / size;

       
        System.out.println("Sum of numbers in the array: " + sum);
        System.out.println("Average of numbers in the array: " + average);

        scanner.close();
    }
}

