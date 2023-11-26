/*
    Author: Xokthavy Vongsiharath
    Description: defines a single grocery item
 */

// Define a class representing a shopping list item
package com.example.grocery_list;

// ShoppingListItem class
public class ShoppingListItem {
    private String itemName;
    private boolean checked;

    // Constructor
    public ShoppingListItem(String itemName, boolean checked) {
        this.itemName = itemName;
        this.checked = checked;
    }

    // Getter for item name
    public String getItemName() {
        return itemName;
    }

    // Getter for checked status
    public boolean isChecked() {
        return checked;
    }

    // Setter for checked status
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
