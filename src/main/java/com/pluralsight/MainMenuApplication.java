package com.pluralsight;

import jdk.jfr.Recording;

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
        String userInput;
        String space = " ";
        while(true){
            System.out.printf("""
          ______________________________________
         |                                      |
         |              ATM TERMINAL            |
         |   ________________________________   |
         |  |                                |  |
         |  |  A) Add Deposit                |  |
         |  |  M) Make Payment (Debit)       |  |
         |  |  L) Ledger                     |  |
         |  |  X) Exit                       |  |
         |  |                                |  |
               Select an option:%s""", space);
            userInput = myScanner.nextLine().toLowerCase();
            switch (userInput){
                case "a" -> {
                    addDeposit(myScanner);
                }
                case "m" -> {
                    makePayment(myScanner);
                }
                case "l" -> {
                    ledgerScreen(myScanner);

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

        public static void addDeposit(Scanner methodScanner) {
            LocalDateTime userTime = LocalDateTime.now();
            String formattedDate = userTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String formattedTime = userTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));


            double depositAmt = 0;
            System.out.print("Enter your name: ");
            String userName = methodScanner.nextLine();

            System.out.print("Enter a short description: ");
            String description = methodScanner.nextLine();
            while(true){

                System.out.print("Enter deposit amount: ");
                depositAmt = Double.parseDouble(methodScanner.nextLine());

                if(depositAmt < 1){
                    System.out.println("You tried to pull a fast one but we're a bank");
                } else{
                    break;
                }
            }
            System.out.println(depositAmt);

            // add deposit amount parse into csv file
            try(FileWriter writer = new FileWriter("src/main/resources/transaction.csv", true)){
                writer.write(formattedDate + "|" + formattedTime +"|" + description + "|" + userName + "|" + depositAmt + "\n");
            } catch (IOException e){
                System.out.println("What were you trying to do?");
                throw new RuntimeException(e);
            }
        }

        public static void makePayment(Scanner methodScanner) {
            LocalDateTime userTime = LocalDateTime.now();
            String formattedDate = userTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String formattedTime = userTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));


            System.out.print("enter your card number: ");
            long cardNum = Long.parseLong(methodScanner.nextLine());

            System.out.print("What are you buying?: ");
            String description = methodScanner.nextLine();

            System.out.print("Who is the vendor your buying from?: ");
            String vendor = methodScanner.nextLine();

            System.out.print("How much?: ");
            double amount = Double.parseDouble(methodScanner.nextLine());
            if(amount > 0){
                amount *= -1;
            }

            try(FileWriter writer = new FileWriter("src/main/resources/payments.csv", true)){
                writer.write(formattedDate + "|" + formattedTime +"|" + cardNum + "|" + description + "|" + "|" + vendor + "|" + amount +"\n");
            } catch(IOException e){
                System.out.println("What were you trying to do?");
                throw new RuntimeException(e);
            }
            System.out.println("Transaction Successful!");
        }

    public static void ledgerScreen(Scanner methodScanner) {
        String userInput;
        Boolean breakPoint = true;
        while(breakPoint){
            System.out.println("""
                A -  All entries
                D - Deposits
                P - Payments
                R - Reports
                H) Home
                """);
            userInput = methodScanner.nextLine().toLowerCase();
            switch (userInput){
                case "a" ->{
                    //print
                }
                case "d" -> {
                    //deposit
                }
                case "p" -> {
                    //
                }
                case "r" -> {

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
}
