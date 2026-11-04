package com.pluralsight;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LedgerEntry {
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //returns format in specified format

    public LedgerEntry(String date, String time, String description, String vendor, double amount){
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //returns date in a loccaldate format instead of string
    public LocalDate getDate() { return LocalDate.parse(date, formatter); }

    public String getTime() { return time; }

    public String getDescription() { return description; }

    public String getVendor() { return vendor; }

    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return String.format("%s %s | %s | %s | %.2f", date, time, description, vendor, amount);
    }
}
