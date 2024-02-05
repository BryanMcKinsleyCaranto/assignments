package stringbuilderoperations;

import java.util.Scanner;

public class StringBuilderOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a string of at least 10 characters: ");
        String inputString = scanner.nextLine();

        
        if (inputString.length() < 10) {
            System.out.println("Error: The string must have at least 10 characters.");
            return;
        }

        
        StringBuilder stringBuilder = new StringBuilder(inputString);

        
        System.out.println("Length of the string: " + stringBuilder.length());
        System.out.println("First character of the string: " + stringBuilder.charAt(0));
        System.out.println("Last character of the string: " + stringBuilder.charAt(stringBuilder.length() - 1));
        System.out.println("Index of first occurrence of 'a': " + stringBuilder.indexOf("a"));
        System.out.println("Substring from index 3 to index 6: " + stringBuilder.substring(3, 7));

        stringBuilder.append("123"); 
        stringBuilder.insert(4, "xyz"); 
        stringBuilder.delete(2, 5); 
        stringBuilder.deleteCharAt(8); 
        stringBuilder.reverse(); 

        
        System.out.println("Modified string: " + stringBuilder.toString());

        scanner.close();
    }
}

