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
        //region art
        String pcAsciiArt = """
            ::::==========::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            :::::::=========::::::.---------------.:::::::::::::::::::::::::::::::::::::::::::
            :::=============::::::| .-----------. |:::::::::::::::::::::::::::::::::::::::::::
            ::::==========::::::::| | === == == | |:::::::::::::::::::::::::::::::::::::::::::
            ::::==========::::::::| | 260 ED OO | |:::::::::::::::::::::::::::::::::::::::::::
            :::::::=========='::::| |  urgent!  | |:::::::::::::::::::::::::::::::::::::::::::
            :::===========::::::::| |___________| |::::::((;):::::::::::::::::::::::::::::::::
            ""\""============""\"""\"|___________oo__|"")""\"";(""\"""\"""\"""\"""\"""\"""\""
              ==========='           ___)___(___,o  (   .---._
                 ===========        |___________| 8  \\ |TEA|_)    .+-------+.
              ===========                     o8o8    ) |___|    .' |_______| `.
                =============      __________8___    (          /  /         \\  \\
             |\\`==========='/|   .'= --------- --`.   `.       |\\ /           \\ /|
             | "-----------" |  / ooooooooooooo  oo\\   _\\_     | "-------------" |
             |______I_N______| /  oooooooooooo[] ooo\\  |=|     |_______OUT_______|
                              / O O =========  O OO  \\ "-"   .-------,
                              `""\"""\"""\"""\"""\"""\"""\""'      /~~~~~~~/
            _______________________________________________/_   ~~~/_______________
            hjw.......................................... \\/_____/..desk at 17:30..
            """;
        String eyeAsciiArt = """
            .           ..         .           .       .           .           .
                  .         .            .          .       .
                        .         ..xxxxxxxxxx....               .       .             .
                .             MWMWMWWMWMWMWMWMWMWMWMWMW                       .
                          IIIIMWMWMWMWMWMWMWMWMWMWMWMWMWMttii:        .           .
             .      IIYVVXMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWxx...         .           .
                 IWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMx..
               IIWMWMWMWMWMWMWMWMWBY%ZACH%AND%OWENMWMWMWMWMWMWMWMWMWMWMWMWMx..        .
                ""MWMWMWMWMWM""\"""\""".  .:..   .""\"""MWMWMWMWMWMWMWMWMWMWMWMWMWti.
             .     ""   . `  .: . :. : .  . :.  .  . . .  ""\""MWMWMWMWMWMWMWMWMWMWMWMWMti=
                    . .   :` . :   .  .'.' '....xxxxx...,'. '   ' .""\"YWMWMWMWMWMWMWMWMWMW+
                 ; . ` .  . : . .' :  . ..XXXXXXXXXXXXXXXXXXXXx.    `     . "YWMWMWMWMWMWMW
            .    .  .  .    . .   .  ..XXXXXXXXWWWWWWWWWWWWWWWWXXXX.  .     .     ""\"""\""
                    ' :  : . : .  ...XXXXXWWW"   W88N88@888888WWWWWXX.   .   .       . .
               . ' .    . :   ...XXXXXXWWW"    M88N88GGGGGG888^8M "WMBX.          .   ..  :
                     :     ..XXXXXXXXWWW"     M88888WWRWWWMW8oo88M   WWMX.     .    :    .
                       "XXXXXXXXXXXXWW"       WN8888WWWWW  W8@@@8M    BMBRX.         .  : :
              .       XXXXXXXX=MMWW":  .      W8N888WWWWWWWW88888W      XRBRXX.  .       .
                 ....  ""XXXXXMM::::. .        W8@889WWWWWM8@8N8W      . . :RRXx.    .
                     ``...'''  MMM::.:.  .      W888N89999888@8W      . . ::::"RXV    .  :
             .       ..'''''      MMMm::.  .      WW888N88888WW     .  . mmMMMMMRXx
                  ..' .            ""MMmm .  .       WWWWWWW   . :. :,miMM""\"  : ""`    .
               .                .       ""MMMMmm . .  .  .   ._,mMMMM""\"  :  ' .  :
                           .                  ""MMMMMMMMMMMMM""\" .  : . '   .        .
                      .              .     .    .                      .         .
            .                                         .          .         .

            """;

        //endregion

        try {

            Thread.sleep(500);
            System.out.print("N");
            Thread.sleep(500);
            System.out.print("e");
            Thread.sleep(500);
            System.out.println("o");
            Thread.sleep(500);
            System.out.println(pcAsciiArt);
            Thread.sleep(500);
            System.out.println(eyeAsciiArt);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }




        Scanner myScanner = new Scanner(System.in);
    String transactionPath = "src/main/resources/transaction.csv";
    String userInput;
    String space = " ";
        while(true) {
        System.out.printf("""
                \033[32m
                ╔══════════════════════════════════════╗
                ║                                      ║
                ║      █████╗ ████████╗███╗   ███╗     ║
                ║     ██╔══██╗╚══██╔══╝████╗ ████║     ║
                ║     ███████║   ██║   ██╔████╔██║     ║
                ║     ██╔══██║   ██║   ██║╚██╔╝██║     ║
                ║     ██║  ██║   ██║   ██║ ╚═╝ ██║     ║
                ║     ╚═╝  ╚═╝   ╚═╝   ╚═╝     ╚═╝     ║
                ║                                      ║
                ║          BANK OF Matrix              ║
                ║  ┌────────────────────────────────┐  ║
                ║  │                                │  ║
                ║  │  [A]  Add Deposit              │  ║
                ║  │  [M]  Make Payment (Debit)     │  ║
                ║  │  [L]  Ledger                   │  ║
                ║  │  [X]  Exit                     │  ║
                ║  │                                │  ║
                ║  ├────────────────────────────────┤  ║
                ║  │        Select an option        │  ║
                ║  └────────────────────────────────┘  ║
                ╚══════════════════════════════════════╝
                \033[0mWere you listening to me Neo? -->%s""", space);
        userInput = myScanner.nextLine().toLowerCase();
        switch (userInput) {
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
    while (true) {
        System.out.print("Enter deposit amount: ");
        depositAmt = Double.parseDouble(methodScanner.nextLine());

        if (depositAmt < 1) {
            System.out.println("You tried to pull a fast one but we're a bank");
        } else {
            break;
        }
    }

    // add deposit amount parse into csv file
    try (FileWriter writer = new FileWriter(transactionPath, true)) {
        writer.write(formattedDate + "|" + formattedTime + "|" + description + "|" + userName + "|" + depositAmt + "\n");
    } catch (IOException e) {
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
    if (amount > 0) {
        amount *= -1;
    }

    try (FileWriter writer = new FileWriter(transactionPath, true)) {
        writer.write(formattedDate + "|" + formattedTime + "|" + description + "|" + vendor + "|" + amount + "\n");
    } catch (IOException e) {
        System.out.println("What were you trying to do?");
        throw new RuntimeException(e);
    }
    System.out.println("Transaction Successful!");
}

public static void ledgerScreen(Scanner methodScanner, String transactionPath) {
    String userInput;
    Boolean breakPoint = true;
    while (breakPoint) {
        //create a ledger class instance with all csv's inputted
        Ledgers myLedger = new Ledgers(transactionPath);
        String space = " ";
        System.out.printf("""
                \033[36m
                ╔══════════════════════════════════════╗
                ║                                      ║
                ║             L E D G E R              ║
                ║    ┌─────────────┬─────────────┐     ║
                ║    │ + $  xxx.xx │ - $   xx.xx │     ║
                ║    │ + $  xxx.xx │ - $   xx.xx │     ║
                ║    │ + $   xx.xx │ - $   xx.xx │     ║
                ║    └─────────────┴─────────────┘     ║
                ║                                      ║
                ║  ┌────────────────────────────────┐  ║
                ║  │                                │  ║
                ║  │  [A]  All Entries              │  ║
                ║  │  [D]  Deposits                 │  ║
                ║  │  [P]  Payments                 │  ║
                ║  │  [R]  Reports                  │  ║
                ║  │  [H]  Home                     │  ║
                ║  │                                │  ║
                ║  ├────────────────────────────────┤  ║
                ║  │        Select an option        │  ║
                ║  └────────────────────────────────┘  ║
                ╚══════════════════════════════════════╝
                \033[0m[=] You have to choose a pill Keanu! -->%s""", space);

        userInput = methodScanner.nextLine().toLowerCase();
        switch (userInput) {
            case "a" -> {
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
                reportMenuScreen(methodScanner, myLedger);
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

public static void reportMenuScreen(Scanner methodScanner, Ledgers myLedger) {
    String space = " ";
    int usrInput;
    boolean breakPoint = true;
    while (breakPoint) {
        System.out.printf("""
                \033[35m
                ╔══════════════════════════════════════╗
                ║                                      ║
                ║            R E P O R T S             ║
                ║                                      ║
                ║     $ │            ▄▄                ║
                ║       │       ▄▄   ██   ▄▄           ║
                ║       │  ▄▄   ██   ██   ██           ║
                ║       │  ██   ██   ██   ██           ║
                ║       └─────────────────────         ║
                ║          Q1   Q2   Q3   Q4           ║
                ║                                      ║
                ║  ┌────────────────────────────────┐  ║
                ║  │                                │  ║
                ║  │  [1]  Month To Date            │  ║
                ║  │  [2]  Previous Month           │  ║
                ║  │  [3]  Year To Date             │  ║
                ║  │  [4]  Previous Year            │  ║
                ║  │  [5]  Search by Vendor         │  ║
                ║  │  [0]  Go Back                  │  ║
                ║  │                                │  ║
                ║  ├────────────────────────────────┤  ║
                ║  │        Select an option        │  ║
                ║  └────────────────────────────────┘  ║
                ╚══════════════════════════════════════╝
                \033[0m[] The Red Pill Or The Blue Pill? -->%s""", space);
        usrInput = Integer.parseInt(methodScanner.nextLine());

        switch (usrInput) {
            case 1 -> searchMontToDate(methodScanner, myLedger); //month to date
            case 2 -> searchPreviousMonth(myLedger); //previous month
            case 3 -> {
                //TODO: year to date
                searchYeartoDate(methodScanner, myLedger);
            }
            case 4 -> {
                //TODO: prev year
                searchPreviousYear(myLedger);
            }
            case 5 -> {
                //TODO: search by vendor
                searchVendor(methodScanner, myLedger);
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
    public static void searchMontToDate(Scanner methodScanner, Ledgers myLedger) {
        System.out.println("enter a date you want to search in the following format MM/dd/yyyy: ");
        String userInput = methodScanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //returns format in specified format
        LocalDate searchDate = LocalDate.parse(userInput, formatter); //parsing user input into LocalDate type

        //for each loop, looping through list of entries in the csv file as item
        for (LedgerEntry item: myLedger.getAllEntries()){
            //getting date of each item
            LocalDate ledgerDate = item.getDate();

            //if the month value of the month to search and year to search matches the singular entry
            if (ledgerDate.getMonthValue() == searchDate.getMonthValue() && ledgerDate.getYear() == searchDate.getYear()){
                System.out.println(item);
            }
        }
    }

    public static void searchPreviousMonth(Ledgers myLedger) {
        LocalDateTime userTime = LocalDateTime.now();

        //for each loop, looping through list of entries in the csv file as item
        for (LedgerEntry item: myLedger.getAllEntries()){
            //getting date of each item
            LocalDate ledgerDate = item.getDate();

            //if the month value of the month to search and year to user time matches the singular entry
            if (ledgerDate.getMonthValue() == userTime.getMonthValue() && ledgerDate.getYear() == userTime.getYear()){
                System.out.println(item);
            }
        }
    }

    public static void searchYeartoDate(Scanner methodScanner, Ledgers myLedger) {

    }

    public static void searchPreviousYear(Ledgers myLedger) {

    }

    public static void searchVendor(Scanner methodScanner, Ledgers myLedger) {

    }

}
