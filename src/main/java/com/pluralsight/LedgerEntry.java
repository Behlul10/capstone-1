package com.pluralsight;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LedgerEntry implements Comparable<LedgerEntry> {
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

    /*
     * We've covered overloading before for constructors one with params and one without.
     * I'm doing something similar but not the same.
     * the difference is overriding changes the original method so there are no 2 versions of it like in overloading
     * (this method already existed in java, I am overriding something that exists)
     */
    @Override
    public String toString() {
        return String.format("%s %s | %s | %s | %.2f", date, time, description, vendor, amount);
    }

    /**
     * @param otherLedgerEntry the object to be compared.
     * @return 0, 1, or -1
     * 0: objects are equal, no preference
     * 1: this entry comes after the other one
     * -1: this entry comes before the other one
     */
    @Override
    public int compareTo(LedgerEntry otherLedgerEntry){
        LocalDate date = this.getDate();
        LocalDate otherDate = otherLedgerEntry.getDate();
        String time = this.getTime();
        String otherTime = otherLedgerEntry.getTime();

        //if == to each other return 0
        if(date.equals(otherDate)) {
            return time.compareTo(otherTime); //I am not recursively calling compareTo() on itself, this is Strings own compareTo() method
        }
        return date.compareTo(otherDate);

        //region the old way
        /*
        if (date.isBefore(otherDate)) { return -1; //if date is before otherdate return -1 }
        if (date.isAfter(otherDate)){ return 1; //if date is after otherdate return 1 }
        */ //endregion
    }
}
