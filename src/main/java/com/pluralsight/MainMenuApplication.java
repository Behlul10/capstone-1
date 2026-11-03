package com.pluralsight;

import java.util.Scanner;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author Behlul
 */
public class MainMenuApplication {
    public static void main(String[] args) {
            Scanner myScanner = new Scanner(System.in);
            String transactionPath = "src/main/resources/transaction.csv";
            String userInput;
            String space = " ";
            while(true){
                System.out.printf("""
             \033[32m
             ========================================
             |                                      |
             |              ATM TERMINAL            |
             |   ================================   |
             |  |                                |  |
             |  |  A) Add Deposit                |  |
             |  |  M) Make Payment (Debit)       |  |
             |  |  L) Ledger                     |  |
             |  |  X) Exit                       |  |
             |  |                                |  |
             |  |                                |  |
             |  |                                |  |
             |  |        Select an option        |  |
             |  |                                |  |
             |  ==================================  |
             ========================================
             Were you listening to me Neo? -->%s""", space);
                userInput = myScanner.nextLine().toLowerCase();
                switch (userInput){
                case "a" -> {
                    addDeposit(myScanner, transactionPath);
                }
                case "m" -> {
                    makePayment(myScanner, transactionPath);
                }
                case "l" -> {
                    ledgerScreen(myScanner, transactionPath);
                }
                case "x" -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid Input, Try again!");
                }
            }
        }
    }

    public static void addDeposit(Scanner methodScanner, String transactionPath) {
        //Getting time of user in correct format
        LocalDateTime userTime = LocalDateTime.now();
        String formattedDate = userTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String formattedTime = userTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        //intilizing
        String description = "deposit";
        double depositAmt = 0;

        //user inpit
        System.out.print("Enter your name: ");
        String userName = methodScanner.nextLine();

        //looping deposit amount input until user inputs a valid deposit amount
        while(true){
            System.out.print("Enter deposit amount: ");
            depositAmt = Double.parseDouble(methodScanner.nextLine());

            if(depositAmt < 1){
                System.out.println("You tried to pull a fast one but we're a bank");
            } else{
                break;
            }
        }

        // add deposit amount parse into csv file
        try(FileWriter writer = new FileWriter(transactionPath, true)){
            writer.write(formattedDate + "|" + formattedTime +"|" + description + "|" + userName + "|" + depositAmt + "\n");
        } catch (IOException e){
            System.out.println("What were you trying to do?");
            throw new RuntimeException(e);
        }
        System.out.println("Transaction Successful!");
    }

    public static void makePayment(Scanner methodScanner, String transactionPath) {
        LocalDateTime userTime = LocalDateTime.now();
        String formattedDate = userTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String formattedTime = userTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));


        System.out.print("enter your card number: ");
        String description = methodScanner.nextLine();

        System.out.print("Who is the vendor your buying from?: ");
        String vendor = methodScanner.nextLine();

        System.out.print("How much?: ");
        double amount = Double.parseDouble(methodScanner.nextLine());
        if(amount > 0){
            amount *= -1;
        }

        try(FileWriter writer = new FileWriter(transactionPath, true)){
                writer.write(formattedDate + "|" + formattedTime +"|" + description  + "|" + vendor + "|" + amount +"\n");
        } catch(IOException e){
            System.out.println("What were you trying to do?");
            throw new RuntimeException(e);
        }
        System.out.println("Transaction Successful!");
    }

    public static void ledgerScreen(Scanner methodScanner, String transactionPath) {
        String userInput;
        Boolean breakPoint = true;
        while(breakPoint){
            //create a ledger class instance with all csv's inputted
            Ledgers myLedger = new Ledgers(transactionPath);
            String space = " ";
            System.out.printf("""
             \033[36m
             ========================================
             |                                      |
             |            Ledger Options            |
             |   ================================   |
             |  |                                |  |
             |  |  A) All entries                |  |
             |  |  D) Deposits                   |  |
             |  |  P) Payments                   |  |
             |  |  R) Reports                    |  |
             |  |  H) Home                       |  |
             |  |                                |  |
             |  |                                |  |
             |  |        Select an option        |  |
             |  |                                |  |
             |  ==================================  |
             ========================================
             [=]You have to choose a pill Keanu! -->%s""", space);

            userInput = methodScanner.nextLine().toLowerCase();
            switch (userInput){
                case "a" ->{
                    System.out.println("\n--- All Entries ---");
                    for (LedgerEntry entry : myLedger.getAllEntries()) {
                        System.out.println(entry); // This calls toString() on each entry
                    }
                    System.out.println("--- End of List ---\n");
                }
                case "d" -> {
                    //deposits
                    System.out.println(myLedger.getDeposits());
                }
                case "p" -> {
                    //payments
                    System.out.println(myLedger.getPayments());
                }
                case "r" -> {
                    //Report menu
                    reportMenuScreen(methodScanner);
                }
                case "h" -> {
                    breakPoint = false;
                }

                default -> {
                    System.out.printf("What are we doing? Please type something I can understand!");
                }
            }
        }
    }

    public static void reportMenuScreen(Scanner methodScanner) {
        String space = " ";
        int usrInput;
        boolean breakPoint = true;
        while(breakPoint){
            System.out.printf("""
             \033[35m
             ========================================
             |                                      |
             |            Search Report             |
             |   ================================   |
             |  |                                |  |
             |  |  1) Month To Date              |  |
             |  |  2) Previous Month             |  |
             |  |  3) Year To Date               |  |
             |  |  4) Previous Year              |  |
             |  |  5) Search by Vendor           |  |
             |  |  0) Go Back                    |  |
             |  |                                |  |
             |  |                                |  |
             |  |        Select an option        |  |
             |  |                                |  |
             |  ==================================  |
             ========================================
             [] The Red Pill Or The Blue Pill? -->%s""", space);
            usrInput = Integer.parseInt(methodScanner.nextLine());

            switch (usrInput){
                case 1 ->{
                    //TODO: month to date
                }
                case 2 -> {
                    //TODO: previous month
                }
                case 3 -> {
                    //TODO: year to date
                }
                case 4 -> {
                    //TODO: prev year
                }
                case 5 -> {
                    //TODO: search by vendor
                }
                case 0 -> {
                    breakPoint = false;
                }
                default -> {
                    System.out.println("What was it that I said Neo?");
                }
            }
        }
    }
}
