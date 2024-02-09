package onlinebankingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GcashApp {
    private static final int MAX_USERS = 10;
    private static User[] users = new User[MAX_USERS];
    private static User currentUser;

    public static void main(String[] args) {
        initializeUsers();

        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            isLoggedIn = login(email, password);

            if (!isLoggedIn) {
                System.out.println("Invalid email or password. Please try again.");
            }
        }

        System.out.println("Welcome, " + currentUser.getEmail() + "!");

        int choice;
        do {
            try {
                System.out.println("Choose an option:");
                System.out.println("1. Check Balance");
                System.out.println("2. Cash In");
                System.out.println("3. Cash Transfer");
                System.out.println("4. Transactions");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        cashIn(scanner);
                        break;
                    case 3:
                        cashTransfer(scanner);
                        break;
                    case 4:
                        displayTransactions();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please try again.");
                scanner.nextLine(); // consume newline
                choice = 0;
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void initializeUsers() {
        // Dummy user data initialization
        users[0] = new User("user1@example.com", "password1", 100);
        users[1] = new User("user2@example.com", "password2", 200);
    }

    private static boolean login(String email, String password) {
        for (User user : users) {
            if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    private static void checkBalance() {
        System.out.println("Your balance is: $" + currentUser.getBalance());
    }

    private static void cashIn(Scanner scanner) {
        try {
            System.out.print("Enter amount to deposit: $");
            double amount = scanner.nextDouble();
            currentUser.deposit(amount);
            System.out.println("Deposit successful.");
            currentUser.addTransaction("Deposit: +$" + amount);
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid amount.");
            scanner.nextLine(); // consume newline
        }
    }

    private static void cashTransfer(Scanner scanner) {
        try {
            System.out.print("Enter recipient's email: ");
            String recipientEmail = scanner.nextLine();
            System.out.print("Enter amount to transfer: $");
            double amount = scanner.nextDouble();

            User recipient = findUserByEmail(recipientEmail);
            if (recipient != null && currentUser.getBalance() >= amount) {
                currentUser.withdraw(amount);
                recipient.deposit(amount);
                System.out.println("Transfer successful.");
                currentUser.addTransaction("Transfer to " + recipient.getEmail() + ": -$" + amount);
                recipient.addTransaction("Transfer from " + currentUser.getEmail() + ": +$" + amount);
            } else {
                System.out.println("Transfer failed. Invalid recipient or insufficient balance.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
            scanner.nextLine(); // consume newline
        }
    }

    private static void displayTransactions() {
        System.out.println("Transaction History:");
        for (String transaction : currentUser.getTransactions()) {
            System.out.println(transaction);
        }
    }

    private static User findUserByEmail(String email) {
        for (User user : users) {
            if (user != null && user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}

class User {
    private String email;
    private String password;
    private double balance;
    private List<String> transactions;

    public User(String email, String password, double balance) {
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }
}
