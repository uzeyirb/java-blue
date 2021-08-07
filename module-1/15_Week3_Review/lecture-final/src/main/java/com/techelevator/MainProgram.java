package com.techelevator;

import com.techelevator.items.Item;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;

public class MainProgram {

    private static final String CHOICE_QUIT = "Q";
    private static final String CHOICE_SHOW_ITEMS = "S";

    private Menu menu;
    private Store store;

    public MainProgram(Menu menu) {
        this.menu = menu;
    }

    public void run() {

        while (true) {
            String filename = menu.getInventoryPathFromUser();
            try {
                store = new Store(filename);
                break;
            } catch (FileNotFoundException e) {
                menu.showFileNotFound();
            }
        }

        menu.showWelcome();

        while(true) {
            String choice = menu.getChoiceFromMainMenu();

            if (choice.equalsIgnoreCase(CHOICE_QUIT)) {
                break;
            } else if (choice.equalsIgnoreCase(CHOICE_SHOW_ITEMS)) {
                showItemsMenu();
            }

        }

        menu.showGoodbye();
    }

    private void showItemsMenu() {

        Map<String, Item> items = store.getInventory();
        menu.showItems(items);


        while(true) {
            String choice = menu.getChoiceFromItems();

            if (choice.equalsIgnoreCase("A")) {
                addItemToCart();
                System.out.println();
            } else if (choice.equalsIgnoreCase("B")){
                break;
            }
        }
    }

    private void addItemToCart() {

    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        MainProgram main = new MainProgram(menu);
        main.run();
    }


}
