package com.example.baking.data.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@SuppressWarnings("NullableProblems")
@Entity(tableName = "ingredients")
public class Ingredient extends BakingEntity {
    
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int ingredientId;
    
    public String quantity;
    public String measure;
    public String ingredient;
    
    @ForeignKey(entity = Recipe.class, parentColumns = "id", childColumns = "recipe_id", onDelete = CASCADE)
    @ColumnInfo(name = "recipe_id")
    public int recipeId;
    
    public Ingredient(String quantity, String measure, String ingredient, int recipeId) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
        this.recipeId = recipeId;
    }
}