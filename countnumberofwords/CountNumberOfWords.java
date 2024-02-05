package countnumberofwords;

import java.util.Scanner;

public class CountNumberOfWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Split the input string into words using whitespace as delimiter
        String[] words = inputString.split("\\s+");

        // Count the number of words
        int wordCount = words.length;

        // Output the result
        System.out.println("Number of words in the input: " + wordCount);

        scanner.close();
    }
}

