package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Ledger {
    private List<LedgerEntry> entries;
    String filePath;

    public Ledger(String filePath){
        this.filePath = filePath;
        this.entries = new ArrayList<>();
        loadEntries();
    }
    private void loadEntries(){
        //reading csv file
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            //loading csv line to line var + checking if line is not empty
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }
                //parsing each part with pipes
                String[] parts = line.split("\\|");
                //making sure we have each field before loading it into variables
                if (parts.length == 5) {
                    String date = parts[0];
                    String time = parts[1];
                    String description = parts[2];
                    String vendor = parts[3];
                    double amount = Double.parseDouble(parts[4]);

                    //making each a LedgerEntry object and adding it to an array
                    LedgerEntry entry = new LedgerEntry(date, time, description, vendor, amount);
                    entries.add(entry);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading ledger file: " + e.getMessage());
        }
    }

    //get all entries method
    public List<LedgerEntry> getAllEntries(){ return entries; }

    public List<LedgerEntry> getDeposits(){
        //Creating a new array list object for LedgerEntries with only depoists
        List<LedgerEntry> result = new ArrayList<>();

        //for each loop iterating through all the entries in the list
        for(LedgerEntry item : entries){
            //only add if description has deposit inside it
            if(item.getAmount() > 0) {
                result.add(item);
            }
        }
        return result;
    }
    //gets only payments
    public List<LedgerEntry> getPayments() {
        List<LedgerEntry> result = new ArrayList<>();
        //for each loop iterating thorough each entry
        for (LedgerEntry item : entries){
            if(item.getAmount() < 0){
                result.add(item);
            }
        }
        return result;
    }
}
