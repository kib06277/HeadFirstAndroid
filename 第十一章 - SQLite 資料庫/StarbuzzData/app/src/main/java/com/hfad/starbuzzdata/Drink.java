package com.hfad.starbuzzdata;

public class Drink
{
    private String name;
    private String description;
    private int imageResourceId;

    //drinks is an array of Drinks
    //各種飲料 Array
    public static final Drink[] drinks =
    {
            new Drink("Latte", "A couple of espresso shots with steamed milk", R.drawable.latte),
            new Drink("Cappuccino", "Espresso, hot milk, and a steamed milk foam", R.drawable.cappuccino),
            new Drink("Filter", "Highest quality beans roasted and brewed fresh", R.drawable.filter)
    };

    //Each Drink has a name, description, and an image resource
    //每個飲料都有名稱，描述和圖像資源
    private Drink(String name, String description, int imageResourceId)
    {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription()
    {
        return description;
    }

    public String getName()
    {
        return name;
    }

    public int getImageResourceId()
    {
        return imageResourceId;
    }

    public String toString()
    {
        return this.name;
    }
}
