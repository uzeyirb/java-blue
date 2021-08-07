package com.techelevator.inventory;

import com.techelevator.items.Item;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Item> items;

    public Inventory(String filename) throws FileNotFoundException {
        InventoryReader reader = new FileInventoryReader(filename); //new MemoryInventoryReader();
        items = reader.read();
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void remove(Item item) {

    }
}
