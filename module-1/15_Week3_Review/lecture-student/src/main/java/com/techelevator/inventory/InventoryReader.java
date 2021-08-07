package com.techelevator.inventory;

import com.techelevator.items.Item;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public interface InventoryReader {

    // below is interface method
    Map<String, Item> read() throws FileNotFoundException;
}
