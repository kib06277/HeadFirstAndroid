package com.hfad.starbuzz;

public class Food
{
    private String name;
    private String description;
    private int imageResourceId;

    //drinks is an array of Drinks
    public static final Food[] foods =
    {
            new Food("A", "AAAAAAAAAAAAAAAAA", R.drawable.latte),
            new Food("B", "BBBBBBBBBBBBBBBBBBBBB", R.drawable.cappuccino),
            new Food("C", "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC", R.drawable.filter)
    };

    //Each Food has a name, description, and an image resource
    private Food(String name, String description, int imageResourceId)
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
