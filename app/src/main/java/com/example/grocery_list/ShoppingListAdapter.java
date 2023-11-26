/*
    Author: Xokthavy Vongsiharath
    Description: defines and implements a custom adapter for displaying and managing the shopping list items in a ListView
 */

// Import necessary packages
package com.example.grocery_list;

// Import Android dependencies
import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

// Custom adapter for the shopping list
public class ShoppingListAdapter extends ArrayAdapter<ShoppingListItem> {

    // Constructor
    public ShoppingListAdapter(Context context, int resource, List<ShoppingListItem> items) {
        super(context, resource, items);
    }

    // getView method to populate each item view in the ListView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        // Inflate the layout if the view is null
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get references to UI elements in the list item layout
        CheckBox checkBox = listItemView.findViewById(R.id.checkBox);
        TextView itemNameTextView = listItemView.findViewById(R.id.itemName);

        // Get the current ShoppingListItem object at the given position
        final ShoppingListItem currentItem = getItem(position);

        // Check if the item is not null
        if (currentItem != null) {
            // Set the checkbox state based on the item's checked status
            checkBox.setChecked(currentItem.isChecked());

            // Apply a strike-through text decoration when the item is checked
            if (currentItem.isChecked()) {
                SpannableString spannableString = new SpannableString(currentItem.getItemName());
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                itemNameTextView.setText(spannableString);
            } else {
                // No decoration for unchecked items
                itemNameTextView.setText(currentItem.getItemName());
            }

            // Set up a listener for checkbox state changes
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    currentItem.setChecked(isChecked);
                    // Notify the adapter of data change
                    notifyDataSetChanged();
                }
            });
        }

        // Return the populated view for the current item
        return listItemView;
    }
}
