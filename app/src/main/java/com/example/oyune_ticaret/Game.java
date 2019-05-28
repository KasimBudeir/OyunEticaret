package com.example.oyune_ticaret;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Game implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("release")
    @Expose
    private String release;
    @SerializedName("developer")
    @Expose
    private String developer;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("discountPrice")
    @Expose
    private String discountPrice;
    @SerializedName("Platforms")
    @Expose
    private ArrayList<Platform> platforms;

    public Game(String name, String release, String developer, String imagUrl, String price, String discountPrice) {
        this.name = name;
        this.release = release;
        this.developer = developer;
        this.imageUrl = imagUrl;
        this.price = price;
        this.discountPrice = discountPrice;

    }
    public Game(String name, String release, String developer, String imagUrl, String price) {
        this.name = name;
        this.release = release;
        this.developer = developer;
        this.imageUrl = imagUrl;
        this.price = price;
        this.discountPrice = "";

    }

    protected Game(Parcel in) {
        name = in.readString();
        release = in.readString();
        developer = in.readString();
        imageUrl = in.readString();
        price = in.readString();
        discountPrice = in.readString();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<Platform> platforms) {
        this.platforms = platforms;
    }


    //create Static data of Game  for testing
    public static ArrayList<Game> getGames() {
        ArrayList<Game> Games = new ArrayList<Game>();

        Games.add(new Game("Grand Theft Auto 5","2013-08-05T08:40:51.620Z","Rockstar Games","https://bobbybounce.files.wordpress.com/2013/09/gta-v-2013-08-30-300x300.jpg","60$","40$"));
        Games.add(new Game("Metro Exodus","2019-02-26T08:40:51.620Z","4A Games","https://www.thegamingreview.com/wp-content/uploads/2019/01/MetroExodus-300x300.jpg","59$"));
        Games.add(new Game("PlayerUnknown's Battlegrounds","2017-02-26T08:40:51.620Z","Bluehole","https://i.ebayimg.com/images/g/XYAAAOSwCcZZ5jzb/s-l300.jpg","40$","29$"));
        return Games;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(release);
        dest.writeString(developer);
        dest.writeString(imageUrl);
        dest.writeString(price);
        dest.writeString(discountPrice);
    }
}
