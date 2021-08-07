package com.techelevator.items;

public abstract class Item {

    private String code;
    private double price;
    private String name;

    public Item(String code, double price, String name) {
        this.code = code;
        this.price = price;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
