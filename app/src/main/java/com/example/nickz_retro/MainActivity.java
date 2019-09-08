package com.example.nickz_retro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.nickz_retro.Model.FoodRecipe;
import com.example.nickz_retro.Model.FoodResponse;
import com.example.nickz_retro.Nickz.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Nickz_Adapter adapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)  findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        Data();
    }

    public void Data() {

        dialog=new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setCancelable(true);
        dialog.show();;


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api_Interface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api_Interface api_interface =retrofit.create(Api_Interface.class);
        Call<FoodResponse> call =api_interface.getRecipe( api_interface.API_KEY_FOUR, "1a6a61");

        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                Log.d("Response",response.body().toString());

                dialog.dismiss();
                FoodRecipe example=((FoodResponse)response.body()).getRecipe();
                Log.d("Title"," "+example);

            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {

                 dialog.dismiss();
                 Log.d("response",t.getMessage());
            }
        });

    }
}
