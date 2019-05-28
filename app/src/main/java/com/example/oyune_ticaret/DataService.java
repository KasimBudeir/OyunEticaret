package com.example.oyune_ticaret;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("/games")
    Call<ArrayList<Game>> getAllGames();
}
