package com.example.oyune_ticaret;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "ListActivity";
    private ArrayList<Game> games;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        // Get a reference to the ListView, and attach the adapter to the listView.
       final ListView listView = (ListView) findViewById(R.id.activity_list);

        /*Create handle for the DataService interface*/
        DataService service = RetrofitClient.getRetrofitInstance().create(DataService.class);
        Call<ArrayList<Game>> call = service.getAllGames();
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {

                response.body();
                Log.d(TAG, "onResponse: " + response.body().get(0).getPlatforms().get(0).getName());
                games= response.body();
                GameAdapter gameAdapter = new GameAdapter(ListActivity.this, games);

                listView.setAdapter(gameAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Toast.makeText(ListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                games = Game.getGames();
            }
        });


    }
}
