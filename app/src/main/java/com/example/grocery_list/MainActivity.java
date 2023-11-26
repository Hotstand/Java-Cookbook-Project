package com.example.grocery_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mShoppingList;
    private EditText mItemEdit;
    private Button mAddButton;
    private Button mClearButton;
    private Button mGoToHomeButton; // New button for navigating to HomeActivity
    private ShoppingListAdapter mAdapter;

    // Request code for startActivityForResult
    private static final int REQUEST_HOME_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Shopping List");

        mShoppingList = findViewById(R.id.shopping_listView);
        mItemEdit = findViewById(R.id.item_editText);
        mAddButton = findViewById(R.id.add_button);
        mClearButton = findViewById(R.id.clear_button);
        mGoToHomeButton = findViewById(R.id.go_to_home_button); // Initialize the new button

        List<ShoppingListItem> shoppingItems = new ArrayList<>();
        mAdapter = new ShoppingListAdapter(this, R.layout.list_item, shoppingItems);
        mShoppingList.setAdapter(mAdapter);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = mItemEdit.getText().toString();
                final ShoppingListItem newItem = new ShoppingListItem(item, false);

                mAdapter.add(newItem);
                mAdapter.notifyDataSetChanged();
                mItemEdit.setText("");
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.clear();
                mAdapter.notifyDataSetChanged();
                shoppingItems.clear();
            }
        });

        // Set up click listener for the "Go to Home Screen" button
        mGoToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to HomeActivity
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivityForResult(intent, REQUEST_HOME_ACTIVITY); // Use startActivityForResult
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_HOME_ACTIVITY && resultCode == RESULT_OK) {
            // Handle the result from HomeActivity, if needed
        }
    }
}
