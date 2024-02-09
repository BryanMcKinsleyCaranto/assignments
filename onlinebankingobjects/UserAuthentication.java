package onlinebankingobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserAuthentication {
    private List<User> users;

    public UserAuthentication() {
        users = new ArrayList<>();
    }

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter number: ");
        String number = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Validate fields
        if (name.isEmpty() || email.isEmpty() || number.isEmpty() || pin.isEmpty()) {
            System.out.println("Please provide all required information.");
            return;
        }

        // Check if user with the same email already exists
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("User with this email already exists.");
                return;
            }
        }

        // Generate unique ID for the user
        int id = users.size() + 1;

        // Create new user and add to the list
        User newUser = new User(id, name, email, number, pin);
        users.add(newUser);

        System.out.println("User registered successfully. ID: " + id);
    }

    public int loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Find user with matching email and pin
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPin().equals(pin)) {
                System.out.println("User logged in successfully.");
                return user.getId();
            }
        }

        System.out.println("Invalid email or PIN. Please try again.");
        return -1;
    }

    public void changePin(int userId) {
        Scanner scanner = new Scanner(System.in);

        // Find user with matching ID
        for (User user : users) {
            if (user.getId() == userId) {
                System.out.print("Enter new PIN: ");
                String newPin = scanner.nextLine();

                // Update user's PIN
                user.setPin(newPin);
                System.out.println("PIN changed successfully.");
                return;
            }
        }

        System.out.println("User not found.");
    }

    public void logout() {
        System.out.println("User logged out successfully.");
    }

    public static void main(String[] args) {
        UserAuthentication authentication = new UserAuthentication();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to GcashApp!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Register a new user");
            System.out.println("2. Login");
            System.out.println("3. Change PIN");
            System.out.println("4. Logout");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    authentication.registerUser();
                    break;
                case 2:
                    int userId = authentication.loginUser();
                    if (userId != -1) {
                        // Perform online banking transactions
                        System.out.println("Performing online banking transactions for user ID: " + userId);
                    }
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    int changePinId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    authentication.changePin(changePinId);
                    break;
                case 4:
                    authentication.logout();
                    break;
                case 0:
                    System.out.println("Exiting GcashApp. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class User {
    private int id;
    private String name;
    private String email;
    private String number;
    private String pin;

    public User(int id, String name, String email, String number, String pin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}