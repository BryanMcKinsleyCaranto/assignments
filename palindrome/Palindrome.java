package palindrome;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        
        inputString = inputString.replaceAll("\\s", "").toLowerCase();

        
        boolean isPalindrome = true;
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputString.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        
        if (isPalindrome) {
            System.out.println("Yes, '" + inputString + "' is a palindrome.");
        } else {
            System.out.println("No, '" + inputString + "' is not a palindrome.");
        }

        scanner.close();
    }
}

