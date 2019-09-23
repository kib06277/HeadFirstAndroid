package com.hfad.starbuzz;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import static com.hfad.starbuzz.DrinkActivity.EXTRA_DRINKNO;

public class FoodActivity  extends AppCompatActivity
{
    public static final String EXTRA_FoodNO = "foodNo";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //Get the Food from the intent
        //從 Intent 取得食物資料
        int foodNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        Food food = Food.foods[foodNo];

        //Populate the Food image
        //填寫食物圖像
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(food.getImageResourceId());
        photo.setContentDescription(food.getName());

        //Populate the Food name
        //填寫食物名稱
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(food.getName());

        //Populate the Food description
        //填寫食物描述
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(food.getDescription());
    }
}
