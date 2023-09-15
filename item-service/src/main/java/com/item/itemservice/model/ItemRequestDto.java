package com.item.itemservice.model;


public class ItemRequestDto {

    private String itemName;

    public ItemRequestDto() {
    }

    public ItemRequestDto(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
