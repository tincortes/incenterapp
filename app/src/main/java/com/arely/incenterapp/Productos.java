package com.arely.incenterapp;

public class Productos {

    private int id;
    private int sku;
    private String name;
    private String description;
    private String buyPrice;
    private String sellPrice;
    private String inventory;
//    private String image;

    public Productos() {
    }

    public Productos(int id, int sku, String name, String description, String buyPrice, String sellPrice, String inventory) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.inventory = inventory;
//        this.image = image;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getSku() { return sku; }
    public void setSku(int sku) { this.sku = sku; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getBuyPrice() {
        return buyPrice;
    }
    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }
    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getInventory() {
        return inventory;
    }
    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

//    public String getImage() { return image; }
//    public void setImage(String image) { this.image = image; }
}
