package com.example.javacookbookproject;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

// Parcelable to pass data between fragments
public class Recipe implements Parcelable {
    private int id;
    private String name;
    private String ingredients;
    private String instructions;
    private boolean favorite;
    private int photo;

    public Recipe() {
        // Default constructor
    }

    public Recipe(int id, String name, String ingredients, String instructions, boolean favorite, int photo) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.favorite = favorite;
        this.photo = photo;
    }

    protected Recipe(Parcel in) {
        id = in.readInt();
        name = in.readString();
        ingredients = in.readString();
        instructions = in.readString();
        favorite = in.readByte() != 0;
        photo = in.readInt();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean getFavorite() { return this.favorite; }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setFavorite(boolean favorite) { this.favorite = favorite; }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    /**
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * @param parcel
     * @param i
     */
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(ingredients);
        parcel.writeString(instructions);
        parcel.writeByte((byte) (favorite ? 1 : 0));
        parcel.writeInt(photo);
    }
}
