package com.example.javacookbookproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.javacookbookproject.databinding.FragmentGroceryListBinding;

import java.util.ArrayList;
import java.util.List;

public class GroceryList extends Fragment {

    private FragmentGroceryListBinding binding;
    private EditText itemEditText;
    private List<ShoppingListItem> shoppingList;
    private ShoppingListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGroceryListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shoppingList = new ArrayList<>(); // This should be the list of your items

        // Create the adapter and set it to the ListView
        adapter = new ShoppingListAdapter(requireContext(), R.layout.list_item, shoppingList);
        ListView listView = view.findViewById(R.id.shopping_listView);
        listView.setAdapter(adapter);

        // Get references to UI elements
        itemEditText = view.findViewById(R.id.item_editText);
        Button addButton = view.findViewById(R.id.add_button);
        Button clearButton = view.findViewById(R.id.clear_button);

        // Set click listener for the add button
        addButton.setOnClickListener(v -> {
            String itemName = itemEditText.getText().toString().trim();
            if (!itemName.isEmpty()) {
                // Create a new ShoppingListItem and add it to the list
                ShoppingListItem newItem = new ShoppingListItem(itemName, false);
                shoppingList.add(newItem);

                // Notify the adapter that the data has changed
                adapter.notifyDataSetChanged();

                // Clear the EditText for the next item
                itemEditText.getText().clear();
            }
        });

        // Set click listener for the clear button
        clearButton.setOnClickListener(v -> {
            // Clear the EditText
            itemEditText.getText().clear();

            // Clear the list of items
            shoppingList.clear();

            // Notify the adapter that the data has changed
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
