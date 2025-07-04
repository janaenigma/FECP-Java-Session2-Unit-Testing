package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private static final ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);
    public static boolean running = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (running) {
            displayMenu();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    depositMoney();
                    break;
                case 5:
                    withdrawMoney();
                    break;
                case 6:
                    System.out.println("Bye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter a valid number.");
            }
            System.out.println("Would you like to return to the menu? (yes/no)");
            String ans = input.next().toLowerCase();
            if (!ans.equals("yes")) {
                System.out.println("Thank you! Bye!");
                running = false;
            }
        }
        input.close();
    }

    public static void displayMenu(){
        System.out.println();
        System.out.println("=== Bank Menu ===");
        System.out.println("1. Create Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Check Balance");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Exit");
        System.out.print("Enter choice (1-5): ");
    }

    private static void createAccount(){
        System.out.print("Enter account number: ");
        String accNum = input.next();
        System.out.print("Enter account holder name: ");
        String accName = input.next();
        System.out.print("Enter initial deposit amount: ");
        double deposit = input.nextDouble();
        BankAccount bankAccount = new BankAccount(accNum, accName,deposit);
        if (deposit <= 0){
            System.out.println("Invalid deposit amount.");
        }
        else {
            bankAccounts.add(bankAccount);
            bankAccount.createAccount(deposit);
        }
        System.out.println("Account created successfully!");
    }

    private static void viewAllAccounts(){
        System.out.println("=== Bank Accounts ===");
        if (bankAccounts.isEmpty()){
            System.out.println("No accounts to display");
        }
        else {
            for (BankAccount account: bankAccounts){
                System.out.println(account);
            }
        }
    }

    private static void checkBalance(){
        System.out.print("Enter account number: ");
        String num = input.nextLine();

        BankAccount account = findAccount(num);
        if (account != null) {
            System.out.println("Current balance: " + account.getAccountBalance());
        } else {
            System.out.println("Account not found.");
        }

    }

    private static void depositMoney(){
        System.out.print("Enter account number: ");
        String num = input.nextLine();

        BankAccount account = findAccount(num);
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = input.nextDouble();
            account.depositMoney(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney(){
        System.out.print("Enter account number: ");
        String num = input.nextLine();

        BankAccount account = findAccount(num);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = input.nextDouble();
            account.withdrawMoney(amount);
        } else {
            System.out.print("Account not found.");
        }
    }

    private static BankAccount findAccount(String number){
        for (BankAccount account : bankAccounts){
            if (account.getAccountNumber().equals(number)){
                return account;
            }
        }
        return null;
    }

}