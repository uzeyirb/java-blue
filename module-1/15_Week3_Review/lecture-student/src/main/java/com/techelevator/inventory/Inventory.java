package com.techelevator.inventory;

import com.techelevator.items.Item;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Item> items;

    public Inventory(String fileName) throws FileNotFoundException {
        //InventoryReader reader = new MemoryInventoryReader();
        InventoryReader reader = new FileInventoryReader(fileName);
        items = reader.read();

    }

    public Map<String, Item> getItems(){
        return items;
    }

    public void add(Item item){

    }

    public void remove(Item item){

    }
}
