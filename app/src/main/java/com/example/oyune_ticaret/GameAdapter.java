package com.example.oyune_ticaret;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class GameAdapter extends ArrayAdapter<Game> {

    private Context context;

    public GameAdapter(Activity context, ArrayList<Game> games) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, games);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.game_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Game currentGame = getItem(position);

        // Find the TextView in the game_item.xml layout with the ID text_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.text_name);
        // Get the name of game from current game
        // set this text on the name TextView
        nameTextView.setText(currentGame.getName());


        // Find the TextView in the game_item.xml layout with the ID text_price
        TextView priceTextView = (TextView) listItemView.findViewById(R.id.text_price);
        // Get the game price from the current price
        // set this text on the price TextView
        priceTextView.setText(currentGame.getPrice());


        // Find the TextView in the game_item.xml layout with the ID text_price
        TextView discountPriceTextView = (TextView) listItemView.findViewById(R.id.text_discountprice);
        // Get the discount price from current game
        // set this text on the discountPrice TextView
        discountPriceTextView.setText(currentGame.getDiscountPrice());


        // Find the ImageView in the game_item.xml layout with the ID image_view
        ImageView gameView = (ImageView) listItemView.findViewById(R.id.image_view);
        // Get the image resource Url from current game object
        // set the image to gameview
        Picasso.get().load(currentGame.getImageUrl()).into(gameView);


        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String platformsName = "";
                String platformsSales = "";
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("currentGame", currentGame);

                Log.d("curentitem name",currentGame.getPlatforms().size() +"" );
              ArrayList<Platform> currentGamePlatforms =  currentGame.getPlatforms();
               for(int i=0; i<currentGamePlatforms.size(); i++) {
                    Platform platform = currentGamePlatforms.get(i);

                   platformsName += platform.getName() + "\n" ;
                   platformsSales += platform.getNumberOfSales() + "\n";

               }
                intent.putExtra("platformsName", platformsName);
                intent.putExtra("platformsSales", platformsSales);
                context.startActivity(intent);

            }
        });


        // Return the whole list item layout (containing 3 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
