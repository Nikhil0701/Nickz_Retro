package com.example.nickz_retro;


import com.example.nickz_retro.Model.FoodRecipe;
import com.example.nickz_retro.Model.FoodResponse;
import com.example.nickz_retro.Nickz.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_Interface {

     public static final String BASE_URL="https://www.food2fork.com";
     public  static  final String API_KEY_FOUR="2244d9a2caf4045bcd0cc6f414758be6";

     @GET("api/get")
     Call<FoodResponse>  getRecipe(
             @Query("key") String Key,
             @Query("rid") String RecipeId
     );

}
