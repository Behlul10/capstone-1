package com.pluralsight;
import java.util.Scanner;

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
}
