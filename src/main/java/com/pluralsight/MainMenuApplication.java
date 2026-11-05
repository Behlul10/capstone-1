package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author Behlul
 */
public class MainMenuApplication {
    public static void main(String[] args) {
        //region artistic intro sequence
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
        //endregion

        //Initializing
        Scanner myScanner = new Scanner(System.in);
        String transactionPath = "src/main/resources/transaction.csv";
        String userInput;
        String space = " ";

        //Main Menu Loop
        while (true) {
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
                case "a" -> addDeposit(myScanner, transactionPath);
                case "m" -> makePayment(myScanner, transactionPath);
                case "l" -> ledgerScreen(myScanner, transactionPath);
                case "x" -> System.exit(0);
                default -> System.out.println("Invalid Input, Try again!");
            }
        }
    }

    public static void addDeposit(Scanner methodScanner, String transactionPath) {
        //Getting time of user in correct format
        LocalDateTime userTime = LocalDateTime.now();
        String formattedDate = userTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String formattedTime = userTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        //initializing
        String description = "deposit";
        double depositAmt = 0;

        //user input
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
                    //loop deposits and print
                    for (LedgerEntry item : myLedger.getDeposits()){
                        System.out.println(item);
                    }
                }
                case "p" -> {
                    //payments
                    for (LedgerEntry item : myLedger.getPayments()){
                        System.out.println(item);
                    }
                }
                case "r" -> reportMenuScreen(methodScanner, myLedger); //Report menu
                case "h" -> breakPoint = false;
                default -> System.out.printf("What are we doing? Please type something I can understand!");
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
                    ║  │  [6]  Custom Search            │  ║
                    ║  │  [0]  Go Back                  │  ║
                    ║  │                                │  ║
                    ║  ├────────────────────────────────┤  ║
                    ║  │        Select an option        │  ║
                    ║  └────────────────────────────────┘  ║
                    ╚══════════════════════════════════════╝
                    \033[0m[] The Red Pill Or The Blue Pill? -->%s""", space);
            usrInput = Integer.parseInt(methodScanner.nextLine());

            switch (usrInput) {
                case 1 -> searchToDate(myLedger, "Month"); //month to date
                case 2 -> searchPrevious(myLedger, "month"); //previous month
                case 3 -> searchToDate(myLedger, "Year"); //year to date
                case 4 -> searchPrevious(myLedger, "year"); //prev year
                case 5 -> searchVendor(methodScanner, myLedger);
                case 6 -> searchCustom(methodScanner, myLedger);
                case 0 -> breakPoint = false;
                default -> System.out.println("What was it that I said Neo?");
            }
        }
    }

    public static void searchCustom(Scanner methodScanner, Ledgers myLedger) {
        List<LedgerEntry> results = new ArrayList<>();
        System.out.println("Press enter if you want to leave empty.");

        System.out.print("Start date: ");
        String startInput = methodScanner.nextLine();

        System.out.print("End Date: ");
        String endInput = methodScanner.nextLine();

        System.out.print("Description: ");
        String description = methodScanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = methodScanner.nextLine();

        System.out.print("Amount: ");
        String amountInput = methodScanner.nextLine();


        LocalDate startDate = null;
        LocalDate endDate = null;
        Double amount = null;

        //P A R S E    I F    N O T    E M P T Y
        //Start Date
        if (!startInput.isBlank()) {//blank checks whitespaces
            startDate = LocalDate.parse(startInput);
        } //End date
        if (!endInput.isBlank()){
            endDate = LocalDate.parse(endInput);
        } //Amount
        if (!amountInput.isBlank()) {
            amount = Double.parseDouble(amountInput);
        }

        //Looping through each entry && Seeing if it meets the criteria
        for (LedgerEntry entry : myLedger.getAllEntries()){
            boolean matches = true;

            //filter through start-date, end-date, description, vendor, amount
            if (startDate != null && entry.getDate().isBefore(startDate)) { //checks for start date and if entry is too old
                matches = false;
            }
            if (endDate != null && entry.getDate().isAfter(endDate)) { //if user set something and entry is before users input date
                matches = false;
            }
            if (!description.isBlank() && entry.getDescription().contains(description)) {
                matches = false;
            }
            if (!vendor.isBlank() && entry.getVendor().equals(vendor)) {
                matches = false;
            }

            if (amount != null && entry.getAmount() != amount){
                matches = false;
            }

            //FINALLY ADD MATCHES IF IT PASSED ALL THE CRITERIA
            if(matches) {
                results.add(entry);
            }
        }

        System.out.println("========================== Start ==========================");
        //printing final result
        for (LedgerEntry entry : results) {
            System.out.println(entry);
        }
        System.out.println("====================== END OF THE LINE ======================");
    }

    public static void searchToDate(Ledgers myLedger, String userDateOption) {
        LocalDate today = LocalDate.now();
        LocalDate startOfOption;

        //setting start of date
        if (userDateOption.equals("Year")) {
            startOfOption = LocalDate.of(today.getYear(), 1, 1); // Jan 1st of current year
        } else {
            startOfOption = today.withDayOfMonth(1); // Sets day to 1, keeps month/year + becomes an immutable object
        }

        System.out.println("---- " + userDateOption + " to date from " + startOfOption + " to " + today + " ----");

        //for each loop, looping through list of entries in the csv file as item
        for (LedgerEntry item : myLedger.getAllEntries()) {
            //getting date of each item
            LocalDate ledgerDate = item.getDate();

            //if the month value of the month to search and year to search matches the singular entry
            if (!ledgerDate.isBefore(startOfOption) && !ledgerDate.isAfter(today)) {
                System.out.println(item);
            }
        }
    }


    public static void searchPrevious(Ledgers myLedger, String userDateOption) {
        LocalDate userCurrentTime = LocalDate.now();
        LocalDate targetDate;

        if (userDateOption.equalsIgnoreCase("year")) {      //setting target date based on specification
            targetDate = userCurrentTime.minusYears(1);
        } else {
            targetDate = userCurrentTime.minusMonths(1);
        }

        for (LedgerEntry item : myLedger.getAllEntries()) {   //looping through each ledger entry as 'item'
            LocalDate ledgerDate = item.getDate();            //getting date of each item

            if (ledgerDate.equals(targetDate)) { //checking if target date equals to ledger date
                System.out.println(item);
            }
        }
    }

    public static void searchVendor(Scanner methodScanner, Ledgers myLedger) {
        System.out.println("enter the name of the vendor you want to search: ");
        String userInput = methodScanner.nextLine();

        //for each loop, looping through list of entries in the csv file as item
        for (LedgerEntry item : myLedger.getAllEntries()) {
            //if the month value of the month to search and year to search matches the singular entry
            if (item.getVendor().equals(userInput)) {
                System.out.println(item);
            }
        }
    }
}
