package com.pluralsight;
import jdk.jfr.Recording;

import java.util.Scanner;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class MainMenuApplication {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        while(true){
            System.out.println("""
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
         |  |  Select an option: _           |  |
         |  |________________________________|  |
         |                                      |
         |      [1] [2] [3]    CARD: [====]     |
         |      [4] [5] [6]                     |
         |      [7] [8] [9]    CASH: [______]   |
         |      [*] [0] [#]                     |
         |______________________________________|""");
            userInput = myScanner.nextLine().toLowerCase();

            switch (userInput){
                case "a" -> {
                    addDeposit(myScanner);
                }
                case "m" -> {

                }
                case "l" -> {

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
        double depositAmt = 0;
        System.out.print("Enter your name: ");
        String userName = methodScanner.nextLine();

        System.out.print("Enter a short description: ");
        String description = methodScanner.nextLine();
        while(true){

            System.out.print("Enter deposit amount: ");
            depositAmt = Double.parseDouble(methodScanner.nextLine());

            if(depositAmt < 1){
                System.out.println("You tried to pull a fast one but were a bank");
            } else{
                break;
            }
        }
        System.out.println(depositAmt);

        // add deposit amount parse into csv file
        try(FileWriter writer = new FileWriter("src/main/resources/transaction.csv", true)){
            writer.write("1999" + "|" + "time" +"|" + description + "|" + userName + "|" + depositAmt + "\n");


        } catch (IOException e){
            System.out.println("What were you trying to do?");
            throw new RuntimeException(e);
        }
    }
}
