package com.example.oyune_ticaret;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent currentIntent = getIntent();
        Game currentGame = currentIntent.getParcelableExtra("currentGame");
        String platformsName = currentIntent.getStringExtra("platformsName");
        String platformsSales = currentIntent.getStringExtra("platformsSales");


        // Find the TextView in the activity_details.xml layout with the ID name_text_dt
        TextView nameTextView = (TextView) findViewById(R.id.name_text_dt);

        nameTextView.setText("Name : " + currentGame.getName());


        // Find the TextView in the activity_details.xml layout with the ID price_text_dt
        TextView priceTextView = (TextView) findViewById(R.id.price_text_dt);
        priceTextView.setText("Price : " + currentGame.getPrice());


        // Find the TextView in the activity_details.xml layout with the ID text_price
        if (currentGame.getDiscountPrice() != null){
            TextView discountPriceTextView = (TextView) findViewById(R.id.discountPrice_text_dt);

            discountPriceTextView.setText("DiscountPrice : " + currentGame.getDiscountPrice());
        }


        // Find the TextView in the activity_details.xml layout with the ID developer_text_dt
        TextView developerTextView = (TextView) findViewById(R.id.developer_text_dt);

        developerTextView.setText("Developer : " + currentGame.getDeveloper());

        // Find the TextView in the activity_details.xml layout with the ID release_text_dt
        TextView releaseTextView = (TextView) findViewById(R.id.release_text_dt);

        releaseTextView.setText("Release : " + currentGame.getRelease());


        // Find the TextView in the activity_details.xml layout with the ID platformName_text_dt
        TextView platformsNameInfo = (TextView) findViewById(R.id.platformName_text_dt);

        platformsNameInfo.setText("Platform Name : "+"\n" + platformsName);


        // Find the TextView in the activity_details.xml layout with the ID platformSales_text_dt
        TextView platformsSalesInfo = (TextView) findViewById(R.id.platformSales_text_dt);

        // set the Sales Number to TextView
        platformsSalesInfo.setText("Sales Number : "+"\n" + platformsSales);



        // Find the ImageView in the game_item.xml layout with the ID image_url_dt
        ImageView gameView = (ImageView) findViewById(R.id.image_url_dt);

        // set the image to gameview
        Picasso.get().load(currentGame.getImageUrl()).into(gameView);



    }
}
