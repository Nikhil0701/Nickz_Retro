
package com.example.nickz_retro.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodResponse
{


  FoodRecipe recipe=new FoodRecipe();
  public FoodRecipe getRecipe() {
      return recipe;
  }

}
