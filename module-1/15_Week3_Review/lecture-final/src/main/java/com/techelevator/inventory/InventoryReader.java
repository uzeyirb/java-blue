package com.techelevator.inventory;

import com.techelevator.items.Item;

import java.io.FileNotFoundException;
import java.util.Map;

public interface InventoryReader {

    Map<String, Item> read() throws FileNotFoundException;
}
