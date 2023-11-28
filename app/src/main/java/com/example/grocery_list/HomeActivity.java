// HomeActivity.java
package com.example.grocery_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);    // Replace with your actual layout
        getSupportActionBar().setTitle("Home");

        // Button to navigate to the recipe list activity
        Button recipeListButton = findViewById(R.id.recipeListButton);
        /*
        recipeListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class); //recipe list activity
                startActivity(intent);
            }
        });

         */

        // Button to navigate to the grocery list activity
        Button groceryListButton = findViewById(R.id.groceryListButton);
        groceryListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, grocery_list.class);
                startActivity(intent);
            }
        });


    }
}
