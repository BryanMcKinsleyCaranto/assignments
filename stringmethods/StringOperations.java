package stringmethods;

import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

      
        int length = userInput.length();
        System.out.println("Length of the string: " + length);

        String uppercase = userInput.toUpperCase();
        System.out.println("Uppercase string: " + uppercase);

      
        String lowercase = userInput.toLowerCase();
        System.out.println("Lowercase string: " + lowercase);

       
        char firstCharacter = userInput.charAt(0);
        System.out.println("First character: " + firstCharacter);

      
        char lastCharacter = userInput.charAt(length - 1);
        System.out.println("Last character: " + lastCharacter);

      
        String substring = userInput.substring(1, 5);
        System.out.println("Substring: " + substring);

      
        scanner.close();
    }
}

