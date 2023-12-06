package com.example.javacookbookproject;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.javacookbookproject.databinding.FragmentRecipeListBinding;
import com.example.javacookbookproject.databinding.FragmentRecipePageBinding;

import java.util.ArrayList;
import java.util.List;

public class recipe_list extends Fragment {


    private FragmentRecipeListBinding binding;
    private List<Recipe> allRecipes = new ArrayList<Recipe>();


    //private DBHandler dbhandler = new DBHandler(getActivity());


    // sample recipe 1 - Chocolate chip pancakes
    //Recipe recipe_1 = dbhandler.getRecipe(1);
    // sample recipe 2 - chocolate mousse
    //Recipe recipe_2 = dbhandler.getRecipe(2);
    // sample recipe 3 - creamy tomato rigatoni
    //Recipe recipe_3 = dbhandler.getRecipe(3);
    // sample recipe 4 - brownies
    //Recipe recipe_4 = dbhandler.getRecipe(4);
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentRecipeListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DBHandler dbhandler = new DBHandler(getActivity());

        dbhandler.addRecipe("Chocolate Chip Pancakes", "1 1/2 cup all-purpose flour\n4 tsp baking powder\n1/2 tsp salt\n2 Tbs sugar\n1 1/4 cup milk\n1 egg beaten\n3 Tbs butter melted\n1 tsp vanilla\n1 cup chocolate chips any flavor", "1. Whisk together flour, baking powder, salt and sugar until combined.\n2. In another bowl whisk together milk, egg, butter and vanilla.\n3. Fold or whisk in your wet ingredients into your dry ingredients until just combined.\n4. Then fold in your chocolate chips, batter may be lumpy and that is ok.\n5. Let the batter rest for about 5 minutes.\n6. Heat a non-stick skillet on stove over medium-high heat and spray with non-stick cooking spray.\n7. Pour or scoop the batter onto the pan in 1/4 cup measurements, gently spread the batter out some then press chocolate chips into the batter.\n8. Cook on each side for about 3-4 minutes until you see bubbles form and burst on top of batter, and the underside is golden.\n9. Flip until browned on other side, remove to plate to repeat until all batter is used.", 1);
        dbhandler.addRecipe("Chocolate Mousse", "1 cup chocolate chips\n½ cup heavy whipping cream, for melting chocolate chips\n⅔ cup chilled heavy whipping cream, for whipping\n1 tablespoon powdered sugar\n¼ teaspoon pure vanilla extract", "1. In a large bowl, heat chocolate chips and ½ cup cream until the chocolate is melted and the mixture is smooth. I do this in the microwave in 20 seconds increments, stirring well between each. Set aside to cool to room temperature, stirring occasionally (this took about 15 minutes).\n2. In the bowl of a hand mixer or stand mixer fitted with the whisk attachment, beat ⅔ cups chilled cream with powdered sugar and vanilla until stiff peaks form (see note about making extra for topping). Transfer the whipped cream to the refrigerator until the chocolate has cooled to room temperature.\n3. Using a rubber/silicone spatula, fold* the whipped cream into the melted chocolate. Once fully combined, transfer the mousse into individual serving dishes and chill for at least 2 hours. The colder it is, the more firm it will be. If you'd like it softer you can leave it at room temperature for about 15 minutes before serving", 0);
        dbhandler.addRecipe("Creamy Tomato Rigatoni", "1/4 cup unsalted butter\n1 cup chopped yellow onion\n1 (28-ounce) can whole peeled plum tomatoes, tomatoes crushed by hand and juices reserved\n12 ounces uncooked rigatoni pasta\n1/2 cup heavy cream\n1 teaspoon kosher salt\n1/4 teaspoon black pepper\n1/4 teaspoon crushed red pepper\n1/2 ounce Parmesan cheese, grated\nChopped fresh flat-leaf parsley, for garnish", "1. Melt butter in a large Dutch oven over medium. Add onion; cook, stirring occasionally, until tender and golden brown, about 5 minutes.\n2. Add tomatoes and their juices; bring to a boil over medium.\n3. Reduce heat to medium-low; simmer, stirring occasionally, until flavors meld and sauce thickens, about 30 minutes.\n4. Meanwhile, cook pasta in salted water according to package directions for al dente. Drain pasta, reserving 1/2 cup pasta cooking liquid.\n5. Stir cream, salt, black pepper, and crushed red pepper into tomato sauce. Add cooked pasta and toss to coat.\n6. Add reserved pasta cooking liquid, 1/4 cup at a time, until desired consistency is reached.\n7. Divide pasta evenly among 4 bowls; sprinkle with Parmesan and garnish with parsley.", 1);
        dbhandler.addRecipe("Brownies", "10 tablespoons salted butter melted\n1 cup granulated sugar\n2 large eggs\n2 teaspoons vanilla extract\n1/2 cup melted milk chocolate chips\n3/4 cup all-purpose flour\n1/4 cup unsweetened cocoa powder\n1/2 teaspoon salt\n1 cup milk chocolate chips", "1. Preheat oven to 350 degrees F. Line a metal 9x9 pan with parchment paper.\n2. Pour melted butter into a large mixing bowl. Whisk in sugar by hand until smooth, 30 seconds.\n3. Add in eggs and vanilla extract. Whisk 1 minute.\n4.Whisk in melted chocolate until combined and smooth.\n5. Use a rubber spatula to stir in flour, cocoa powder, and salt until just combined. Stir in whole chocolate chips.\n6. Pour into prepared pan and smooth out.\n7. Bake in the preheated oven for 30 minutes. Let cool in pan 30 minutes before slicing.", 0);

        // sample recipe 1 - Chocolate chip pancakes
        Recipe recipe_1 = dbhandler.getRecipe(1);
        // sample recipe 2 - chocolate mousse
        Recipe recipe_2 = dbhandler.getRecipe(2);
        // sample recipe 3 - creamy tomato rigatoni
        Recipe recipe_3 = dbhandler.getRecipe(3);
        // sample recipe 4 - brownies
        Recipe recipe_4 = dbhandler.getRecipe(4);



        // add recipes to recipe list
        allRecipes.add(recipe_1);
        allRecipes.add(recipe_2);
        allRecipes.add(recipe_3);

        // set recipe navigation button text to recipe name
        binding.recipe1.setText(recipe_1.getName());
        binding.recipe2.setText(recipe_2.getName());
        binding.recipe3.setText(recipe_3.getName());
        binding.recipe4.setText(recipe_4.getName());

        // recipe 1 nav button
        binding.recipe1.setOnClickListener(view1 -> {

            // create parcelable to send recipe object to recipe page
            Bundle bundle = new Bundle();
            bundle.putParcelable("recipe", (Parcelable) recipe_1);

            NavHostFragment.findNavController(recipe_list.this)
                    .navigate(R.id.action_recipe_list_to_recipePageFragment, bundle);
        });
        // recipe 2 nav button
        binding.recipe2.setOnClickListener(view1 -> {

            // create parcelable to send recipe object to recipe page
            Bundle bundle = new Bundle();
            bundle.putParcelable("recipe", (Parcelable) recipe_2);

            NavHostFragment.findNavController(recipe_list.this)
                    .navigate(R.id.action_recipe_list_to_recipePageFragment, bundle);
        });
        // recipe 3 nav button
        binding.recipe3.setOnClickListener(view1 -> {

            // create parcelable to send recipe object to recipe page
            Bundle bundle = new Bundle();
            bundle.putParcelable("recipe", (Parcelable) recipe_3);

            NavHostFragment.findNavController(recipe_list.this)
                    .navigate(R.id.action_recipe_list_to_recipePageFragment, bundle);
        });
        // recipe 4 nav button
        binding.recipe4.setOnClickListener(view1 -> {

            // create parcelable to send recipe object to recipe page
            Bundle bundle = new Bundle();
            bundle.putParcelable("recipe", (Parcelable) recipe_4);

            NavHostFragment.findNavController(recipe_list.this)
                    .navigate(R.id.action_recipe_list_to_recipePageFragment, bundle);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}