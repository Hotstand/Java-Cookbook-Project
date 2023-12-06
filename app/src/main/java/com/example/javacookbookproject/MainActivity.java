package com.example.javacookbookproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.javacookbookproject.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListView;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private List<Recipe> recipeList; // Declare recipeList here
    private DBHandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);


        SQLiteDatabase db = new DBHandler(getApplicationContext()).getWritableDatabase();

        //getSupportActionBar().hide();
        //Toolbar myToolbar = (Toolbar)findViewById(R.id.toolbar1);
        //myToolbar.setTitle("Cooking Chronicles");
        //setSupportActionBar(myToolbar);
        //getSupportActionBar().setTitle("Cooking Chronicles");


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        ListView listView = findViewById(R.id.list_view);
        recipeList = createDummyRecipeList(); // Replace with your actual recipe data
        RecipeAdapter recipeAdapter = new RecipeAdapter(this, R.layout.recipe_item, recipeList);
        listView.setAdapter(recipeAdapter);
        //getSupportActionBar().setTitle("Cooking Chronicles");

        // Handle item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected recipe
                Recipe selectedRecipe = recipeList.get(position);

                // Intent to open RecipeDetailActivity
                Intent intent = new Intent(MainActivity.this, RecipeDetailActivity.class);

                // Pass relevant information to the new activity
                intent.putExtra("recipe_id", selectedRecipe.getId());
                intent.putExtra("recipe_name", selectedRecipe.getName());
                // Add any other necessary information about the recipe

                startActivity(intent);
            }
        });
    }

    // A method to create dummy recipe data (replace with your actual data)
    private List<Recipe> createDummyRecipeList() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe(1, "Spaghetti Bolognese", "Ingredients 1", "Instructions 1",true, R.drawable.chocolatemoussejava));
        recipes.add(new Recipe(2, "Chicken Alfredo", "Ingredients 2", "Instructions 2", true, R.drawable.chocolatemoussejava));
        // Add more recipes as needed
        return recipes;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
