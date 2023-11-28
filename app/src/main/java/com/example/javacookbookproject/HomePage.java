package com.example.javacookbookproject;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.javacookbookproject.databinding.FragmentHomePageBinding;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment {

    private FragmentHomePageBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentHomePageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // grocery list nav button
        binding.groceryListButton.setOnClickListener(view1 -> {

            NavHostFragment.findNavController(HomePage.this)
                    .navigate(R.id.action_homePage_to_groceryList);
        });

        // recipe list nav button
        binding.recipeListButton.setOnClickListener(view1 -> {

            NavHostFragment.findNavController(HomePage.this)
                    .navigate(R.id.action_homePage_to_recipe_list);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}