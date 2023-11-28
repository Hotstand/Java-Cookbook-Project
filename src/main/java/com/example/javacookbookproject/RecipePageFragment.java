package com.example.javacookbookproject;

// import statements
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//noinspection SuspiciousImport
import android.R.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.javacookbookproject.databinding.FragmentRecipePageBinding;

// recipe page
public class RecipePageFragment extends Fragment {

    private FragmentRecipePageBinding binding;

    // set recipe name - currently sample value for name
    private String recipeName = "Chocolate Chip Pancakes";

    // set recipe ingredients - currently sample value for ingredients
    private String ingredients = "1 1/2 cup all-purpose flour\n4 tsp baking powder\n1/2 tsp salt\n2 Tbs sugar\n1 1/4 cup milk\n1 egg beaten\n3 Tbs butter melted\n1 tsp vanilla\n1 cup chocolate chips any flavor";

    // set recipe directions - currently sample value for directions
    private String directions = "1. Whisk together flour, baking powder, salt and sugar until combined.\n2. In another bowl whisk together milk, egg, butter and vanilla.\n3. Fold or whisk in your wet ingredients into your dry ingredients until just combined.\n4. Then fold in your chocolate chips, batter may be lumpy and that is ok.\n5. Let the batter rest for about 5 minutes.\n6. Heat a non-stick skillet on stove over medium-high heat and spray with non-stick cooking spray.\n7. Pour or scoop the batter onto the pan in 1/4 cup measurements, gently spread the batter out some then press chocolate chips into the batter.\n8. Cook on each side for about 3-4 minutes until you see bubbles form and burst on top of batter, and the underside is golden.\n9. Flip until browned on other side, remove to plate to repeat until all batter is used.";

    // set recipe favorite - currently sample value for favorite
    private boolean favorite = true;

    // set recipe picture
    private int picture = R.drawable.chocolatechippancakesjava;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // get passed recipe object and set recipe data
        Recipe recipe = getArguments().getParcelable("recipe");
        recipeName = recipe.getName();
        ingredients = recipe.getIngredients();
        directions = recipe.getInstructions();
        favorite = recipe.getFavorite();
        picture = recipe.getPhoto();

        binding = FragmentRecipePageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int id = getId();

        // set Text box values to recipe values
        binding.recipeName.setText(recipeName); // set name
        binding.ingredients.setText(ingredients); // set ingredients
        binding.directions.setText(directions); // set directions
        binding.recipeImage.setImageResource(picture);

        if (favorite) { // favorite - set favorite
            // set star to on
            binding.favoriteButton.setImageResource(drawable.btn_star_big_on);
        }
        // not favorite - set star to off
        else { binding.favoriteButton.setImageResource(drawable.btn_star_big_off); }

        // toggle favorite button
        binding.favoriteButton.setOnClickListener(view1 -> {
            favorite = !favorite; // toggle favorite here
            if (favorite) {
                // favorite - set star to on
                binding.favoriteButton.setImageResource(drawable.btn_star_big_on);
            }
            else {
                // not favorite - set star to off
                binding.favoriteButton.setImageResource(drawable.btn_star_big_off);
            }
            Log.i("MyApp", "Favorite");
        });

        // edit recipe name button
        binding.editRecipeNameButton.setOnClickListener(view1 -> {
            Log.i("MyApp", "Edit recipe name");
        });

        // edit ingredients button
        binding.editIngredientsButton.setOnClickListener(view1 -> {
            Log.i("MyApp", "Edit recipe ingredients");
        });

        // edit directions button
        binding.editDirectionsButton.setOnClickListener(view1 -> {
            Log.i("MyApp", "Edit recipe directions");
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}