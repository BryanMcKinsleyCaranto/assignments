package vowelsandconsonant;

import java.util.Scanner;

public class VowelsAndConsonant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Convert the input string to lowercase
        inputString = inputString.toLowerCase();

        int vowelsCount = 0;
        int consonantsCount = 0;

        // Iterate through each character in the input string
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelsCount++;
            }
            // Check if the character is a consonant (alphabetical character that is not a vowel)
            else if (ch >= 'a' && ch <= 'z') {
                consonantsCount++;
            }
        }

        // Output the count of vowels and consonants
        System.out.println("Number of vowels: " + vowelsCount);
        System.out.println("Number of consonants: " + consonantsCount);

        scanner.close();
    }
}