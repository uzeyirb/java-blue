package com.techelevator;

import com.techelevator.inventory.Inventory;
import com.techelevator.items.Item;

import java.io.FileNotFoundException;
import java.util.Map;

public class Store {

    private Inventory inventory;

    public Store(String filename) throws FileNotFoundException {
        inventory = new Inventory(filename);
    }

    public Map<String, Item> getInventory() {
        return inventory.getItems();
    }

}
