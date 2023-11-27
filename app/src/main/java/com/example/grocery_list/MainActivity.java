/*
    Author: Xokthavy Vongsiharath
    Description: defines and implements a custom adapter for displaying and managing the shopping list items in a ListView
 */

// Import necessary packages
package com.example.grocery_list;

// Import Android dependencies
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Main activity class
public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    ListView mShoppingList;
    EditText mItemEdit;
    Button mAddButton;
    ShoppingListAdapter mAdapter; // Custom adapter for the shopping list
    Button mClearButton;

    // onCreate method called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the content view to activity_main.xml
        Objects.requireNonNull(getSupportActionBar()).setTitle("Shopping List"); // Set the title for the action bar

        // Initialize UI elements
        mShoppingList = findViewById(R.id.shopping_listView);
        mItemEdit = findViewById(R.id.item_editText);
        mAddButton = findViewById(R.id.add_button);

        // Create a list of ShoppingListItem objects
        List<ShoppingListItem> shoppingItems = new ArrayList<>();

        // Initialize the custom adapter with the context, layout, and shoppingItems list
        mAdapter = new ShoppingListAdapter(this, R.layout.list_item, shoppingItems);
        mClearButton = findViewById(R.id.clear_button);
        mShoppingList.setAdapter(mAdapter); // Set the adapter for the ListView

        // Set up click listener for the "Add" button
        mAddButton.setOnClickListener(v -> {
            String item = mItemEdit.getText().toString();
            final ShoppingListItem newItem = new ShoppingListItem(item, false);

            // Add the new item to the adapter and notify of the data change
            mAdapter.add(newItem);
            mAdapter.notifyDataSetChanged();
            mItemEdit.setText(""); // Clear the input field
        });

        // Set up click listener for the "Clear" button
        mClearButton.setOnClickListener(v -> {
            // Clear the shopping list and notify the adapter
            mAdapter.clear(); // Clears the adapter
            mAdapter.notifyDataSetChanged();
            // Clear the shoppingItems list
            shoppingItems.clear();
        });
    }
}
