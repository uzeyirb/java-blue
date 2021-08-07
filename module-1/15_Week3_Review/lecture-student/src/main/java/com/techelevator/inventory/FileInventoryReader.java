package com.techelevator.inventory;

import com.techelevator.items.Book;
import com.techelevator.items.Bookmark;
import com.techelevator.items.Item;
import com.techelevator.items.Magazine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileInventoryReader implements InventoryReader{
    private String fileName;

    public FileInventoryReader(String fileName){
        this.fileName = fileName;
    }


    @Override
    public Map<String, Item> read() throws FileNotFoundException {
        Map<String, Item> inventory = new HashMap<String, Item>();

        File file = new File(fileName);

        try(Scanner inventoryFile = new Scanner(file) ) {

            while (inventoryFile.hasNextLine()){
                String item = inventoryFile.nextLine();
                String[] parts = item.split("\\|");

                String type = parts[0].substring(0,1);

                Item newItem = null;
                if(type.equalsIgnoreCase("B")){
                    newItem = new Book(parts[0], Double.parseDouble(parts[1]), parts[2]);
                }
                if(type.equalsIgnoreCase("M")){
                    newItem = new Magazine(parts[0], Double.parseDouble(parts[1]), parts[2]);
                }
                if(type.equalsIgnoreCase("C")){
                    newItem = new Bookmark(parts[0], Double.parseDouble(parts[1]), parts[2]);
                }
                inventory.put(parts[0], newItem );
            }

        }
        return inventory;
    }
}

