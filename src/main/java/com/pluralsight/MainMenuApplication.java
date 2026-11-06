package com.pluralsight;

import java.time.format.DateTimeParseException;
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
        asciiArtPrint("starter-sequence");

        //Initializing
        Scanner myScanner = new Scanner(System.in);
        String transactionPath = "src/main/resources/transactions.csv";
        String userInput;

        //Main Menu Loop
        while (true) {
            asciiArtPrint("home-menu");
            userInput = myScanner.nextLine().toLowerCase();
            switch (userInput) {
                case "d" -> addDeposit(myScanner, transactionPath);
                case "p" -> makePayment(myScanner, transactionPath);
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
        double depositAmt;

        //user input
        System.out.print("Enter your name: ");
        String userName = methodScanner.nextLine();

        System.out.print("Description: ");
        String description = methodScanner.nextLine();
        //looping deposit amount input until user inputs a valid deposit amount
        while (true) {
            depositAmt = readDoubleAmount(methodScanner, "Deposit Amount: ");

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

        System.out.print("enter your description: ");
        String description = methodScanner.nextLine();

        System.out.print("Who is the vendor your buying from?: ");
        String vendor = methodScanner.nextLine();

        double amount = readDoubleAmount(methodScanner, "Enter an amount you would like to pay: $");

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
        boolean breakPoint = true;
        while (breakPoint) {
            asciiArtPrint("ledger-screen");

            //create a ledger class instance with all csv's inputted
            Ledger myLedger = new Ledger(transactionPath);

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
                    for (LedgerEntry item : myLedger.getDeposits()) {
                        System.out.println(item);
                    }
                }
                case "p" -> {
                    //payments
                    for (LedgerEntry item : myLedger.getPayments()) {
                        System.out.println(item);
                    }
                }
                case "r" -> reportMenuScreen(methodScanner, myLedger); //Report menu
                case "h" -> breakPoint = false;
                default -> System.out.println("What are we doing? Please type something I can understand!");
            }
        }
    }

    public static void reportMenuScreen(Scanner methodScanner, Ledger myLedger) {
        String usrInput;
        boolean breakPoint = true;
        while (breakPoint) {
            asciiArtPrint("report-screen");
            usrInput = methodScanner.nextLine();
            switch (usrInput) {
                case "1" -> searchToDate(myLedger, "Month"); //month to date
                case "2" -> searchPrevious(myLedger, "month"); //previous month
                case "3" -> searchToDate(myLedger, "Year"); //year to date
                case "4" -> searchPrevious(myLedger, "year"); //prev year
                case "5" -> searchVendor(methodScanner, myLedger);
                case "6" -> searchCustom(methodScanner, myLedger);
                case "0" -> breakPoint = false;
                default -> System.out.println("What was it that I said Neo?");
            }
        }
    }

    public static void searchCustom(Scanner methodScanner, Ledger myLedger) {
        List<LedgerEntry> results = new ArrayList<>();
        System.out.println("Press enter if you want to leave empty.");

        System.out.print("Start date (yyyy-MM-dd): ");
        String startInput = methodScanner.nextLine();

        System.out.print("End Date (yyyy-MM-dd): ");
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
        try{
            //Start Date
            if (!startInput.isBlank()) {//blank checks whitespaces
                startDate = LocalDate.parse(startInput);
            } //End date
            if (!endInput.isBlank()) {
                endDate = LocalDate.parse(endInput);
            } //Amount
            if (!amountInput.isBlank()) {
                amount = Double.parseDouble(amountInput);
            }
        } catch (DateTimeParseException d) {
            System.out.println("Wrong input, enter a valid date in (yyyy-MM-dd) format");
            return; //goes back to the report menu
        } catch (NumberFormatException e) {
            System.out.println("Invalid: Enter a valid amount");
            return; //goes back to the report menu
        }

        //Looping through each entry && Seeing if it meets the criteria
        for (LedgerEntry entry : myLedger.getAllEntries()) {
            boolean[] matches = new boolean[5];

            //filter through start-date, end-date, description, vendor, amount
            if (startDate == null || !entry.getDate().isBefore(startDate)) { //match if no start date, or entry is on/after start date
                matches[0] = true;
            }
            if (endDate == null || !entry.getDate().isAfter(endDate)) { //if user set something and entry is before users input date
                matches[1] = true;
            }
            if (description.isBlank() || entry.getDescription().toLowerCase().contains(description.toLowerCase())) {
                matches[2] = true;
            }
            if (vendor.isBlank() || entry.getVendor().equalsIgnoreCase(vendor)) {
                matches[3] = true;
            }

            if (amount == null || entry.getAmount() == amount) {
                matches[4] = true;
            }

            //FINALLY ADD MATCHES IF IT PASSED ALL THE CRITERIA
            if (matches[0] && matches[1] && matches[2] && matches[3] && matches[4]) {
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

    public static void searchToDate(Ledger myLedger, String userDateOption) {
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

    public static void searchPrevious(Ledger myLedger, String userDateOption) {
        LocalDate userCurrentTime = LocalDate.now();
        LocalDate targetDate;
        boolean pickedYear = false;

        if (userDateOption.equalsIgnoreCase("year")) {  //if user option is search previous year we -1 year of current user time
            targetDate = userCurrentTime.minusYears(1);
            pickedYear = true;
        } else {
            targetDate = userCurrentTime.minusMonths(1);
        }

        for (LedgerEntry item : myLedger.getAllEntries()) {   //looping through each ledger entry as 'item'
            LocalDate ledgerDate = item.getDate();            //getting date of each item

            if(pickedYear) {
                if(ledgerDate.getYear() == targetDate.getYear()) {
                    System.out.println(item);
                }
            } else if (ledgerDate.getMonth() == targetDate.getMonth()  && ledgerDate.getYear() == targetDate.getYear()) {
                System.out.println(item);
            }
        }
    }

    public static void searchVendor(Scanner methodScanner, Ledger myLedger) {
        System.out.println("enter the name of the vendor you want to search: ");
        String userInput = methodScanner.nextLine();

        //for each loop, looping through list of entries in the csv file as item
        for (LedgerEntry item : myLedger.getAllEntries()) {
            //if the month value of the month to search and year to search matches the singular entry
            if (item.getVendor().equalsIgnoreCase(userInput)) {
                System.out.println(item);
            }
        }
    }

    public static double readDoubleAmount(Scanner methodScanner, String message) {
        double amount;

        while (true){
            try{
                System.out.print(message);
                amount = Double.parseDouble(methodScanner.nextLine());
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid input");
            }
        }
    }

    public static void asciiArtPrint(String option) {
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
        String skeletonAscii = """
                
                
                                                       @= + @    :                                                 \s
                                                    -       #  @           .                                       \s
                                                .     :  :%         -. *                                           \s
                                                          :   =.     %                                             \s
                                                     ==*= % *.  @ .      =.@                                       \s
                                                    @.  *  #  +@@#*@ =-@% * @                                      \s
                                              :     %#:@ @+  # @=  @  :   .       +-                               \s
                                                  @  @@@ --@# @    +  * :  .         -*                            \s
                                                  :  +  @@=:*-.:%@+   .:         -.                                \s
                                             *+ .     =%%++=# %% +@@ @@@@-*:  =*                                   \s
                                            :   - =@@ @*+=+-*++**# =@   +*@@@ @+@ ..       -                       \s
                                                  -@%*#==========++-   **  #@- @+ @=     .                         \s
                                           -     @-%++============+*@@@@##*#  %@                                   \s
                                                . # -*+===========+-+. +=+*=  @@=@.                                \s
                                          ::      @%* #===========+ +++++=*@:#          -                          \s
                                           @    .:+.@ @===========***+++#-@:@ @@@                                  \s
                                         @   @%+ %=+@ @+:======-+*= :.:* - :    @@.                                \s
                                          @   @@ ** % #-+==+++==*= @*** .% +   @@#@    - -                         \s
                                          @  @+%#.=#:*+===+* +==+. *=- **@@  @    =  : -.                          \s
                                              @@@*@@#*+++=+:++==+##**#=*%@ @=@@@    *                              \s
                                          @   =     .+*%@%##*+-=+=*# #+.     .  .#@  *@ - -                        \s
                                               +@@@@ =      -%@%%+*-  -%@@#*:# ..=          .                      \s
                                          @. .=% @ .##%@@@%#*   * %*%# * @ .@  -      --# -.                       \s
                                         :*@#@@@=@@#-++*+##*%@@@ @%*#%%@%@       #                                 \s
                                                   *@@-@-+ . %+@ %+ --  %#      :@   %-    @==                     \s
                                          :      @@.  +@% @%@ #@ @@@@ @ -@*  .-     :. #                           \s
                                          =      .@@ *     ::  @#@    =                                            \s
                                        @           @%                                                             \s
                                       *=   @                 . @ @@            @                                  \s
                                           @@                  @# :@                      .@@@                     \s
                                         : @@                @@@ #@@@@: :                  @%@                     \s
                                             @+    :       @   - @@@                        -                      \s
                                        .  @:#@@@:     @@@@ +:@                         .@                         \s
                                                 -@@@*@ .                       . =- .                             \s
                                                           =#                                                      \s
                                                          *                                                        \s
                                                     .:-    :                                                      \s
                                                         #@ +      #      :                                        \s
                                                      .   @ -      %     :#                                        \s
                                                       :  =%@@    :+     @                                         \s
                                                   @     @ % @@@ +@*# : @#                                         \s
                                                   @@@@  @@ **+*%#%@. + @                                          \s
                                                    @:@@  #@%@%*@*-@@                                              \s
                                                   :@=  @     ++ :@%                                               \s
                                                       @==@@ .              @-                                     \s
                                                     . #@: @@@@@@@  @@@.@@-@@*                                     \s
                                                     -   @@ #*@@%@@@@@  @*                                         \s
                                                          @@.   @@ @@%  +                                          \s
                 @@@+                               :%      %@@                                                    \s
                 **%@:                        = %@ .# *     %@ @@=@=@                                              \s
                .@@@@=                         %:@:: :  .         # #                                              \s
                          @                   -@= @          .                                                     \s
                      - .   +:@ . -%:    + @@ -+               .                                                   \s
                  @@ @-=*=@   + :       @ + @ .         :@@@  =@                                                   \s
                   :                                         .                                                     \s
                """;
        String space = " ";
        String starterMenuScreen = """
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
                    ║  │  [D]  Add Deposit              │  ║
                    ║  │  [P]  Make Payment (Debit)     │  ║
                    ║  │  [L]  Ledger                   │  ║
                    ║  │  [X]  Exit                     │  ║
                    ║  │                                │  ║
                    ║  ├────────────────────────────────┤  ║
                    ║  │        Select an option        │  ║
                    ║  └────────────────────────────────┘  ║
                    ╚══════════════════════════════════════╝
                    \033[0mWere you listening to me Neo? -->%s""";

        String ledgerScreen = """
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
                    \033[0m[=] You have to choose a pill Keanu! -->%s""";

        String reportScreen = """
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
                    \033[0m[] The Red Pill Or The Blue Pill? -->%s""";


        //endregion
        switch (option) {
            case "starter-sequence" -> {
                //start up sequence
                try {
                    Thread.sleep(500);
                    System.out.print("N");
                    Thread.sleep(500);
                    System.out.print("e");
                    Thread.sleep(500);
                    System.out.println("o");
                    Thread.sleep(1500);
                    System.out.println(skeletonAscii);
                    Thread.sleep(1500);
                    System.out.print("I once got so mad I cought the tiger by his toe and when he hollered");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(500);
                    System.out.print(".");
                    Thread.sleep(500);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(" I didn't let go");
                    Thread.sleep(4000);
                    System.out.println(pcAsciiArt);
                    Thread.sleep(2500);
                    System.out.println(eyeAsciiArt);
                } catch (
                        InterruptedException e) {
                    System.out.println("Thread.sleep had an Issue!");
                    e.printStackTrace();
                }
            }
            case "home-menu" -> System.out.printf(starterMenuScreen, space); // Starter Menu Screen

            case "ledger-screen" -> System.out.printf(ledgerScreen, space);

            case "report-screen" -> System.out.printf(reportScreen, space);

            default -> {
                System.out.print("wrong input from the system, the code is broken");
                System.exit(1);
            }
        }
    }
}