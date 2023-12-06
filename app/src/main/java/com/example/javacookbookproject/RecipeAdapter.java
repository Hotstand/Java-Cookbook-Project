package com.example.javacookbookproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    private List<Recipe> recipeList;
    private int layoutResourceId;
    private Context context;

    public RecipeAdapter(Context context, int layoutResourceId, List<Recipe> recipeList) {
        super(context, layoutResourceId, recipeList);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.recipeList = recipeList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecipeHolder holder;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecipeHolder();
            holder.recipeNameTextView = row.findViewById(R.id.recipe_name_text_view);
            holder.recipeImageView = row.findViewById(R.id.recipe_image_view);

            row.setTag(holder);
        } else {
            holder = (RecipeHolder) row.getTag();
        }

        Recipe recipe = recipeList.get(position);
        holder.recipeNameTextView.setText(recipe.getName());

//        holder.recipeImageView.setImageBitmap(recipe.getPhoto());

        return row;
    }

    static class RecipeHolder {
        TextView recipeNameTextView;
        ImageView recipeImageView;
        // Add other views if needed
    }
}
