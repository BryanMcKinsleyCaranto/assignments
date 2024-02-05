package integerloop;
import java.util.Scanner;
public class IntegerLoop {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        // Generate the pattern using a for loop
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println(); // Move to the next line after each row
        }

        scanner.close();
}
}