# Matrix Bank
A Matrix themed CLI application where you can add deposits and make payments simulating transactions.

## How to run
1. Open the project folder in IntelliJ
2. run [MainMenuApplication.java](src/main/java/com/pluralsight/MainMenuApplication.java) from the project root because the [transactions.csv](src/main/resources/transactions.csv) path is relative.

## Requirements
- Java 17

## Features
- Make Deposits & Payments
- Ledger (view deposits, payments, and Reports)
- Custom Search

## Repo Layout
```text
capstone-1/
├── pom.xml
├── README.md
└── src/main/
    ├── java/com/pluralsight/
    │   ├── MainMenuApplication.java   # Entry point: menus and user input
    │   ├── Ledger.java                # Loads, sorts and filters transactions
    │   └── LedgerEntry.java           # One transaction (date, time, description, vendor, amount)
    └── resources/
        └── transactions.csv           # Transaction data (pipe-separated)
```
    

## Menus examples
### Main Menu
```text
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
```
### Ledger Menu
```text
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
```
### Reports Menu
```text
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
```
